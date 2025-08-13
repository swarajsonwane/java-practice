package LD.splitwise.Expense.Split;

import java.util.List;

public class UnequalExpenseSplit implements ExpenseSplit {

    @Override
    public void validateSplitRequest(List<Split> splitDetails, double totalAmount) {
        double totalSplitAmount = 0.0;
        for (Split split : splitDetails) {
            totalSplitAmount += split.getAmount();
        }

        if (totalSplitAmount != totalAmount) {
            throw new IllegalArgumentException("Total split amount does not match the expense amount.");
        }
    }
}
