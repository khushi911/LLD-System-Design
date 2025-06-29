package VendingStates;

import VendingMachine.Coin;
import VendingMachine.Item;
import VendingMachine.VendingMachine;

public class DispenseState extends State{
    public DispenseState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Currently dispensing. Please wait.");
    }

    @Override
    public void selectItem(String code) {
        System.out.println("Currently dispensing. Please wait.");
    }

    @Override
    public void dispense() {
        System.out.println("Product has been dispensed");

        Item item = machine.getSelectedItem();
        int balance = machine.getBalance();
        if (balance >= item.getPrice()) {
            machine.getInventory().reduceStock(item.getCode());
            balance -= item.getPrice();
            System.out.println("Dispensed: " + item.getName());
            if (balance > 0) {
                System.out.println("Returning change: " + balance);
            }
        }
        machine.reset();
        machine.setState(new IdleState(machine));

    }

    @Override
    public void refund() {
        System.out.println("Dispensing in progress. Refund not allowed.");
    }

}
