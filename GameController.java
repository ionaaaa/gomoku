public class GameController {
    Player p1,p2,onTurn;

    public GameController(Player p1, Player p2){
        this.p1 = p1;
        this.p2 = p2;
        this.onTurn = p1;

    }

    public Player getOnTurn(){
        return onTurn;
    }

    public Player getP1(){
        return p1;
    }

    public Player getP2(){
        return p2;
    }

}
