package com.example.MicroservicioCliente.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MicroservicioCliente.Entity.Cliente;
import com.example.MicroservicioCliente.Entity.validation.Error;
import com.example.MicroservicioCliente.Model.Factura;
import com.example.MicroservicioCliente.Model.Producto;
import com.example.MicroservicioCliente.Service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> traerTodo(){
        List<Cliente> traeTodo = clienteService.getAll();
        if(traeTodo.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(traeTodo);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> traeUno(@PathVariable("id") Long id){
        Cliente traerUno = clienteService.getByID(id);
        if(traerUno == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(traerUno);
    }

    

    @PostMapping()
    public ResponseEntity<?> guardar(@Valid @RequestBody Cliente cliente, BindingResult result) {
        if (result.hasErrors()) {
            List<String> messages = result.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList());
            String errorMessage = String.join(", ", messages); 
            return ResponseEntity.badRequest().body(new Error("Validation Error", errorMessage));
        }
        Cliente newCliente = clienteService.save(cliente);
        return ResponseEntity.ok(newCliente);
    }

    @GetMapping("/Factura/{userId}")
    public ResponseEntity<?> getFacturas(@PathVariable("userId")Long userId){
        Cliente cliente = clienteService.getByID(userId);
        if(cliente == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El registro no existe");
        List<Factura> facturas = clienteService.getFacturas(userId);
        return ResponseEntity.ok(facturas);
    }
    
    @GetMapping("/Producto/{userId}")
public ResponseEntity<?> getProductos(@PathVariable("userId")Long userId){
        Cliente cliente = clienteService.getByID(userId);
        if(cliente == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El registro no existe");
        List<Producto> productos = clienteService.getProductos(userId);
        return ResponseEntity.ok(productos);
    }




    
    



}
