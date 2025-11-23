package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/article")
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public String addNewArticle(@RequestParam Integer userId, @RequestParam String title,
            @RequestParam String content) {
        User author = userRepository.findById(userId).orElse(null);
        if (author == null) {
            return "Utilisateur non trouvé";
        }

        Article article = new Article(author, title, content);
        articleRepository.save(article);
        return "Article créé avec succès";
    }

    @GetMapping(path = "/all")
    public Iterable<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Article getArticleById(@PathVariable Integer id) {
        return articleRepository.findById(id).orElse(null);
    }
}
