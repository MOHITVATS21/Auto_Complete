

package com.job_app.autocomplete.util;

import java.util.ArrayList;
import java.util.List;

public class FuzzySearch {

    /**
     * Returns a list of names that are close to the query using Levenshtein distance
     * @param query user input
     * @param data list of all words (from trie)
     * @param maxDistance maximum allowed edit distance
     * @return list of fuzzy matches
     */
    public static List<String> search(String query, List<String> data, int maxDistance) {
        List<String> results = new ArrayList<>();
        String lowerQuery = query.toLowerCase();

        for (String word : data) {
            if (levenshteinDistance(lowerQuery, word.toLowerCase()) <= maxDistance) {
                results.add(word);
            }
        }

        return results;
    }

    private static int levenshteinDistance(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++) dp[i][0] = i;
        for (int j = 0; j <= b.length(); j++) dp[0][j] = j;

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],
                            Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[a.length()][b.length()];
    }
}

