package com.example.heroesbackend;

import com.example.heroesbackend.service.ServiceA;
import com.example.heroesbackend.service.ServiceB;
import com.example.heroesbackend.service.serviceImplementation.ServiceAImpl;
import com.example.heroesbackend.service.serviceImplementation.ServiceBImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class TestServiceB {
    @Test
    public void testMultiply(){
        //given
        int a = 2;
        int b = 2;
        int expectedResult = 4;
        ServiceB serviceB = new ServiceBImpl();
        //when
        int testResult = serviceB.multiply(a, b);

        //then
        assertThat(testResult)
                .isEqualTo(expectedResult);
    }

    /**Lo malo de hacerlo sin mokito es que si algo en la clase ServiceA, en su metodo Addition
     * cambia, esto va a fallar, porque la logica del metodo ya no es la misma y el resultado
     * va a poder cambiar. Por otro lado con mokito, en s[i lo que se hace es simular que el metodo
     * se ejecuta, pero realmente NO se esta ejecutando, solo se esta diciendo que cuando el metodo
     * se deba ejecutar va a retornar un valor que el dev ya le da por defecto para que la prueba pase*/
  @Test
    public void testMultiplicateAdditionWithoutMockito(){
        //given
        int a = 2;
        int b = 3;
        int c = 2;
        int expectedResult = 10;

        ServiceA serviceA = new ServiceAImpl();
        ServiceB serviceB = new ServiceBImpl();

        serviceB.setServiceA(serviceA);
        //when
        int testResult = serviceB.multiplyAddition(a, b, c);

        //then
        assertThat(testResult)
                .isEqualTo(expectedResult);
    }

    @Test
    public void testMultiplicateAdditionWithMockito(){
        //given
        int factorOne = 2;
        int factorTwo = 3;
        int multiplicator = 2;
        int preparedResultForMockito = 10000;
        int expectedResult = 20000;

        /**Aqui es donde se va a uasr mokito, este hace parecer que es una instancia de una clase
         * de verdad, pero en realidad es una simulacion que va a dar el resultado que se ponga
         * y NO va a ejecutar realmente a los meetodos de la clase, simplemente, cuando un metodo de
         * esta clase simulada sea invocado por la case B, lo que se le va a dar es el resultado
         * que se le indico al metodo de la clase simulador que diera, pero NO se esta ejecutando ningun metodo*/
        ServiceA serviceA = Mockito.mock(ServiceA.class);

        /**En este paso se le dice lo que debe dar como respuesta a un metodo cuando le llamen.
         * Como se puede ver,todo es preparado, se le esta enviando un 2 y un 3 como parametro
         * y se le esta diciendo que va a responder con 10000 algo que no es correcto, pero como
         * la respuesta esta preparada y simplemente se quiere que retorne algo preparado pues se le puso eso*/
        Mockito.when(serviceA.addition(factorOne, factorTwo)).thenReturn(preparedResultForMockito);
        ServiceB serviceB = new ServiceBImpl();

        serviceB.setServiceA(serviceA); //Aqui, nuevamente, NO se le esta enviando la clase de verdad, si no el simulador con el metodo cheteado.
        //when
        int testResult = serviceB.multiplyAddition(factorOne, factorTwo, multiplicator);

        //then
        assertThat(testResult)
                .isEqualTo(expectedResult);
    }
}
