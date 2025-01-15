package com.latihan.spring.repository;

import com.latihan.spring.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class PersonRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insertPerson(Person person) {
        String sql = "INSERT INTO person (nama, umur, alamat) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, person.getNama(), person.getUmur(), person.getAlamat());
    }

    public int updatePerson(String nama, Person updatedPerson) {
        String sql = "UPDATE person SET nama = ?, umur = ?, alamat = ? WHERE nama = ?";
        return jdbcTemplate.update(sql, updatedPerson.getNama(), updatedPerson.getUmur(), updatedPerson.getAlamat(), nama);
    }

    public Person getPersonByNama(String nama) {
        String sql = "SELECT * FROM person WHERE nama = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Person.class), nama);
    }

    public int deletePersonByNama(String nama) {
        String sql = "DELETE FROM person WHERE nama = ?";
        return jdbcTemplate.update(sql, nama);
    }

    public List<Person> getAllPersons() {
        String sql = "SELECT * FROM person";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Person.class));
    }

}
