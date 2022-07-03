package com.projects.TODOList_springboot.groups;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class GroupConfig {

    @Bean
    CommandLineRunner commandLineRunner(GroupRepository groupRepository) {
        return args -> {
            TODOGroup TODOGroup1 = new TODOGroup(
                    "Home",
                    null
            );

            TODOGroup TODOGroup2 = new TODOGroup(
                    "Work",
                    null
            );

            TODOGroup TODOGroup3 = new TODOGroup(
                    "School",
                    null
            );

            groupRepository.saveAll(List.of(TODOGroup1, TODOGroup2, TODOGroup3));
        };
    }
}
