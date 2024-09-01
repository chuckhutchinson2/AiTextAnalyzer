package org.example.ai.repository;

import org.example.ai.model.*;

import java.util.List;

public interface TextAnalyzerRepository {
    List< Text> getTexts(String id);
}
