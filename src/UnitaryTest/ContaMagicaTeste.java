package UnitaryTest;

import Sistema.Categoria;
import Sistema.ContaMagica;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;



/*
 * PREGUNTAS - Como podemos definir a ordem de execução dos testes? Existe um @Before para testes de maneira individual?
 *  Exemplo: antes de fazer os testes da conta o getStatus funcionava.
 */

public class ContaMagicaTeste {
    private ContaMagica conta;

    @BeforeEach
    public void setUp(){
        conta = new ContaMagica("Marina");
        conta.setSaldo(new BigDecimal(10000));
    }

    @Test
    public void testeGetSaldo(){
        Assertions.assertEquals(new BigDecimal(10000), conta.getSaldo());
    }

    @Test
    public void testeGetNomeCliente(){
        Assertions.assertEquals("Marina", conta.getNomeCliente());
    }

    @Test
    public void testeNomeClienteNull(){
        assertThrows(NullPointerException.class, () -> new ContaMagica(null));
    }

    @Test
    public void testeNomeClienteVoid(){
        assertThrows(NullPointerException.class, () -> new ContaMagica(""));
    }

    @Test
    public void testeGetStatus(){
        Assertions.assertEquals(Categoria.SILVER, conta.getStatus());
    }

    @Test
    public void testeSetSaldo(){
        conta.setSaldo(new BigDecimal(10000));
        Assertions.assertEquals(new BigDecimal(10000), conta.getSaldo());
    }

    @Test
    public void testeDepositoSemSairDeSilverAbaixoDeCinquentaMil(){
        conta.deposito(new BigDecimal(35000));
        Assertions.assertEquals(new BigDecimal(45000), conta.getSaldo());
    }

    @Test
    public void testeDepositoJaEmGoldExtamenteCinquentaMil(){
        conta.deposito(new BigDecimal(40000));
        Assertions.assertEquals(new BigDecimal(50400), conta.getSaldo());
    }

    @Test
    public void testeDepositoSemSairDeGold(){
        conta.deposito(new BigDecimal(105000));
        Assertions.assertEquals(new BigDecimal(116050), conta.getSaldo());
    }

    @Test
    public void testeDepositoPlatinumExatamenteDuzentos(){
        conta.deposito(new BigDecimal(190000));
        Assertions.assertEquals(new BigDecimal(204750), conta.getSaldo());
    }

    @Test
    public void testeDepositoPlatinumAcimaDeDuzentos(){
        conta.deposito(new BigDecimal(215000));
        Assertions.assertEquals(new BigDecimal(230375), conta.getSaldo());
    }

    @Test
    public void testeRetiradaNegativa(){
        assertThrows(IllegalArgumentException.class, () -> conta.retirada(new BigDecimal(-1150000)));
    }

    @Test
    public void testeRetiradaPlatinumParaGold(){
        conta.deposito(new BigDecimal(215000));
        conta.retirada(new BigDecimal(140000));
        Assertions.assertEquals(new BigDecimal(90375), conta.getSaldo());
    }

    @Test
    public void testeRetiradaGoldParaSilver(){
        conta.deposito(new BigDecimal(40000));
        conta.retirada(new BigDecimal(30000));
        Assertions.assertEquals(new BigDecimal(20400), conta.getSaldo());
    }

    @Test
    public void testeRetiradaSilverParaSilver(){
        conta.retirada(new BigDecimal(5000));
        Assertions.assertEquals(new BigDecimal(5000), conta.getSaldo());
    }

    @Test
    public void testeRetiradaMaiorQueSaldo(){
        assertThrows(IllegalArgumentException.class, () -> conta.retirada(new BigDecimal(115000)));
    }

    @Test
    public void testeRetiradaValorZero(){
        assertThrows(IllegalArgumentException.class, () -> conta.retirada(new BigDecimal(0)));
    }
}