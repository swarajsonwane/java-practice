package LD.splitwise.Expense.Split;

import java.util.List;

public class PercentageExpenseSplit implements ExpenseSplit {

    @Override
    public void validateSplitRequest(List<Split> splitDetails, double totalAmount) {
        double totalPercentage = 0.0;
        for (Split split : splitDetails) {
            totalPercentage += split.getAmount();
        }

        if (totalPercentage != 100.0) {
            throw new IllegalArgumentException("Total percentage must equal 100%");
        }

        // Additional validation can be added here if needed

    }
}
