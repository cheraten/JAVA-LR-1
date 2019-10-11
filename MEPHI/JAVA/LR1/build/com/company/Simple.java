package com.company;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import java.io.*;
import java.util.Scanner;

public class Simple extends Main {

    public void SimpleHash(String flag, String path) {
        String content = FileRead(path);

        if (flag.equals("-md5")) {
            String hash = DigestUtils.md5Hex(content);
            System.out.println("MD5: " + hash);
        }

        if (flag.equals("-sha256")) {
            String  hash = DigestUtils.shaHex(content);
            System.out.println("SHA256: " + hash);
        }
    }

    public void PathsRead(String flag) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the file path: ");
        String paths = in.nextLine();

        for (String path : paths.split(" ")) {
            String content = FileRead(path);
            SimpleHash(flag, content);
        }
    }
}
