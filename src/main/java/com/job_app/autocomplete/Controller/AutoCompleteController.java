package com.job_app.autocomplete.Controller;

import com.job_app.autocomplete.Service.TrieService;
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
        //return trieService.getTrie().getWordsStartingWith(prefix);
        long start = System.nanoTime();
        List<String> results = trieService.getTrie().getWordsStartingWith(prefix);
        long end = System.nanoTime();

        System.out.println("Time taken: " + (end - start) + " ns");
        return results;
        //return trieService.getWordsStartingWith(prefix.toLowerCase());
    }



}
