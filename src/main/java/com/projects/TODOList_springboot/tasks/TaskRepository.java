package com.projects.TODOList_springboot.tasks;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TODOTask, Long> {
}
