package com.latihan.spring.model;

import lombok.Data;

@Data
public class PersonResponse extends BaseResponse {
    private Person person;
}
