package br.com.boletojuros.core.domain.enums;

public enum TipoExcecao {
    BOLETO_INVALIDO{
        @Override
        public String getMensagemErro() {
            return "o boleto encontrado é inválido";
        }
    },
    TIPO_BOLETO_INVALIDO
            {
                @Override
                public String getMensagemErro() {
                    return "Infelizmente só podemos calcular o juro dos boletos XPTO";
                }
            },
    BOLETO_NAO_VENCIDO{
        @Override
        public String getMensagemErro() {
            return "O Boleto informado ainda não est´[a vencido";
        }
    };

    public abstract String getMensagemErro();
}
