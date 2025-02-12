package com.doevida.infrastructure.out;

import com.doevida.core.domain.Person;
import com.doevida.infrastructure.out.builder.SqlGenerated;
import com.doevida.infrastructure.out.dto.DonorsByBloodTypeReceiverDto;
import com.doevida.infrastructure.out.dto.MediaAgeBloodTypeDto;
import com.doevida.infrastructure.out.dto.PeopleAgeRangeDto;
import com.doevida.infrastructure.out.dto.PeopleObeseGenderDto;
import com.doevida.infrastructure.out.dto.StateCandidatePersonDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = SqlGenerated.getNumberPeopleByState, nativeQuery = true)
    List<StateCandidatePersonDto> getNumberPeopleByState();

    @Query(value = SqlGenerated.getPeopleByAgeRange, nativeQuery = true)
    List<PeopleAgeRangeDto> getPeopleByAgeRange(@Param("minAge") Integer minAge, @Param("maxAge") Integer maxAge);

    @Query(value = SqlGenerated.getNumberPeopleObeseByGender, nativeQuery = true)
    List<PeopleObeseGenderDto> getNumberPeopleObeseByGender();

    @Query(value = SqlGenerated.getNumberPeopleMediaAgeByBoodType, nativeQuery = true)
    List<MediaAgeBloodTypeDto> getNumberPeopleMediaAgeByBoodType();

    @Query(value = SqlGenerated.numberDonorsByBloodTypeReceiveSql, nativeQuery = true)
    List<DonorsByBloodTypeReceiverDto> getNumberDonorsByBloodTypeReceive();

}
