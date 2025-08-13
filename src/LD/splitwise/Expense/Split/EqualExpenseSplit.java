package LD.splitwise.Expense.Split;

import java.util.List;

public class EqualExpenseSplit implements ExpenseSplit {

    @Override
    public void validateSplitRequest(List<Split> splitDetails, double totalAmount) {
        if (splitDetails == null || splitDetails.isEmpty()) {
            throw new IllegalArgumentException("Split details cannot be null or empty");
        }

        double splitAmount = totalAmount / splitDetails.size();
        for (Split split : splitDetails) {
            // Assuming Split class has a method to get the amount
            if (split.getAmount() != splitAmount) {
                throw new IllegalArgumentException("Each split must be equal to " + splitAmount);
            }
        }
    }
}
