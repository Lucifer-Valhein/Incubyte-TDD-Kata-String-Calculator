package com.incubyte;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String delimiterPattern = ",|\n";
        String numbersSection = numbers;

        // Check for custom delimiter declaration
        if (numbers.startsWith("//")) {
            int newlineIndex = numbers.indexOf("\n");
            String delimiterDeclaration = numbers.substring(2, newlineIndex);
            numbersSection = numbers.substring(newlineIndex + 1);

            // Handle cases: //[delimiter], //[***], //[*][%]
            List<String> delimiters = new ArrayList<>();

            if (delimiterDeclaration.startsWith("[") && delimiterDeclaration.contains("]")) {
                // Extract each delimiter within [ ]
                Matcher matcher = Pattern.compile("\\[(.*?)]").matcher(delimiterDeclaration);
                while (matcher.find()) {
                    delimiters.add(Pattern.quote(matcher.group(1)));
                }
            } else {
                // Single character delimiter
                delimiters.add(Pattern.quote(delimiterDeclaration));
            }

            delimiterPattern = String.join("|", delimiters);
        }

        // Split numbers using the built delimiter pattern
        String[] tokens = numbersSection.split(delimiterPattern);

        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String token : tokens) {
            if (token.isEmpty()) continue;

            int num = Integer.parseInt(token.trim());

            if (num < 0) {
                negatives.add(num);
            } else if (num <= 1000) { // Ignore numbers >1000
                sum += num;
            }
        }

        if (!negatives.isEmpty()) {
            String joinedNegatives = String.join(",",
                    negatives.stream()
                            .map(String::valueOf)
                            .toArray(String[]::new));
            throw new RuntimeException("negative numbers not allowed " + joinedNegatives);
        }

        return sum;
    }
}
