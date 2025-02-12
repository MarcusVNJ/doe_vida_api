package com.doevida.core.service;

import com.doevida.infrastructure.out.PersonRepository;
import com.doevida.infrastructure.out.dto.PeopleAgeRangeAverageDto;
import com.doevida.infrastructure.out.dto.PeopleAgeRangeDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;

@Service
public class SearchPeopleByAgeService {

    private final PersonRepository repository;

    public SearchPeopleByAgeService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<PeopleAgeRangeAverageDto> execute(Integer minAge, Integer maxAge) {
        List<PeopleAgeRangeDto> peopleByAgeRange = repository.getPeopleByAgeRange(minAge, maxAge);
        DoubleSummaryStatistics intSummaryStatistics = peopleByAgeRange.stream().map(PeopleAgeRangeDto::getImcMedia)
                .mapToDouble(Float::floatValue).summaryStatistics();
        BigDecimal imcMedia = BigDecimal.valueOf(intSummaryStatistics.getAverage()).setScale(2, RoundingMode.HALF_UP);
        return List.of(new PeopleAgeRangeAverageDto(imcMedia, minAge, maxAge));


    }
}
