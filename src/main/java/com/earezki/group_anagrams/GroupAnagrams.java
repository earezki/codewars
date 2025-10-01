package com.earezki.group_anagrams;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> grouped = new HashMap<>();

        for (String str : strs) {
            String key = Arrays.toString(str.chars().sorted().toArray());
            List<String> group = grouped.getOrDefault(key, new ArrayList<>());
            group.add(str);
            grouped.put(key, group);
        }

        return new ArrayList<>(grouped.values());
    }

}
