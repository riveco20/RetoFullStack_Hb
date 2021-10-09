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
    private String precio;
    private String marca;

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

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
