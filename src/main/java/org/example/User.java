package org.example;

import java.util.Objects;

public abstract class User {
    private static int nextId = 0;

    private int id;
    private String name;
    private Sex sex;

    public User(String name, Sex sex) {
        this.id = nextId++;
        this.name = name;
        this.sex = sex;
    }

    public abstract void displayDashboard();

    public enum Sex {
        MALE, FEMALE
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && sex == user.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sex);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
