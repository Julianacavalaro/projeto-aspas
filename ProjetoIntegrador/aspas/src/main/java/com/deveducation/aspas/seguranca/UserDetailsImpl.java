package com.deveducation.aspas.seguranca;

import java.util.Collection;

import com.deveducation.aspas.model.UsuarioModel;


public class UserDetailsImpl {
	
	private static final long serialVersionUID = 1L; //versão 

	private String userName;
	private String password;

	public UserDetailsImpl(UsuarioModel user) { //CONSTRUTOR DE CLASSE
		this.userName = user.getEmailUsuario();
		this.password = user.getSenhaUsuario();		
	}

	public UserDetailsImpl() {}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true; //aqui costuma ser if else pra dar caminhos e diferentes situações
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
