package Dubles;

import System.CadastroContas;
import java.util.Scanner;

public class DummyApp {
    private static DummyCadastro dummyCad = new DummyCadastro();

    private static void atendeUsuario( String escolha) {
        String resposta;

        if (escolha.equals("1")) {
            System.out.println("Teste cria conta: ");
            resposta = dummyCad.insereConta();

            if (resposta.equals("insereConta 0.K"))
                System.out.println("teste 0.K");
            else
                System.out.println("fracassada HAHA");

            resposta = "";
        }

        if (escolha.equals("2")) {
            System.out.println("Teste deposito: ");
            DummyContaMagica auxConta = new DummyContaMagica();
            resposta = auxConta.deposito();

            if (resposta.equals("deposito 0.K"))
                System.out.println("teste 0.K");
            else
                System.out.println("fracassada HAHA");

            resposta = "";
        }

        if (escolha.equals("3")) {
            System.out.println("Teste retirada: ");
            DummyContaMagica auxConta = new DummyContaMagica();
            resposta = auxConta.retirada();

            if (resposta.equals("retirada 0.K"))
                System.out.println("teste 0.K");
            else
                System.out.println("fracassada HAHA");

            resposta = "";
        }

        if (escolha.equals("4")) {
            System.out.println("Teste encerra conta: ");
            resposta = dummyCad.removeConta();

            if (resposta.equals("removeConta 0.K"))
                System.out.println("teste 0.K");
            else
                System.out.println("fracassada HAHA");

            resposta = "";
        }

        if (escolha.equals("5")) {
            System.out.println("Teste mostra cadastro: ");
            resposta = DummyApp.fazPergunta("Insira a senha: ");
            DummyApp.mostraCadastro(resposta);
            resposta = "";
        }

    }

    public static String fazPergunta(String pergunta) {
        Scanner in = new Scanner(System.in);
        String resposta = "";
        System.out.println(pergunta);
        resposta = in.nextLine();
        return resposta;
    }

    private static void mostraCadastro(String newSenha) {
        String senha = "dummies";
        if (senha.equals(newSenha))
            System.out.println(dummyCad.toString());
        else
            System.out.println("Senha incorreta!");
    }

    private static void mostraOpcoes() {
        System.out.println("1 = Criar uma conta nova no banco");
        System.out.println("2 = Efetuar deposito");
        System.out.println("3 = Efetuar saque");
        System.out.println("4 = Encerrar uma conta");
        System.out.println("5 = mostrar contas");
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String resposta = "";

        System.out.println("=======================TESTING APP=========================");

        while (true) {
            System.out.println("O que deseja fazer?");
            DummyApp.mostraOpcoes();
            resposta = in.nextLine();
            DummyApp.atendeUsuario(resposta);

            System.out.println("Deseja realizar outra operação?");
            System.out.println("0 = Não \n1 = Sim");
            resposta = in.nextLine();
            if ((resposta.equals("0")) || (resposta.equals("nao"))) {
                System.out.println("Obrigada pela preferência!");
                System.out.println("======================TESTING END========================");
                break;
            }
        }
    }
}