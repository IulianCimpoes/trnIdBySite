package com.example.service;

import com.example.model.IdDetails;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
@Data
public class IdUtilities {
    public String generateIdByDetails(IdDetails details){
        return "Site" + details.getSiteId() + RandomStringUtils.random(details.getIdLength() - 5);
    }
}
