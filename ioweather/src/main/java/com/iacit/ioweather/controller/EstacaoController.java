package com.iacit.ioweather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iacit.ioweather.model.Estacao;
import com.iacit.ioweather.repository.Estacoes;

@Controller
//@RequestMapping("/principal")
public class EstacaoController {
	
	@Autowired
	private Estacoes estacoes;
	
	@RequestMapping(value=("/principal"),method=RequestMethod.GET)
	public ModelAndView paginaInicial() {
		ModelAndView mv=new ModelAndView("index");
		return mv;
		
	}
	
	@RequestMapping(value=("/grafico"),method=RequestMethod.GET)
	public ModelAndView grafico() {
		ModelAndView mv=new ModelAndView("grafico");
		return mv;
		
	}

	@RequestMapping(value=("/sobreNos"),method=RequestMethod.GET)
	public ModelAndView sobreNos() {
		ModelAndView mv=new ModelAndView("sobreNos");
		return mv;
		
	}

	@GetMapping("/filtroEstacao")
	public String filtrarEstacao(Estacao estacao, Model model){
	    model.addAttribute("estacoes",estacoes.findAll());
	    return "grafico";
	}
		
	
	
	
	@RequestMapping(value=("/novaEstacao"), method=RequestMethod.GET)
	public ModelAndView cadastroGetEstacoes() {
		ModelAndView mv=new ModelAndView("cadastroestacao");
		mv.addObject(new Estacao());
		return mv;
		
	}
	
	
	
	
	@RequestMapping(value=("/novaEstacao"),method=RequestMethod.POST)
	public String salvar(@Validated Estacao estacao,Errors erros, RedirectAttributes attributes) {
		
		if(erros.hasErrors()) {
			System.out.println("caiu aqui");
			return "cadastroestacao";
		}
		
		estacoes.save(estacao);
		attributes.addFlashAttribute("mensagem","Estação salva com sucesso.");
		
		
		return "redirect:/novaEstacao";
	}
	
	
	
	@RequestMapping(value=("/estacoes"), method=RequestMethod.GET)
	public ModelAndView pesquisarEstacao() {
		ModelAndView mv=new ModelAndView("pesquisaestacao");
		List<Estacao> todasEstacoes=estacoes.findAll();
		mv.addObject("estacoes",todasEstacoes);
		return mv;
		
	}
	
	
	
	@RequestMapping(value="/estacoes/{idEstacao}",method=RequestMethod.GET)
	public ModelAndView editarEstacao(@PathVariable ("idEstacao") Estacao estacao) {
		ModelAndView mv=new ModelAndView("cadastroestacao");
		mv.addObject(estacao);
		return mv;
		
	}
	
	
	@RequestMapping(value="/estacoes/{idEstacao}",method=RequestMethod.DELETE)
	public String excluirEstacao(@PathVariable Long idEstacao,RedirectAttributes attributes) {
		estacoes.deleteById(idEstacao);
		attributes.addFlashAttribute("mensagem","Estação excluída com sucesso.");
		
		
		
		return "redirect:/estacoes";
	}

}
