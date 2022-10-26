package com.idat.ec2.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name="clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idCliente;
	private String nombre;
	private String direccion;
	private String dni;
	
	@ManyToMany()
	@JoinTable(
			name= "cliente_producto",
			joinColumns = @JoinColumn(
					name="id_cliente",
					nullable= false,
					unique=true,
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_cliente references clientes(id_cliente)")
					),
			inverseJoinColumns = @JoinColumn(
					name= "id_producto",
					nullable = false,
					unique = true,
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_producto references productos(id_producto)")
					)
			)
	private List<Producto> productos = new ArrayList<>();

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}


	
	

}
