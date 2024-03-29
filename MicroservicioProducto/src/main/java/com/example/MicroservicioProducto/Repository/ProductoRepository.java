package com.example.MicroservicioProducto.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MicroservicioProducto.Entity.Producto;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
    List<Producto> findByUserId(int userId);

}
