public class Bill {
    Reservation reservation;
    double totalBillamount;
    boolean isBillPaid;

    Bill(Reservation reservation){
        this.reservation=reservation;
        this.totalBillamount= computeBillAmount();
        isBillPaid=false;
    }

    private double computeBillAmount(){
        return 100.0;
    }
}
