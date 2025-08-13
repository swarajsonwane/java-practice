package LD.splitwise.Group;

import LD.splitwise.Expense.Expense;
import LD.splitwise.Expense.ExpenseController;
import LD.splitwise.Expense.ExpenseSplitType;
import LD.splitwise.Expense.Split.Split;
import LD.splitwise.User.User;

import java.util.ArrayList;
import java.util.List;

public class Group {
    String groupId;
    String groupName;
    List<User> groupMembers;

    List<Expense> groupExpenses;

    ExpenseController expenseController;

    public Group(){
        this.expenseController = new ExpenseController();
        this.groupMembers = new ArrayList<>();
        this.groupExpenses = new ArrayList<>();
    }

    public void addMember(User user) {
        groupMembers.add(user);
    }

    public void removeMember(User user) {
        groupMembers.remove(user);
    }

    public String getGroupId() {
        return groupId;
    }
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Expense createExpense(String expenseId, String description, double amount, User paidBy, ExpenseSplitType expenseType, List<Split> splitDetails) {
        Expense expense = expenseController.createExpense(expenseId, description, amount, paidBy, expenseType, splitDetails);
        groupExpenses.add(expense);
        return expense;
    }
}
