package atm.states;

import atm.ATM;
import atm.OperationType;

//STATE PATTERN

public interface ATMState {
    void insertCard(ATM atm, String cardNumber);
    void enterPin(ATM atm, String pin);
    void selectOperation(ATM atm, OperationType op,int... args); //Internally, int... args is treated as int[] args.
    void ejectCard(ATM atm);
}
