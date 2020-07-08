package br.com.branquinho.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GerenciadorDeExceptions {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErroView methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        final String erros = ex
            .getBindingResult()
            .getFieldErrors()
            .stream()
            .map(e -> e.getField() + " " + messageSource.getMessage(e, LocaleContextHolder.getLocale()))
            .collect(Collectors.joining(";"));

        return new ErroView(erros);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    public ErroView runtimeException(RuntimeException ex) {
        log.info(ex.getMessage(), ex);
        return new ErroView(ex.getMessage());
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
