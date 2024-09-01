package org.example.ai.controller;

import org.example.ai.model.*;
import org.example.ai.service.GeminiService;
import org.example.ai.service.TextAnalyzerService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// http://localhost:8080/swagger-ui.html
@Slf4j
@RestController
@RequestMapping("/api/v1/analyze")
public class TextAnalyzerController {
    private TextAnalyzerService textAnalyzerService;
    private GeminiService geminiService;
    public TextAnalyzerController(TextAnalyzerService textAnalyzerService,
                                  GeminiService geminiService) {
        this.textAnalyzerService = textAnalyzerService;
        this.geminiService = geminiService;
    }

    @PostMapping("ask")
    public ResponseEntity<String> ask(@RequestBody String question) {
        return ResponseEntity.ok(geminiService.ask(question));
    }

    @PostMapping("/text/classify")
    public ResponseEntity<List<TextClassification>> classify(@RequestBody String text) {
        return ResponseEntity.ok(textAnalyzerService.classify(text));
    }
    @PostMapping("/text/analyze")
    public ResponseEntity<List<TextAnalysis>> analyze(@RequestBody String text) {
        return ResponseEntity.ok(textAnalyzerService.analyze(text));
    }
}
