package br.usjt.arqsw.controller;

import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.usjt.arqsw.entity.Fila;
import br.usjt.arqsw.service.FilaService;

@Controller
@Transactional
public class ManterFilaController {

	@Autowired
	private FilaService filaService;
	
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping(value = "fila", method = RequestMethod.GET)
	public String fila() {
		return "FilaCriar";
	}
	@RequestMapping(value = "fila", method = RequestMethod.POST)
	public String criarFila(Fila fila, @RequestParam("file") MultipartFile file, Model model) {
		filaService.criar(fila);
		try {
			filaService.gravarImagem(servletContext, fila, file);
		} catch (IOException e) {
			e.printStackTrace();
			return "erro";
		}
		
		return "redirect:listar-fila";
	}
	@RequestMapping("/listar-fila")
	public String listarFilasExibir(Model model) {
		try {
			model.addAttribute("filas", filaService.listarFilas());
			return "FilaListar";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	@RequestMapping("/fila-exibir")
	public String exibir(@RequestParam(value = "id")int idFila,Model model) throws IOException {
			Fila fila = filaService.carregar(idFila);
			model.addAttribute("fila", fila);
			
			return "FilaExibir";

	}
	@RequestMapping(value = "alterar-fila", method = RequestMethod.GET)
	public String criarFila(@RequestParam(value = "id")int idFila,Model model) {
		Fila fila = null;
		try {
			fila = filaService.carregar(idFila);
		} catch (IOException e) {
			e.printStackTrace();
			return "erro"; 
		}
		model.addAttribute("fila", fila);
		
		return "FilaCriar";
	}
	@RequestMapping("/excluir-fila")
	public String excluir(@RequestParam(value = "id")int idFila,Model model) throws IOException {
			filaService.excluir(idFila);
			
			return "redirect:listar-fila";

	}
}
