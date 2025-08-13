package LD.splitwise.Expense;

import LD.splitwise.Expense.Split.EqualExpenseSplit;
import LD.splitwise.Expense.Split.ExpenseSplit;
import LD.splitwise.Expense.Split.PercentageExpenseSplit;
import LD.splitwise.Expense.Split.UnequalExpenseSplit;

public class SplitFactory {

        public static ExpenseSplit getExpenseSplit(ExpenseSplitType expenseSplitType) {
            if (expenseSplitType == ExpenseSplitType.EQUAL) {
                return new EqualExpenseSplit();
            } else if (expenseSplitType == ExpenseSplitType.UNEQUAL) {
                return new UnequalExpenseSplit();
            } else if (expenseSplitType == ExpenseSplitType.PERCENTAGE) {
                return new PercentageExpenseSplit();
            } else {
                throw new IllegalArgumentException("Invalid expense split type: " + expenseSplitType);
            }
        }
}
