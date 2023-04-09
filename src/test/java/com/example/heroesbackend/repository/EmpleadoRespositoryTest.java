package com.example.heroesbackend.repository;

import com.example.heroesbackend.model.EmpleadosTEST;
import com.example.heroesbackend.respository.EmpleadoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.*;

@DataJpaTest //Sirve para probar componente solo de la capa de persistencia. Busca las clases que tengan la anotacion Entity
//Es decir, esto solo tocar[ia los archivos que esten en la carpeta model y repository
public class EmpleadoRespositoryTest {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Test
    void testGuardarEmpleado(){
        //given
        EmpleadosTEST empleado1 = EmpleadosTEST.builder()
                .nombre("Pepe")
                .apellido("Lopez")
                .email("p12@gmail.com")
                .build();
        //when
        EmpleadosTEST empleadoGuardado = empleadoRepository.save(empleado1);

        //then
        /**Para la parte de los assertion, hay que ver que se le puede hacer para probar, si se ve, en el save
         * que es un metodo ya probado, lo que se deberia probar es que si se guarda, cuando se guarda correctamente
         * el valore del objeto es devuelto, por lo que NO deber[ia ser null y adem[as, el id, como es incremental, debido
         * a la estrategia escogida, DEBE ser mayor que 0, ya que como este es el primer empleado que se guarda y la estrategia de dar
         * el id es incremental, el id pasa de ser 0 a 1, por lo que esas pueden ser las pruebas.
         */
        assertThat(empleadoGuardado).isNotNull();
        assertThat(empleadoGuardado.getId()).isGreaterThan(0);
    }
}
