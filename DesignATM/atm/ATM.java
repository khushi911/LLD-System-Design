package atm;
import java.util.concurrent.atomic.AtomicLong;

import atm.dispenser.DispenseChain;
import atm.dispenser.NoteDispenser100;
import atm.dispenser.NoteDispenser20;
import atm.dispenser.NoteDispenser50;
import atm.states.ATMState;
import atm.states.IdleState;

public class ATM {
    private static ATM INSTANCE;
    
    //Banking Service Integration: The ATM interacts with a backend banking service to validate accounts and perform transactions.
    private final BankService bankService;
    private final CashDispenser cashDispenser;
    //In Java, you should use AtomicLong when you need thread-safe operations on a long value without using synchronization (like synchronized blocks or Locks)
    //Multiple threads access or modify a shared long variable concurrently, and you want to avoid race conditions.
    private static AtomicLong transactionCounter = new AtomicLong(0);
    private ATMState currentState;
    private Card currentCard;

    //SINGLETON PATTERN
    private ATM(){
        this.currentState= new IdleState();
        this.bankService =new BankService();

        // Setup the dispenser chain
        DispenseChain chain1 = new NoteDispenser100(10); // 10 x Rs.100 notes
        DispenseChain chain2 = new NoteDispenser50(20); // 20 x Rs.50 notes
        DispenseChain chain3 = new NoteDispenser20(30); // 30 x Rs.20 notes

        chain1.setNextChain(chain2);
        chain2.setNextChain(chain3);
        this.cashDispenser =new CashDispenser(chain1);
    }

    public static ATM getInstance(){
        if(INSTANCE==null){
            INSTANCE = new ATM();
        }
        return INSTANCE;
    }

    public void changeState(ATMState newState){
        this.currentState=newState;
    }

    public void setCurrentCard(Card card){
        this.currentCard =card;
    }

    public void insertCard(String cardNumber){
        currentState.insertCard(this,cardNumber);
    }

    public void enterPin(String pin){
        currentState.enterPin(this,pin);
    }

    public void selectOperation(OperationType op, int... args){
        currentState.selectOperation(this, op, args);
    }

    public Card getCard(String cardNumber){
        return bankService.getCard(cardNumber);
    }

    public boolean authenticate(String pin){
        return bankService.authenticate(currentCard,pin);
    }

    public void checkBalance(){
        double balance=bankService.getBalance(currentCard);
        System.out.printf("Your current balance is: %.2f%n " +balance);
    }

    public void withdrawCash(int amount){
        if(!cashDispenser.canDispenseCash(amount)){
            throw new IllegalStateException("Insufficient cash available in the ATM.");
        }

        bankService.withdrawMoney(currentCard,amount);

        try{
            cashDispenser.dispenseCash(amount);
        }
        catch(Exception e){
            // Deposit back if dispensing fails
            bankService.depositMoney(currentCard,amount);
        }
    }

    public void depositCash(int amount){
        bankService.depositMoney(currentCard,amount);
    }

    public Card getCurrentCard(){
        return currentCard;
    }

    public BankService getBankService(){
        return bankService;
    }

}
