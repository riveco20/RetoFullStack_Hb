package com.conSofkau.crudTiendaElectrodomesticos.repository;

import com.conSofkau.crudTiendaElectrodomesticos.entity.Electrodomesticos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryI extends JpaRepository<Electrodomesticos,Long> {

}
