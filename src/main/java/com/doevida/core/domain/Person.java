package com.doevida.core.domain;

import java.time.LocalDate;

import com.doevida.core.domain.enums.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "pessoa")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(length = 14)
    private String cpf;

    @Column(length = 20)
    private String rg;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dateBirth;

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Enumerated(EnumType.STRING)
    @Column(name = "genero")
    private Gender gender;

    @Column(name = "mae")
    private String mother;

    @Column(name = "pai")
    private String father;

    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id", nullable = false)
    private Address address;

    @Column(length = 20, name = "telefone")
    private String phone;

    @Column(length = 20, name = "celular")
    private String mobilePhone;

    @Column(name = "altura")
    private Float height;

    @Column(name = "peso")
    private Float weight;

    @Column(name = "tipo_sanguineo")
    private String bloodType;

    @Column(name = "idade")
    private Short age;

    public Person(Long id, String name, String cpf, String rg, LocalDate dateBirth, Gender gender,
                  String mother, String father, String email, Address address, String phone,
                  String mobilePhone, Float height, Float weight, String bloodType, Short age) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.rg = rg;
        this.dateBirth = dateBirth;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.mobilePhone = mobilePhone;
        this.height = height;
        this.weight = weight;
        this.bloodType = bloodType;
        this.age = age;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public String getMother() {
        return mother;
    }

    public String getFather() {
        return father;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public Float getHeight() {
        return height;
    }

    public Float getWeight() {
        return weight;
    }

    public String getBloodType() {
        return bloodType;
    }

    public Short getAge() {
        return age;
    }
}
