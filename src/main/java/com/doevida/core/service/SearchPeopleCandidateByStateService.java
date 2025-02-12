package com.doevida.core.service;

import com.doevida.infrastructure.out.PersonRepository;
import com.doevida.infrastructure.out.dto.DtoResponse;
import com.doevida.infrastructure.out.dto.StateCandidatePersonDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchPeopleCandidateByStateService {

    private final PersonRepository repository;

    public SearchPeopleCandidateByStateService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<StateCandidatePersonDto> execute() {
        return repository.getNumberPeopleByState();
    }
}
