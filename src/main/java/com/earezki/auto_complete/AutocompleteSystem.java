package com.earezki.auto_complete;

import java.util.*;

public class AutocompleteSystem {

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        Set<String> sentences = new HashSet<>();
    }

    private final TrieNode root = new TrieNode();
    private final  Map<String, Integer> frequency = new HashMap<>();

    private StringBuilder currentInput = new StringBuilder();;
    private TrieNode currentNode;

    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            frequency.put(sentences[i], times[i]);
            insert(sentences[i]);
        }

        currentNode = root;
    }

    private void insert(String sentence) {
        TrieNode node = root;
        for (char c : sentence.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
            node.sentences.add(sentence);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            String sentence = currentInput.toString();
            frequency.put(sentence, frequency.getOrDefault(sentence, 0) + 1);

            insert(sentence);

            currentInput = new StringBuilder();
            currentNode = root;
            return Collections.emptyList();
        }

        currentInput.append(c);
        if (currentNode != null) {
            currentNode = currentNode.children.get(c);
        }
        if (currentNode == null) {
            return Collections.emptyList();
        }

        List<String> candidates = new ArrayList<>(currentNode.sentences);
        candidates.sort((a, b) -> {
            int cmp = frequency.get(b) - frequency.get(a);
            if (cmp == 0) return a.compareTo(b);
            return cmp;
        });

        return candidates.size() > 3 ? candidates.subList(0, 3) : candidates;
    }
}
