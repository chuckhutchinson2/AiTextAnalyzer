package org.example.ai.controller;

import org.example.ai.model.*;
import org.example.ai.service.TextAnalyzerService;

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
import static org.junit.Assert.assertEquals;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;
import lombok.extern.slf4j.Slf4j;

@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
@Slf4j
public class TextAnalyzerControllerTest {

    @Autowired
    @InjectMocks
    private TextAnalyzerController  textanalyzerController;

    @Mock
    private TextAnalyzerService textanalyzerService;

    @Test
    public void testGetTexts() {
        String key = new String("0");

        List<Text> texts = new ArrayList<>();
        Text text = new Text();
        text.setId(key);
        texts.add(text);

        when(textanalyzerService.getTexts(key)).thenReturn(texts);
        ResponseEntity<List<Text>> result = textanalyzerController.getTexts(key);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        List<Text> resultTexts = result.getBody();
        assertNotNull(resultTexts);
        assertTrue(resultTexts.size() == 1);

        verify(textanalyzerService).getTexts(key);
    }
}
