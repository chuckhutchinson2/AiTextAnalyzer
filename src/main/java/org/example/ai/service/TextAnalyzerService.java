package org.example.ai.service;

import org.example.ai.model.*;

import java.util.List;

public interface TextAnalyzerService {
    List<Text> getTexts(String id);
}
