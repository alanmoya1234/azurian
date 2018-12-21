package com.azurian.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.azurian.web.DAO.CargoDAO;
import com.azurian.web.DAO.PersonaDAO;
import com.azurian.web.entity.Cargo;
import com.azurian.web.entity.Persona;

@Controller
@RequestMapping("/persona")
public class PersonaController {

	
	@Autowired
	private PersonaDAO pDAO;
	
	@Autowired
	private CargoDAO cDAO;
	
	
	@GetMapping("/listar")
	public String listar(Model model) {

		try {
			model.addAttribute("personas", pDAO.crud().findAll());
			model.addAttribute("cargos", cDAO.crud().findAll());
		} catch (Exception e) {
			System.out.println("catch de listar");
		}
		
		return "listar.html";
	}
	
	@GetMapping("/eliminar")
	public String eliminar(Model model, RedirectAttributes ra ,@RequestParam("id") int id) {
		
		String mensaje="error al eliminar";

		try {
			pDAO.crud().deleteById(id);
			mensaje="Persona Eliminada";
		} catch (Exception e) {
			mensaje="error al eliminar"+e.getMessage();
			System.out.println("catch de eliminar");
		}
		
		
		ra.addFlashAttribute("mensaje", mensaje);
		return "redirect:listar";
	}
	
	@PostMapping("/almacenar")
	public String almacenar(Model model, RedirectAttributes ra,
			@RequestParam("txtRUT") String rut,
			@RequestParam("txtNombre") String nombre,
			@RequestParam("txtEdad") int edad,
			@RequestParam("cboCargo") int idc		) {
		
		String mensaje="error al agregar";
		
		try {
			System.out.println("try");
			
			Cargo carg=new Cargo();
			carg.setId(idc);
			
			Persona p= new Persona();

			p.setRut(rut);
			p.setNombre(nombre);
			p.setEdad(edad);

			Persona pg=pDAO.crud().save(p);
			
			if(pg!=null) {
				mensaje="Persona agregada";
			}
		} catch (Exception e) {
			mensaje="Error al agregar";
			System.out.println("catch de agregar");
		}
		
		ra.addFlashAttribute("mensaje", mensaje);
		return "redirect:listar";
	}
}
