package atm.dispenser;

public interface DispenseChain {
    void setNextChain(DispenseChain dispenseChain);
    void dispense(int amount);
    boolean canDispenseCash(int amount);
}
