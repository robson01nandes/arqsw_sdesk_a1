package br.usjt.arqsw.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author RA81617543 Igor Almeida CCP3AN-MCA Arquitetura de software
 *
 */
@Entity
@Table(name = "FILA")
public class Fila implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_FILA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NM_FILA")
	private String nome;

	@Column(name = "CAMINHO_FIGURA")
	private String caminhoFigura;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCaminhoFigura() {
		return caminhoFigura;
	}

	public void setCaminhoFigura(String caminhoFigura) {
		this.caminhoFigura = caminhoFigura;
	}

	@Override
	public String toString() {
		return "Fila [id=" + id + ", nome=" + nome + "]";
	}

}
