import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class IsNeighbor {
    private Chess c1,c2;
    private int sidelength;
    boolean p = false;

    IsNeighbor(){

    }

    IsNeighbor(Chess c1, Chess c2, int a){
        this.c1 = c1;
        this.c2 = c2;
        sidelength = a;
    }

    public boolean XNeighbor(){
        if (c1.getX() - c2.getX() == sidelength || c2.getX() - c1.getX() == sidelength){
            if (c1.getY() == c2.getY()){
                p = true;
            }
        }
        return p;
    }

    public boolean YNeighbor(){
        if (c1.getY() - c2.getY() == sidelength || c2.getY() - c1.getY() == sidelength){
            if (c1.getX() == c2.getX()){
                p = true;
            }
        }
        return p;
    }

    public boolean CrossUpNeighbor(){
        if (XNeighbor()){
            if (YNeighbor()){
                ArrayList<Chess> chesses = new ArrayList<>();
                chesses.add(c1);
                chesses.add(c2);
                Collections.sort(chesses, new Comparator<Chess>() {
                    @Override
                    public int compare(Chess o1, Chess o2) {
                        return o1.getX() - o2.getX();
                    }
                });
                if (chesses.get(0).getY() < chesses.get(1).getY()){
                    p = true;
                }
            }
        }
        return p;
    }//check this

    public boolean CrossDownNeighbor(){
        if (XNeighbor()){
            if (YNeighbor()){
                ArrayList<Chess> chesses = new ArrayList<>();
                chesses.add(c1);
                chesses.add(c2);
                Collections.sort(chesses, new Comparator<Chess>() {
                    @Override
                    public int compare(Chess o1, Chess o2) {
                        return o1.getX() - o2.getX();
                    }
                });
                if (chesses.get(0).getY() > chesses.get(1).getY()){
                    p = true;
                }
            }
        }
        return p;
    }

    public static void main(String[] args) {
        Chess c1 = new Chess(1,1);
        Chess c2 = new Chess(0,1);
        IsNeighbor isNeighbor = new IsNeighbor(c1,c2,1);
        System.out.println(isNeighbor.XNeighbor());
    }


}
