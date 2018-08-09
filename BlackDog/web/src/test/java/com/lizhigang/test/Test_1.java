package com.lizhigang.test;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.assertj.core.util.Arrays;

import java.util.HashSet;
import java.util.Set;

public class Test_1 {
    public static void main(String[] args) {
        String password = "123456";
        System.out.println(new SimpleHash("MD5","20160224",password).toString());
    }
}
