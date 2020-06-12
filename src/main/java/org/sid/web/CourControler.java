package org.sid.web;


import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.sid.dao.CourRepository;
import org.sid.dao.LoginRepository;
import org.sid.dao.TypeCourRepisitory;
import org.sid.entities.Cour;

import org.sid.entities.TypeCour;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourControler {
   @Autowired
	TypeCourRepisitory typeCourRepisitory;
   @Autowired
   CourRepository courRepository;
   @Autowired
	private LoginRepository logindao;
	@GetMapping(path = "/user/cour")
    public String edit(Model model, HttpServletRequest  req) {
	   
		List<TypeCour> crs   = typeCourRepisitory.findAll();
		
		List<Cour> cours = courRepository.findAll();
		List<String> images = new ArrayList<String>();
		

		cours.forEach(e -> {
        	if(e.getTitle().contains("JEE"))
        	{
        		images.add("jee.jpg");
        	}
          });
	   
		 Principal p = req.getUserPrincipal();
		 model.addAttribute("user", logindao.findByUsername(p.getName()).getUser());
		model.addAttribute("cours",cours);
		model.addAttribute("coursType",crs);
		model.addAttribute("images",images);
		
		return "/user/PageCour";
    }
	@GetMapping(path = "/user/downloadFile")
    public ResponseEntity<ByteArrayResource> downloadFile(@RequestParam(name = "cour",defaultValue = "") long  id) {
	     Cour cour = courRepository.findById(id).get();
	     return ResponseEntity.ok()
	    		 .contentType(MediaType.parseMediaType(cour.getMimetype()))
	    		 .header(HttpHeaders.CONTENT_DISPOSITION,"attachement:filename=\""+cour.getName()+"\"")
	    		 .body(new ByteArrayResource(cour.getPic()));

		
		
		
    }
	@GetMapping(path = "/user/CourRecherche")
    public String courRecherche(HttpServletRequest  req,Model model,@RequestParam(name = "TypeCour",defaultValue = "") long  id) {
	   
		List<TypeCour> crs   = typeCourRepisitory.findAll();
		
		List<Cour> cours = courRepository.findByid_TypeCour(id);
		List<String> images = new ArrayList<String>();
		 Principal p = req.getUserPrincipal();
		 model.addAttribute("user", logindao.findByUsername(p.getName()).getUser());
		cours.forEach(e -> {
        	if(e.getTitle().contains("JEE"))
        	{
        		images.add("jee.jpg");
        	}
          });
	   
	    	
		model.addAttribute("cours",cours);
		model.addAttribute("coursType",crs);
		model.addAttribute("images",images);
		
		return "/user/PageCour";
    }
	
	
}


