import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class testWin {

        public static void main(String[] args) {
            Chess c1 = new Chess(0,0);
            Chess c2 = new Chess(-4,4);
            Chess c3 = new Chess(-3,3);
            Chess c4 = new Chess(-2,2);
            Chess c5 = new Chess(-1,1);

            System.out.println(Xwin(c1,c2,c3,c4,c5,1));
            System.out.println(Ywin(c1,c2,c3,c4,c5,1));
            System.out.println(CrossUpwin(c1,c2,c3,c4,c5,1));
            System.out.println(CrossDownwin(c1,c2,c3,c4,c5,1));

        }




        public static boolean isNeighbor(int xy1, int xy2, int a){ //a is side length, remember to replace it
            boolean p = false;
            if (xy1 - xy2 == a || xy2 - xy1 == a){
                p = true;
            }
            return p;
        }
        //see if two chesses are neighbored(x or y)

        public static boolean isSameRow(int xy1, int xy2){
            boolean p = false;
            if (xy1 == xy2){
                p = true;
            }
            return p;
        }
        //see if 2 chesses are same row(x or y)

        public static boolean XNeighbor(Chess c1, Chess c2, int a){
            boolean p = false;
            if (isNeighbor(c1.getX(), c2.getX(), a)){
                if (isSameRow(c1.getY(), c2.getY())){
                    p = true;
                }
            }
            return p;
        }
        // see if 2 chesses are x neighbored

        public static boolean YNeighbor(Chess c1, Chess c2, int a){
            boolean p = false;
            if (isNeighbor(c1.getY(), c2.getY(), a)){
                if (isSameRow(c1.getX(), c2.getX())){
                    p = true;
                }
            }
            return p;
        }
        // see if 2 chesses are y neighbored

        public static boolean CrossNeighborUp(Chess c1, Chess c2, int a){
            boolean p = false;
            if (isNeighbor(c1.getX(), c2.getX(), a)){
                if (isNeighbor(c1.getY(), c2.getY(), a)){
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
        }
        // see if 2 chesses are y = x

        public static boolean CrossNeighborDown(Chess c1, Chess c2, int a){
            boolean p = false;
            if (isNeighbor(c1.getX(), c2.getX(), a)){
                if (isNeighbor(c1.getY(), c2.getY(), a)){
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
        // see if 2 chesses are y = -x


//    public static boolean neighborXY(int x1, int x2, int x3, int x4, int x5, int a){
//        boolean p = false;
//        ArrayList<Integer> Xs = new ArrayList<>();
//        Xs.add(x1);
//        Xs.add(x2);
//        Xs.add(x3);
//        Xs.add(x4);
//        Xs.add(x5);
//        Collections.sort(Xs);
//        if (isNeighbor(Xs.get(0), Xs.get(1), a) && isNeighbor(Xs.get(1), Xs.get(2), a) && isNeighbor(Xs.get(2), Xs.get(3), a) && isNeighbor(Xs.get(3), Xs.get(4), a)){
//            p = true;
//        }
//        return p;
//    }
//    // see if 5 chesses' x or y coordinate is neibored


        public static boolean Xwin(Chess c1, Chess c2, Chess c3, Chess c4, Chess c5, int a){
            boolean p = false;
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
                if (!XNeighbor(chesses.get(i), chesses.get(i + 1), a)){
                    p = false;
                    break;
                }
                p = true;
            }
            return p;
        }
        // see if 5 chesses is x win

        public static boolean Ywin(Chess c1, Chess c2, Chess c3, Chess c4, Chess c5, int a){
            boolean p = false;
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
                if (!YNeighbor(chesses.get(i), chesses.get(i + 1), a)){
                    p = false;
                    break;
                }
                p = true;
            }
            return p;
        }
        // see if 5 chesses is y win

        public static boolean CrossUpwin(Chess c1, Chess c2, Chess c3, Chess c4, Chess c5, int a){
            boolean p = false;
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
                if (!CrossNeighborUp(chesses.get(i), chesses.get(i + 1), a)){
                    p = false;
                    break;
                }
                p = true;
            }
            return p;
        }
        // see if 5 chesses is y=x win

        public static boolean CrossDownwin(Chess c1, Chess c2, Chess c3, Chess c4, Chess c5, int a){
            boolean p = false;
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
                if (!CrossNeighborDown(chesses.get(i), chesses.get(i + 1), a)){
                    p = false;
                    break;
                }
                p = true;
            }
            return p;
        }
        // see if 5 chesses is y=-x win


}
