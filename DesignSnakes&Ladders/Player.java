public class Player{
    String name;
    int currPosition;

    Player(String name){
        this.name=name;
        this.currPosition=0;//initial position
    }

    //getters & setters
     public String getName() {
        return name;
    }

    public int getPosition() {
        return currPosition;
    }

    public void setPosition(int position) {
        this.currPosition = position;
    }

}