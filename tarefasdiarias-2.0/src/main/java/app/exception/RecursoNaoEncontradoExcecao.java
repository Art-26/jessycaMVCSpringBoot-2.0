package app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * Essa é uma classe de exceção que consegue ser utilizada quando ocorre alguma exceção, não importando
 * onde ocorre essa exceção, seja ela no Controller, no Model ou em qualquer outro lugar, logo,
 * caso seja colocado algum ID que não existe, ele vai retornar essa exceção. Além disso, o @ResponseStatus
 * informa ao Spring que essa exceção deve retornar um HTTP 404.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecursoNaoEncontradoExcecao extends RuntimeException {

    public RecursoNaoEncontradoExcecao(String mensagem) {
        super(mensagem);
    }
}