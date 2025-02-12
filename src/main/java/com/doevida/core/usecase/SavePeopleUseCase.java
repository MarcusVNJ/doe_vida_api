package com.doevida.core.usecase;

import com.doevida.core.domain.Person;
import com.doevida.core.service.SavePeopleService;
import com.doevida.infrastructure.in.dto.PersonDTO;
import com.doevida.infrastructure.in.factories.PersonFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SavePeopleUseCase {

    private final PersonFactory personFactory;
    private final SavePeopleService salvarDadosService;

    public SavePeopleUseCase(PersonFactory personFactory, SavePeopleService salvarDadosService) {
        this.personFactory = personFactory;
        this.salvarDadosService = salvarDadosService;
    }

    public void execute(List<PersonDTO> pessoas) {
        List<Person> listaPeople = pessoas.parallelStream().map(this.personFactory::createPerson).toList();
        salvarDadosService.execute(listaPeople);
    }
}
