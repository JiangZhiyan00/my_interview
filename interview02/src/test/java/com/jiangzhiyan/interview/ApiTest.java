package com.jiangzhiyan.interview;

import com.alibaba.fastjson.JSON;
import org.junit.Assert;
import org.junit.Test;

public class ApiTest {

    @Test
    public void testHash(){
        // 初始化一组字符串
        final String[] words = {"abc","123","444","sada","66ad","so*18","s$ja"};
        // 定义要存放的数组,长度为8=2^3
        String[] tab = new String[8];
        for (String word : words) {
            //计算索引位置,当tab.length=2^n时,等价于word.hashCode() % tab.length
            int index = (int) getRemainder(word.hashCode(),tab.length);
            System.out.printf("word:%s,index:%d%n",word,index);
            if (tab[index] == null) {
                tab[index] = word;
                continue;
            }
            tab[index] = tab[index] + "->" + word;
        }
        System.out.println(JSON.toJSONString(tab));
    }

    /**
     * 计算余数
     * @param dividend 被除数
     * @param divisor 除数
     * @return 余数
     */
    public static long getRemainder(long dividend, long divisor){
        Assert.assertNotEquals("除数不能为0", 0, divisor);
        if ((divisor & (divisor - 1)) == 0){
            return dividend & (divisor - 1);
        }
        return dividend % divisor;
    }

    @Test
    public void test_remainder() {
        System.out.println(14 % 8);//6
        System.out.println(getRemainder(14, 8));//6
        System.out.println(121 % 8);//1
        System.out.println(getRemainder(121, 8));//1
        System.out.println(33 % 8);//1
        System.out.println(getRemainder(33, 8));//1
        System.out.println(143 % 8);//7
        System.out.println(getRemainder(143, 8));//7
    }
}
