package br.com.branquinho.jpa.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.stream.Collectors;

@RestController
@ControllerAdvice
public class GerenciadorDeExceptions {

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErroView methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        final String erros = ex
            .getBindingResult()
            .getAllErrors()
            .stream()
            .map(error -> error.getDefaultMessage())
            .collect(Collectors.joining(";"));

        return new ErroView(erros);
    }

    class ErroView {

        final String erro;
        final LocalDate data = LocalDate.now();

        ErroView(String descricao) {
            this.erro = descricao;
        }

        public String getErro() {
            return erro;
        }

        public LocalDate getData() {
            return data;
        }
    }

}
