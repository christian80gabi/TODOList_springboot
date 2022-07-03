package com.projects.TODOList_springboot.notes;

import com.projects.TODOList_springboot.shared.ObjectType;
import com.projects.TODOList_springboot.shared.SharedService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final SharedService sharedService;

    @Autowired
    public NoteService(NoteRepository noteRepository, SharedService sharedService) {
        this.noteRepository = noteRepository;
        this.sharedService = sharedService;
    }

    public List<TODONote> getNotes() {
        return noteRepository.findAll();
    }

    public TODONote getOneNote(Long noteId) {
        return noteRepository.findById(noteId).orElseThrow(
                () -> new IllegalStateException("Note with id" + noteId + "does not exist.")
        );
    }

    public List<TODONote> getNotesByObjectType(ObjectType objectType) {
        return noteRepository.findByObjectType(objectType);
    }

    public List<TODONote> getNotesByObjectTypeAndObjectId(ObjectType objectType, Long objectId) {
        return noteRepository.findByObjectTypeAndObjectId(objectType, objectId);
    }

    public void checkIfNoteExists(@NotNull TODONote note) {
        Optional<TODONote> noteOptional = noteRepository.findByObjectTypeAndObjectIdAndValue(note.getObjectType(), note.getObjectId(), note.getValue());

        if (noteOptional.isPresent()) {
            throw new IllegalStateException("Note already saved");
        }

    }

    public void addNote(@NotNull TODONote note) {
        checkIfNoteExists(note);

        noteRepository.save(note);
    }

    public void deleteNote(Long noteId) {
        TODONote note = noteRepository.findById(noteId).orElseThrow(
                () -> new IllegalStateException("Note with id" + noteId + "does not exist.")
        );

        note.setDeletedDate(sharedService.getCurrentDateFormLocalDate());
        noteRepository.save(note);
    }
}
