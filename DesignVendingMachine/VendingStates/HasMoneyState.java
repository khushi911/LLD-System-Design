package VendingStates;

import VendingMachine.Coin;
import VendingMachine.VendingMachine;

public class HasMoneyState extends State{
    public HasMoneyState(VendingMachine machine){
        super(machine);
    }

     @Override
    public void insertCoin(Coin coin){
        System.out.println("Already received full amount");
    }

    @Override
    public void selectItem(String code){
        System.out.println("Item already selected.");
    }

    @Override
    public void dispense(){
        machine.setState(new DispenseState(machine));
    }

    @Override
    public void refund(){
        machine.refundBalance();
        machine.reset();
        machine.setState(new IdleState(machine));
    }
}
