package mytest.java.io;

import org.junit.Test;

import java.io.File;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-06-28 10:56
 **/
public class MyFile {
    private String parentPath;

    public String getEntryPath(File path) {
        return path.getAbsolutePath().replace(parentPath, "");
    }

    @Test
    public void testFile() {
        String s = new String("C:/Users/86159/IdeaProjects/LeetCodeTest/src/main/resources/test2");
        File file = new File(s);
        System.out.println(file.getParent());
        String[] list = file.list();
//        String str = new String("test.tar.gz");
////        String str = new String("C:/Users/86159/IdeaProjects/LeetCodeTest/src/main/resources/test.tar.gz");
//        String s = str.substring(0, str.indexOf("."));
//        System.out.println(s);
//        File file = new File("C:/Users/86159/IdeaProjects/LeetCodeTest/src/main/resources/test.tar.gz");
//        File file = new File("C:\\Users\\86159\\IdeaProjects\\LeetCodeTest\\src\\main\\resources\\");
//        System.out.println(file.getAbsoluteFile());
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.getName());
//        System.out.println(file.getParent());
//        System.out.println(file.getParentFile());
//        System.out.println(file.getPath());
//        System.out.println(file.isDirectory());
//        File[] files = file.listFiles();
//        for (File file1 : files) {
//            System.out.println(file1);
//        }
//        String str = new String("C:\\Users\\86159\\IdeaProjects\\LeetCodeTest\\src\\main\\resources");
//        File file = new File(str);
//        parentPath = file.getParent();
//        String entryPath = getEntryPath(file);
//        System.out.println("entryPath:" + entryPath);
//        String entryPath1 = getEntryPath(new File("C:\\Users\\86159\\IdeaProjects\\LeetCodeTest\\src\\main\\resources\\a\\a.txt"));
//        System.out.println("entryPath1:" + entryPath1);
    }
}
