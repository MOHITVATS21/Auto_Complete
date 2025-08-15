package com.job_app.autocomplete.Service;

import com.job_app.autocomplete.Model.Name;

import com.job_app.autocomplete.Service.Trie;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Service
public class TrieService {
    //private final NameRepository nameRepository;
    private final Trie trie;

    public TrieService() {
       // this.nameRepository = nameRepository;
        this.trie = new Trie();
    }

    @PostConstruct
    public void loadNamesIntoTrie() {

        // Load from file
        try (InputStream is = getClass().getResourceAsStream("/BoyNames.txt");
             BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {

            String line;
            while ((line = br.readLine()) != null) {
                trie.insert(line.trim());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("✅ Trie loaded with names from file.");

        System.out.println("Trie size: " + trie.getSize());
        System.out.println("Trie size calculated from nodes: " + trie.calculateSizeFromNodes());
    }

    public Trie getTrie() {
        System.out.println("I am called");
        return trie;
    }
}

