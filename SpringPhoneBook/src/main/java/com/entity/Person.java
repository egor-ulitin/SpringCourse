package com.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ElementCollection
    @CollectionTable(name = "phoneNumber", joinColumns = @JoinColumn(name = "id"))
    private List<String> phoneNumber;

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

    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void addPhone(String newPhone) {
        this.phoneNumber.add(newPhone);
    }
}
