package com.controller;

import com.entity.Person;
import com.exception.CustomException;
import com.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    List<Person> getAll() {
        return (List<Person>) personService.getAll();
    }

    @GetMapping("/{name}")
    Person findByName(@PathVariable String name) throws CustomException {
        return personService.findByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Person newPerson(@RequestBody Person person) {
        return personService.create(person);
    }

    @PutMapping("/{name}")
    Person addPhone(@PathVariable String name, @RequestParam("phone") String phoneNumber) throws CustomException {
        return personService.addNumber(name, phoneNumber);
    }

    @DeleteMapping(value = "/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteMovie(@PathVariable String name) throws CustomException {
        personService.delete(name);
    }
}
