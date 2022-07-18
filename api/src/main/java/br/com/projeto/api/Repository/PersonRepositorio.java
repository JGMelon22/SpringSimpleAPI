// Para o repositório, usamos uma Interface
package br.com.projeto.api.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import br.com.projeto.api.Models.Person;

@Repository // Indica que é um repositório
// Espera como paramentro um model e o tipo de chave, no caso, um Integer
// (classe) pois int (Id) é primitivo
public interface PersonRepositorio extends CrudRepository<Person, Integer> {

    // Lista de todas
    List<Person> findAll();

    // Uma pessoa em específico
    Person findById(int id);

}