package com.job_app.autocomplete.Controller;

import com.job_app.autocomplete.Exception.NoResultFoundException;
import com.job_app.autocomplete.Exception.PrefixCannotbenull;
import com.job_app.autocomplete.Service.TrieService;
import com.job_app.autocomplete.util.FuzzySearch;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autocomplete")
public class AutoCompleteController {

    private final TrieService trieService;

    public AutoCompleteController(TrieService trieService) {
        this.trieService = trieService;
    }

    @GetMapping
    public List<String> getSuggestions(@RequestParam String prefix) {
        if (prefix == null || prefix.isEmpty()) {
            throw new PrefixCannotbenull("Prefix cannot be null or empty.");
        }

        // Step 1: Trie search
        List<String> results = trieService.getTrie().getWordsStartingWith(prefix);

        // Step 2: Fuzzy search fallback
        if (results.isEmpty()) {
            results = FuzzySearch.search(prefix, trieService.getTrie().getAllWords(), 2); // max edit distance 2
        }

        if (results.isEmpty()) {
            throw new NoResultFoundException("No results found for the given prefix.");
        }

        return results;
    }




}
