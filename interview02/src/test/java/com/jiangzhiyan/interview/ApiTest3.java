package com.jiangzhiyan.interview;

import org.junit.Test;

public class ApiTest3 {

    @Test
    public void test_hashMap(){
        String[] words = {"abc","def","sad","2saj","389s","28*s","sa09",
                "#sl;","sassy","s*&*","T78^","`sa&","s[]s",".';[","O|sa"};
        for (String word : words) {
            int hash = word.hashCode() ^ (word.hashCode() >>> 16);
            System.out.println("字符串:" + word
                    + "\tindex(16):" + (hash & (16 - 1))
                    + "\tBit值:" + Integer.toBinaryString(hash)
                    + " - " + Integer.toBinaryString(hash & 16)
                    + "\tindex(32):" + (hash & (32 - 1)));
            System.out.println(Integer.toBinaryString(word.hashCode())
                    + " " + Integer.toBinaryString(hash)
                    + " " + Integer.toBinaryString(hash & (32 - 1)));
        }
    }
}
