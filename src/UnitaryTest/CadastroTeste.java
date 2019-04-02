package UnitaryTest;

import Dubles.MockCadastro;
import Dubles.MockContaMagica;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CadastroTeste {
    private MockCadastro cad;
    private MockContaMagica mockConta;

    @BeforeEach
    public void setUp(){
        cad = new MockCadastro();
        mockConta = new MockContaMagica();
    }

    @Test
    public void testeInsereConta(){
        assertTrue(cad.insereConta(mockConta));
    }

    @Test
    public void testeRemoveConta(){
        assertTrue(cad.removeConta(mockConta));
    }

    @Test
    public void testePesquisaConta(){
        assertEquals(mockConta, cad.pesquisaContas(mockConta));
    }

    @Test
    public void testeToString(){
        assertEquals("toString 0.K",cad.toString());
    }
}
