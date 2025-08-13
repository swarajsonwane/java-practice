package LD.splitwise;

import java.util.HashMap;
import java.util.Map;

public class UserExpenseBalanceSheet {
    Map<String, Balance> userVsBalance;
    double totalYourExpense;
    double totalPayment;
    double totalYouOwe;
    double totalYouGetBack;

    public UserExpenseBalanceSheet() {
        this.totalYourExpense = 0.0;
        this.totalPayment = 0.0;
        this.totalYouOwe = 0.0;
        this.totalYouGetBack = 0.0;
        this.userVsBalance = new HashMap<>();
    }
    public Map<String, Balance> getUserVsBalance() {
        return userVsBalance;
    }

    public void setUserVsBalance(Map<String, Balance> userVsBalance) {
        this.userVsBalance = userVsBalance;
    }

    public double getTotalYourExpense() {
        return totalYourExpense;
    }

    public void setTotalYourExpense(double totalYourExpense) {
        this.totalYourExpense = totalYourExpense;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public double getTotalYouOwe() {
        return totalYouOwe;
    }

    public void setTotalYouOwe(double totalYouOwe) {
        this.totalYouOwe = totalYouOwe;
    }

    public double getTotalYouGetBack() {
        return totalYouGetBack;
    }

    public void setTotalYouGetBack(double totalYouGetBack) {
        this.totalYouGetBack = totalYouGetBack;
    }
}
