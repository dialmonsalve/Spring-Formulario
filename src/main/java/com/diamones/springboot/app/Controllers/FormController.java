package com.diamones.springboot.app.Controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.diamones.springboot.app.editors.NombreMayusculaEditor;
import com.diamones.springboot.app.models.domain.Usuario;
import com.diamones.springboot.app.validator.UsuarioValidador;

@Controller
@SessionAttributes("usuario")
public class FormController {
	
	
	@RequestMapping({"/", "/index", " "})
	public String index() {
		
		return "/layout/layout";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		binder.registerCustomEditor(String.class,"nombre", new NombreMayusculaEditor());
		binder.registerCustomEditor(String.class,"apellido", new NombreMayusculaEditor());
	}
	
	@ModelAttribute("paisesMap")
	public Map<String, String> paisesMap(){
		
		Map<String, String> paises = new HashMap<String, String>();
		
		paises.put("AR", "Argentina");
		paises.put("BR", "Brasil");
		paises.put("BOL", "Bolivia");
		paises.put("CH", "Chile");
		paises.put("COL", "Colombia");
		paises.put("PAR", "Paraguay");
		paises.put("PER", "Perú");
		paises.put("URU", "Uruguay");
		paises.put("VE", "Venezuela");
		
		return paises;
	}
	
	@GetMapping("/form")
	public String crearFormulario(Model model) {
		
		Usuario usuario = new Usuario();
		
		usuario.setId(1);
		
		model.addAttribute("titulo", "Creacion de clientes");
		model.addAttribute("usuario", usuario);
		
		return "form";
	}
	
	@PostMapping("/form")
	public String recibeFormulario(@Valid Usuario usuario, BindingResult result, Model model) {
					
		validador.validate(usuario, result);
		
		if (result.hasErrors()) {
			
			model.addAttribute("titulo", "Cliente creado satisfactorimente");
			
			return "form";
		}
		
		return "redirect:/ver";
	}
	
	@GetMapping("/ver")
	public String ver(@SessionAttribute(name="usuario", required = false) Usuario usuario, Model model, SessionStatus status) {
		
		if (usuario==null) {
			
			return "redirect:/form";
		}
		
		model.addAttribute("titulo", "Cliente creado satisfactorimente");
		
		status.setComplete();
		
		return "resultado";
	}
	
	@Autowired
	private UsuarioValidador validador;

}
