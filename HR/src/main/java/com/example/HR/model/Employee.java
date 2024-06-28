package com.example.HR.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity//Bu anotasyon, bu sınıfın bir veri tabanı tablosuna karşılık geldiğini belirtir.

public class Employee {

    @Id//Bu Id alanının , id alanınızın birincil anahtar olduğunu belirtir.
    @GeneratedValue(strategy = GenerationType.IDENTITY)// bu "id" alanının otomatik olarak artırılacağını belirtir.
    private long id;// Çalışsanın benzersiz kimliği

    private String firstName;// Çalışsanın ismi

    private String lastName;// Çalışsanın ismi

    private String iban; // çalışana ait Iban no

    private String position;// Çalışsanın pozisyonu

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
