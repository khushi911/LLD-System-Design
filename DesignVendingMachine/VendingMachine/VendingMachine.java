//Singleton Pattern - For ensuring a single instance of the VendingMachine.

package VendingMachine;

import VendingStates.*;

public class VendingMachine {
    public final static VendingMachine INSTANCE = new VendingMachine();
    public final Inventory inventory = new Inventory();
    private State currentState;
    private int balance = 0;
    private String selectedItemCode;
    
    public VendingMachine(){
        currentState= new IdleState(this);
    }

    public static VendingMachine getInstance(){
        return INSTANCE;
    }

    public void insertCoin(Coin coin){
        currentState.insertCoin(coin);
    }

    public Item addItem(String code, String name, int price, int quantity) {
        Item item = new Item(code, name, price);
        inventory.addItem(code, item, quantity);
        return item;
    }

    public void selectItem(String code) {
        currentState.selectItem(code);
    }

    public void dispense() {
        currentState.dispense();
    }

    public void refundBalance() {
        System.out.println("Refunding: " + balance);
        balance = 0;
    }

    public void reset() {
        selectedItemCode = null;
        balance = 0;
    }

    public void addBalance(int value) {
        balance += value;
    }

    public Item getSelectedItem() {
        return inventory.getItem(selectedItemCode);
    }

    public void setSelectedItemCode(String code) {
        this.selectedItemCode = code;
    }

    public void setState(State state) {
        this.currentState = state;
    }

    // Getters for states and inventory
    public Inventory getInventory() { return inventory; }
    public int getBalance() { return balance; }
}
