package LD.splitwise.Expense.Split;


import LD.splitwise.User.User;

public class Split {

    User user;
    double amount;

    public Split(User user, double amount) {
        this.user = user;
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
