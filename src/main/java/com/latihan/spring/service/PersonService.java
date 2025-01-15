package com.latihan.spring.service;

import com.latihan.spring.model.BaseResponse;
import com.latihan.spring.model.Person;
import com.latihan.spring.model.PersonListResponse;
import com.latihan.spring.model.PersonResponse;
import com.latihan.spring.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public PersonResponse addPerson(Person person) {
        PersonResponse personResponse = new PersonResponse();
        personRepository.insertPerson(person);
        personResponse.setErrorCode("SUKSES-200");
        personResponse.setErrorMessage("Person berhasil ditambahkan");
        personResponse.setPerson(person);
        return personResponse;
    }

    public PersonResponse updatePerson(String nama, Person updatedPerson) {
        PersonResponse personResponse = new PersonResponse();
        personRepository.updatePerson(nama, updatedPerson);
        personResponse.setErrorCode("SUKSES-200");
        personResponse.setErrorMessage("Person berhasil di-update");
        personResponse.setPerson(updatedPerson);
        return personResponse;
    }

    public PersonResponse getPersonByNama(String nama) {
        Person person = personRepository.getPersonByNama(nama);
        PersonResponse personResponse = new PersonResponse();
        personResponse.setErrorCode("SUKSES-200");
        personResponse.setErrorMessage("Person ditemukan");
        personResponse.setPerson(person);
        return personResponse;
    }

    public BaseResponse deletePersonByNama(String nama) {
        personRepository.deletePersonByNama(nama);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setErrorCode("SUKSES-200");
        baseResponse.setErrorMessage("Person berhasil dihapus");
        return baseResponse;
    }

    public PersonListResponse getAllPersons() {
        List<Person> persons = personRepository.getAllPersons();
        PersonListResponse personListResponse = new PersonListResponse();
        personListResponse.setErrorCode("SUKSES-200");
        personListResponse.setErrorMessage("Berhasil menampilkan semua person");
        personListResponse.setPerson(persons);
        return personListResponse;
    }

}
