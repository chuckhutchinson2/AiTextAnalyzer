package org.example.ai.repository.impl;

import org.example.ai.model.*;
import org.example.ai.repository.TextAnalyzerRepository;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import lombok.extern.slf4j.Slf4j;
@ActiveProfiles("test")
@Slf4j
public class TextAnalyzerRepositoryImplTest {

    private TextAnalyzerRepositoryImpl  textanalyzerRepository = new TextAnalyzerRepositoryImpl();

    @Test
    public void testGetTexts() {
        String string = new String("0");

        List<Text> texts = textanalyzerRepository.getTexts(string);
        assertNotNull(texts);
        assertTrue(texts.size() > 0);
    }
}
