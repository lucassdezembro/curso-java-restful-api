package br.com.lucassdezembro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lucassdezembro.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
