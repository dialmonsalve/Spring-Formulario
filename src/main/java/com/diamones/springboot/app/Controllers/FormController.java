package com.diamones.springboot.app.Controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.diamones.springboot.app.models.Usuario;

@Controller
@SessionAttributes("usuario")
public class FormController {
	
	@RequestMapping({"/", "/index", " "})
	public String index() {
		
		return "/layout/layout";
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
	public String recibeFormulario(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {
					
		model.addAttribute("titulo", "Cliente creado satisfactorimente");
		
		if (result.hasErrors()) {
			
			return "form";
		}
		
		model.addAttribute("usuario", usuario);
				
	status.setComplete();
		
		return "resultado";
	}

}
