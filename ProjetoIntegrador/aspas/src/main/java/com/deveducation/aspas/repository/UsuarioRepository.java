package com.deveducation.aspas.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.deveducation.aspas.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
	public List<UsuarioModel> findAllByNomeCompletoContainingIgnoreCase(String nomeCompleto);

	public Optional<UsuarioModel> findByEmailUsuario(String emailUsuario);

}