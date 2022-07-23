package com.diamones.springboot.app.Controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.diamones.springboot.app.models.Usuario;

@Controller
public class FormController {
	
	@GetMapping("/form")
	public String crearFormulario(@Valid Usuario usuario, Model model) {
		
		model.addAttribute("titulo", "Creacion de clientes");
		
		return "form";
	}
	
	@PostMapping("/form")
	public String recibeFormulario(Model model) {
		
		model.addAttribute("titulo", "Cliente creado satisfactorimente");
		
		return "resultado";
	}

}
