package com.conSofkau.crudTiendaElectrodomesticos.service;

import com.conSofkau.crudTiendaElectrodomesticos.entity.Electrodomestico;
import com.conSofkau.crudTiendaElectrodomesticos.repository.RepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@org.springframework.stereotype.Service
public class ServiceElectrodomestico implements ServiceInterface {

    @Autowired
    private RepositoryInterface data;

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
        UUID uuid = UUID.randomUUID();
        electrodomesticos.setSerial(uuid.toString().replace("-","").substring(17));
        return data.save(electrodomesticos);

    }

    @Override
    public void borrar(int id) {
        data.delete(listarId(id));

    }


}
