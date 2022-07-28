package com.jiangzhiyan.interview;

import com.jiangzhiyan.interview.impl.HashIndexNoDisturb;
import com.jiangzhiyan.interview.impl.HashIndexWithDisturb;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ApiTest2 {

    private Set<String> words;

    private final String[] tab = new String[2 << 6];

    private HashIndex hashIndex;

    private Map<Integer,Integer> map = new HashMap<>(tab.length);

    @Before
    public void getWords(){
        words = FileUtil.readWordSet("E:\\my_projects\\my_interview\\interview02\\src\\test\\resources\\103976个英语单词库.txt");
    }

    @Test
    public void testNoDisturb(){
        hashIndex = new HashIndexNoDisturb();
        for (String word : words) {
            int index = hashIndex.getHashIndex(word, tab.length);
            if (map.containsKey(index)){
                int count = map.get(index);
                map.put(index,++count);
            }else {
                map.put(index,1);
            }
        }
        for (int i = 0; i < 128; i++) {
            System.out.println(map.get(i));
        }
    }

    @Test
    public void testWithDisturb(){
        hashIndex = new HashIndexWithDisturb();
        for (String word : words) {
            int index = hashIndex.getHashIndex(word, tab.length);
            if (map.containsKey(index)){
                int count = map.get(index);
                map.put(index,++count);
            }else {
                map.put(index,1);
            }
        }
        for (int i = 0; i < 128; i++) {
            System.out.println(map.get(i));
        }
    }
}
