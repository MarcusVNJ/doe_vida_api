package com.doevida.core.usecase;

import com.doevida.core.service.SearchPeopleByAgeService;
import com.doevida.core.service.SearchPeopleCandidateByStateService;
import com.doevida.core.service.SearchPeopleDonorsByBloodTypeReceiverService;
import com.doevida.core.service.SearchPeopleMediaAgeByBloodTypeService;
import com.doevida.core.service.SearchPeopleObeseByGenderService;
import com.doevida.infrastructure.out.dto.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchPeopleUseCase {

    private final SearchPeopleCandidateByStateService peopleCandidateByState;
    private final SearchPeopleByAgeService peopleByAge;
    private final SearchPeopleObeseByGenderService peopleObeseByGender;
    private final SearchPeopleMediaAgeByBloodTypeService mediaAgeByBloodType;
    private final SearchPeopleDonorsByBloodTypeReceiverService peopleDonorsByBloodTypeReceiver;

    public SearchPeopleUseCase(SearchPeopleCandidateByStateService peopleCandidateByState, SearchPeopleByAgeService peopleByAge, SearchPeopleObeseByGenderService peopleObeseByGender, SearchPeopleMediaAgeByBloodTypeService mediaAgeByBloodType, SearchPeopleDonorsByBloodTypeReceiverService peopleDonorsByBloodTypeReceiver) {
        this.peopleCandidateByState = peopleCandidateByState;
        this.peopleByAge = peopleByAge;
        this.peopleObeseByGender = peopleObeseByGender;
        this.mediaAgeByBloodType = mediaAgeByBloodType;
        this.peopleDonorsByBloodTypeReceiver = peopleDonorsByBloodTypeReceiver;
    }

    public List<StateCandidatePersonDto> candidateByState() {
        return peopleCandidateByState.execute();
    }

    public List<PeopleAgeRangeAverageDto> peopleByAge(Integer minAge, Integer maxAge) {
        return peopleByAge.execute(minAge, maxAge);
    }

    public List<PeopleObeseGenderDto> peopleObeseByGender() {
        return peopleObeseByGender.execute();
    }

    public List<MediaAgeBloodTypeDto> mediaAgeByBloodType() {
        return mediaAgeByBloodType.execute();
    }

    public List<DonorsByBloodTypeReceiverDto> donorsByBloodTypeReceiver() {
        return peopleDonorsByBloodTypeReceiver.execute();
    }

}
