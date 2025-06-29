package VendingStates;

import VendingMachine.Coin;
import VendingMachine.VendingMachine;

public class IdleState extends State{
    public IdleState(VendingMachine machine){
        super(machine);
    }

    @Override
    public void insertCoin(Coin coin){
        System.out.println("Please select an item before inserting money.");
    }

    @Override
    public void selectItem(String code){
        //check if item is present in inventory or not
        if(!machine.getInventory().isAvailable(code)){
            System.out.println("Item not available");
            return;
        }

        machine.setSelectedItemCode(code);
        machine.setState(new ItemSelectedState(machine));
        System.out.println("Item selected" + code);
    }

    @Override
    public void dispense(){
        System.out.println("No item selected");
    }

    @Override
    public void refund(){
        System.out.println("No money to refund");
    }

}
