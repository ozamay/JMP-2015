package com.epam.olukash.module3.facade;

/**
 * @author oleksii.lukash
 */
public class Person
{
    private String name;
    private int age;
    private int iq;

    public Person(String name, int age, int iq)
    {
        this.name = name;
        this.age = age;
        this.iq = iq;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    @Override
    public String toString()
    {
        return name + ", " + age + " years old with iq: " + iq;
    }
}
