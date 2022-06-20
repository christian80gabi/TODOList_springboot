package com.projects.TODOList_springboot.groups;

import com.projects.TODOList_springboot.counter.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class GroupController {

    @RequestMapping(path = "groups")
    abstract static class BaseController {

        @RequestMapping
        abstract Object getGroups();

        abstract Object getOneGroup(Long groupId);

        @RequestMapping
        abstract Object addGroup(Group group);

        @RequestMapping
        abstract Object updateGroup(Long groupId, Group group);

        @RequestMapping
        abstract Object deleteGroup(Long groupId);
    }

    @RestController
    @RequestMapping(path = "api/v1/groups")
    static class RESTController extends BaseController {

        private final GroupService groupService;

        @Autowired
        public RESTController(GroupService groupService) {
            this.groupService = groupService;
        }

        @Override
        @GetMapping
        public List<Group> getGroups() {
            return groupService.getGroups();
        }

        @Override
        @RequestMapping("/{groupId}")
        public Group getOneGroup(@PathVariable Long groupId) {
            return groupService.getOneGroup(groupId);
        }

        @Override
        @PostMapping
        public String addGroup(@RequestBody Group group) {
            groupService.addGroup(group);

            return "Group (" + group + ") added successfully!";
        }

        @Override
        @PutMapping(path = "{groupId}")
        public String updateGroup(@PathVariable("groupId") Long groupId, @RequestBody Group group) {
            groupService.updateGroup(groupId, group);

            return "Group (" + group + ")  updated successfully!";
        }

        @Override
        @DeleteMapping(path = "{groupId}")
        public String deleteGroup(@PathVariable("groupId") Long groupId) {
            groupService.deleteGroup(groupId);

            return "Group  (" + groupId + ")  deleted successfully!";
        }
    }

    @Controller
    @RequestMapping(path = "v1/groups")
    static class HTMLController extends BaseController {

        private final GroupService groupService;
        private final CounterService counterService;

        @Autowired
        public HTMLController(GroupService groupService, CounterService counterService) {
            this.groupService = groupService;
            this.counterService = counterService;
        }

        @Override
        @RequestMapping
        ModelAndView getGroups() {
            ModelAndView model = new ModelAndView("index");

            model.addObject("groups", groupService.getGroups());
            model.addObject("counter", counterService);

            model.addObject("group", new Group());

            return model;
        }

        @Override
        @RequestMapping(path = "/{groupId}", method = {RequestMethod.GET, RequestMethod.POST})
        public ModelAndView getOneGroup(@PathVariable Long groupId) {
            ModelAndView model = new ModelAndView("index");

            Group group = groupService.getOneGroup(groupId);
            model.addObject("group", group);

            return model;
        }

        @Override
        @RequestMapping(path = "/add", method = {RequestMethod.POST, RequestMethod.GET})
        public String addGroup(@ModelAttribute Group group) {
            groupService.addGroup(group);

            return "redirect:/v1/groups";
        }

        @Override
        @RequestMapping(path = "/{groupId}/update", method = {RequestMethod.PUT, RequestMethod.POST, RequestMethod.GET})
        public String updateGroup(@PathVariable("groupId") Long groupId, @ModelAttribute("group") Group group) {
            groupService.updateGroup(groupId, group);

            return "redirect:/v1/groups";
        }

        @Override
        @RequestMapping(path = "/{groupId}/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
        public String deleteGroup(@PathVariable("groupId") Long groupId) {
            groupService.deleteGroup(groupId);

            return "redirect:/v1/groups";
        }
    }
}
