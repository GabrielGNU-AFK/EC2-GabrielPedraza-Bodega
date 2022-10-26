package com.idat.ec2.security;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.idat.ec2.model.Usuario;

@Service
public class UserDetailService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		if("adminx".equals(username)) {
			return new User("adminx","123",new ArrayList<>());
		}else {
			throw new UsernameNotFoundException("USER no encontrado" + username);
		}
		
	}

}
