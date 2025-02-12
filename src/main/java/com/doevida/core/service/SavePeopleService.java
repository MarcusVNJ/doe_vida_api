package com.doevida.core.service;

import com.doevida.core.domain.Address;
import com.doevida.core.domain.Person;
import com.doevida.infrastructure.out.AddressRepository;
import com.doevida.infrastructure.out.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavePeopleService {
    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    public SavePeopleService(PersonRepository personRepository, AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }

    @Transactional
    public void execute(List<Person> people) {
        List<Address> addresses = people.parallelStream().map(Person::getAddress).toList();
        addressRepository.saveAll(addresses);
        personRepository.saveAll(people);
    }

}
