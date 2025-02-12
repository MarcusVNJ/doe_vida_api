package com.doevida.infrastructure.in;

import com.doevida.core.usecase.SavePeopleUseCase;
import com.doevida.infrastructure.in.dto.PersonDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.doevida.infrastructure.in.port.PathBase;

import java.util.List;

@RestController
public class RegisterPeopleResource implements PathBase {

    private final SavePeopleUseCase savePeople;

    public RegisterPeopleResource(SavePeopleUseCase savePeople) {
        this.savePeople = savePeople;
    }

    @PostMapping("/register")
    public ResponseEntity<String> execute(@RequestBody List<PersonDTO> people) {
        savePeople.execute(people);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
