package org.example.ai.service.impl;

import org.example.ai.model.*;
import org.example.ai.repository.TextAnalyzerRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import static org.mockito.Mockito.*;
import lombok.extern.slf4j.Slf4j;

@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
@Slf4j
public class TextAnalyzerServiceImplTest {

    @Autowired
    @InjectMocks
    private TextAnalyzerServiceImpl  textanalyzerService;

    @Mock
    private TextAnalyzerRepository textanalyzerRepository;

    @Test
    public void testGetTexts() {
        String key = new String("0");

        List<Text> texts = new ArrayList<>();
        Text text = new Text();
        text.setId(key);
        texts.add(text);

        when(textanalyzerRepository.getTexts(key)).thenReturn(texts);

        List<Text> resultTexts = textanalyzerService.getTexts(key);
        assertNotNull(resultTexts);
        assertTrue(resultTexts.size() == 1);

        verify(textanalyzerRepository).getTexts(key);
    }
}
