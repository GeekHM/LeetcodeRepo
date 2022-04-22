package mytest.utils.decrypt;

import org.junit.Test;

import java.io.*;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-06-02 14:39
 **/
public class CharDecodeTest {
    @Test
    public void test(){
        File file = new File("src/main/resources/test1.txt");
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
//            reader = new BufferedReader(new FileReader(file));
            reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream("src/main/resources/test.txt"),"utf-8"));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                System.out.println(tempStr);
                sbf.append(new String(tempStr.getBytes("gbk")));
//                sbf.append(tempStr);
            }
            reader.close();
            System.out.println(sbf);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
