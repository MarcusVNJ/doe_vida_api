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
public class SearchPeopleCandidatesResource implements PathPerson {

    private final SearchPeopleUseCase searchPeopleUseCase;

    public SearchPeopleCandidatesResource(SearchPeopleUseCase searchPeopleUseCase) {
        this.searchPeopleUseCase = searchPeopleUseCase;
    }

    @GetMapping("/candidate")
    public ResponseEntity<List<? extends DtoResponse>> execute(@RequestParam String by) {
        return switch (by) {
            case "state" -> ResponseEntity.ok(searchPeopleUseCase.candidateByState());
            case "bloodType" -> ResponseEntity.ok(searchPeopleUseCase.donorsByBloodTypeReceiver());
            default -> ResponseEntity.notFound().build();
        };
    }
}
