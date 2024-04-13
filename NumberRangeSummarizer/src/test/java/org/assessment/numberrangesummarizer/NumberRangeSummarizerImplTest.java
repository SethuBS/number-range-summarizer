package org.assessment.numberrangesummarizer;


import org.assessment.numberrangesummarizer.service.impl.NumberRangeSummarizerImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class NumberRangeSummarizerImplTest {

    @Test
    public void testCollect() {
        NumberRangeSummarizerImpl summarizer = new NumberRangeSummarizerImpl();
        Collection<Integer> result = summarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");

        assertEquals(Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31), new ArrayList<>(result));
    }

    @Test
    public void testSummarizeCollection() {
        NumberRangeSummarizerImpl summarizer = new NumberRangeSummarizerImpl();
        Collection<Integer> input = summarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        String result = summarizer.summarizeCollection(input);

        assertEquals("1, 3, 6-8, 12-15, 21-24, 31", result);
    }

    @Test
    public void testSummarizeCollection_EmptyInput() {
        NumberRangeSummarizerImpl summarizer = new NumberRangeSummarizerImpl();
        Collection<Integer> input = new ArrayList<>();
        String result = summarizer.summarizeCollection(input);

        assertEquals("", result);
    }

    @Test
    public void testSummarizeCollection_SingleNumber() {
        NumberRangeSummarizerImpl summarizer = new NumberRangeSummarizerImpl();
        Collection<Integer> input = new ArrayList<>();
        input.add(5);
        String result = summarizer.summarizeCollection(input);

        assertEquals("5", result);
    }

    @Test
    public void testSummarizeCollection_InvalidInput() {
        NumberRangeSummarizerImpl summarizer = new NumberRangeSummarizerImpl();
        Collection<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(4);
        input.add(5);
        String result = summarizer.summarizeCollection(input);

        assertEquals("1-2, 4-5", result); // No sequential numbers
    }
}
