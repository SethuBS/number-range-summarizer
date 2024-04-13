package org.assessment.numberrangesummarizer;


import org.assessment.numberrangesummarizer.service.NumberRangeSummarizer;
import org.assessment.numberrangesummarizer.service.impl.NumberRangeSummarizerImpl;

import java.util.Collection;

public class Main {

    public static void main(String[] args) {

        NumberRangeSummarizer summarizer = new NumberRangeSummarizerImpl();

        // Test collect method
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> numbers = summarizer.collect(input);
        System.out.println("Collected numbers: " + numbers);

        // Test summarizeCollection method
        String summary = summarizer.summarizeCollection(numbers);
        System.out.println("Summary: " + summary);
    }
}