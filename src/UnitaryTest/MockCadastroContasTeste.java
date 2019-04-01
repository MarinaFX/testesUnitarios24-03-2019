package UnitaryTest;

import Dubles.MockCadastro;
import Dubles.MockContaMagica;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MockCadastroContasTeste {
    MockContaMagica mockConta;
    MockCadastro mockCad;

    @BeforeEach
    public void setUp(){
        mockConta = new MockContaMagica();
        mockCad = new MockCadastro();
    }

    @Test
    public void testeInsereConta(){
        assertTrue(mockCad.insereConta());
    }

    @Test
    public void testeRemoveConta(){
        assertTrue(mockCad.removeConta());
    }

    @Test
    public void testePesquisaConta(){
        MockContaMagica f = new MockContaMagica();
        assertEquals(1, mockCad.pesquisaContas().compareTo(f));
    }

    @Test
    public void testeToString(){
        assertEquals("toString 0.K", mockCad.toString());
    }
}
