package com.example.MicroservicioFactura.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MicroservicioFactura.Entity.Factura;
import com.example.MicroservicioFactura.Repository.FacturaRepository;

@Service
public class FacturaService {
    @Autowired
    FacturaRepository facturaRepository;


    public List<Factura> getAll(){
        return facturaRepository.findAll();
    }

    public Factura getById(Long id){
        return facturaRepository.findById(id).orElse(null);
    }

    public Factura save(Factura factura){
        Factura newFactura = facturaRepository.save(factura);
        return newFactura;
    }

    public List<Factura> byUserId(int userId){
        return facturaRepository.findByUserId(userId);
    }
    

}
