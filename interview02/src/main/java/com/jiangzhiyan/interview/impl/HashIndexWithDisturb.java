package com.jiangzhiyan.interview.impl;

import com.jiangzhiyan.interview.HashIndex;

/**
 * 有扰动函数计算
 */
public class HashIndexWithDisturb implements HashIndex {

    @Override
    public int getHashIndex(Object obj, int size) {
        return hash(obj) & (size - 1);
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
