package org.dnd.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.lang.NullPointerException;

public class GlobalExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> nullPointerExceptionHandler(NullPointerException ex) {
        logger.error("NullPointerException : {}", ex.getMessage());
        return createErrorResponse(HttpStatus.BAD_GATEWAY, ex.getMessage());
    }

    @ExceptionHandler(IllegalStringException.class)
    public ResponseEntity<ErrorResponse> illegalStringHandler(IllegalStringException ex) {
        logger.error("Illegal String Exception : {}", ex.getMessage());
        return createErrorResponse(HttpStatus.BAD_GATEWAY, ex.getMessage());
    }

    private ResponseEntity<ErrorResponse> createErrorResponse(HttpStatus code, String message) {
        ErrorResponse errorResponse = new ErrorResponse(code.value(), code.getReasonPhrase(), message);
        return new ResponseEntity<>(errorResponse, code);
    }
}
