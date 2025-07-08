package atm.states;

import atm.ATM;
import atm.Card;
import atm.OperationType;

public class IdleState implements ATMState {
    @Override
    public void insertCard(ATM atm, String cardNumber) {
        System.out.println("Card has been inserted");
        Card card = atm.getCard(cardNumber);

        //validate card 
        if (card == null) {
            ejectCard(atm);
        }
        else{
            atm.setCurrentCard(card);
            atm.changeState(new HasCardState());
        }
    }

    @Override
    public void enterPin(ATM atm, String pin){
        System.out.println("Error: PLease insert a card first");
    }

    @Override
    public void selectOperation(ATM atm, OperationType op, int... args){
        System.out.println("Error: PLease insert a card first");
    }

    @Override
    public void ejectCard(ATM atm){
        System.out.println("Error: Card not found to eject");
        atm.setCurrentCard(null);
    }

}