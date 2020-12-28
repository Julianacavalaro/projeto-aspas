package com.deveducation.aspas.service;

import java.nio.charset.Charset;
import java.util.Optional;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.deveducation.aspas.model.UserLogin;
import com.deveducation.aspas.model.UsuarioModel;
import com.deveducation.aspas.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repository;

	public Optional<UsuarioModel> CadastrarUsuario(UsuarioModel usuario) {
		if(repository.findByEmailUsuario(usuario.getEmailUsuario()).isPresent())
			return null;
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaEncoder = encoder.encode(usuario.getSenhaUsuario());
		usuario.setSenhaUsuario(senhaEncoder);
		return Optional.of(repository.save(usuario));
	}

	public Optional<UserLogin> Logar(Optional<UserLogin> user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<UsuarioModel> usuario = repository.findByEmailUsuario(user.get().getEmailUsuario());
		if (usuario.isPresent()) {
			if (encoder.matches(user.get().getSenhaUsuario(), usuario.get().getSenhaUsuario())) {
				String auth = user.get().getEmailUsuario() + ":" + user.get().getSenhaUsuario();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
				user.get().setTipoUsuario(usuario.get().getTipoUsuario());
				user.get().setToken(authHeader);
				user.get().setNomeCompleto(usuario.get().getNomeCompleto());
				return user;
			}
		}
		return null;
	}
}