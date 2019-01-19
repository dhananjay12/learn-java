package com.mynotes.lomboktest.equalshashCode;

import lombok.ToString;

@ToString(onlyExplicitlyIncluded = true)
public class User {

    @ToString.Include
    private String name;

    @ToString.Include
    private String email;

    private Integer age;

}
