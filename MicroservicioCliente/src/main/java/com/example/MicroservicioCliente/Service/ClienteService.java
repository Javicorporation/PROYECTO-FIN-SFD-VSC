package com.example.MicroservicioCliente.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.MicroservicioCliente.Entity.Cliente;
import com.example.MicroservicioCliente.Model.Factura;
import com.example.MicroservicioCliente.Model.Producto;
import com.example.MicroservicioCliente.Repository.ClienteRepository;

@Service
public class ClienteService{
    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    RestTemplate restTemplate;

  
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    
    public Cliente getByID(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Factura> getFacturas(Long userId){
        List<Factura> facturas = restTemplate.getForObject("http://localhost:8083/Factura/byUser/"+userId, List.class);
        return facturas;
    }

    public List<Producto> getProductos(Long userId){
        List<Producto> productos = restTemplate.getForObject("http://localhost:8082/Producto/byUser/"+userId,List.class);
        return productos;
    }



    
    

}
