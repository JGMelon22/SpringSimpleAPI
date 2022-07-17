// Para o repositório, usamso uma Interface
package br.com.projeto.api.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.api.Models.Person;

@Repository // Indica que é um repositório
// Espera como paramentro um model e o tipo de chave, no caso, um Integer
// (classe) pois int (Id) é primitivo
public interface PersonRepositorio extends CrudRepository<Person, Integer> {
    
    // Similar com o que você já fazia em Asp
    List<Person> findAll(); 

}