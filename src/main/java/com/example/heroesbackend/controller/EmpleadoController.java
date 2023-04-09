package com.example.heroesbackend.controller;

import com.example.heroesbackend.model.EmpleadosTEST;
import com.example.heroesbackend.service.EmpleadoTESTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {
    @Autowired
    private EmpleadoTESTService empleadoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmpleadosTEST guardarEmpleado(@RequestBody EmpleadosTEST empleado){
        return empleadoService.saveEmpleado(empleado);
    }

    @GetMapping
    public List<EmpleadosTEST> listarEmpleados(){
        return empleadoService.getAllEmpleados();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadosTEST> obtenerEmpleadoPorId(@PathVariable("id") long empleadoId){
        return empleadoService.getEmpleadoById(empleadoId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadosTEST> actualizarEmpleado(@PathVariable("id") long empleadoId,@RequestBody EmpleadosTEST empleado){
        return empleadoService.getEmpleadoById(empleadoId)
                .map(empleadoGuardado -> {
                    empleadoGuardado.setNombre(empleado.getNombre());
                    empleadoGuardado.setApellido(empleado.getApellido());
                    empleadoGuardado.setEmail(empleado.getEmail());

                    EmpleadosTEST empleadoActualizado = empleadoService.updateEmpleado(empleadoGuardado);
                    return new ResponseEntity<EmpleadosTEST>(empleadoActualizado,HttpStatus.OK);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEmpleado(@PathVariable("id") long empleadoId){
        empleadoService.deleteEmpleadoTEST(empleadoId);
        return new ResponseEntity<>("Empleado eliminado exitosamente",HttpStatus.OK);
    }
}
