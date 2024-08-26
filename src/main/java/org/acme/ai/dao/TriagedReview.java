package org.acme.ai.dao;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TriagedReview {

    private String evaluation;
    private String message;
}
