package com.burra.practice.softwareAg;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Person {
    @NotNull
    private final int age;
    @NotNull
    private final String name;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + name.hashCode(); // using odd prime number like 31 would produce fewer collisions in calculating hashcodes.
        return result;
    }
}
