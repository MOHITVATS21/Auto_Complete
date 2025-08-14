package com.job_app.autocomplete.Service;

import com.job_app.autocomplete.Model.Name;
import com.job_app.autocomplete.Repository.NameRepository;
import com.job_app.autocomplete.Service.Trie;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class TrieService {
    private final NameRepository nameRepository;
    private final Trie trie;

    public TrieService(NameRepository nameRepository) {
        this.nameRepository = nameRepository;
        this.trie = new Trie();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadNamesIntoTrie() {
        nameRepository.findAll()
                .forEach(name -> trie.insert(name.getName()));
        System.out.println("✅ Trie loaded with names from database.");
        System.out.println("Trie size: " + trie.getSize());
        System.out.println("Trie size calculated from nodes: " + trie.calculateSizeFromNodes());
    }

    public Trie getTrie() {
        System.out.println("I am called");
        return trie;
    }
}

