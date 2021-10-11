package com.conSofkau.crudTiendaElectrodomesticos.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@lombok.Getter
@lombok.Setter
public class Electrodomestico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String serial;
    private String nameElectrodomestico;
    private String marca;
    private String precio;
    private boolean vendido;


    public Electrodomestico() {
    }

    public Electrodomestico(String serial) {
        this.serial = serial;
    }
}
