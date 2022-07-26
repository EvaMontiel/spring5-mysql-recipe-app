package guru.springframework.spring5recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5recipeapp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class IndexController {

	private final RecipeService recipeService;

	public IndexController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@GetMapping({ "", "/", "/index" })
	public String getIndexPage(Model model) {
		log.debug("Getting Index Page");
		model.addAttribute("recipes", recipeService.getRecipes());
		return "index";
	}
}
