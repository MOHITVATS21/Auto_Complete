package com.job_app.autocomplete.Service;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    private TrieNode root;
    private int size; // Number of unique words inserted

    public Trie() {
        root = new TrieNode();
        size = 0;
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toLowerCase().toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
        }
        if (!node.isEndOfWord) { // Word is new
            node.isEndOfWord = true;
            size++;
        }
    }

    // Returns the tracked size
    public int getSize() {
        return size;
    }

    // Dynamically counts all words for debugging
    public int calculateSizeFromNodes() {
        return countWords(root);
    }

    private int countWords(TrieNode node) {
        int count = node.isEndOfWord ? 1 : 0;
        for (TrieNode child : node.children.values()) {
            count += countWords(child);
        }
        return count;
    }

    public List<String> getWordsStartingWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toLowerCase().toCharArray()) {
            if (!node.children.containsKey(ch)) {
                return new ArrayList<>();
            }
            node = node.children.get(ch);
        }
        return collectAllWords(node, prefix.toLowerCase());
    }

    private List<String> collectAllWords(TrieNode node, String prefix) {
        List<String> words = new ArrayList<>();
        if (node.isEndOfWord) {
            words.add(prefix);
        }
        for (char ch : node.children.keySet()) {
            words.addAll(collectAllWords(node.children.get(ch), prefix + ch));
        }
        return words;
    }

    public List<String> getAllWords() {
        return collectAllWords(root, "");
    }

}
