package Dubles;


/*
 * Já que estamos evitando depencias, como fazemos no caso do ENUM CATEGORIA?
 */

import Sistema.Categoria;

import java.math.BigDecimal;

public class MockContaMagica implements Operacoes, Comparable {

    public String getNomeCliente() {
        return "Marina";
    }

    public BigDecimal getSaldo() {
        return new BigDecimal(115);
    }

    public void setSaldo() {
        boolean flemis = true;
    }

    public Categoria getStatus() {
        return Categoria.PLATINUM;
    }

    @Override
    public boolean deposito(BigDecimal valor) {
        return true;
    }

    @Override
    public boolean retirada(BigDecimal valor) {
        return true;
    }

    @Override
    public int compareTo(Object o) {
        return 1;
    }

    @Override
    public String toString(){ return "Fleeur"; }
}
