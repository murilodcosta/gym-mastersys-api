package dev.murilodcosta.mastersys.exception;

/**
 * Exceção personalizada utilizada para interromper o fluxo da aplicação
 * quando uma regra de negócio é violada (ex: registros duplicados, dados não encontrados).
 * Por herdar de RuntimeException, não exige declaração explícita de throws.
 */
public class RegraNegocioException extends RuntimeException{

    public RegraNegocioException(String message) {
        super(message);
    }
}
