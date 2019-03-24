package System;

import java.util.ArrayList;
import java.util.List;

public class CadastroContas {
    private List<ContaMagica> contas;

    public CadastroContas(List<ContaMagica> contas) {
        contas = new ArrayList<ContaMagica>(contas);
    }

    public CadastroContas() {
        contas = new ArrayList<ContaMagica>();
    }

    public boolean insereConta(ContaMagica newConta) {
        if (contas.size() == 0) {
            contas.add(newConta);
            return true;
        } else {
            for (ContaMagica f : contas) {
                if (f.compareTo(newConta) > 0) {
                    contas.add(newConta);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean removeConta(String titular) {
        for (ContaMagica f : contas) {
            if (f.getNomeCliente().equals(titular)) {
                contas.remove(f);
                return true;
            }
        }
        return false;
    }

    public ContaMagica pesquisaContas(String titular) {
        for (ContaMagica f : contas) {
            if (f.getNomeCliente().equals(titular))
                return f;
        }
        return null;
    }

    @Override
    public String toString() {
        String str = "";
        int roots = 1;
        str += "================================================\n";
        for (ContaMagica f : contas) {
            str+= "Conta " + roots + ": \n";
            str += "Nome do titular -> " + f.getNomeCliente() + "\n";
            str += "Categoria -> " + f.getStatus() + "\n";
            str += "Saldo -> " + f.getSaldo() + "\n";
            str += "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
            roots++;
        }
        str += "================================================";
        return str;
    }
}