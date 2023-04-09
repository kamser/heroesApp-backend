package com.example.heroesbackend.service.serviceImplementation;

import com.example.heroesbackend.exception.ResourceNotFoundException;
import com.example.heroesbackend.model.EmpleadosTEST;
import com.example.heroesbackend.respository.EmpleadoRepository;
import com.example.heroesbackend.service.EmpleadoTESTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImplTEST implements EmpleadoTESTService {

    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Override
    public EmpleadosTEST saveEmpleado(EmpleadosTEST empleado) {
        Optional<EmpleadosTEST> empleadoGuardado = empleadoRepository.findByEmail(empleado.getEmail());
        if(empleadoGuardado.isPresent()){
            throw new ResourceNotFoundException("El empleado con ese email ya existe: " + empleado.getEmail());
        }
        return empleadoRepository.save(empleado);
    }

    @Override
    public List<EmpleadosTEST> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Optional<EmpleadosTEST> getEmpleadoById(long id) {
        return empleadoRepository.findById(id);
    }

    @Override
    public EmpleadosTEST updateEmpleado(EmpleadosTEST empleadoTESTActualizado) {
        return empleadoRepository.save(empleadoTESTActualizado);
    }

    @Override
    public void deleteEmpleadoTEST(long id) {
        empleadoRepository.deleteById(id);
    }
}
