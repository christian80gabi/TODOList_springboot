package com.projects.TODOList_springboot.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class NoteController {
    @RestController
    @RequestMapping(path = "api/v1/notes")
    static class RESTController {

        private final NoteService noteService;

        @Autowired
        public RESTController(NoteService noteService) {
            this.noteService = noteService;
        }

        @GetMapping
        public List<TODONote> getNotes() {
            return noteService.getNotes();
        }

        @GetMapping("/{noteId}")
        public TODONote getOneNote(@PathVariable Long noteId) {
            return noteService.getOneNote(noteId);
        }

        @PostMapping
        public String addNote(@RequestBody TODONote note) {
            noteService.addNote(note);

            return "Note (" + note.getValue() + ") added successfully!";
        }

        /*
        @PutMapping(path = "{groupId}")
        public String updateGroup(@PathVariable("groupId") Long groupId, @RequestBody TODOGroup TODOGroup) {
            groupService.updateGroup(groupId, TODOGroup);

            return "Group (" + TODOGroup + ")  updated successfully!";
        }

        @DeleteMapping(path = "{groupId}")
        public String deleteGroup(@PathVariable("groupId") Long groupId) {
            groupService.deleteGroup(groupId);

            return "Group  (" + groupId + ")  deleted successfully!";
        }
        */
    }
}
