package com.idat.ec2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.idat.ec2.dto.UsuarioDTORequest;
import com.idat.ec2.dto.UsuarioDTOResponse;
import com.idat.ec2.security.TokenUtil;
import com.idat.ec2.security.UserDetailService;

@Controller
public class UsuarioController {
	
	@Autowired
	private TokenUtil util;
	@Autowired
	private UserDetailService service;
	
	@RequestMapping(path= "/crearToken",method = RequestMethod.POST)
	public ResponseEntity<?> crearToken(@RequestBody UsuarioDTORequest request){
		UserDetails user= service.loadUserByUsername(request.getUsuario());
		return ResponseEntity.ok(new UsuarioDTOResponse(util.generateToken(user.getUsername())));
		
	}

}
