package com.idat.ec2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.ec2.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
