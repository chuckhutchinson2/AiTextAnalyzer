package org.example.ai.service.impl;

import org.example.ai.model.*;
import org.example.ai.repository.TextAnalyzerRepository;
import org.example.ai.service.TextAnalyzerService;

import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Service
@Slf4j
public class TextAnalyzerServiceImpl implements TextAnalyzerService {
    private TextAnalyzerRepository textanalyzerRepository;

    public TextAnalyzerServiceImpl(TextAnalyzerRepository textanalyzerRepository) {
        this.textanalyzerRepository = textanalyzerRepository;
    }

    @Override
    public List<Text> getTexts(String id) {
        log.info("getTexts(String {}) ", id);
        return textanalyzerRepository.getTexts(id);
    }
}
