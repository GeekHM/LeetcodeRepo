package mytest.Decrypt;

import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.*;
import java.security.Key;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-06-30 10:40
 **/
public class TestDesFile {
    private final static String secretKey = "thismy3desdemotestsecreq";
    private final static String iv = "01234567";

    /**
     * @param zipFilePath 要压缩的文件
     * @param zipOutPath  压缩文件输出的路径
     * @throws Exception
     */
    public static void encryptZip(String zipFilePath, String zipOutPath) throws Exception {
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);


        OutputStream zipOutputPathStream = new FileOutputStream(new File(zipOutPath));
        OutputStream cipherOutputStream = new CipherOutputStream(zipOutputPathStream, cipher);
        ZipOutputStream zipOutputStream = new ZipOutputStream(cipherOutputStream);
        zipOutputStream.putNextEntry(new ZipEntry(zipFilePath));
        InputStream fileInputStream = new FileInputStream(new File(zipFilePath));
        BufferedInputStream bis = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bos = new BufferedOutputStream(zipOutputStream);

        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len
            );
        }
        bos.flush();

        bos.close();
        bis.close();
        fileInputStream.close();
        zipOutputStream.close();
        cipherOutputStream.close();
        zipOutputPathStream.close();

    }

    /**
     * @param unZipPath   要解密的压缩文件路径
     * @param outFilePath 解密解压缩之后的文件路径
     * @throws Exception
     */
    public static void decryptZip(String unZipPath, String outFilePath) throws Exception {
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, deskey, ips);


        InputStream zipInputStream = new FileInputStream(new File(unZipPath));
        CipherInputStream cipherInputStream = new CipherInputStream(zipInputStream, cipher);
        ZipInputStream decryptZipInputStream = new ZipInputStream(cipherInputStream);
        if (decryptZipInputStream.getNextEntry() == null) {
            System.out.println("");
            return;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(new File(outFilePath));
        BufferedInputStream bis = new BufferedInputStream(decryptZipInputStream);
        BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);

        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }
        bos.flush();
        bos.close();
        bis.close();
        fileOutputStream.close();
        decryptZipInputStream.close();
        cipherInputStream.close();
        zipInputStream.close();
    }

    @Test
    public void test() throws Exception {
//        encryptZip("d:/Atest.txt", "d:/Dtest.txt");
        decryptZip("d:/Dtest.txt", "d:/Ftest.txt");
    }
}
