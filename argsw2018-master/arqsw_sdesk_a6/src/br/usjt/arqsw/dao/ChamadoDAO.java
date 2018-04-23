package br.usjt.arqsw.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Chamado;

/**
 * 
 * @author RA81617543 Igor Almeida CCP3AN-MCA Arquitetura de software
 *
 */
@Repository
public class ChamadoDAO {
	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public List<Chamado> listarPorIdFila(int id) throws IOException {
		return manager.createQuery("select c from Chamado c Where c.fila.id = ?").setParameter(1, id).getResultList();
	}

	public Chamado salvar(Chamado chamado) {
		 manager.persist(chamado);
		 return obterUltimoRegistro();
	}

	private Chamado obterUltimoRegistro() {
		return (Chamado) manager.createQuery("select c from Chamado c Order By c.id desc").setMaxResults(1).getSingleResult();
	}

	public Chamado obterPorId(int idChamado) {
		return manager.find(Chamado.class, idChamado);
	}

}
