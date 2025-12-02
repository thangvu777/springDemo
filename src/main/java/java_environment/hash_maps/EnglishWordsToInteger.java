package java_environment.hash_maps;

import java.util.HashMap;

// https://leetcode.com/problems/integer-to-english-words/description/
// Time: O(N)
// Space: O(1)
public class EnglishWordsToInteger {
    
    private static final HashMap<String, Integer> map = new HashMap<>();

    static {
        // Insert ones
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        // Teens
        map.put("ten", 10);
        map.put("eleven", 11);
        map.put("twelve", 12);
        map.put("thirteen", 13);
        map.put("fourteen", 14);
        map.put("fifteen", 15);
        map.put("sixteen", 16);
        map.put("seventeen", 17);
        map.put("eighteen", 18);
        map.put("nineteen", 19);

        // Ty's
        map.put("twenty", 20);
        map.put("thirty", 30);
        map.put("forty", 40);
        map.put("fifty", 50);
        map.put("sixty", 60);
        map.put("seventy", 70);
        map.put("eighty", 80);
        map.put("ninety", 90);

        // Scales
        map.put("hundred", 100);
        map.put("thousand", 1000);
        map.put("million", 1000000);
        map.put("billion", 1000000000);
    }


    public static int convertWordsToInteger(String english) {
        if (english == null || english.isEmpty()) {
            return 0;
        }
        // hypen for eighty-four scenario
        // cleaning up any extra spaces and normalizing with 1 space in each
        // trimming last space
        String cleaned = english.toLowerCase().replace("-", " ").replaceAll("\\s+", " ").trim();
        String[] tokens = cleaned.split(" ");

        int finalNumber = 0;
        int currentBlock = 0;
        int currentScale = 1;

        for (int i = tokens.length - 1; i >= 0; i--) {
            String word = tokens[i];
            if (word.equals("and")) {
                continue;
            }

            int value = map.getOrDefault(word, 0);

            if (value >= 1000) {
                finalNumber += currentBlock * currentScale;
                currentBlock = 0;
                currentScale = value;
            } else if (value >= 100) {
                if (i > 0) {
                    // Multiply the *current digit* (from i-1) by 100, and add it to the chunk.
                    currentBlock += map.getOrDefault(tokens[i - 1], 0) * 100;
                    i--; // CRITICAL: Skip the preceding multiplier digit
                }
            } else {
                // Single Digit
                currentBlock += value;
            }
        }

        // Add the last current processed chunk
        finalNumber += (currentBlock * currentScale);
        return finalNumber;
    }


    static void main() {
        String[] tests = {
                "One thousand three hundred and fifty two", // 1352
                "Seven hundred and five", // 705
                "One million nine hundred thousand eight hundred and seventy-six", // 1,900,876
                "Two billion twenty-five million fifty-nine thousand nine", // 2,025,059,009
                "Eighty-four", // 84 (Handles hyphenated numbers with simple logic)
                "Forty" // 40
        };

        for (String test : tests) {
            int result = convertWordsToInteger(test);
            System.out.println("\"" + test + "\" -> " + result);
        }
    }
}
