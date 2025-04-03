package net.iouhase.kat2.model;

public class Cat {
    private int id;
    private int owner;
    private String name;
    private String race;
    private int age;

    public Cat(int owner, String name, String race, int age) {
        this.owner = owner;
        this.name = name;
        this.race = race;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
