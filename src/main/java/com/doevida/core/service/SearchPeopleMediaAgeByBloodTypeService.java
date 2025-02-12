package com.doevida.core.service;

import com.doevida.infrastructure.out.PersonRepository;
import com.doevida.infrastructure.out.dto.MediaAgeBloodTypeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchPeopleMediaAgeByBloodTypeService {

    private final PersonRepository repository;

    public SearchPeopleMediaAgeByBloodTypeService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<MediaAgeBloodTypeDto> execute() {
        return repository.getNumberPeopleMediaAgeByBoodType();
    }
}
