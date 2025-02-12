package com.doevida.infrastructure.in;

import com.doevida.core.usecase.SearchPeopleUseCase;
import com.doevida.infrastructure.in.port.PathPerson;
import com.doevida.infrastructure.out.dto.DtoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchPeopleResource implements PathPerson {

    private final SearchPeopleUseCase searchPeopleUseCase;

    public SearchPeopleResource(SearchPeopleUseCase searchPeopleUseCase) {
        this.searchPeopleUseCase = searchPeopleUseCase;
    }


    @GetMapping
    public ResponseEntity<List<? extends DtoResponse>> execute(@RequestParam String by,
                                                     @RequestParam(required = false) Integer minAge,
                                                     @RequestParam(required = false) Integer maxAge) {
        return switch (by) {
            case "age" -> (minAge == null || maxAge == null)
                    ? ResponseEntity.notFound().build()
                    : ResponseEntity.ok(searchPeopleUseCase.peopleByAge(minAge, maxAge));
            case "obese" -> ResponseEntity.ok(searchPeopleUseCase.peopleObeseByGender());
            case "mediaAge" -> ResponseEntity.ok(searchPeopleUseCase.mediaAgeByBloodType());
            default -> ResponseEntity.notFound().build();
        };
    }
}
