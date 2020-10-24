package com.bgw.nio.file;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;

/**
 * @author zhibin.wang
 */
public class PathExample {

    public static void main(String[] args) {
        //testPath();

        testCreateDir();
    }

    private static void testPath() {
        Path path = Paths.get("e:\\names.txt");
        Path path2 = Paths.get("c:\\data", "myfile.txt");
        System.out.println(path2.getFileName() == path2);

        boolean flag = Files.exists(path, LinkOption.NOFOLLOW_LINKS);
    }

    private static void testCreateDir() {
        Path path = Paths.get("e:\\kk");
        System.out.println(Files.exists(path));

        try {
            Path newDir = Files.createDirectory(path);
            System.out.println(Files.exists(newDir));
        } catch(FileAlreadyExistsException e){
            // the directory already exists.
        } catch (IOException e) {
            //something else went wrong
            e.printStackTrace();
        }
    }

    public static void testOverridingFile () {
        Path path = Paths.get("e:\\names.txt");
    }
}
