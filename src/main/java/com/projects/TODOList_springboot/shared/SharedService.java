package com.projects.TODOList_springboot.shared;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Service
public class SharedService {

    public Date getCurrentDateFormLocalDate() {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();

        return Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
    }

}
