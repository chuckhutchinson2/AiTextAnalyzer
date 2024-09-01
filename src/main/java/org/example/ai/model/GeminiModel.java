package org.example.ai.model;

import lombok.Getter;

// https://ai.google.dev/gemini-api/docs/models/gemini
@Getter
public enum GeminiModel {
    GEMINI_1_5_FLASH("gemini-1.5-flash", "Audio, images, videos, and text", "Text", "Fast and versatile performance across a diverse variety of tasks"),
    GEMINI_1_5_PRO("gemini-1.5-pro", "Audio, images, videos, and text", "Text", "Complex reasoning tasks such as code and text generation, text editing, problem solving, data extraction and generation"),
    GEMINI_1_0_PRO("gemini-1.0-pro", "Text", "Text", "Natural language tasks, multi-turn text and code chat, and code generation"),
    TEXT_EMBEDDING("text-embedding-004", "Text", "Text embeddings", "Measuring the relatedness of text strings"),
    AQA("aqa", "Text", "Text", "Providing source-grounded answers to questions");

    private String description;
    private String input;
    private String output;
    private String name;
    GeminiModel(String name, String input, String output, String description) {
        this.name = name;
        this.input = input;
        this.output = output;
        this.description = description;
    }
}
