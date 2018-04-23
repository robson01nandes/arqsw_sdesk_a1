package br.usjt.arqsw.controller.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;
import br.usjt.arqsw.service.ChamadoService;
import br.usjt.arqsw.service.FilaService;

/**
 * 
 * @author RA81617543 Igor Almeida
 * CCP3AN-MCA 
 * Arquitetura de software
 *
 */

@RestController
@Transactional
public class ManterChamadosRest {

	@Autowired
	private FilaService filaService;

	@Autowired
	private ChamadoService chamadoService;
	
	@RequestMapping(value = "/rest/fila", method = RequestMethod.GET)
	public List<Fila> listarFila() {
		List<Fila> filas = new ArrayList<>();
		try {
			filas = filaService.listarFilas();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filas;
	}
	
	@RequestMapping(value = "/rest/chamado/{idFila}", method = RequestMethod.GET)
	public List<Chamado> listarChamadoPorIdFila(@PathVariable("idFila") int idFila) {
		List<Chamado> chamados = new ArrayList<>();
		try {
			Fila fila = filaService.carregar(idFila);
			chamados = chamadoService.listarChamadoPorFila(fila);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return chamados;
	}
	@RequestMapping(value = "/rest/chamado", method = RequestMethod.POST)
	public ResponseEntity<Chamado> salvarChamado(@RequestBody Chamado chamado) {
		try {
			Chamado chamadoCriado = chamadoService.salvar(chamado);
			return ResponseEntity.ok(chamadoCriado);
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body(chamado);
		}
	}
}
