package application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.Usuario;
import application.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository rep;
	
	public Usuario findUsuarioByNomeUsuario(String nomeUsuario){
		return rep.findUsuariosByNomeUsuarioEquals(nomeUsuario);
		
	}
	public Usuario loginUsuario(String nomeUsuario, String senhaUsuario){
		Usuario usuario = this.findUsuarioByNomeUsuario(nomeUsuario);
		if(usuario != null && usuario.getSenhaUsuario().equals(senhaUsuario)){
			return usuario;
		}
		return null;
	}
}
