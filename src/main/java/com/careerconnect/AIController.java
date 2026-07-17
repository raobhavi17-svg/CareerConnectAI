package com.careerconnect;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ai")
public class AIController {

    private final OllamaService ollamaService;

    public AIController(OllamaService ollamaService) {
        this.ollamaService = ollamaService;
    }

    @PostMapping("/career-advice")
    public AIResponse getCareerAdvice(@RequestBody AIRequest request) {

        String answer = ollamaService.askOllama(request.getPrompt());

        return new AIResponse(answer);
    }
}