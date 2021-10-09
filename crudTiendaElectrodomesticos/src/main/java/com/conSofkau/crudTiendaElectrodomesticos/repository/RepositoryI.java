package com.conSofkau.crudTiendaElectrodomesticos.repository;

import com.conSofkau.crudTiendaElectrodomesticos.entity.Electrodomestico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryI extends JpaRepository<Electrodomestico,Integer> {

}
