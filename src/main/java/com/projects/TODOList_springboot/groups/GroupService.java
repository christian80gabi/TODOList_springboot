package com.projects.TODOList_springboot.groups;

import com.projects.TODOList_springboot.notes.NoteService;
import com.projects.TODOList_springboot.notes.TODONote;
import com.projects.TODOList_springboot.shared.ObjectType;
import com.projects.TODOList_springboot.shared.SharedService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class GroupService {

    private final GroupRepository groupRepository;
    private final SharedService sharedService;
    private final NoteService noteService;

    @Autowired
    public GroupService(GroupRepository groupRepository, SharedService sharedService, NoteService noteService) {
        this.groupRepository = groupRepository;
        this.sharedService = sharedService;
        this.noteService = noteService;
    }

    public List<TODOGroup> getGroups() {
        return groupRepository.findAll();
    }

    public TODOGroup getOneGroup(Long groupId) {
        return groupRepository.findById(groupId).orElseThrow(
                () -> new IllegalStateException("Group with id" + groupId + "does not exist.")
        );
    }

    public void addGroup(@NotNull TODOGroup group) {
        Optional<TODOGroup> groupValueOptional = groupRepository.findGroupByValue(group.getValue());

        if(groupValueOptional.isPresent()){
            throw new IllegalStateException("Group name already taken");
        }

        groupRepository.save(group);
    }

    @Transactional
    public void updateGroup(Long groupId, TODOGroup group) {
        TODOGroup groupObject = groupRepository.findById(groupId).orElseThrow(
                () -> new IllegalStateException("Group with id" + groupId + "does not exist.")
        );

        if (group != null) {
            if (group.getValue() != null && group.getValue().length() > 0 && !Objects.equals(group.getValue(), groupObject.getValue())) {
                Optional<TODOGroup> groupNameOptional = groupRepository.findGroupByValue(group.getValue());
                if (groupNameOptional.isPresent()) {
                    throw new IllegalStateException("Group Name already taken");
                }
                groupObject.setValue(group.getValue());
            }

            if (group.getIcon() != null && group.getIcon().length > 0 && group.getIcon() != groupObject.getIcon()) {
                groupObject.setIcon(group.getIcon());
            }
        }
    }

    public void deleteGroup(Long groupId) {
        TODOGroup TODOGroup = groupRepository.findById(groupId).orElseThrow(
                () -> new IllegalStateException("Group with id" + groupId + "does not exist.")
        );

        TODOGroup.setDeletedDate(sharedService.getCurrentDateFormLocalDate());
        groupRepository.save(TODOGroup);
    }

    public List<TODONote> getNotes(Long groupId) {
        return noteService.getNotesByObjectTypeAndObjectId(ObjectType.GROUP, groupId);
    }

    public void addNote(Long groupId, TODONote note) {
        noteService.checkIfNoteExists(note);

        noteService.addNote(new TODONote(groupId, ObjectType.GROUP, note.getValue()));
    }
}
