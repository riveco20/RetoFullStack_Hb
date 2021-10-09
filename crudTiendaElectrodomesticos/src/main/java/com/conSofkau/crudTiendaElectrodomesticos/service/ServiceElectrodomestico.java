package com.conSofkau.crudTiendaElectrodomesticos.service;

import com.conSofkau.crudTiendaElectrodomesticos.entity.Electrodomestico;
import com.conSofkau.crudTiendaElectrodomesticos.repository.RepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ServiceElectrodomestico implements ServiceI{

    @Autowired
    private RepositoryI data;

    @Override
    public List<Electrodomestico> listar() {
        return (List<Electrodomestico>) data.findAll();
    }

    @Override
    public Electrodomestico listarId(int id) {
        Optional<Electrodomestico> optionalTodo = data.findById(id);
        if(optionalTodo.isEmpty()){
            throw  new NoSuchElementException("El electrodomesticolistado no existe");
        }
        return optionalTodo.get();
    }


    @Override
    public Electrodomestico guardar(Electrodomestico electrodomesticos) {
        return data.save(electrodomesticos);
    }

    @Override
    public void borrar(int id) {
        data.delete(listarId(id));

    }


}
