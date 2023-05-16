package com.service;

import com.exception.CustomException;
import com.entity.Person;
import com.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Iterable<Person> getAll() {
        return personRepository.findAll();
    }

    public Person create(Person newPerson) {
        personRepository.save(newPerson);
        return newPerson;
    }

    public Person addNumber(String name, String newPhone) throws CustomException {
        Person person =  Optional.ofNullable(personRepository.findByName(name))
                .orElseThrow(() -> new CustomException("Could not find user with name " + name));
        person.addPhone(newPhone);
        return personRepository.save(person);
    }

    public Person findByName(String name) throws CustomException {
        return Optional.ofNullable(personRepository.findByName(name))
                .orElseThrow(() -> new CustomException("Could not find user with name " + name));
    }

    public void delete(String name) throws CustomException {
       personRepository.delete(Optional.ofNullable(personRepository.findByName(name))
               .orElseThrow(() -> new CustomException("Could not find user with name " + name)));
    }
}
