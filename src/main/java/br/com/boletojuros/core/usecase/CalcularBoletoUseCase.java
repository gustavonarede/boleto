package br.com.boletojuros.core.usecase;

import br.com.boletojuros.core.domain.Boleto;
import br.com.boletojuros.core.domain.BoletoCalculado;
import br.com.boletojuros.core.domain.enums.TipoBoleto;
import br.com.boletojuros.core.domain.enums.TipoExcecao;
import br.com.boletojuros.core.exception.ApplicationException;
import br.com.boletojuros.core.port.in.CalculoBoletoPort;
import br.com.boletojuros.core.port.out.ComplementoBoletoPort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CalcularBoletoUseCase implements CalculoBoletoPort {

    private final ComplementoBoletoPort complementBoletoPort;

    public CalcularBoletoUseCase(ComplementoBoletoPort complementBoletoPort) {
        this.complementBoletoPort = complementBoletoPort;
    }


    @Override
    public BoletoCalculado executar(String codigo, LocalDate dataPagamento) {


        var boleto = complementBoletoPort.executar(codigo);
        //TODO - validar boleto

        validar(boleto);

        // TODO - calcular boleto

        //todo - salvar boleto
        return null;
    }


    private void validar(Boleto boleto) {


        if (boleto == null) {

            throw new ApplicationException(TipoExcecao.TIPO_BOLETO_INVALIDO);
        }
        if (boleto.getTipo() != TipoBoleto.XPTO) {

            throw new ApplicationException(TipoExcecao.BOLETO_INVALIDO);
        }
        if (boleto.getDataVencimento().isAfter(LocalDate.now())) {

            throw new ApplicationException(TipoExcecao.BOLETO_NAO_VENCIDO);
        }
    }
}
