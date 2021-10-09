package com.conSofkau.crudTiendaElectrodomesticos.controller;


import com.conSofkau.crudTiendaElectrodomesticos.entity.Electrodomestico;
import com.conSofkau.crudTiendaElectrodomesticos.service.ServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class ControllerElectrodomesticos {

    @Autowired
    private ServiceI servicio;

    @GetMapping(value="listarElectrodomesticos")
    public Iterable<Electrodomestico> listarElectrodomesticos(){
        return servicio.listar();
    }


    @PostMapping(value ="guardarElectrodomestico")
    public Electrodomestico guardarElectrodomestico(@RequestBody Electrodomestico electrodomestico){
        return servicio.guardar(electrodomestico);
    }


}
