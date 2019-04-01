package UnitaryTest;

import Dubles.MockContaMagica;
import Sistema.Categoria;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MockContaMagicaTeste {
    MockContaMagica mockConta;

    @BeforeEach
    public void setUp(){
        mockConta = new MockContaMagica();
    }

    @Test
    public void testeGetNome(){
        assertEquals("Marina", mockConta.getNomeCliente());
    }

    @Test
    public void testeGetSaldo(){
        assertEquals(new BigDecimal(115), mockConta.getSaldo());
    }

    @Test
    public void testeSetSaldo(){

    }

    @Test
    public void testeGetCategoria(){
        assertEquals(Categoria.PLATINUM, mockConta.getStatus());
    }

    @Test
    public void testeDeposito(){
        assertTrue(mockConta.deposito(new BigDecimal(115)));
    }

    @Test
    public void testeRetirada(){
        assertTrue(mockConta.retirada(new BigDecimal(115)));
    }

    @Test
    public void testeCompareTo(){
        assertEquals(1, mockConta.compareTo(new Object()));
    }

    @Test
    public void testeToString(){
        assertEquals("Fleeur", mockConta.toString());
    }
}
