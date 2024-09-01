package org.example.ai.repository.impl;

import org.example.ai.io.JsonUtils;
import org.example.ai.model.*;
import org.example.ai.repository.TextAnalyzerRepository;

import org.springframework.stereotype.Repository;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class TextAnalyzerRepositoryImpl implements TextAnalyzerRepository {
    @Override
    public List<Text> getTexts(String id) {
        log.info("getTexts(String {}) ", id);
        List<Text> texts = new ArrayList<>();
        Text text = new Text();
        text.setId(id);
        texts.add(text);
        return texts;
    }
}
