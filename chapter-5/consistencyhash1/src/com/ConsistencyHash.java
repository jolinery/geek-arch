package com;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @program: chapter-6
 * @description: hash一致性算法
 * @author: zhanglin16
 * @create: 2020-06-29 11:49
 **/
public class ConsistencyHash {

    private SortedMap<Integer, String> hashCircle = new TreeMap<Integer, String>();
    private int virtualNodeCount;
    private List<String> nodeList;

    public ConsistencyHash(List<String> nodeList, int virtualNodeCount) {
        this.virtualNodeCount = virtualNodeCount;
        this.nodeList = nodeList;
        nodeList.forEach(x -> {
            addNode(x);
        });
    }

    /**
     * 算法。
     *
     * @param digest
     * @param nTime
     * @return
     */
    private Long getHash(byte[] digest, int nTime) {
        long rv = ((long) (digest[3 + nTime * 4] & 0xFF) << 24)
                | ((long) (digest[2 + nTime * 4] & 0xFF) << 16)
                | ((long) (digest[1 + nTime * 4] & 0xFF) << 8)
                | (digest[0 + nTime * 4] & 0xFF);
        /* Truncate to 32-bits */
        return rv & 0xffffffffL;
    }

    /**
     * FNV1_32_HASH算法
     */
    private int getHash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash ^ str.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        // 如果算出来的值为负数则取其绝对值
        if (hash < 0) {
            hash = Math.abs(hash);
        }
        return hash;
    }

    /**
     * 添加节点
     * @param node
     */
    public void addNode(String node) {
        if (node == null) {
            return;
        }
        for (int i = 0; i < virtualNodeCount; i++) {
            int hash = getHash(node+i);
            hashCircle.put(hash, node);
            System.out.println(String.format("虚拟节点[ %s ] hash: %s 已添加", i, hash));
        }
    }
    /**
     * 获取node节点
     * @param
     */
    public String getNode(String key) {
        if (key == null) {
            return null;
        }
        if (hashCircle.isEmpty()) {
            return null;
        }
        int hash = getHash(key);
        if (!hashCircle.containsKey(hash)) {
            //未命中对应的节点
            SortedMap<Integer, String> tailMap = hashCircle.tailMap(hash);
            hash = tailMap.isEmpty() ? hashCircle.firstKey() : tailMap.firstKey();
        }
        return hashCircle.get(hash);
    }
}
