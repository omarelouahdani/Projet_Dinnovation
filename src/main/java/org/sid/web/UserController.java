package org.sid.web;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.sid.dao.*;
import  org.sid.entities.*;
@Controller
public class UserController {
	@Autowired
	private ArticleRepository articledao;
	@Autowired 
	private UtilisateurRepository userdao;
	@Autowired
	private LoginRepository logindao;
	@Autowired
	private FiliereRepository filiereRepository;
	

	@GetMapping("/user/articles")
	public String articles(Model model ,HttpServletRequest  req) {
	
		Article article = new Article();
	    Principal p = req.getUserPrincipal();
		article.setUser(logindao.findByUsername(p.getName()).getUser());
		model.addAttribute("article", article);
		model.addAttribute("articles",  articledao.findAll());
		model.addAttribute("filieres", filiereRepository.findAll());
		model.addAttribute("user", logindao.findByUsername(p.getName()).getUser());
		return "/user/ArticlePage";
	}
	
	@GetMapping("/user/articles/ArticleForm")
	public String formArticles(Model model,HttpServletRequest  req) {
		Article article = new Article();
		 Principal p = req.getUserPrincipal();
			article.setUser(logindao.findByUsername(p.getName()).getUser());
				
		model.addAttribute("article", article);
		return "/user/FormArticle";
	}
	
	@RequestMapping(value = "/user/articles/save", method = RequestMethod.POST)
	public String saveArticle(Model model,@Valid Article article, BindingResult bindingResult,HttpServletRequest  req) {
		if (bindingResult.hasErrors())
			return "FormArticle";
		 Principal p = req.getUserPrincipal();
		 article.setUser(logindao.findByUsername(p.getName()).getUser());
		articledao.save(article);
		return "redirect:/user/articles";
	}
	

}
