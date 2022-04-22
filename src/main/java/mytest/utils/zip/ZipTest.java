package mytest.utils.zip;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-06-24 11:26
 **/
public class ZipTest {
    @Test
    public void test() throws Exception {
        String s = compressFileByGZ("src/main/resources/zipTestDir");
        System.out.println(s);
    }

    @Test
    public void test2() throws Exception {
        extractGz("src/main/resources/test1.txt.gz");
        System.out.println("ok");
    }

    private String compressFileByGZ(String filePath) throws Exception {
        File file = new File(filePath);
        System.out.println(file.getName());
        String outputFIleName = "src/main/resources/" + file.getName() + ".gz";
        GZIPOutputStream gzipOutputStream = new GZIPOutputStream(new FileOutputStream(outputFIleName));

        FileInputStream fileInputStream = new FileInputStream(filePath);
        byte[] bytes = new byte[1024];
        int read;
        while ((read = fileInputStream.read(bytes)) != -1) {
            gzipOutputStream.write(bytes);
        }
        fileInputStream.close();
        gzipOutputStream.close();

        return outputFIleName;
    }

    public static void extractGz(String filePath) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        GZIPInputStream gzipInputStream = new GZIPInputStream(fileInputStream);
        FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/"+new File(filePath).getName().replace(".gz", ""));
        byte[] bytes = new byte[1024];
        int x;
        while ((x = gzipInputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes);
        }
        fileInputStream.close();
        gzipInputStream.close();
        fileOutputStream.close();
    }
}
