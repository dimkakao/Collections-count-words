package com.epam.rd.autotasks;


import java.util.*;

public class Words {

    public String countWords(List<String> lines) {

        SortedMap<String, Integer> map = new TreeMap<>();
        for (String s: lines) {
            String[] strings = s.toLowerCase().split("[\"! .$%˘&()*+,-./™ˇ•:;–—<=>?@\\[\\\\\\]^_`’”“{}|‘‡‚†…„~€]+|('s)");

            for (String string : strings) {
                if (string.length() < 4) continue;
                if (map.containsKey(string)) {
                    map.replace(string, map.get(string) + 1);
                } else map.put(string, 1);
            }
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(new MyComparator());
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> e:entryList) {
            if (e.getValue() >= 10)
                sb.append(e.getKey()).append(" - ").append(e.getValue()).append("\n");
        }
        sb.deleteCharAt(sb.lastIndexOf("\n"));
        return sb.toString();
    }

    static class MyComparator implements Comparator<Map.Entry<String,Integer>>{
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return o2.getValue().compareTo(o1.getValue());
        }
    }
}




