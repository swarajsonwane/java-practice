package LD.splitwise.Expense;

import LD.splitwise.Expense.Split.Split;
import LD.splitwise.User.User;

import java.util.ArrayList;
import java.util.List;

public class Expense {
    String expenseId;
    String description;
    double amount;
    User paidBy;
    ExpenseSplitType expenseType;
    List<Split> splitDetails = new ArrayList<>();

    public Expense(String expenseId, String description, double amount, User paidBy, ExpenseSplitType expenseType, List<Split> splitDetails) {
        this.expenseId = expenseId;
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        this.expenseType = expenseType;
        this.splitDetails = splitDetails;
    }
}
