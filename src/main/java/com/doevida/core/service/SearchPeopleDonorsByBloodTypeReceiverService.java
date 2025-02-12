package com.doevida.core.service;

import com.doevida.infrastructure.out.PersonRepository;
import com.doevida.infrastructure.out.dto.DonorsByBloodTypeReceiverDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchPeopleDonorsByBloodTypeReceiverService {

    private final PersonRepository repository;

    public SearchPeopleDonorsByBloodTypeReceiverService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<DonorsByBloodTypeReceiverDto> execute() {
        return repository.getNumberDonorsByBloodTypeReceive();
    }
}
