package com.doevida.infrastructure.out.dto;

public interface PeopleAgeRangeDto extends DtoResponse {
    Integer getTotalPessoas();
    Integer getIdade();
    Float getImcMedia();
}
