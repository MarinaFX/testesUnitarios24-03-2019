package UnitaryTest;

import Dubles.MockCadastro;
import Dubles.MockContaMagica;
import Sistema.App;

import java.math.BigDecimal;
import java.util.Scanner;

public class AppTeste {
    private static MockCadastro cadastro = new MockCadastro();

    private static String fazPergunta(String pergunta) {
        Scanner in = new Scanner(System.in);
        String resposta;
        System.out.println(pergunta);
        resposta = in.nextLine();
        return resposta;
    }

    private static void mostraOpcoes() {
        System.out.println("1 = Criar uma conta nova");
        System.out.println("2 = Efetuar deposito");
        System.out.println("3 = Efetuar saque");
        System.out.println("4 = Encerrar uma conta");
        System.out.println("5 = mostrar contas");
    }

    private static void mostraCadastro(String newSenha) {
        String senha = "flemis115";
        if (senha.equals(newSenha))
            System.out.println(cadastro.toString());
        else
            System.out.println("Senha incorreta!");
    }

    private static void atendeUsuario(String escolha) {
        String resposta;
        boolean aux;

        if (escolha.equals("1")) {
            resposta = AppTeste.fazPergunta("Insira o titular da nova conta: ");
            aux = cadastro.insereConta();

            if (aux)
                System.out.println("Conta criada!");
            else
                System.out.println("Essa Conta já existe!");

            resposta = "";
            aux = false;
        } else {
            if (escolha.equals("2")) {
                resposta = AppTeste.fazPergunta("Insira a conta para o deposito: ");
                MockContaMagica auxConta = cadastro.pesquisaContas();

                if (!(auxConta == null)) {
                    try {
                        resposta = AppTeste.fazPergunta("Insira a quantia a ser depositada: ");
                        aux = auxConta.deposito(new BigDecimal(resposta));

                        if (aux) {
                            System.out.println("Deposito realizado com sucesso!");
                        }

                    } catch (IllegalArgumentException f) {
                        System.out.println(f.getMessage());
                    }
                }

                resposta = "";
                aux = false;
            } else {
                if (escolha.equals("3")) {
                    resposta = AppTeste.fazPergunta("Insira a conta para o saque: ");
                    MockContaMagica auxConta = cadastro.pesquisaContas();

                    if (!(auxConta == null)) {
                        try {
                            resposta = AppTeste.fazPergunta("Insira a quantia a ser sacada: ");
                            aux = auxConta.retirada(new BigDecimal(resposta));

                            if (aux) {
                                System.out.println("Saque realizado com sucesso!");
                            }

                        } catch (IllegalArgumentException f) {
                            System.out.println(f.getMessage());
                        }
                    }

                    resposta = "";
                    aux = false;
                } else {
                    if (escolha.equals("4")) {
                        resposta = AppTeste.fazPergunta("Insira o titular da conta a ser encerrada: ");
                        aux = cadastro.removeConta();

                        if (aux)
                            System.out.println("Conta encerrada com sucesso!");
                        else
                            System.out.println("Conta não existe!");

                        resposta = "";
                        aux = false;
                    } else {
                        if (escolha.equals("5")) {
                            resposta = AppTeste.fazPergunta("Insira a senha: ");
                            AppTeste.mostraCadastro(resposta);
                            resposta = "";
                            aux = false;
                        }
                    }
                }
            }
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String resposta = "";

        System.out.println("=======================Bem Vindo!=========================");

        while (true) {
            System.out.println("O que deseja fazer?");
            AppTeste.mostraOpcoes();
            resposta = in.nextLine();
            AppTeste.atendeUsuario(resposta);

            System.out.println("Deseja realizar outra operação?");
            System.out.println("0 = Não \n1 = Sim");
            resposta = in.nextLine();
            if ((resposta.equals("0")) || (resposta.equals("nao"))) {
                System.out.println("Obrigada pela preferência!");
                System.out.println("======================FIM========================");
                break;
            }
        }
    }
}
