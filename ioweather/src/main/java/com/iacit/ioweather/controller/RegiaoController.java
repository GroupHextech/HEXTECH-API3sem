package com.iacit.ioweather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iacit.ioweather.model.Regiao; 
import com.iacit.ioweather.repository.Regioes;

@Controller
//@RequestMapping("/principal")
public class RegiaoController {

//============================================================
	@Autowired
	private Regioes regioes;
	
	@RequestMapping(value=("/principal/regiao"),method=RequestMethod.GET)
	public ModelAndView paginaInicial() {
		ModelAndView mv=new ModelAndView("cadastroregiao");
		return mv;
		
	}
	
	@RequestMapping(value=("/grafico/regiao"),method=RequestMethod.GET)
	public ModelAndView grafico() {
		ModelAndView mv=new ModelAndView("grafico");
		return mv;
		
	}
		
//============================================================	
	
	
	@RequestMapping(value=("/novaRegiao"), method=RequestMethod.GET)
	public ModelAndView cadastroGetRegioes() {
		ModelAndView mv=new ModelAndView("cadastroregiao");
		mv.addObject(new Regiao());
		return mv;
		
	}
	
	
	
	@RequestMapping(value=("/novaRegiao"),method=RequestMethod.POST)
	public String salvar(@Validated Regiao regiao,Errors erros, RedirectAttributes attributes) {
		
		if(erros.hasErrors()) {
			System.out.println("caiu aqui");
			return "cadastroregiao";
		}
		
		regioes.save(regiao);
		attributes.addFlashAttribute("mensagem","Região salva com sucesso.");
		
		
		return "redirect:/novaRegiao";
	}
	
	
	
	@RequestMapping(value=("/regiao"), method=RequestMethod.GET)
	public ModelAndView pesquisarRegiao() {
		ModelAndView mv=new ModelAndView("pesquisaregiao");
		List<Regiao> todasRegioes=regioes.findAll();
		mv.addObject("regioes",todasRegioes);
		return mv;
		
	}
	
	
	
	@RequestMapping(value="/regioes/{idRegiao}",method=RequestMethod.GET)
	public ModelAndView editarRegiao(@PathVariable ("idRegiao") Regiao regiao) {
		ModelAndView mv=new ModelAndView("cadastroregiao");
		mv.addObject(regiao);
		return mv;
		
	}
	
	
	@RequestMapping(value="/regioes/{idRegiao}",method=RequestMethod.DELETE)
	public String excluirRegiao(@PathVariable Long idRegiao,RedirectAttributes attributes) {
		regioes.deleteById(idRegiao);
		attributes.addFlashAttribute("mensagem","Região excuída com sucesso.");
		
		
		
		return "redirect:/regiao";
	}

}


