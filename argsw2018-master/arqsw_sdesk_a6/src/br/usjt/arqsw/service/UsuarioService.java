package br.usjt.arqsw.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.arqsw.dao.UsuarioDAO;
import br.usjt.arqsw.entity.Usuario;
/**
 * 
 * @author RA81617543 Igor Almeida
 * CCP3AN-MCA 
 * Arquitetura de software
 *
 */
@Service
public class UsuarioService {
	
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	public UsuarioService(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	/**
	 * M�todo que valida as credenciais de um usu�rio
	 * @param autenticar Usuario que quer logar
	 * @return Usuario
	 * @throws IOException
	 */
	public Usuario logar(Usuario autenticar) throws IOException {
		Usuario usuario = usuarioDAO.obterPorUsuario(autenticar.getUsername());
		
		if(usuario != null && usuario.getPassword().equals(autenticar.getPassword())){
			return usuario;
		}
		return null;
	}
}
