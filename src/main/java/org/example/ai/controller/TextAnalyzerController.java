package org.example.ai.controller;

import org.example.ai.model.*;
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
    public TextAnalyzerController(TextAnalyzerService textAnalyzerService) {
        this.textAnalyzerService = textAnalyzerService;
    }

    @PostMapping("/text/classify")
    ResponseEntity<List<TextClassification>> classify(@RequestBody String text) {
        return ResponseEntity.ok(textAnalyzerService.classify(text));
    }
    @PostMapping("/text/analyze")
    ResponseEntity<List<TextAnalysis>> analyze(@RequestBody String text) {
        return ResponseEntity.ok(textAnalyzerService.analyze(text));
    }
}
