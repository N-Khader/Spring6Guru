package guru.khader.spring6web.controllers;

import guru.khader.spring6web.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(value = "/authors")
    public String getAuthor(Model model){

        model.addAttribute("authors"  , authorService.getAuthors());

        return "authors";
    }
}
