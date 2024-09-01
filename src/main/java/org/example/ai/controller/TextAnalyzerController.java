package org.example.ai.controller;

import org.example.ai.model.*;
import org.example.ai.service.TextAnalyzerService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// http://localhost:8080/swagger-ui.html
@Slf4j
@RestController
@RequestMapping("/api/v1/analyze")
public class TextAnalyzerController {
    private TextAnalyzerService textanalyzerService;
    public TextAnalyzerController(TextAnalyzerService textanalyzerService) {
        this.textanalyzerService = textanalyzerService;
    }

    @GetMapping("/texts/{id}")
    ResponseEntity<List<Text>> getTexts(@PathVariable String id) {
        List<Text> texts = textanalyzerService.getTexts(id);

        return new ResponseEntity<>(texts, HttpStatus.OK);
    }
}
