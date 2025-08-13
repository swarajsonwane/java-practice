package LD.splitwise.Expense;

import LD.splitwise.BalanceSheetController;
import LD.splitwise.Expense.Split.ExpenseSplit;
import LD.splitwise.Expense.Split.Split;
import LD.splitwise.User.User;

import java.util.List;

import static LD.splitwise.Expense.SplitFactory.getExpenseSplit;

public class ExpenseController {

    BalanceSheetController balanceSheetController;

    public ExpenseController() {
        this.balanceSheetController = new BalanceSheetController();
    }
    public Expense createExpense(String expenseId, String description, double amount, User paidBy, ExpenseSplitType expenseType, List<Split> splitDetails) {
        ExpenseSplit expenseSplit = getExpenseSplit(expenseType);
        expenseSplit.validateSplitRequest(splitDetails, amount);

        Expense expense = new Expense(expenseId, description, amount, paidBy, expenseType, splitDetails);

        balanceSheetController.updateUserExpenseBalanceSheet(paidBy, splitDetails, amount);
        return expense;
    }
}
