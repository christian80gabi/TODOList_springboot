package com.projects.TODOList_springboot.groups;

import com.projects.TODOList_springboot.shared.SharedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class GroupService {

    private final GroupRepository groupRepository;
    private final SharedService sharedService;

    @Autowired
    public GroupService(GroupRepository groupRepository, SharedService sharedService) {
        this.groupRepository = groupRepository;
        this.sharedService = sharedService;
    }

    public List<Group> getGroups() {
        return groupRepository.findAll();
    }

    public Group getOneGroup(Long groupId) {
        return groupRepository.findById(groupId).orElseThrow(
                () -> new IllegalStateException("List Group with id" + groupId + "does not exist.")
        );
    }

    public void addGroup(Group group) {
        Optional<Group> groupValueOptional = groupRepository.findGroupByValue(group.getValue());

        if(groupValueOptional.isPresent()){
            throw new IllegalStateException("Group name already taken");
        }

        groupRepository.save(group);
    }

    public void deleteGroup(Long groupId) {
        Group group = groupRepository.findById(groupId).orElseThrow(
                () -> new IllegalStateException("Group with id" + groupId + "does not exist.")
        );

        group.setDeleted_date(sharedService.getCurrentDateFormLocalDate());
        groupRepository.save(group);
    }

    @Transactional
    public void updateGroup(Long groupId, Group group) {
        Group groupObject = groupRepository.findById(groupId).orElseThrow(
                () -> new IllegalStateException("Group with id" + groupId + "does not exist.")
        );

        if (group != null) {
            if (group.getValue() != null && group.getValue().length() > 0 && !Objects.equals(group.getValue(), groupObject.getValue())) {
                Optional<Group> groupNameOptional = groupRepository.findGroupByValue(group.getValue());
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
}
