package com.projects.TODOList_springboot.notes;

import com.projects.TODOList_springboot.shared.ObjectType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<TODONote, Long> {
    List<TODONote> findByObjectType(ObjectType objectType);
    List<TODONote> findByObjectTypeAndObjectId(ObjectType objectType, Long objectId);
    Optional<TODONote> findByObjectTypeAndObjectIdAndValue(ObjectType objectType, Long objectId, String value);
}
