package LD.splitwise;

import LD.splitwise.Group.GroupController;
import LD.splitwise.User.User;
import LD.splitwise.User.UserController;

public class SplitWise {
    UserController userController;
    GroupController groupController;
    BalanceSheetController balanceSheetController;

    SplitWise(){
        this.userController = new UserController();
        this.groupController = new GroupController();
        this.balanceSheetController = new BalanceSheetController();
    }

    public void demo(){
        setUpUsersAndGroup();


    }

    public void setUpUsersAndGroup(){
        User user1 = new User("U1", "Swaraj");
        User user2 = new User("U2", "Raj");
        User user3 = new User("U3", "Manish");
        userController.addUser(user1);
        userController.addUser(user2);
        userController.addUser(user3);

        User createdBy = userController.getUserById("U1");
        groupController.createGroup("G1", "Florida Riverwalk", createdBy);
    }
}
