package com.projects.TODOList_springboot.steps;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StepRepository extends JpaRepository<TODOStep, Long> {
}
