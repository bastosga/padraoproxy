import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CarroTest {

    @BeforeEach
    void setUp() {
        DataBase.addCarro(new Carro(001, "Focus", "Ford", 80000.0f));
        DataBase.addCarro(new Carro(002, "Up", "Volkswagen", 50000.0f));
    }

    @Test
    void retornaDadosCarro() {
        CarroProxy carro = new CarroProxy(001);

        assertEquals(Arrays.asList("Focus", "Ford"), carro.receberDadosCarro());
    }

    @Test
    void retornaValorCarro() {
        Funcionario funcionario = new Funcionario("Henry", true);
        CarroProxy carro = new CarroProxy(002);

        assertEquals(Arrays.asList(50000.0f), carro.receberValor(funcionario));
    }

    @Test
    void retornaUserNaoAutorizado() {
        try {
            Funcionario funcionario = new Funcionario("Jack", false);
            CarroProxy carro = new CarroProxy(002);

            carro.receberValor(funcionario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Funcionário não autorizado", e.getMessage());
        }
    }
}