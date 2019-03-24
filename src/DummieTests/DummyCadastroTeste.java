package DummieTests;

import Dubles.DummyCadastro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DummyCadastroTeste {
    private DummyCadastro dumb;

    @BeforeEach
    public void setUp(){
        dumb = new DummyCadastro();
    }

    @Test
    public void testeInsereConta(){
        assertEquals("insereConta 0.K", dumb.insereConta());
    }

    @Test
    public void testeRemoveConta(){
        assertEquals("removeConta 0.K", dumb.removeConta());
    }

    @Test
    public void testePesquisaContas(){
        assertEquals("pesquisaConta 0.K", dumb.pesquisaContas());
    }

    @Test
    public void testeToString(){
        assertEquals("toString 0.K", dumb.toString());
    }
}
