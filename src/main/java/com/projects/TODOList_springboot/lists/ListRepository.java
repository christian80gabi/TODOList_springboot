package com.projects.TODOList_springboot.lists;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepository extends JpaRepository<TODOList, Long> {
}
