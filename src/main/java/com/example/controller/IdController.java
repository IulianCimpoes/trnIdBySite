package com.example.controller;

import com.example.model.IdDetails;
import com.example.service.IdUtilities;
import lombok.Data;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Data
@Log4j2
@RestController
public class IdController {
    @Autowired
    IdUtilities utilities;

    @PostMapping("/generate")
    ResponseEntity<String> generateId(@RequestBody IdDetails details){
        log.info("Id details -> siteId = {} idLength = {} pattern {}",
                details.getSiteId(), details.getIdLength(), details.getPattern());
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(utilities.generateIdByDetails(details));
    }
}
