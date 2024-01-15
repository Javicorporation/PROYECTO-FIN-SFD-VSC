package com.example.MicroservicioCliente.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

@Table(name = "clientes")
public class Cliente {
   
    public Cliente(Long id, String name, String lastName, int phone, String mail) {
        super();
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.mail = mail;
    }


    public Cliente(String name, String lastName, int phone, String mail) {
        super();
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.mail = mail;
    }


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El nombre no puede estar vacio")
    @NotBlank(message = "El nombre no puede ser nulo")
    @Column(name = "nombre",nullable = false)
    private String name;

    @NotNull(message = "El apellido no puede estar vacio")
    @NotBlank(message = "El apellido no puede ser nulo")
    @Column(name = "apellido",nullable = false)
    private String lastName;

    @NotNull(message = "El telefono no puede estar vacio")
    @Column(name = "telefono",nullable = false)
    private int  phone;

    @Email(message = "El Formato de correo electrónico no válido")
    @NotBlank(message = "El correo no puede ser nulo")
    @Column(name = "correo",nullable = false)
    private String mail;




    @Override
    public String toString() {
        return "Cliente [id=" + id + ", name=" + name + ", lastName=" + lastName + ", phone=" + phone + ", mail=" + mail
                + "]";
    }

    

}
