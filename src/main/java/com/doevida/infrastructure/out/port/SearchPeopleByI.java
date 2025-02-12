package com.doevida.infrastructure.out.port;

import com.doevida.infrastructure.out.dto.DtoResponse;

import java.util.List;

public interface SearchPeopleByI {

    public List<DtoResponse> getNumberPeopleByState();

    public List<DtoResponse> getPeopleByAgeRage(Integer minAge, Integer maxAge);

    public List<DtoResponse> getNumberPeopleObeseByGender();

    public List<DtoResponse> getNumberPeopleMediaAgeByBoodType();

    public List<DtoResponse> getNumberDonorsByBloodTypeReceive();
}
