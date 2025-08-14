package com.job_app.autocomplete;

import com.job_app.autocomplete.Service.Trie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TrieTest {

    private Trie trie;

    @BeforeEach
    public void setUp() {
        trie = new Trie();
        // Insert some sample names
        trie.insert("Marcus");
        trie.insert("Maria");
        trie.insert("Mark");
        trie.insert("Martha");
        trie.insert("Martin");
    }

    @Test
    public void testGetWordsStartingWith() {
        String prefix = "Mar";

        long start = System.nanoTime();
        List<String> results = trie.getWordsStartingWith(prefix); // use the same trie
        long end = System.nanoTime();

        System.out.println("Time taken for prefix '" + prefix + "': " + (end - start) + " ns");

        // Convert all results to lowercase for assertion
        results.replaceAll(String::toLowerCase);

        // Assertions
        assertNotNull(results);
        assertEquals(5, results.size()); // We inserted 5 words starting with 'Mar'
        assertTrue(results.contains("marcus"));
        assertTrue(results.contains("maria"));
        assertTrue(results.contains("mark"));
        assertTrue(results.contains("martha"));
        assertTrue(results.contains("martin"));
    }
}
