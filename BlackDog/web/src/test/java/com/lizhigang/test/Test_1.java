package com.lizhigang.test;

import org.assertj.core.util.Arrays;

import java.util.HashSet;
import java.util.Set;

public class Test_1 {
    public static void main(String[] args) {
        String str = "sys:porject:all,123456";
        Set<String> players = new HashSet(Arrays.asList(str.split(",")));
        Set<String> j = new HashSet<String>();
        players.forEach((player) -> j.add(player));
        j.forEach((js) -> System.out.println("-"+js));
    }
}
