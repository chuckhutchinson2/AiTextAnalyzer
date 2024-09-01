package org.example.ai.service;

import org.example.ai.model.GeminiModel;

public interface GeminiService {

    String ask(String question, GeminiModel model);
}
