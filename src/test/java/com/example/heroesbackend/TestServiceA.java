package com.example.heroesbackend;

import com.example.heroesbackend.service.ServiceA;
import com.example.heroesbackend.service.serviceImplementation.ServiceAImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class TestServiceA {
    @Test
    public void testAddition(){
        //given
        int a = 2;
        int b = 2;
        int expectedResult = 4;
        ServiceA serviceA = new ServiceAImpl();

        //when
        int additionResult = serviceA.addition(a, b);

        //then
        assertThat(additionResult)
                .isEqualTo(expectedResult);
    }
}
