package com.mynotes.lomboktest.toString;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

    @EqualsAndHashCode.Include
    private String name;

    @EqualsAndHashCode.Include
    private String email;

    private Integer age;

}
