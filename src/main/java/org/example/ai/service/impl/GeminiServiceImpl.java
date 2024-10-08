package org.example.ai.service.impl;

import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.generativeai.ChatSession;
import com.google.cloud.vertexai.generativeai.GenerativeModel;
import com.google.cloud.vertexai.generativeai.ResponseHandler;
import org.example.ai.model.GeminiModel;
import org.example.ai.service.GeminiService;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GeminiServiceImpl implements GeminiService {

    
    @Override
    public String ask(String question, GeminiModel geminiModel) {

        try (VertexAI vertexAI = new VertexAI()) {
            String modelName = "gemini-1.5-flash-001";
            GenerativeModel generativeModel = new GenerativeModel(geminiModel.getName(), vertexAI);

            ChatSession chatSession = new ChatSession(generativeModel);

            GenerateContentResponse response = chatSession.sendMessage(question);
            return ResponseHandler.getText(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
