package com.conSofkau.crudTiendaElectrodomesticos.service;

import com.conSofkau.crudTiendaElectrodomesticos.entity.Electrodomestico;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ServiceInterface {

    public List<Electrodomestico> listar();
    public Electrodomestico listarId(int id);
    public Electrodomestico guardar(Electrodomestico electrodomesticos);
    public void borrar(int id);
}
