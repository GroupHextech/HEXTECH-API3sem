
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

import com.iacit.ioweather.model.Estado;
import com.iacit.ioweather.repository.Estados;

@Controller
//@RequestMapping("/principal")
public class EstadoController {

//============================================================
	@Autowired
	private Estados estados;
	
	@RequestMapping(value=("/principal/estado"),method=RequestMethod.GET)
	public ModelAndView paginaInicial() {
		ModelAndView mv=new ModelAndView("cadastroestado");
		return mv;
		
	}
	
	@RequestMapping(value=("/grafico/estado"),method=RequestMethod.GET)
	public ModelAndView grafico() {
		ModelAndView mv=new ModelAndView("grafico");
		return mv;
		
	}
		
//============================================================	
	
	
	@RequestMapping(value=("/novoEstado"), method=RequestMethod.GET)
	public ModelAndView cadastroGetEstados() {
		ModelAndView mv=new ModelAndView("cadastroestado");
		mv.addObject(new Estado());
		return mv;
		
	}
	
	
	
	@RequestMapping(value=("/novoEstado"),method=RequestMethod.POST)
	public String salvar(@Validated Estado estado,Errors erros, RedirectAttributes attributes) {
		
		if(erros.hasErrors()) {
			System.out.println("caiu aqui");
			return "cadastroestado";
		}
		
		estados.save(estado);
		attributes.addFlashAttribute("mensagem","Estado salvo com sucesso.");
		
		
		return "redirect:/novoEstado";
	}
	
	
	
	@RequestMapping(value=("/estados"), method=RequestMethod.GET)
	public ModelAndView pesquisarEstado() {
		ModelAndView mv=new ModelAndView("pesquisaestado");
		List<Estado> todosEstados=estados.findAll();
		mv.addObject("estados",todosEstados);
		return mv;
		
	}
	
	
	
	@RequestMapping(value="/estados/{idEstado}",method=RequestMethod.GET)
	public ModelAndView editarEstado(@PathVariable ("idEstado") Estado estado) {
		ModelAndView mv=new ModelAndView("cadatroestado");
		mv.addObject(estado);
		return mv;
		
	}
	
	
	@RequestMapping(value="/estados/{idEstado}",method=RequestMethod.DELETE)
	public String excluirEstado(@PathVariable Long idEstado,RedirectAttributes attributes) {
		estados.deleteById(idEstado);
		attributes.addFlashAttribute("mensagem","Estado excluido com sucesso.");
		
		
		
		return "redirect:/estados";
	}

}


