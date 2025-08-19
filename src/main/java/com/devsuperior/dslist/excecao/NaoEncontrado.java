package com.devsuperior.dslist.excecao;

public class NaoEncontrado extends RuntimeException {

    public NaoEncontrado(String mensagem) {
        super(mensagem);
    }

    public NaoEncontrado(String mensagem, Throwable throwable) {
        super(mensagem, throwable);
    }
}
