package Dubles;

public class MockCadastro {

    public boolean insereConta(){
        return true;
    }

    public boolean removeConta(){
        return true;
    }

    public MockContaMagica pesquisaContas(){
        return new MockContaMagica();
    }

    public String toString(){
        return "toString 0.K";
    }
}
