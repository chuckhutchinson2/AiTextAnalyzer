package org.example.ai.model;

import lombok.Data;

import java.util.Map;

@Data
public class TextAnalysis {
    private String name;
    private Float confidence;
    private Map<String, String> metaDataMap;
}
