import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestWin {
    private int sidelength;
    private Chess c1,c2,c3,c4,c5;
    private boolean p = false;
    private boolean isXwin, isYwin, isCrossUpwin, isCrossDownwin;


    TestWin(){

    }

    TestWin(Chess c1, Chess c2, Chess c3, Chess c4, Chess c5, int a){
        sidelength = a;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.c4 = c4;
        this.c5 = c5;
    }

        public boolean Xwin(){
            ArrayList<Chess> chesses = new ArrayList<>();
            chesses.add(c1);
            chesses.add(c2);
            chesses.add(c3);
            chesses.add(c4);
            chesses.add(c5);

            Collections.sort(chesses, new Comparator<Chess>() {
                @Override
                public int compare(Chess o1, Chess o2) {
                    return o1.getX() - o2.getX();
                }
            });

            for (int i = 0; i < chesses.size() - 1; i++){
                IsNeighbor isNeighborTester = new IsNeighbor(chesses.get(i), chesses.get(i + 1), sidelength);
                if (!isNeighborTester.XNeighbor()){
                    isXwin = false;
                    break;
                }
                isXwin = true;
            }
            return isXwin;
        }
        // see if 5 chesses is x win

        public boolean Ywin(){
            ArrayList<Chess> chesses = new ArrayList<>();
            chesses.add(c1);
            chesses.add(c2);
            chesses.add(c3);
            chesses.add(c4);
            chesses.add(c5);

            Collections.sort(chesses, new Comparator<Chess>() {
                @Override
                public int compare(Chess o1, Chess o2) {
                    return o1.getY() - o2.getY();
                }
            });

            for (int i = 0; i < chesses.size() - 1; i++){
                IsNeighbor isNeighborTester = new IsNeighbor(chesses.get(i), chesses.get(i + 1), sidelength);
                if (!isNeighborTester.YNeighbor()){
                    isYwin = false;
                    break;
                }
                isYwin = true;
            }
            return isYwin;
        }
        // see if 5 chesses is y win

        public boolean CrossUpwin(){
            ArrayList<Chess> chesses = new ArrayList<>();
            chesses.add(c1);
            chesses.add(c2);
            chesses.add(c3);
            chesses.add(c4);
            chesses.add(c5);

            Collections.sort(chesses, new Comparator<Chess>() {
                @Override
                public int compare(Chess o1, Chess o2) {
                    return o1.getX() - o2.getX();
                }
            });

            for (int i = 0; i < chesses.size() - 1; i++){
                IsNeighbor isNeighborTester = new IsNeighbor(chesses.get(i), chesses.get(i + 1), sidelength);
                if (!isNeighborTester.CrossUpNeighbor()){
                    isCrossUpwin = false;
                    break;
                }
                isCrossUpwin = true;
            }
            return isCrossUpwin;
        }
        // see if 5 chesses is y=x win

        public boolean CrossDownwin(){
            ArrayList<Chess> chesses = new ArrayList<>();
            chesses.add(c1);
            chesses.add(c2);
            chesses.add(c3);
            chesses.add(c4);
            chesses.add(c5);

            Collections.sort(chesses, new Comparator<Chess>() {
                @Override
                public int compare(Chess o1, Chess o2) {
                    return o1.getX() - o2.getX();
                }
            });

            for (int i = 0; i < chesses.size() - 1; i++){
                IsNeighbor isNeighborTester = new IsNeighbor(chesses.get(i), chesses.get(i + 1), sidelength);
                if (!isNeighborTester.CrossDownNeighbor()){
                    isCrossDownwin = false;
                    break;
                }
                isCrossDownwin = true;
            }
            return isCrossDownwin;
        }
        // see if 5 chesses is y=-x win


//        public boolean isWin() {
//            if (isXwin || isYwin || isCrossUpwin || isCrossDownwin) {
//                p = true;
//            }
//            return p;
//        }



    public static void main(String[] args) {
        Chess c1 = new Chess(1,1);
        Chess c2 = new Chess(2,2);
        Chess c3 = new Chess(3,3);
        Chess c4 = new Chess(4,4);
        Chess c5 = new Chess(5,5);
        int a = 1;

        TestWin testWin = new TestWin(c1,c2,c3,c4,c5,a);
        System.out.println(testWin.CrossUpwin());





    }

}
