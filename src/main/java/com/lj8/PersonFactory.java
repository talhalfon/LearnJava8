package com.lj8;

interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}