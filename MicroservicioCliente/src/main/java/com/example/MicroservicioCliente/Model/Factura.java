package com.example.MicroservicioCliente.Model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Factura {
    private Date fechaExp;
    private String type;
    private String storeName;
    private String sellerName;

}
