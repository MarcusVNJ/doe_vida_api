package com.doevida.infrastructure.out.dto;

import java.math.BigDecimal;

public record PeopleAgeRangeAverageDto(BigDecimal imcAverage, Integer minAge, Integer maxAge) implements DtoResponse {
}
