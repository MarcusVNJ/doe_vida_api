package com.doevida.core.service;

import com.doevida.infrastructure.out.PersonRepository;
import com.doevida.infrastructure.out.dto.PeopleObeseGenderDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchPeopleObeseByGenderService {
    private final PersonRepository repository;

    public SearchPeopleObeseByGenderService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<PeopleObeseGenderDto > execute() {
        return repository.getNumberPeopleObeseByGender();
    }
}
