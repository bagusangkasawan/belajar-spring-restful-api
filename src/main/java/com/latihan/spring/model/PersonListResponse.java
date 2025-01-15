package com.latihan.spring.model;

import lombok.Data;
import java.util.List;

@Data
public class PersonListResponse extends BaseResponse {
    private List<Person> person;
}
