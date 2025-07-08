package atm.states;

import atm.ATM;
import atm.OperationType;

public class AuthenticatedState implements ATMState {
    @Override
    public void insertCard(ATM atm, String cardNumber) {
        System.out.println("Error: A Card has already been inserted,the session is active.");
    }

    @Override
    public void enterPin(ATM atm, String pin) {
        System.out.println("Error: PIN has already been entered and authenticated");
    }

    @Override
    public void selectOperation(ATM atm, OperationType op, int... args) {
        // In a real UI, this would be a menu. Here we use a switch.

        // In Java, int... args is a varargs (variable arguments) syntax. It allows you
        // to pass zero or more integers to a method without explicitly creating an
        // array.
        switch (op) {
            case CHECK_BALANCE:
                atm.checkBalance();
                break;

            case WITHDRAW_CASH:
                if (args.length == 0 || args[0] <= 0) {
                    System.out.println("Error: Invalid withdrawal amount specified");
                    break;
                }

                int withdrawAmount = args[0];

                double accountBalance = atm.getBankService().getBalance(atm.getCurrentCard());
                if (withdrawAmount > accountBalance) {
                    System.out.println("Error: Insufficient balance");
                    break;
                }

                System.out.println("Processing withdrawal for Rs. " + withdrawAmount);
                // Delegate the complex withdrawal logic to the ATM's dedicated method
                atm.withdrawCash(withdrawAmount);
                break;

            case DEPOSIT_CASH:
                if (args.length == 0 || args[0] <= 0) {
                    System.out.println("Error: Invalid withdrawal amount specified");
                    break;
                }

                int depositAmount = args[0];

                System.out.println("Processing deposit for Rs. " + depositAmount);
                atm.depositCash(depositAmount);
                break;

            default:
                System.out.println("Error: Invalid operation selected");
                break;
        }

        // End the session after one transaction
        System.out.println("Transaction complete.");
        ejectCard(atm);
}

    @Override
    public void ejectCard(ATM atm) {
        System.out.println("Ending Session. Card has been ejected. Thank you for using our ATM");
        atm.setCurrentCard(null);
        atm.changeState(new IdleState());
    }

}