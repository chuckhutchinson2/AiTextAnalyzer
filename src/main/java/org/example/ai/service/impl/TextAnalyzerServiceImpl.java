package org.example.ai.service.impl;

import com.google.cloud.language.v2.*;
import lombok.extern.slf4j.Slf4j;
import org.example.ai.model.TextAnalysis;
import org.example.ai.model.TextClassification;
import org.example.ai.service.TextAnalyzerService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TextAnalyzerServiceImpl implements TextAnalyzerService {
    @Override
    public List<TextAnalysis> analyze(String text) {
        // Instantiate the Language client com.google.cloud.language.v2.LanguageServiceClient
        try (LanguageServiceClient language = LanguageServiceClient.create()) {
            Document doc = Document.newBuilder().setContent(text).setType(Document.Type.PLAIN_TEXT).build();
            AnalyzeEntitiesRequest request =
                    AnalyzeEntitiesRequest.newBuilder()
                            .setDocument(doc)
                            .setEncodingType(EncodingType.UTF16)
                            .build();

            AnalyzeEntitiesResponse response = language.analyzeEntities(request);

            List<TextAnalysis> results = new ArrayList<>();
            // Print the response
            for (Entity entity : response.getEntitiesList()) {
                TextAnalysis textAnalysis = new TextAnalysis();
                textAnalysis.setName(entity.getName());
                textAnalysis.setMetaDataMap(entity.getMetadataMap());
                results.add(textAnalysis);
               /*
                for (EntityMention mention : entity.getMentionsList()) {
                    System.out.printf("Begin offset: %d\n", mention.getText().getBeginOffset());
                    System.out.printf("Content: %s\n", mention.getText().getContent());
                    System.out.printf("Type: %s\n\n", mention.getType());
                    System.out.printf("Probability: %s\n\n", mention.getProbability());
                }*/
            }
            return results;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<TextClassification> classify(String text) {

        // Instantiate the Language client com.google.cloud.language.v2.LanguageServiceClient
        try (LanguageServiceClient language = LanguageServiceClient.create()) {
            // Set content to the text string
            Document doc = Document.newBuilder().setContent(text).setType(Document.Type.PLAIN_TEXT).build();
            ClassifyTextRequest request = ClassifyTextRequest.newBuilder().setDocument(doc).build();
            // Detect categories in the given text
            ClassifyTextResponse response = language.classifyText(request);

            List<TextClassification> classificationResults = new ArrayList<>();
            for (ClassificationCategory category : response.getCategoriesList()) {
                TextClassification classifiedTextClassification = new TextClassification();
                classifiedTextClassification.setName(category.getName());
                classifiedTextClassification.setConfidence(category.getConfidence());
                classificationResults.add(classifiedTextClassification);
            }
            return classificationResults;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
