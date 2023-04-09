package com.example.heroesbackend.service;

import com.example.heroesbackend.model.EmpleadosTEST;

import java.util.List;
import java.util.Optional;

public interface EmpleadoTESTService {
    //A estos son los metodos que se les va a hacer pruebas unitarias
    EmpleadosTEST saveEmpleado(EmpleadosTEST empleado);
    List<EmpleadosTEST> getAllEmpleados();
    Optional<EmpleadosTEST> getEmpleadoById(long id);
    EmpleadosTEST updateEmpleado(EmpleadosTEST empleadoTESTActualizado);
    void deleteEmpleadoTEST(long id);
}
