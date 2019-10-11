package com.company;

import org.apache.commons.codec.digest.DigestUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Interactive extends Main{

    public void InteractiveHash(String path) {
        String content = FileRead(path);

        String hash1 = DigestUtils.md5Hex(content);
        System.out.println("MD5: " + hash1);

        String hash2 = DigestUtils.shaHex(content);
        System.out.println("SHA256: " + hash2);
    }
}
