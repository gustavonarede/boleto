package br.com.boletojuros.core.port.out;


import br.com.boletojuros.core.domain.BoletoCalculado;

public interface ComplementoBoletoPort {
    BoletoCalculado executar(String codigo );
}
