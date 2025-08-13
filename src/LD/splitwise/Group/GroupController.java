package LD.splitwise.Group;

import LD.splitwise.User.User;

import java.util.ArrayList;
import java.util.List;

public class GroupController {
    List<Group> groups;

    public GroupController() {
        this.groups = new ArrayList<>();
    }

    //create group
    public void createGroup(String groupId, String groupName, User createdBy) {
        Group group = new Group();
        group.setGroupId(groupId);
        group.setGroupName(groupName);
        group.addMember(createdBy);
        groups.add(group);
    }

    //get group by id

    public Group getGroupById(String groupId) {
        for (Group group : groups) {
            if (group.getGroupId().equals(groupId)) {
                return group;
            }
        }
        return null; // or throw an exception if preferred
    }
}
