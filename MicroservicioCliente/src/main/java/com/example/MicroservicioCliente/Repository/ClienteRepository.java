package com.example.MicroservicioCliente.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MicroservicioCliente.Entity.Cliente;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
