package LD.splitwise.User;

import LD.splitwise.UserExpenseBalanceSheet;

public class User {
    String userId;
    String userName;
    UserExpenseBalanceSheet userBalanceSheet;

    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.userBalanceSheet = new UserExpenseBalanceSheet();
    }

    public String getUserId() {
        return userId;
    }

    public UserExpenseBalanceSheet getUserBalanceSheet() {
        return userBalanceSheet;
    }
}
