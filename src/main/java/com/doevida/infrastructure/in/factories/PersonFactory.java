package com.doevida.infrastructure.in.factories;

import com.doevida.core.domain.Address;
import com.doevida.core.domain.Person;
import com.doevida.core.domain.enums.State;
import com.doevida.core.domain.enums.Gender;
import com.doevida.infrastructure.in.dto.PersonDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

@Component
public class PersonFactory {

    private static final String dateFormatter = "dd/MM/yyyy";
    private static final String mensagemError = "Ocorreu algum problema na definição da age da pessoa";

    public Person createPerson(PersonDTO dto) {
        Address address = new Address(null, dto.zipCode(), dto.address(),
                dto.number().shortValue(), dto.neighborhood(), dto.city(), setState(dto.state()));
        LocalDate dataNascimento = convertDate(dto.dateBirth());

        return new Person(
                null,
                dto.name(),
                dto.cpf(),
                dto.rg(),
                dataNascimento,
                setGender(dto.gender()),
                dto.mother(),
                dto.father(),
                dto.email(),
                address,
                dto.phone(),
                dto.mobilePhone(),
                dto.height(),
                dto.weight(),
                dto.bloodType(),
                setAge(dataNascimento)
        );
    }

    private LocalDate convertDate(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormatter);
            return LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Erro ao converter a data: " + e.getMessage());
        }
    }

    private Gender setGender(String gender) {
        return Gender.valueOf(gender.toUpperCase());
    }

    private State setState(String state) {
        return State.fromSigla(state);
    }

    private Short setAge(LocalDate dateBirth) {
        return Optional.ofNullable(dateBirth)
                .map(data -> Period.between(dateBirth, LocalDate.now()).getYears())
                .orElseThrow(() -> new IllegalArgumentException(mensagemError)).shortValue();
    }
}
