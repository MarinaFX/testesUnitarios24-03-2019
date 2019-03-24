package System;

import java.math.BigDecimal;

public class ContaMagica implements Comparable {
    private String nomeCliente;
    private BigDecimal saldo;
    private Categoria status;

    public ContaMagica(String nomeCliente) {
        if (nomeCliente.equals(null) || nomeCliente.equals(""))
            throw new NullPointerException();
        else
            this.nomeCliente = nomeCliente;
        status = Categoria.SILVER;
        saldo = new BigDecimal(0);
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public BigDecimal getSaldo() {
        return this.saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Categoria getStatus() {
        return status;
    }

    public boolean deposito(BigDecimal valor) {
        boolean val1;

        if (valor.compareTo(new BigDecimal(0)) <= 0)
            throw new IllegalArgumentException("Não é possível depositar valores negativos ou nenhum valor");

        while (true) {
            //para contas SILVER
            if ((this.getSaldo().add(valor).compareTo(new BigDecimal(50000)) < 0)) {
                this.saldo = this.getSaldo().add(valor);
                return true;
            }

            val1 = ((this.getSaldo().add(valor).compareTo(new BigDecimal(50000)) >= 0) &&
                    (this.getSaldo().add(valor).compareTo(new BigDecimal(200000)) < 0));

            //para contas GOLD
            if (val1) {
                this.saldo = this.saldo.add(valor.multiply(new BigDecimal(1.01)));
                this.saldo = this.saldo.setScale(0, BigDecimal.ROUND_DOWN);
                status = Categoria.GOLD;
                return true;
            }

            //para contas PLATINUM
            if ((this.getSaldo().add(valor).compareTo(new BigDecimal(200000)) >= 0)) {
                this.saldo = this.saldo.add(valor.multiply(new BigDecimal(1.025)));
                this.saldo = this.saldo.setScale(0, BigDecimal.ROUND_UP);
                status = Categoria.PLATINUM;
                return true;
            }
        }
    }

    public boolean retirada(BigDecimal valor) {
        boolean val1;

        if (valor.compareTo(new BigDecimal(0)) <= 0)
            throw new IllegalArgumentException("Não é possível realizar saque negativo ou com valor equivalente a zero!");

        if (valor.compareTo(this.getSaldo()) > 0)
            throw new IllegalArgumentException("Valor a ser sacado excede o saldo atual!");

        if ((this.getSaldo().subtract(valor).compareTo(new BigDecimal(25000)) <= 0) &&
                this.getStatus().equals(Categoria.PLATINUM))
            throw new IllegalArgumentException("Não é possível sair da categoria Platinum para Silver!");

        while (true) {
            val1 = (this.getSaldo().subtract(valor).compareTo(new BigDecimal(25000)) >= 0) &&
                    (this.getSaldo().subtract(valor).compareTo(new BigDecimal(100000)) <= 0);

            if (val1) {
                this.saldo = this.getSaldo().subtract(valor);
                status = Categoria.GOLD;
                return true;
            }

            if ((this.getSaldo().subtract(valor).compareTo(new BigDecimal(25000)) < 0)) {
                this.saldo = this.getSaldo().subtract(valor);
                status = Categoria.SILVER;
                return true;
            }
        }
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof ContaMagica) {
            if (!(this.getNomeCliente().equals(((ContaMagica) o).getNomeCliente()))) {
                return 1;
            } else {
                return -1;
            }
        }
        return 0;
    }
}