package com;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 */
public class Main {

    public static void main(String[] args) {

        Map<String, Integer> nodeKeyCount = new HashMap<>();
        int virtualNodeCount = 100;
        List<String> nodeList = new LinkedList<>();
        nodeList.add("192.168.1.1");
        nodeList.add("192.168.1.2");
        nodeList.add("192.168.1.3");
        nodeList.add("192.168.1.4");
        nodeList.add("192.168.1.5");
        nodeList.add("192.168.1.6");
        nodeList.add("192.168.1.7");
        nodeList.add("192.168.1.8");
        nodeList.add("192.168.1.9");
        nodeList.add("192.168.1.10");
        ConsistencyHash consistencyHash = new ConsistencyHash(nodeList, virtualNodeCount);
        for (int i = 0; i < 1000000; i++) {
            String key = consistencyHash.getNode("key" + i);
            int count = 0;
            if (nodeKeyCount.containsKey(key)) {
                count = nodeKeyCount.get(key);
            }
            ;
            nodeKeyCount.put(key, count + 1);
        }
        nodeKeyCount.forEach((key, val) -> {
            System.out.println(String.format("node:%s,总数：%s", key, val));
        });
        System.out.println(String.format("标准差:%s", StandardDiviation(nodeKeyCount.values().stream().map(x -> (double) x).collect(Collectors.toList()))));

    }

    public static double Variance(List<Double> x) {
        int m = x.size();
        double sum = 0;
        for (int i = 0; i < m; i++) {
            //求和
            sum += x.get(i);
        }
        //求平均值
        double dAve = sum / m;
        double dVar = 0;
        //求方差
        for (int i = 0; i < m; i++) {
            dVar += (x.get(i) - dAve) * (x.get(i) - dAve);
        }
        return dVar / m;
    }

    //标准差σ=sqrt(s^2)
    public static double StandardDiviation(List<Double> x) {
        int m = x.size();
        double sum = 0;
        for (int i = 0; i < m; i++) {//求和
            sum += x.get(i);
        }
        double dAve = sum / m;//求平均值
        double dVar = 0;
        for (int i = 0; i < m; i++) {//求方差
            dVar += (x.get(i) - dAve) * (x.get(i) - dAve);
        }
        //reture Math.sqrt(dVar/(m-1));
        return Math.sqrt(dVar / m);
    }
}
