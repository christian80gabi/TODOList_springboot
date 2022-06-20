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
            Group group1 = new Group(
                    "Home",
                    null
            );

            Group group2 = new Group(
                    "Work",
                    null
            );

            Group group3 = new Group(
                    "School",
                    null
            );

            groupRepository.saveAll(List.of(group1, group2, group3));
        };
    }
}
