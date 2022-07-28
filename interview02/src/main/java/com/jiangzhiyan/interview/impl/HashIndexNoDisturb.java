package com.jiangzhiyan.interview.impl;

import com.jiangzhiyan.interview.HashIndex;

/**
 * 无扰动函数计算
 */
public class HashIndexNoDisturb implements HashIndex {

    @Override
    public int getHashIndex(Object obj, int size) {
        return obj.hashCode() & (size - 1);
    }
}
