package org.acme.ai.facade;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import org.acme.ai.dao.TriagedReview;

@RegisterAiService
public interface TriageService {

    @SystemMessage("""
            Estás trabajando para un banco, procesando reseñas sobre
            productos financieros. Clasifica las reseñas en positivas y
            negativas, respondiendo con un documento JSON.
            """
    )
    @UserMessage("""
                Tu tarea es procesar la reseña delimitada por ---.
                Aplica análisis de sentimiento a la reseña para determinar
                si es positiva o negativa, considerando varios idiomas.

                Por ejemplo:
                - `Me encanta tu banco, ¡eres el mejor!` es una reseña 'POSITIVA'
                - `J'adore votre banque` es una reseña 'POSITIVA'
                - `Odio tu banco, ¡eres el peor!` es una reseña 'NEGATIVA'

                Responde con un documento JSON que contenga:
                - la clave 'evaluation' con el valor 'POSITIVA' si la reseña es
                positiva, 'NEGATIVA' en caso contrario
                - la clave 'message' con un mensaje agradeciendo o disculpándose
                con el cliente. Estos mensajes deben ser corteses y coincidir con
                el idioma de la reseña.

                ---
                {review}
                ---
            """)
    TriagedReview triage(String review);
}
