package dev.murilodcosta.mastersys.exception;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Record (DTO) responsável por padronizar a estrutura do corpo de resposta
 * quando erros ocorrem na API, garantindo que o cliente frontend sempre
 * receba a mensagem de erro num mesmo formato consistente (JSON).
 */
public record ErroResponse(
        LocalDateTime timestamp,
        Integer status,
        String erro,
        List<String> mensagens
) {
}
