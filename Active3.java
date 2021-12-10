//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//
//public class Active3 {
//    private Chess c1, c2, c3;
//    private int sidelength;
//    private boolean p = false;
//    private boolean isX3, isY3, isCrossUp3, isCrossDown3;
//
//    Active3(){
//
//    }
//
//    Active3(Chess c1, Chess c2, Chess c3, int sidelength){
//        this.c1 = c1;
//        this.c2 = c2;
//        this.c3 = c3;
//        this.sidelength = sidelength;
//    }
// 
//    public boolean X3(){
//        isX3 = false;
//        ArrayList<Chess> chesses = new ArrayList<>();
//        chesses.add(c1);
//        chesses.add(c2);
//        chesses.add(c3);
//        Collections.sort(chesses, new Comparator<Chess>() {
//            @Override
//            public int compare(Chess o1, Chess o2) {
//                return o1.getX() - o2.getX();
//            }
//        });
//        IsNeighbor isNeighborTester1 = new IsNeighbor(chesses.get(0),chesses.get(1),sidelength);
//        IsNeighbor isNeighborTester2 = new IsNeighbor(chesses.get(1),chesses.get(2),sidelength);
//        if (isNeighborTester1.XNeighbor() && isNeighborTester2.XNeighbor()){
//            isX3 = true;
//        }
//
//        return isX3;
//    }
//
//    public boolean Y3(){
//        isY3 = false;
//        ArrayList<Chess> chesses = new ArrayList<>();
//        chesses.add(c1);
//        chesses.add(c2);
//        chesses.add(c3);
//        Collections.sort(chesses, new Comparator<Chess>() {
//            @Override
//            public int compare(Chess o1, Chess o2) {
//                return o1.getY() - o2.getY();
//            }
//        });
//        IsNeighbor isNeighborTester1 = new IsNeighbor(chesses.get(0),chesses.get(1),sidelength);
//        IsNeighbor isNeighborTester2 = new IsNeighbor(chesses.get(1),chesses.get(2),sidelength);
//        if (isNeighborTester1.YNeighbor() && isNeighborTester2.YNeighbor()){
//            isY3 = true;
//        }
//
//        return isY3;
//    }
//
//    public boolean CrossUp3(){
//        isCrossUp3 = false;
//        ArrayList<Chess> chesses = new ArrayList<>();
//        chesses.add(c1);
//        chesses.add(c2);
//        chesses.add(c3);
//        Collections.sort(chesses, new Comparator<Chess>() {
//            @Override
//            public int compare(Chess o1, Chess o2) {
//                return o1.getX() - o2.getX();
//            }
//        });
//        IsNeighbor isNeighborTester1 = new IsNeighbor(chesses.get(0),chesses.get(1),sidelength);
//        IsNeighbor isNeighborTester2 = new IsNeighbor(chesses.get(1),chesses.get(2),sidelength);
//        if (isNeighborTester1.CrossUpNeighbor() && isNeighborTester2.CrossUpNeighbor()){
//            isCrossUp3 = true;
//        }
//
//        return isCrossUp3;
//    }
//
//    public boolean CrossDown3(){
//        isCrossDown3 = false;
//        ArrayList<Chess> chesses = new ArrayList<>();
//        chesses.add(c1);
//        chesses.add(c2);
//        chesses.add(c3);
//        Collections.sort(chesses, new Comparator<Chess>() {
//            @Override
//            public int compare(Chess o1, Chess o2) {
//                return o1.getX() - o2.getX();
//            }
//        });
//        IsNeighbor isNeighborTester1 = new IsNeighbor(chesses.get(0),chesses.get(1),sidelength);
//        IsNeighbor isNeighborTester2 = new IsNeighbor(chesses.get(1),chesses.get(2),sidelength);
//        if (isNeighborTester1.CrossDownNeighbor() && isNeighborTester2.CrossDownNeighbor()){
//            isCrossDown3 = true;
//        }
//
//        return isCrossDown3;
//    }
//
//
//
//    public static void main(String[] args) {
//        Chess c1 = new Chess(0,0);
//        Chess c2 = new Chess(-1,1);
//        Chess c3 = new Chess(-2,2);
//        Active3 active3tester = new Active3(c1,c2,c3, 1);
//        System.out.println();
//    }
//}
//
//
