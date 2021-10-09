package com.conSofkau.crudTiendaElectrodomesticos.controller;


import com.conSofkau.crudTiendaElectrodomesticos.entity.Electrodomestico;
import com.conSofkau.crudTiendaElectrodomesticos.service.ServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerElectrodomesticos {

    @Autowired
    private ServiceI servicio;

    @GetMapping(value="api/listarElectrodomestico")
    public Iterable<Electrodomestico> listarElectrodomesticos(){
        return servicio.listar();
    }


    @PostMapping(value ="api/apiguardarElectrodomestico")
    public Electrodomestico guardarElectrodomestico(@RequestBody Electrodomestico electrodomestico){
        return servicio.guardar(electrodomestico);
    }

    @PutMapping(value = "api/actualizarElectrodomestico")
    public Electrodomestico actualizar(@RequestBody Electrodomestico electrodomestico){
        if (electrodomestico.getId()!=null) {
            return servicio.guardar(electrodomestico);
        }
        throw new RuntimeException("No existe el id para actualizar");
    }

    @DeleteMapping(value = "api/{id}electrodomestico")
    public void delete(@PathVariable("id") Integer id){
        servicio.borrar(id);
    }

    @GetMapping(value = "api/{id}/electrodomestico")
    public Electrodomestico obtenerTodoId(@PathVariable("id") Integer id){
        return servicio.listarId(id);
    }



}
