package atm;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
//concurrent map - ConcurrentHashMap in Java is a thread-safe, high-performance implementation of the Map interface, designed for concurrent access in multi-threaded environments
//ConcurrentHashMap is ideal for scenarios where multiple threads need to concurrently read from and write to a shared map, requiring efficient and safe concurrent operations.
public class BankService {

    //account Number -> account
    private final Map<String, Account> accounts = new ConcurrentHashMap<>();

    //card Number -> card
    private final Map<String, Card> cards = new ConcurrentHashMap<>();

    //map to link card and account
    private final Map<Card,Account> cardAccountMap = new ConcurrentHashMap<>();

    public BankService(){
        //create sample accounts and cards
        Account account1 = createAccount("1234567890",1000.0);
        Card card1 = createCard("1234-5678-3446-9876","1234");
        linkCardToAccount(card1,account1);

        Account account2 = createAccount("9087654321",500.0);
        Card card2 = createCard("9785-4736-9800-1234","4321");
        linkCardToAccount(card2,account2);
    }

    public Account createAccount(String accountNumber, double initialBalance){
        Account account = new Account(accountNumber, initialBalance);
        accounts.put(accountNumber,account);
        return account;
    }

    public Card createCard(String cardNumber, String pin){
        Card card = new Card(cardNumber, pin);
        cards.put(cardNumber,card);
        return card;
    }

    public boolean authenticate(Card card, String pin){
        return card.getPin().equals(pin);
    }

    public Card getCard(String cardNumber){
        return cards.getOrDefault(cardNumber, null);
    }

    public double getBalance(Card card){
        return cardAccountMap.get(card).getBalance();
    }

    public void withdrawMoney(Card card, double amount){
        cardAccountMap.get(card).withdraw(amount);
    }

    public void depositMoney(Card card, double amount){
        cardAccountMap.get(card).deposit(amount);
    }

    public void linkCardToAccount(Card card, Account account){
        account.getCards().put(card.getCardNumber(),card); // in the account class
        cardAccountMap.put(card, account); // at the bank service 
    }

}
