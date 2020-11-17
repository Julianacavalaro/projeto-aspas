package com.deveducation.aspas.seguranca;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.deveducation.aspas.model.UsuarioModel;
import com.deveducation.aspas.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<UsuarioModel> user = userRepository.findByEmailUsuario(userName);
		user.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));

		return user.map(UserDetailsImpl::new).get();
	}
}