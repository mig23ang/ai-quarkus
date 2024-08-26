package org.acme.ai.controller;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.acme.ai.dao.TriagedReview;
import org.acme.ai.facade.TriageService;

@Path("/ai")
public class AiController {

    private final TriageService triageService;


    public AiController(TriageService triageService) {
        this.triageService = triageService;
    }

    record Review(String review) {}

    @POST
    public TriagedReview triage(Review review) {
        return triageService.triage(review.review());
    }
}
