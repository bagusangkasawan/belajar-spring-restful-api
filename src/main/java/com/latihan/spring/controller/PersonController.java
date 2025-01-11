package com.latihan.spring.controller;

import com.latihan.spring.model.BaseResponse;
import com.latihan.spring.model.Person;
import com.latihan.spring.model.PersonResponse;
import com.latihan.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<PersonResponse> addPerson(@RequestBody Person person) {
        PersonResponse personResponse = personService.addPerson(person);
        return ResponseEntity.ok(personResponse);
    }

    @PutMapping("/update/{nama}")
    public ResponseEntity<PersonResponse> updatePerson(@PathVariable String nama, @RequestBody Person updatedPerson) {
        PersonResponse personResponse = personService.updatePerson(nama, updatedPerson);
        return ResponseEntity.ok(personResponse);
    }

    @GetMapping("/{nama}")
    public ResponseEntity<PersonResponse> getPersonByNama(@PathVariable String nama) {
        PersonResponse personResponse = personService.getPersonByNama(nama);
        return personResponse.getErrorCode().equals("SUKSES-200") ? ResponseEntity.ok(personResponse) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{nama}")
    public ResponseEntity<BaseResponse> deletePersonByNama(@PathVariable String nama) {
        BaseResponse baseResponse = personService.deletePersonByNama(nama);
        return ResponseEntity.ok(baseResponse);
    }
}
