package br.com.projeto.api.Controllers;

import java.util.List;

import javax.persistence.PrePersist;

import org.hibernate.sql.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.Models.Person;
import br.com.projeto.api.Repository.PersonRepositorio;

// Annotation para usar rotas
@RestController

public class PersonController {

    // Injeção de Dependência
    @Autowired
    private PersonRepositorio personRepositorio;

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

    // Cadastro
    @PostMapping("/api")
    public Person registerPerson(@RequestBody Person person) {
        return personRepositorio.save(person);
    }

    // Busca todas as pessoas
    @GetMapping("/api")
    public List<Person> fPeople() {
        return personRepositorio.findAll();
    }

    // Busca uma pessoa baseada em seu id
    @GetMapping("/api/{id}")
    public Person findPersonById(@PathVariable int id) {
        return personRepositorio.findById(id);
    }

    // Modificando uma pessoa
    @PutMapping("/api")
    public Person editPerson(@RequestBody Person person) {
        return personRepositorio.save(person);
    }

    // Deletar uma pessoa
    // Deletar, basico, é void
    // Busca pela pessoa e depois deleta
    @DeleteMapping("/api/{id}")
    public void deletePerson(@PathVariable int id) {
        Person person = findPersonById(id);
        personRepositorio.delete(person);
    }
}
