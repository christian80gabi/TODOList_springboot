package com.projects.TODOList_springboot.groups;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<TODOGroup, Long> {
    Optional<TODOGroup> findGroupByValue (String value);
}
