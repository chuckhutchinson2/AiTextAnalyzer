package org.example.ai.service;

import org.example.ai.model.*;

import java.util.List;

public interface TextAnalyzerService {
    List<TextAnalysis> analyze(String text);
    List<TextClassification> classify(String text);

}
