package DummieTests;

import Dubles.DummyContaMagica;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DummyContaTeste {
    private DummyContaMagica dumb;

    @BeforeEach
    public void setUp(){
        dumb = new DummyContaMagica();
    }

    @Test
    public void testeGetNome(){
        assertEquals("getNomeCliente 0.K", dumb.getNomeCliente());
    }

    @Test
    public void testeGetSaldo(){
        assertEquals("getSaldo 0.K", dumb.getSaldo());
    }

    @Test
    public void testeSetSaldo(){
        assertEquals("setSaldo 0.K", dumb.setSaldo());
    }

    @Test
    public void testeGetStatus(){
        assertEquals("getStatus 0.K", dumb.getStatus());
    }

    @Test
    public void testeDeposito(){
        assertEquals("deposito 0.K", dumb.deposito());
    }

    @Test
    public void testeRetirada(){
        assertEquals("retirada 0.K", dumb.retirada());
    }
}
