import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class GomokuInt {

    private int[][] board = new int[19][19];
    private int x,y;
    private boolean gameover;
    private int chess;

    private int[][] steps = new int[255][3];
    private int step = 0;

    private Random randomGenerator = new Random();
    private int[] randomCorperation = new int[2];



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
//        while (!gameover) {
            Scanner input = new Scanner(System.in);
            x = input.nextInt();
            y = input.nextInt();
//            x = 0;
//            y = 0;
            chess++;

        steps[step][0] = x;
        steps[step][1] = y;
        step++;

        if (board[x][y] == 0) {
            if (chess % 2 == 1) {
                board[x][y] = 1;
                if (is33Ban()){
                    step--;
                    board[steps[step][0]][steps[step][1]] = 0;
                    chess--;
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



//        x = 5;
//        y = 3;
//        chess++;
//
//        steps[step][0] = x;
//        steps[step][1] = y;
//        step++;
//
//        if (board[x][y] == 0) {
//            if (chess % 2 == 1) {
//                board[x][y] = 1;
//                if (is33Ban()){
//                    step--;
//                    board[steps[step][0]][steps[step][1]] = 0;
//                    chess--;
//                }
//            } else board[x][y] = 2;
//            show();
//        }
//        if (isGameWon(x, y)) {
//            gameover = true;
//            if (chess % 2 == 1) {
//                System.out.println("Black win");
//            } else System.out.println("White win");
//        }
////        }
//
////        x = 10;
////        y = 9;
////        chess++;
////        steps[step][0] = x;
////        steps[step][1] = y;
////        steps[step][2] = chess % 2;
////        step++;
////        if (board[x][y] == 0) {
////            if (chess % 2 == 1) {
////                board[x][y] = 1;
////                if (is33Ban()){
////                    System.out.println("ban");
////                    undo(x, y, chess, step);
////                }
////            } else board[x][y] = 2;
////            show();
////        }
////        if (isGameWon(x, y)) {
////            gameover = true;
////            if (chess % 2 == 1) {
////                System.out.println("Black win");
////            } else System.out.println("White win");
////        }
////
////        x = 0;
////        y = 2;
////        chess++;
////        steps[step][0] = x;
////        steps[step][1] = y;
////        steps[step][2] = chess % 2;
////        step++;
////        if (board[x][y] == 0) {
////            if (chess % 2 == 1) {
////                board[x][y] = 1;
////                if (is33Ban()){
////                    System.out.println("ban");
////                    undo(x, y, chess, step);
////                }
////            } else board[x][y] = 2;
////            show();
////        }
////        if (isGameWon(x, y)) {
////            gameover = true;
////            if (chess % 2 == 1) {
////                System.out.println("Black win");
////            } else System.out.println("White win");
////        }
////
////        x = 12;
////        y = 12;
////        chess++;
////        steps[step][0] = x;
////        steps[step][1] = y;
////        if (chess % 2 == 1){
////            steps[step][2] = chess % 2;
////        }else steps[step][2] = 2;
////        step++;
////
////        if (board[x][y] == 0) {
////            if (chess % 2 == 1) {
////                board[x][y] = 1;
////                if (is33Ban()){
////                    System.out.println("ban");
////                    undo(steps[step][0], steps[step][1], steps[step][2], step);
////                }
////            } else board[x][y] = 2;
////            show();
////        }
////        if (isGameWon(x, y)) {
////            gameover = true;
////            if (chess % 2 == 1) {
////                System.out.println("Black win");
////            } else System.out.println("White win");
////        }
////
////        x = 1;
////        y = 3;
////        chess++;
////        steps[step][0] = x;
////        steps[step][1] = y;
////        steps[step][2] = chess % 2;
////        step++;
////        if (board[x][y] == 0) {
////            if (chess % 2 == 1) {
////                board[x][y] = 1;
////                if (is33Ban()){
////                    System.out.println("ban");
////                    undo(x, y, chess, step);
////                }
////            } else board[x][y] = 2;
////            show();
////        }
////        if (isGameWon(x, y)) {
////            gameover = true;
////            if (chess % 2 == 1) {
////                System.out.println("Black win");
////            } else System.out.println("White win");
////        }
////
////        x = 13;
////        y = 13;
////        chess++;
////        steps[step][0] = x;
////        steps[step][1] = y;
////        steps[step][2] = chess % 2;
////        step++;
////        if (board[x][y] == 0) {
////            if (chess % 2 == 1) {
////                board[x][y] = 1;
////                if (is33Ban()){
////                    System.out.println("ban");
////                    undo(x, y, chess, step);
////                }
////            } else board[x][y] = 2;
////            show();
////        }
////        if (isGameWon(x, y)) {
////            gameover = true;
////            if (chess % 2 == 1) {
////                System.out.println("Black win");
////            } else System.out.println("White win");
////        }
////
////        x = 2;
////        y = 2;
////        chess++;
////        steps[step][0] = x;
////        steps[step][1] = y;
////        steps[step][2] = chess % 2;
////        step++;
////        if (board[x][y] == 0) {
////            if (chess % 2 == 1) {
////                board[x][y] = 1;
////                if (is33Ban()){
////                    System.out.println("ban");
////                    undo(x, y, chess, step);
////                }
////            } else board[x][y] = 2;
////            show();
////        }
////        if (isGameWon(x, y)) {
////            gameover = true;
////            if (chess % 2 == 1) {
////                System.out.println("Black win");
////            } else System.out.println("White win");
////        }
////
////        x = 14;
////        y = 14;
////        chess++;
////        steps[step][0] = x;
////        steps[step][1] = y;
////        steps[step][2] = chess % 2;
////        step++;
////        if (board[x][y] == 0) {
////            if (chess % 2 == 1) {
////                board[x][y] = 1;
////                if (is33Ban()){
////                    System.out.println("ban");
////                    undo(x, y, chess, step);
////                }
////            } else board[x][y] = 2;
////            show();
////        }
////        if (isGameWon(x, y)) {
////            gameover = true;
////            if (chess % 2 == 1) {
////                System.out.println("Black win");
////            } else System.out.println("White win");
////        }
////
////        x = 1;
////        y = 2;
////        chess++;
////        steps[step][0] = x;
////        steps[step][1] = y;
////        steps[step][2] = chess % 2;
////        step++;
////        if (board[x][y] == 0) {
////            if (chess % 2 == 1) {
////                board[x][y] = 1;
////                if (is33Ban()){
////                    System.out.println("ban");
////                    undo(x, y, chess, step);
////                }
////            } else board[x][y] = 2;
////            show();
////        }
////        if (isGameWon(x, y)) {
////            gameover = true;
////            if (chess % 2 == 1) {
////                System.out.println("Black win");
////            } else System.out.println("White win");
////        }
////
////        x = 1;
////        y = 4;
////        chess++;
////        steps[step][0] = x;
////        steps[step][1] = y;
////        steps[step][2] = chess % 2;
////        step++;
////        if (board[x][y] == 0) {
////            if (chess % 2 == 1) {
////                board[x][y] = 1;
////                if (is33Ban()){
////                    System.out.println("ban");
////                    undo(x, y, chess, step);
////                }
////            } else board[x][y] = 2;
////            show();
////        }
////        if (isGameWon(x, y)) {
////            gameover = true;
////            if (chess % 2 == 1) {
////                System.out.println("Black win");
////            } else System.out.println("White win");
////        }
//
//        String undo = "undo";
//        if (undo == "undo"){
//            step--;
//            undo1(steps[step][0],steps[step][1],steps[step][2]);
//            chess--;
//
//        }
//
//        x = 2;
//        y = 2;
//        chess++;
//
//        steps[step][0] = x;
//        steps[step][1] = y;
//        step++;
//
//        if (board[x][y] == 0) {
//            if (chess % 2 == 1) {
//                board[x][y] = 1;
//                if (is33Ban()){
//                    step--;
//                    board[steps[step][0]][steps[step][1]] = 0;
//                    chess--;
//                }
//            } else board[x][y] = 2;
//            show();
//        }
//        if (isGameWon(x, y)) {
//            gameover = true;
//            if (chess % 2 == 1) {
//                System.out.println("Black win");
//            } else System.out.println("White win");
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

        int chessInTheGrid = 0;
        if (chess % 2 == 1){
            chessInTheGrid = 1;
        }else chessInTheGrid = 2;

        while (x + xChange >= 0 && x + xChange < 19 && y + yChange >= 0 && y + yChange < 19 && chessInTheGrid == board[x + xChange][y + yChange]){
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

        while (x - xChange >= 0 && x - xChange < 19 && y - yChange >= 0 && y - yChange < 19 && chessInTheGrid == board[x - xChange][y - yChange]){
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

    //xchange 和 ychange 是±3,只是判断第三个，要和checkcount连用,表示是活的，没有被堵
    public boolean different4(int x, int y, int xChange, int yChange, int chess){
        boolean isDifferent = false;
        boolean middle1 = false, middle2 = false;
        int tempx = xChange;
        int tempy = yChange;
        //移动的格子数的初始值

        if (x + xChange >= 0 && x + xChange < 19 && y + yChange >= 0 && y + yChange < 19){
            if((chess == 1 && board[x + xChange][y + yChange] == 0)){
                middle1 = true;
            }
        }

        if (x + xChange == 19 || y + yChange == 19){
                middle1 = true;
        }

        xChange = tempx;
        yChange = tempy;

        if (x - xChange >= 0 && x - xChange < 19 && y - yChange >= 0 && y - yChange < 19){
            if((chess == 1 && board[x - xChange][y - yChange] == 0)){
                middle2 = true;
            }
        }

        if (x - xChange == -1 || y - yChange == -1){
                middle2 = true;
        }

        if (middle1 && middle2){
            isDifferent = true;
        }

        return isDifferent;
    }

    public boolean is33BanExtension(int x, int y, int xChange, int yChange, int chess){
        boolean banWin = false;

        int count = 1;
        int tempx = xChange;
        int tempy = yChange;
        //移动的格子数的初始值

        int chessInTheGrid = 0;
        if (chess % 2 == 1){
            chessInTheGrid = 1;
        }else chessInTheGrid = 2;

        while (x + xChange >= 0 && x + xChange < 19 && y + yChange >= 0 && y + yChange < 19 && chessInTheGrid == board[x + xChange][y + yChange]){
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

        xChange = tempx;
        yChange = tempy;
        //回复初始值

        while (count >= 3 && x - xChange >= 0 && x - xChange < 19 && y - yChange >= 0 && y - yChange < 19 && chessInTheGrid == board[x - xChange][y - yChange]){
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

        if (count == 5){
            banWin = true;
        }

        return banWin;

    }

    public boolean is33Ban(){
        boolean ban = false;

        int[] countInFourDirections = new int[4];
        int chessInTheGrid = board[x][y];
        boolean different0, different1, different2, different3;
        boolean fakeWin0 = false, fakeWin1 = false, fakeWin2 = false, fakeWin3 = false;
        countInFourDirections[0] = checkCount(x, y, 1,0,chessInTheGrid);
        countInFourDirections[1] = checkCount(x, y, 0,1,chessInTheGrid);
        countInFourDirections[2] = checkCount(x, y, 1,1,chessInTheGrid);
        countInFourDirections[3] = checkCount(x, y, 1,-1,chessInTheGrid);


        boolean banWin1 = is33BanExtension(x, y, 1,0,chessInTheGrid);
        different0 = different4(x, y, 3, 0, chessInTheGrid);
        if (countInFourDirections[0] == 5 && different0){
            fakeWin0 = true;
        }

        boolean banWin2 = is33BanExtension(x, y, 0,1,chessInTheGrid);
        different1 = different4(x, y, 0, 3, chessInTheGrid);
        if (countInFourDirections[1] == 5 && different1){
            fakeWin1 = true;
        }

        boolean banWin3 = is33BanExtension(x, y, 1,1,chessInTheGrid);
        different2 = different4(x, y, 3, 3, chessInTheGrid);
        if (countInFourDirections[2] == 5 && different2){
            fakeWin2 = true;
        }

        boolean banWin4 = is33BanExtension(x, y, 1,-1,chessInTheGrid);
        different3 = different4(x, y, 3, -3, chessInTheGrid);
        if (countInFourDirections[3] == 5 && different3){
            fakeWin3 = true;
        }

        boolean specialDifferent0 = false, specialDifferent1 = false, specialDifferent2 = false, specialDifferent3 = false;
        boolean isSpecial0 = false, isSpecial1 = false, isSpecial2 = false, isSpecial3 = false;

        specialDifferent0 = different4(x, y, 2, 0, chessInTheGrid);
        if (countInFourDirections[0] == 3 && specialDifferent0){
            isSpecial0 = true;
        }

        specialDifferent1 = different4(x, y, 0, 2, chessInTheGrid);
        if (countInFourDirections[1] == 3 && specialDifferent1){
            isSpecial1 = true;
        }

        specialDifferent2 = different4(x, y, 2, 2, chessInTheGrid);
        if (countInFourDirections[2] == 3 && specialDifferent2){
            isSpecial2 = true;
        }

        specialDifferent3 = different4(x, y, 2, -2, chessInTheGrid);
        if (countInFourDirections[3] == 3 && specialDifferent3){
            isSpecial3 = true;
        }



        boolean isActive30 = false, isActive31 = false, isActive32 = false, isActive33 = false;
        if (countInFourDirections[0] == 3 && different0){
            isActive30 = true;
        }
        if (countInFourDirections[1] == 3 && different1){
            isActive31 = true;
        }
        if (countInFourDirections[2] == 3 && different2){
            isActive32 = true;
        }
        if (countInFourDirections[3] == 3 && different3){
            isActive33 = true;
        }


        if (fakeWin0 || fakeWin1 || fakeWin2 || fakeWin3){
            ban = true;
        }

        if (isActive30){
            if (isActive31 || isActive32 || isActive33){
                ban = true;
            }
        }
        else if (!isActive30 && isActive31){
            if (isActive32 || isActive33){
                ban = true;
            }
        }
        else if (!isActive30 && !isActive31 && isActive32){
            if (isActive33){
                ban = true;
            }
        }

        if (banWin1 || banWin2 || banWin3 || banWin4){
            ban = true;
        }

        if (isSpecial0){
            if (isSpecial1 || isSpecial2 || isSpecial3){
                ban = true;
            }
        }
        else if (!isSpecial0 && isSpecial1){
            if (isSpecial2 || isSpecial3){
                ban = true;
            }
        }
        else if (!isSpecial0 && !isSpecial1 && isSpecial2){
            if (isSpecial3){
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

    public int[] undo(int x, int y, int chess, int step){
        int[] afterUndo = new int[4];
        afterUndo[0] = x;
        afterUndo[1] = y;
        afterUndo[2] = chess--;
        afterUndo[3] = step--;
        return afterUndo;
    }
    //应该还要改

    public void undo1(int x, int y, int step){
        board[x][y] = 0;
        show();

    }

    public void save() throws FileNotFoundException {
        PrintWriter output = new PrintWriter("saving.txt");
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                output.print(board[i][j]);
            }
        }
    }

    public int[][] load() throws FileNotFoundException {
        File file = new File("saving.txt");
        Scanner input = new Scanner(file);
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                board[i][j] = input.nextInt();
            }
        }
        return board;
    }

    public Player randomFirstPlayer(){
        Player player1 = Player.COMPUTER;
        int a = (int)(Math.random()*2);
        if (a % 2 == 1){
            player1 = Player.PERSON;
        }
        return player1;
    }

    public void randomGrid(int xLastStep, int yLastStep){
//        boolean isEmpty = true;
//        for (int i = 0; i < board.length; i++){
//            for (int j = 0; j < board.length; j++){
//                if (board[i][j] != 0){
//                    isEmpty = false;
//                    break;
//                }
//            }
//        }
//
//        if (isEmpty){
//            this.x = 19 / 2;
//            this.y = 19 / 2;
//            chess++;
//
//            steps[step][0] = x;
//            steps[step][1] = y;
//            step++;
//
//            board[x][y] = 1;
//            show();
//        }else {c9
            int xChange = 0;
            int yChange = 0;
            randomCorperation[0] = xLastStep + xChange;
            randomCorperation[1] = yLastStep + yChange;

        while (board[randomCorperation[0]][randomCorperation[1]] != 0){
            xChange = (int)(Math.random()*3) - 1;
            yChange = (int)(Math.random()*3) - 1;
            randomCorperation[0] = xLastStep + xChange;
            randomCorperation[1] = yLastStep + yChange;
            while (randomCorperation[0] < 0 || randomCorperation[0] > 19
                    || randomCorperation[1] < 0 || randomCorperation[1] > 19){
                xChange = (int)(Math.random()*3) - 1;
                yChange = (int)(Math.random()*3) - 1;
                randomCorperation[0] = xLastStep + xChange;
                randomCorperation[1] = yLastStep + yChange;
            }
        }

//            do {
//                xChange = (int)(Math.random()*3 - 2);
//                yChange = (int)(Math.random()*3 - 2);
//                randomCorperation[0] = xLastStep + xChange;
//                randomCorperation[1] = yLastStep + yChange;
//            } while (randomCorperation[0] < 0 || randomCorperation[0] > 19
//                        || randomCorperation[1] < 0 || randomCorperation[1] > 19);
//
//            while (board[randomCorperation[0]][randomCorperation[1]] != 0){
//                xChange = (int)(Math.random()*3 - 2);
//                yChange = (int)(Math.random()*3 - 2);
//                randomCorperation[0] = xLastStep + xChange;
//                randomCorperation[1] = yLastStep + yChange;
//            }

//        }
    }

    public void computerSetChess(int xLastStep, int yLastStep){

        randomGrid(xLastStep, yLastStep);
        x = randomCorperation[0];
        y = randomCorperation[1];


        step++;
        steps[step][0] = x;
        steps[step][1] = y;
        step++;


        if (board[x][y] == 0) {
            if (chess % 2 == 1) {
                board[x][y] = 1;
                if (is33Ban()){
                    step--;
                    board[steps[step][0]][steps[step][1]] = 0;
                    chess--;
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

    public void playWithComputer(){
        Player playerOnTurn = randomFirstPlayer();
        while (!gameover){
            if (playerOnTurn == Player.COMPUTER){
                chess++;
                if (step == 0){
                    this.x = 19 / 2;
                    this.y = 19 / 2;

                    steps[step][0] = x;
                    steps[step][1] = y;
                    step++;

                    board[x][y] = chess % 2;
                    show();
                    playerOnTurn = Player.PERSON;
                }
                else {
                    step--;
                    computerSetChess(steps[step][0], steps[step][1]);
                    playerOnTurn = Player.PERSON;
                }
            }

            else {
                putChess();
                playerOnTurn = Player.COMPUTER;
            }
        }

    }

    public void play(){
        show();
        playWithComputer();
    }

    public static void main(String[] args) {
        GomokuInt gomokuInt = new GomokuInt();
        gomokuInt.play();
    }

}
