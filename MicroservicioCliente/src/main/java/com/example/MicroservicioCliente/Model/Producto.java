package com.example.MicroservicioCliente.Model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    private String name;
    private String maker;
    private double price;
    private String supplier;
    private Date fechaExp;

}
