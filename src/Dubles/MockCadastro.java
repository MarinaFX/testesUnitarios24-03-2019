package Dubles;

public class MockCadastro {

    public boolean insereConta(MockContaMagica conta) {
        return true;
    }

    public boolean removeConta(MockContaMagica conta) {
        return true;
    }

    public MockContaMagica pesquisaContas(MockContaMagica conta) {
        return conta;
    }

    public String toString() {
        return "toString 0.K";
    }
}
