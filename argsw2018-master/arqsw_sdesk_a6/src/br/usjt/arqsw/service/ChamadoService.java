package br.usjt.arqsw.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.arqsw.dao.ChamadoDAO;
import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;
/**
 * 
 * @author RA81617543 Igor Almeida
 * CCP3AN-MCA 
 * Arquitetura de software
 *
 */
@Service
public class ChamadoService {
	private ChamadoDAO chamadoDAO;
	
	@Autowired
	public ChamadoService(ChamadoDAO chamadoDAO) {
		this.chamadoDAO = chamadoDAO;
	}
	/**
	 * Método para encontrar chamados pela Fila
	 * @param fila Fila para encontrar chamados relacionados a ela
	 * @return Lista de chamados
	 * @throws IOException
	 */
	public List<Chamado> listarChamadoPorFila(Fila fila) throws IOException {
		return chamadoDAO.listarPorIdFila(fila.getId());
	}
	/**
	 * Método para salvar um chamado
	 * @param chamado Chamado que se deseja salvar
	 * @return Chamado que foi salvo
	 * @throws IOException
	 */
	public Chamado salvar(Chamado chamado) throws IOException {
		chamado.setDataAbertura(new Date());
		chamado.setStatus(Chamado.ABERTO);
		
		Chamado chamadoSalvo = chamadoDAO.salvar(chamado);
		
		return chamadoSalvo;
	}
	public Chamado fechar(int idChamado) {
		Chamado chamado = chamadoDAO.obterPorId(idChamado);
		chamado.setStatus(Chamado.FECHADO);
		chamado.setDataFechamento(new Date());
		chamadoDAO.salvar(chamado);
		
		return chamado;
		
	}

}
