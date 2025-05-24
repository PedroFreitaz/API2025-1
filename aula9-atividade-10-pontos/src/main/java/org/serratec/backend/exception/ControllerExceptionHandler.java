package org.serratec.backend.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		List<String> erros = new ArrayList<>();

		for (FieldError erro : ex.getBindingResult().getFieldErrors()) {
			erros.add(erro.getField() + ":" + erro.getDefaultMessage());
		}
		ErroResposta erroResposta = new ErroResposta(
				status.value(), "Erro de Validação", LocalDateTime.now(), erros);
				
		return super.handleExceptionInternal(ex, erroResposta, headers, status, request);
	}

	
	@ExceptionHandler(EntityNotFoundException.class) 
    protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErroResposta erroResposta = new ErroResposta(status.value(), "Recurso Não Encontrado", LocalDateTime.now(), List.of(ex.getMessage()));
        return handleExceptionInternal(ex, erroResposta, new HttpHeaders(), status, request);
    }

	@ExceptionHandler(LancamentoVendasException.class)
	protected ResponseEntity<Object> handleUsuarioException(LancamentoVendasException ex, WebRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		ErroResposta erroResposta = new ErroResposta(status.value(), "Erro na operação de lançamento", LocalDateTime.now(), List.of(ex.getMessage()));
		return handleExceptionInternal(ex, erroResposta, new HttpHeaders(), status, request);
	}

}
