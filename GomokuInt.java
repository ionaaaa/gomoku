import java.util.Scanner;

public class GomokuInt {

    private int[][] board = new int[19][19];
    private int x,y;
    private boolean gameover;
    private int chess;

    private int[][] steps = new int[255][3];
    private int step;


    GomokuInt(){
        gameover = false;
        chess = 0;
        step = 0;
    }

    public void show(){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public void putChess(){
        while (!gameover) {
            Scanner input = new Scanner(System.in);
            x = input.nextInt();
            y = input.nextInt();
//            x = 0;
//            y = 0;
            chess++;

            steps[step][0] = x;
            steps[step][1] = y;
            steps[step][2] = chess % 2;
            step++;

            if (board[x][y] == 0) {
                if (chess % 2 == 1) {
                    board[x][y] = 1;
                    if (is33Ban()){
                        System.out.println("ban");
                        chess--;
                        board[x][y] = 0;
                    }
                } else board[x][y] = 2;
                show();
            }
            if (isGameWon(x, y)) {
                gameover = true;
                if (chess % 2 == 1) {
                    System.out.println("Black win");
                } else System.out.println("White win");
            }
        }
//        }

//        x = 2;
//        y = 0;
//        if (board[x][y] == 0) {
//            chess++;
//            if (chess % 2 == 1) {
//                board[x][y] = 1;
//            } else board[x][y] = 2;
//            show();
//        }
//        if(isGameWon(x,y)){
//            gameover = true;
//            System.out.println("over");
//        }
//
//        x = 1;
//        y = 1;
//        if (board[x][y] == 0) {
//            chess++;
//            if (chess % 2 == 1) {
//                board[x][y] = 1;
//            } else board[x][y] = 2;
//            show();
//        }
//        if(isGameWon(x,y)){
//            gameover = true;
//            System.out.println("over");
//        }
//
//        x = 2;
//        y = 1;
//        if (board[x][y] == 0) {
//            chess++;
//            if (chess % 2 == 1) {
//                board[x][y] = 1;
//            } else board[x][y] = 2;
//            show();
//        }
//        if(isGameWon(x,y)){
//            gameover = true;
//            System.out.println("over");
//        }
//
//        x = 2;
//        y = 2;
//        if (board[x][y] == 0) {
//            chess++;
//            if (chess % 2 == 1) {
//                board[x][y] = 1;
//            } else board[x][y] = 2;
//            show();
//        }
//        if(isGameWon(x,y)){
//            gameover = true;
//            System.out.println("over");
//        }
//
//        x = 1;
//        y = 2;
//        if (board[x][y] == 0) {
//            chess++;
//            if (chess % 2 == 1) {
//                board[x][y] = 1;
//            } else board[x][y] = 2;
//            show();
//        }
//        if(isGameWon(x,y)){
//            gameover = true;
//            System.out.println("over");
//        }
//
//        x = 3;
//        y = 3;
//        if (board[x][y] == 0) {
//            chess++;
//            if (chess % 2 == 1) {
//                board[x][y] = 1;
//            } else board[x][y] = 2;
//            show();
//        }
//        if(isGameWon(x,y)){
//            gameover = true;
//            System.out.println("over");
//        }
//
//        x = 1;
//        y = 0;
//        if (board[x][y] == 0) {
//            chess++;
//            if (chess % 2 == 1) {
//                board[x][y] = 1;
//            } else board[x][y] = 2;
//            show();
//        }
//        if(isGameWon(x,y)){
//            gameover = true;
//            System.out.println("over");
//        }
//
//        x = 4;
//        y = 4;
//        if (board[x][y] == 0) {
//            chess++;
//            if (chess % 2 == 1) {
//                board[x][y] = 1;
//            } else board[x][y] = 2;
//            show();
//        }
//        if(isGameWon(x,y)){
//            gameover = true;
//            System.out.println("over");
//        }
    }

    public boolean isGameWon(int x, int y) {
        boolean win = false;
        int[] countInFourDirections = new int[4];
        int chessInTheGrid = board[x][y];
        countInFourDirections[0] = checkCount(x, y, 1,0,chessInTheGrid);
        countInFourDirections[1] = checkCount(x, y, 0,1,chessInTheGrid);
        countInFourDirections[2] = checkCount(x, y, 1,1,chessInTheGrid);
        countInFourDirections[3] = checkCount(x, y, 1,-1,chessInTheGrid);
        if (countInFourDirections[0] >= 5 || countInFourDirections[1] >= 5
                || countInFourDirections[2] >= 5 || countInFourDirections[3] >= 5){
            win = true;
        }
        return win;
    }


    public int checkCount(int x, int y, int xChange, int yChange, int chess){
        int count = 1;
        int tempx = xChange;
        int tempy = yChange;
        //移动的格子数的初始值

        while (x + xChange >= 0 && x + xChange < 19 && y + yChange >= 0 && y + yChange < 19 && board[x + xChange][y + yChange] != 0 && chess % 2 == board[x + xChange][y + yChange]){
            count ++;
            if (yChange == 0){
                xChange++;
            }
            else if (xChange == 0){
                yChange++;
            }
            else if (xChange == yChange){
                xChange++;
                yChange++;
            }
            else if (xChange == yChange * -1){
                xChange++;
                yChange--;
            }
        }
        //四个方向，向正方向判断

        xChange = tempx;
        yChange = tempy;
        //回复初始值

        while (x - xChange >= 0 && x - xChange < 19 && y - yChange >= 0 && y - yChange < 19 &&  board[x - xChange][y - yChange] != 0 && chess % 2 == board[x - xChange][y - yChange]){
            count ++;
            if (yChange == 0){
                xChange++;
            }
            else if (xChange == 0){
                yChange++;
            }
            else if (xChange == yChange){
                xChange++;
                yChange++;
            }
            else if (xChange == yChange * -1){
                xChange++;
                yChange--;
            }
        }
        //向负方向判断
        return count;
    }

    public boolean is33Ban(){
        boolean ban = false;
        int[] countInFourDirections = new int[4];
        int chessInTheGrid = board[x][y];
        countInFourDirections[0] = checkCount(x, y, 1,0,chessInTheGrid);
        countInFourDirections[1] = checkCount(x, y, 0,1,chessInTheGrid);
        countInFourDirections[2] = checkCount(x, y, 1,1,chessInTheGrid);
        countInFourDirections[3] = checkCount(x, y, 1,-1,chessInTheGrid);
        if (countInFourDirections[0] == 3){
            if (countInFourDirections[1] == 3 || countInFourDirections[2] == 3 || countInFourDirections[3] == 3){
                ban = true;
            }
        }
        else if (countInFourDirections[0] != 3 && countInFourDirections[1] == 3){
            if (countInFourDirections[2] == 3 || countInFourDirections[3] == 3){
                ban = true;
            }
        }
        else if (countInFourDirections[0] != 3 && countInFourDirections[1] != 3 && countInFourDirections[2] == 3){
            if (countInFourDirections[3] == 3){
                ban = true;
            }
        }
        return ban;
    }

    //size要换
    public void clear() {
        chess = 0;
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                board[i][j] = 0;
            }
        }
    }

    public void undo(int x, int y){
        chess--;
        board[x][y] = 0;
    }
    //做undo，思考step位置

    public void play(){
        show();
        putChess();
    }

    public static void main(String[] args) {
        GomokuInt gomokuInt = new GomokuInt();
        gomokuInt.play();
    }

}
