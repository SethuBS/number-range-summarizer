package org.assessment.numberrangesummarizer.service.impl;

import org.assessment.numberrangesummarizer.service.NumberRangeSummarizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NumberRangeSummarizerImpl implements NumberRangeSummarizer {

    @Override
    public Collection<Integer> collect(String input) {
        // Split the input string by commas and parse each part into an integer
        String[] parts = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String part : parts) {
            numbers.add(Integer.parseInt(part.trim()));
        }
        return numbers;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {

        StringBuilder summary = new StringBuilder();
        Integer prev = null;
        Integer startRange = null;

        for (Integer current : input) {
            if (prev == null) {
                startRange = current;
            } else if (current - prev > 1) {
                if (startRange.equals(prev)) {
                    summary.append(startRange).append(", ");
                } else {
                    summary.append(startRange).append("-").append(prev).append(", ");
                }
                startRange = current;
            }
            prev = current;
        }

        if (startRange != null) {
            if (startRange.equals(prev)) {
                summary.append(startRange);
            } else {
                summary.append(startRange).append("-").append(prev);
            }
        }

        return summary.toString();
    }
}
