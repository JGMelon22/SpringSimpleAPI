package br.com.projeto.api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.Models.Person;
import br.com.projeto.api.Repository.Repositorio;
import net.bytebuddy.asm.Advice.Return;

// Annotation para usar rotas
@RestController

public class Controller {

    // Injeção de Dependência
    @Autowired
    private Repositorio acao;

    // Cadastro
    @PostMapping("/api")
    public Person registerPerson(@RequestBody Person obj) {
        return acao.save(obj);
    }

    @GetMapping("")
    public String message() {
        return "Hello, World!";
    }

    // Boas vindas genéricas
    @GetMapping("/welcome")
    public String welcomeUser() {
        return "Welcome, user!";
    }

    // Usando o nome do usuário
    @GetMapping("/welcome/{name}") // Concatenando a string nome passada na url
    public String welcomeUser(@PathVariable String name) {
        return "Welcome, " + name + "!";
    }

    // Rota para trazer um nome e uma idade
    @PostMapping("/person")
    public Person person(@RequestBody Person p) {
        return p;
    }

    // Traz todos as pessoas do banco;
    // @GetMapping("/all")
    // public Person findPerson(@RequestBody Person person) {
    // return acao.findAll();
    // }

    @GetMapping("/api")
    public List<Person> fPersons() {
        return acao.findAll();
    }
}
