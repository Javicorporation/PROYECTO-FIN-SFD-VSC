package com.example.MicroservicioProducto.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MicroservicioProducto.Entity.Producto;
import com.example.MicroservicioProducto.Repository.ProductoRepository;
@Service
public class ProductoServicio {

    @Autowired
    ProductoRepository productoRepository;


    public List<Producto> getAll(){
        return productoRepository.findAll();
    }

    public Producto getById(Long id){
        return productoRepository.findById(id).orElse(null);
    }

    public Producto save (Producto producto){
        Producto newProducto = productoRepository.save(producto);
        return newProducto;
    }

    public List<Producto> byUserId(int userId){
        return productoRepository.findByUserId(userId);
    }
      
}
