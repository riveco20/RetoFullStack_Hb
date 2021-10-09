package com.conSofkau.crudTiendaElectrodomesticos.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tienda")
public class Electrodomestico {

    @Id
    private Integer id;
    private String electrodomestico;

    public Electrodomestico() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getElectrodomestico() {
        return electrodomestico;
    }

    public void setElectrodomestico(String electrodomestico) {
        this.electrodomestico = electrodomestico;
    }

}
