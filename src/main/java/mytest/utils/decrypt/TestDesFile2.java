package mytest.utils.decrypt;

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
 * @create: 2021-06-30 16:15
 **/
public class TestDesFile2 {
    private static final int BUFFER = 1024;

    // 密钥
    private String secretKey = "thismy3desdemotestsecreq";//3DES算法,密钥至少24位，超过24位选取前24位
    // 偏移向量
    private String iv = "01234567"; //8字节偏移向量

    private String tempPath;

//    public TestDesFile2(Map map) {
//        //实现算法参数初始化。
//    }

    //initCipher 初始化加密器  getCipher方法移上来

    public String getEntryPath(File path) {
        return path.getAbsolutePath().replace(tempPath, "");
    }

    /**
     * @throws Exception
     */
    public Cipher getCipher(int mode) throws Exception {
        //构造加密器
        DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("desede");//3DES算法
        Key secretKey = keyFactory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");// 加密算法/加密模式/填充模式
        IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
        cipher.init(mode, secretKey, ips);
        return cipher;
    }

    public void encrypt(String sourcePath, String targetPath) throws Exception {
        //验证路径是否存在
        File sourceFile = new File(sourcePath);
        File targetFile = new File(targetPath);
        tempPath = sourceFile.getParent();

        encryptStart(sourceFile, targetFile);
    }

    public void encryptStart(File sourceFile, File targetFile) throws Exception {
        //文件夹的压缩
        if (sourceFile.isDirectory()) {
            encryptDirectory(sourceFile, targetFile);
        } else {
            //文件的压缩
            encryptFile(sourceFile, new File(targetFile.getAbsolutePath() + File.separator + getEntryPath(sourceFile)));
        }
    }

    public void encryptDirectory(File sourceFile, File targetFile) throws Exception {
        File[] files = sourceFile.listFiles();
        for (File file : files) {
            encryptStart(file, targetFile);
        }
    }

    /**
     * @param sourceFile 要加密的文件路径
     * @param targetFile 加密后文件输出的路径
     * @throws Exception
     */
    public void encryptFile(File sourceFile, File targetFile) throws Exception {
        //验证路径是否存在
//        File sourceFile = new File(sourcePath);
        if (!targetFile.getParentFile().exists()) {
            targetFile.getParentFile().mkdirs();
        }

        //获取加密器
        Cipher cipher = getCipher(Cipher.ENCRYPT_MODE);

        //构造输入输出流，加密文件
        OutputStream zipOutputPathStream = null;
        OutputStream cipherOutputStream = null;
        ZipOutputStream zipOutputStream = null;
        InputStream fileInputStream = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            zipOutputPathStream = new FileOutputStream(targetFile);//targetFile
            cipherOutputStream = new CipherOutputStream(zipOutputPathStream, cipher);
            zipOutputStream = new ZipOutputStream(cipherOutputStream);
            zipOutputStream.putNextEntry(new ZipEntry(sourceFile.getAbsolutePath()));
            fileInputStream = new FileInputStream(sourceFile.getAbsolutePath());
            bis = new BufferedInputStream(fileInputStream);
            bos = new BufferedOutputStream(zipOutputStream);
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len
                );
            }
            bos.flush();

        } catch (Exception e) {
            System.out.println();
        } finally {
            close(bos, bis, fileInputStream, zipOutputStream, cipherOutputStream, zipOutputPathStream);
        }
    }


    public void decrypt(String sourcePath, String targetPath) throws Exception {
        //验证路径是否存在
        File sourceFile = new File(sourcePath);
        File targetFile = new File(targetPath);
        tempPath = sourceFile.getParent();

        decryptStart(sourceFile, targetFile);
    }

    public void decryptStart(File sourceFile, File targetFile) throws Exception {
        //文件夹的压缩
        if (sourceFile.isDirectory()) {
            decryptDirectory(sourceFile, targetFile);
        } else {
            //文件的压缩
            decryptFile(sourceFile, new File(targetFile.getAbsolutePath() + File.separator + getEntryPath(sourceFile)));
        }
    }

    public void decryptDirectory(File sourceFile, File targetFile) throws Exception {
        File[] files = sourceFile.listFiles();
        for (File file : files) {
            decryptStart(file, targetFile);
        }
    }

    /**
     * @param sourceFile 要解密的文件路径
     * @param targetFile 解密后文件输出的路径
     * @throws Exception
     */
    public void decryptFile(File sourceFile, File targetFile) throws Exception {
        //验证路径是否存在
//        File sourceFile = new File(sourcePath);

        if (!targetFile.getParentFile().exists()) {
            targetFile.getParentFile().mkdirs();
        }

        //构造加密器
        Cipher cipher = getCipher(Cipher.DECRYPT_MODE);

        //构造输入输出流，加密文件
        InputStream zipInputStream = null;
        CipherInputStream cipherInputStream = null;
        ZipInputStream decryptZipInputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            zipInputStream = new FileInputStream(sourceFile);
            cipherInputStream = new CipherInputStream(zipInputStream, cipher);
            decryptZipInputStream = new ZipInputStream(cipherInputStream);
            if (decryptZipInputStream.getNextEntry() == null) {
                return;
            }
            fileOutputStream = new FileOutputStream(targetFile);
            bis = new BufferedInputStream(decryptZipInputStream);
            bos = new BufferedOutputStream(fileOutputStream);
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
            bos.flush();
        } catch (Exception e) {
            System.out.println();
        } finally {
            close(bos, bis, fileOutputStream, decryptZipInputStream, cipherInputStream, zipInputStream);
        }
    }

    public void close(Closeable... closeableList) {
        try {
            for (Closeable closeable : closeableList) {
                if (closeable != null) {
                    closeable.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() throws Exception {
//        encrypt("C:\\Users\\86159\\IdeaProjects\\LeetCodeTest\\src\\main\\resources\\zipTestDir",
//                "C:\\Users\\86159\\IdeaProjects\\LeetCodeTest\\src\\main\\resources\\test");
        decrypt("C:\\Users\\86159\\IdeaProjects\\LeetCodeTest\\src\\main\\resources\\test\\zipTestDir",
                "C:\\Users\\86159\\IdeaProjects\\LeetCodeTest\\src\\main\\resources\\test2");
    }
}
