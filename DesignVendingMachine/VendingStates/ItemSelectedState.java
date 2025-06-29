package VendingStates;

import VendingMachine.Coin;
import VendingMachine.VendingMachine;

public class ItemSelectedState extends State {
    public ItemSelectedState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void insertCoin(Coin coin) {
        // add the coin value to balance (to calculate change if present)
        machine.addBalance(coin.getValue());
        System.out.println("Coin inserted" + coin.getValue());

        int price = machine.getSelectedItem().getPrice();
        if (machine.getBalance() >= price) {
            System.out.println("Sufficient money received.");
            machine.setState(new HasMoneyState(machine));
        }
    }

    @Override
    public void selectItem(String code) {
        System.out.println("Item already selected");
    }

    @Override
    public void dispense() {
        System.out.println("Please insert required money");
    }

    @Override
    public void refund() {
        machine.reset();
        machine.setState(new IdleState(machine));
    }

}
