import com.sun.org.apache.bcel.internal.classfile.Constant;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class gomoku {
    private int SIZE1 = 17;

    private int[][] board = new int[SIZE1 + 1][SIZE1 + 1];//记录数据的数组大小，不知道改不改，数学不好
    private int x, y; //落子坐标
    private boolean gameover; //游戏是否结束
    private int chess;//棋子

    private int[][] steps = new int[255][2]; //存储步数的数组
    private int step;//步数

    private int[] randomCorperation = new int[2]; //存储人机系统中电脑随机的坐标的数组

    //timer系统
    private Calendar c = Calendar.getInstance();
    private long endtime = c.getTimeInMillis();
    private Date date = new Date();
    private long starttime = date.getTime();
    private long midtime = (endtime - starttime) / 1000;
    private int time;
    private boolean isTimeUp = false;



    //constructor
    gomoku() {
        gameover = false;
        chess = 0;
        step = 0;
        c.set(2021, 11, 24, 0, 0, 0);
    }



    //开屏展示，封面+选择棋盘+棋盘
    public void show() throws InterruptedException, FileNotFoundException {
        //显示封面
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        StdDraw.setXscale(0,SIZE1 + 1);
        StdDraw.setYscale(0,SIZE1 + 1);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.setFont();
        StdDraw.picture((SIZE1 +1)/2,(SIZE1 -2)/2,"fengmian.jpg",(SIZE1 + 4),(SIZE1 + 6));


        //进入pvp
        while (true) {
            if ((StdDraw.mouseX() >= 0.75 * (SIZE1 + 1)) && (StdDraw.isMousePressed()) && (StdDraw.mouseX() <= 0.95 * (SIZE1 + 1)) && (StdDraw.mouseY() <= 0.75 * (SIZE1 + 1)) && (StdDraw.mouseY() >= 0.6 * (SIZE1 + 1))) {
                StdDraw.clear();
                StdDraw.picture((SIZE1 +2)/2,(SIZE1 -1)/2,"chicun.jpg",(SIZE1 + 7),(SIZE1 + 8));
                while (true){
                    if ((StdDraw.mouseX() >= 0.1*(SIZE1 + 1)) && (StdDraw.isMousePressed()) && (StdDraw.mouseX() <= 0.4*(SIZE1 + 1)) && (StdDraw.mouseY() <= 0.3*(SIZE1 + 1)) && (StdDraw.mouseY() >= 0.0*(SIZE1 + 1))) {
                        SIZE1 = 17;
                        break;
                    }
                    if ((StdDraw.mouseX() >= 0.1*(SIZE1 + 1)) && (StdDraw.isMousePressed()) && (StdDraw.mouseX() <= 0.4*(SIZE1 + 1)) && (StdDraw.mouseY() <= 0.60*(SIZE1 + 1)) && (StdDraw.mouseY() >= 0.40*(SIZE1 + 1))) {
                        SIZE1 = 15;
                        break;
                    }
                    if ((StdDraw.mouseX() >= 0.1*(SIZE1 + 1)) && (StdDraw.isMousePressed()) && (StdDraw.mouseX() <= 0.4*(SIZE1 + 1)) && (StdDraw.mouseY() <= 0.750*(SIZE1 + 1)) && (StdDraw.mouseY() >= 0.650*(SIZE1 + 1))) {
                        SIZE1 = 13;
                        break;
                    }
                }
                StdDraw.clear();
                StdDraw.setXscale(0,SIZE1 + 6);
                StdDraw.setYscale(0,SIZE1 + 6);
                switch (SIZE1) {
                    case 13:
                        StdDraw.picture((SIZE1 + 1) / 2, (SIZE1 + 1) / 2, "qipan(2).png", (SIZE1 + 1), (SIZE1 + 1));
                        break;
                    case 15:
                        StdDraw.picture((SIZE1 + 1) / 2, (SIZE1 + 1) / 2, "qipan(1).png", (SIZE1 + 1), (SIZE1 + 1));
                        break;
                    case 17:
                        StdDraw.picture((SIZE1 + 1) / 2, (SIZE1 + 1) / 2, "qipan.png", (SIZE1 + 1), (SIZE1 + 1));
                        break;
                }
                StdDraw.setPenColor(StdDraw.ORANGE);
                StdDraw.filledRectangle(SIZE1-12, SIZE1+3, 0.2*20, 0.03*20);
                StdDraw.filledRectangle(SIZE1-12, SIZE1+5, 0.2*20, 0.03*20);
                StdDraw.filledRectangle(SIZE1+3, SIZE1+5,  0.2*SIZE1, 0.03*SIZE1);
                StdDraw.filledRectangle(SIZE1+3.5, SIZE1-4, 0.1*SIZE1, 0.03*SIZE1);
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.text(SIZE1-10, SIZE1+3, "Undo ");
                StdDraw.text(SIZE1-10, SIZE1+5, "save");
                StdDraw.text(SIZE1+3, SIZE1+5, "load");
                StdDraw.text(SIZE1+3.5, SIZE1-4, "timer");
                Thread.sleep(100);
                playWithPerson();

            }

            //进入pve
            if ((StdDraw.mouseX() >= 0.75 * (SIZE1 + 1)) && (StdDraw.isMousePressed()) && (StdDraw.mouseX() <= 0.95 * (SIZE1 + 1)) && (StdDraw.mouseY() <= 0.55 * (SIZE1 + 1)) && (StdDraw.mouseY() >= 0.45 * (SIZE1 + 1))) {
                StdDraw.clear();
                StdDraw.picture((SIZE1 +2)/2,(SIZE1 -1)/2,"chicun.jpg",(SIZE1 + 7),(SIZE1 + 8));
                while (true){
                    if ((StdDraw.mouseX() >= 0.1*(SIZE1 + 1)) && (StdDraw.isMousePressed()) && (StdDraw.mouseX() <= 0.4*(SIZE1 + 1)) && (StdDraw.mouseY() <= 0.3*(SIZE1 + 1)) && (StdDraw.mouseY() >= 0.0*(SIZE1 + 1))) {
                        SIZE1 = 17;
                        break;
                    }
                    if ((StdDraw.mouseX() >= 0.1*(SIZE1 + 1)) && (StdDraw.isMousePressed()) && (StdDraw.mouseX() <= 0.4*(SIZE1 + 1)) && (StdDraw.mouseY() <= 0.60*(SIZE1 + 1)) && (StdDraw.mouseY() >= 0.40*(SIZE1 + 1))) {
                        StdDraw.clear();
                        SIZE1 = 15;
//                        StdDraw.setXscale(0,SIZE1 + 6);
//                        StdDraw.setYscale(0,SIZE1 + 6);
//
//                        StdDraw.picture((SIZE1 + 1)/2,(SIZE1 + 1)/2,"qipan(1).png",(SIZE1 + 1),(SIZE1 + 1));
//                        StdDraw.setPenColor(StdDraw.ORANGE);
//                        StdDraw.filledRectangle(SIZE1-12, SIZE1+3, 0.2*20, 0.03*20);
//                        StdDraw.filledRectangle(SIZE1-12, SIZE1+5, 0.2*20, 0.03*20);
//                        StdDraw.filledRectangle(SIZE1+1, SIZE1+5, 0.2*20, 0.03*20);
//                        StdDraw.filledRectangle(SIZE1+3.5, SIZE1-4, 0.1*SIZE1, 0.03*SIZE1);
//                        StdDraw.setPenColor(StdDraw.BLACK);
//                        StdDraw.text(SIZE1-12, SIZE1+3, "Undo");
//                        StdDraw.text(SIZE1-12, SIZE1+5, "save");
//                        StdDraw.text(SIZE1+1, SIZE1+5, "load");
//                        StdDraw.text(SIZE1+3.5, SIZE1-4, "timer");
                        break;
                    }
                    if ((StdDraw.mouseX() >= 0.1*(SIZE1 + 1)) && (StdDraw.isMousePressed()) && (StdDraw.mouseX() <= 0.4*(SIZE1 + 1)) && (StdDraw.mouseY() <= 0.750*(SIZE1 + 1)) && (StdDraw.mouseY() >= 0.650*(SIZE1 + 1))) {
                        SIZE1 = 13;
//                        StdDraw.clear();
//                        StdDraw.setXscale(0,SIZE1 + 6);
//                        StdDraw.setYscale(0,SIZE1 + 6);
//                        StdDraw.picture((SIZE1 + 1)/2,(SIZE1 + 1)/2,"qipan(2).png",(SIZE1 + 1),(SIZE1 + 1));
//                        StdDraw.setPenColor(StdDraw.ORANGE);
//                        StdDraw.filledRectangle(SIZE1-12, SIZE1+3, 0.2*20, 0.03*20);
//                        StdDraw.filledRectangle(SIZE1-12, SIZE1+5, 0.2*20, 0.03*20);
//                        StdDraw.filledRectangle(SIZE1+3, SIZE1+5,  0.2*SIZE1, 0.03*SIZE1);
//                        StdDraw.filledRectangle(SIZE1+3.5, SIZE1-4, 0.1*SIZE1, 0.03*SIZE1);
//                        StdDraw.setPenColor(StdDraw.BLACK);
//                        StdDraw.text(SIZE1-10, SIZE1+3, "Undo ");
//                        StdDraw.text(SIZE1-10, SIZE1+5, "save");
//                        StdDraw.text(SIZE1+3, SIZE1+5, "load");
//                        StdDraw.text(SIZE1+3.5, SIZE1-4, "timer");
                        break;
                    }
                }
                StdDraw.clear();
                StdDraw.setXscale(0,SIZE1 + 6);
                StdDraw.setYscale(0,SIZE1 + 6);
                switch (SIZE1) {
                    case 13:
                        StdDraw.picture((SIZE1 + 1) / 2, (SIZE1 + 1) / 2, "qipan(2).png", (SIZE1 + 1), (SIZE1 + 1));
                        break;
                    case 15:
                        StdDraw.picture((SIZE1 + 1) / 2, (SIZE1 + 1) / 2, "qipan(1).png", (SIZE1 + 1), (SIZE1 + 1));
                        break;
                    case 17:
                        StdDraw.picture((SIZE1 + 1) / 2, (SIZE1 + 1) / 2, "qipan.png", (SIZE1 + 1), (SIZE1 + 1));
                        break;
                }
                StdDraw.setPenColor(StdDraw.ORANGE);
                StdDraw.filledRectangle(SIZE1-12, SIZE1+3, 0.2*20, 0.03*20);
                StdDraw.filledRectangle(SIZE1-12, SIZE1+5, 0.2*20, 0.03*20);
                StdDraw.filledRectangle(SIZE1+3, SIZE1+5,  0.2*SIZE1, 0.03*SIZE1);
                StdDraw.filledRectangle(SIZE1+3.5, SIZE1-4, 0.1*SIZE1, 0.03*SIZE1);
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.text(SIZE1-10, SIZE1+3, "Undo ");
                StdDraw.text(SIZE1-10, SIZE1+5, "save");
                StdDraw.text(SIZE1+3, SIZE1+5, "load");
                StdDraw.text(SIZE1+3.5, SIZE1-4, "timer");
                Thread.sleep(100);
                playWithComputer();
            }


            //exit game
            if ((StdDraw.mouseX() >= 0.8*(SIZE1 + 1)) && (StdDraw.isMousePressed()) && (StdDraw.mouseX() <= 0.95*(SIZE1 + 1)) && (StdDraw.mouseY() <= 0.3*(SIZE1 + 1)) && (StdDraw.mouseY() >= 0.20*(SIZE1 + 1))) {
                StdDraw.clear();
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.picture((SIZE1 + 2)/2,(SIZE1 -2)/2,"Game Over.jpg",(SIZE1 + 6),(SIZE1 +10));
            }
        }
    }



    //玩家放置棋子
    public void putChess() throws InterruptedException, FileNotFoundException {
//        while (isMousePressed()){
        if (!gameover) {
            if ((double) Math.round(StdDraw.mouseX()) - 0.3 < StdDraw.mouseX() && StdDraw.mouseX() < (double) Math.round(StdDraw.mouseX()) + 0.3
                    && (double) Math.round(StdDraw.mouseY()) - 0.3 < StdDraw.mouseY() && StdDraw.mouseY() < (double) Math.round(StdDraw.mouseY()) + 0.3
                    && (StdDraw.mouseX() > 0.04 * (SIZE1 + 1)) && (StdDraw.mouseY() > 0.04 * (SIZE1 + 1))
                    && (StdDraw.mouseX() < 0.96 * (SIZE1 + 1)) && (StdDraw.mouseY() < 0.96 * (SIZE1 + 1))) {

                //获取鼠标点击坐标
                x = (int) Math.round(StdDraw.mouseX());
                y = (int) Math.round(StdDraw.mouseY());

                //落子处为空
                if (board[x][y] == 0) {
                    chess++;

                    //记录本次落子步数、位置
                    steps[step][0] = x;
                    steps[step][1] = y;
                    step++;

                    if (chess % 2 == 1) {
                        board[x][y] = 1;
                        if (is33Ban()) {
                            StdDraw.text(0.40 * (SIZE1 + 1), 0.60 * (SIZE1 + 1), "ban");
                            step--;
                            board[steps[step][0]][steps[step][1]] = 0;
                            chess--;
                        }
                    } else board[x][y] = 2;
                    drawChess();
                }

                //若落子处非空
                if (board[x][y] != 0) {
                    Thread.sleep(100);
                }

                //若某方获胜
                if (isGameWon(x, y)) {
                    gameover = true;
                    if (chess % 2 == 1) {
                        StdDraw.clear();
                        StdDraw.setPenColor(Color.BLACK);
                        StdDraw.picture((SIZE1 + 5) / 2, (SIZE1 + 3) / 2, "Black Win.jpg", (SIZE1 + 7), (SIZE1 + 10));
                    } else {
                        StdDraw.setPenColor(Color.BLACK);
                        StdDraw.picture((SIZE1 + 5) / 2, (SIZE1 + 3) / 2, "White Win.jpg", (SIZE1 + 7), (SIZE1 + 10));
                    }
                }
            }

            //undo系统
            if ((StdDraw.mouseX() >= 0) && (StdDraw.isMousePressed()) && (StdDraw.mouseX() <= 9) && (StdDraw.mouseY() <= SIZE1+3.6) && (StdDraw.mouseY() >= SIZE1+2.4)) {
                step--;
                board[steps[step][0]][steps[step][1]] = 0;
                chess--;
                switch (SIZE1) {
                    case 13:
                        StdDraw.picture((SIZE1 + 1) / 2, (SIZE1 + 1) / 2, "qipan(2).png", (SIZE1 + 1), (SIZE1 + 1));
                        break;
                    case 15:
                        StdDraw.picture((SIZE1 + 1) / 2, (SIZE1 + 1) / 2, "qipan(1).png", (SIZE1 + 1), (SIZE1 + 1));
                        break;
                    case 17:
                        StdDraw.picture((SIZE1 + 1) / 2, (SIZE1 + 1) / 2, "qipan.png", (SIZE1 + 1), (SIZE1 + 1));
                        break;
                }
                drawChess();
            }

            //调用存档方法
            if ((StdDraw.mouseX() >= 0) && (StdDraw.isMousePressed()) && (StdDraw.mouseX() <= 9) && (StdDraw.mouseY() <= SIZE1+5.6) && (StdDraw.mouseY() >= SIZE1+4.4)) {
                StdDraw.text(0.40 * (SIZE1 + 1), 0.60 * (SIZE1 + 1), "SAVE");
                save();
            }

            //调用读档方法
            if ((StdDraw.mouseX() >= 9.1) && (StdDraw.isMousePressed()) && (StdDraw.mouseX() <= 20) && (StdDraw.mouseY() <= SIZE1+5.6) && (StdDraw.mouseY() >= SIZE1+4.4)) {
                board = load();
                switch (SIZE1) {
                    case 13:
                        StdDraw.picture((SIZE1 + 1) / 2, (SIZE1 + 1) / 2, "qipan(2).png", (SIZE1 + 1), (SIZE1 + 1));
                        break;
                    case 15:
                        StdDraw.picture((SIZE1 + 1) / 2, (SIZE1 + 1) / 2, "qipan(1).png", (SIZE1 + 1), (SIZE1 + 1));
                        break;
                    case 17:
                        StdDraw.picture((SIZE1 + 1) / 2, (SIZE1 + 1) / 2, "qipan.png", (SIZE1 + 1), (SIZE1 + 1));
                        break;
                }
                drawChess();
            }

        }
    }

//        }




    //重绘棋盘上的棋子
    public void drawChess(){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == 1){
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.picture(i, (j), "heizi.png",0.75,0.75);
                }
                if (board[i][j] == 2){
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.picture(i, (j), "baizi.png",0.77,0.77);
                }
            }
        }
    }


    //判定是否获胜，思路：看落子处四个方向是否能连成五子。使用checkcount方法统计相连棋子的数量，若数量大于等于5，则win
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

    //用于统计相连棋子的数量，此处规定填入的xchange与ychange只能为（1,0）（0,1）（1,1）（1，-1）四组（对应四个方向）
    public int checkCount(int x, int y, int xChange, int yChange, int chess){
        int count = 1;

        //存储移动的格子数的初始值
        int tempx = xChange;
        int tempy = yChange;


        int chessInTheGrid = 0;
        if (chess % 2 == 1){
            chessInTheGrid = 1;
        }else chessInTheGrid = 2;

        //四个方向，向正方向判断
        while (x + xChange >= 0 && x + xChange < SIZE1 && y + yChange >= 0 && y + yChange < SIZE1
                && chessInTheGrid == board[x + xChange][y + yChange]){
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

        //将xchange和ychange回复初始值，进行反向判断
        xChange = tempx;
        yChange = tempy;

        //反向判断
        while (x - xChange >= 0 && x - xChange < SIZE1 && y - yChange >= 0 && y - yChange < SIZE1 && chessInTheGrid == board[x - xChange][y - yChange]){
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
        return count;
    }




    //用来判断是活三还是死三，填入的xchange 和 ychange 是±3,只是判断第四个位置的棋子是不是空的
    public boolean different4(int x, int y, int xChange, int yChange, int chess){
        boolean isDifferent = false;
        boolean middle1 = false, middle2 = false;
        int tempx = xChange;
        int tempy = yChange;
        //移动的格子数的初始值

        if (x + xChange >= 0 && x + xChange < SIZE1 && y + yChange >= 0 && y + yChange < SIZE1){
            if((chess == 1 && board[x + xChange][y + yChange] == 0)){
                middle1 = true;
            }
        }

        if (x + xChange == SIZE1 || y + yChange == SIZE1){
            middle1 = true;
        }

        xChange = tempx;
        yChange = tempy;

        if (x - xChange >= 0 && x - xChange < SIZE1 && y - yChange >= 0 && y - yChange < SIZE1){
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


    //非普通三三禁的情况判定
    public boolean is33BanExtension(int x, int y, int xChange, int yChange, int chess){
        boolean banWin = false;

        int count = 1;
        int tempx = xChange;
        int tempy = yChange;
        //移动的格子数的初始值

        while (x + xChange >= 0 && x + xChange < SIZE1 && y + yChange >= 0 && y + yChange < SIZE1 && board[x + xChange][y + yChange] != 0 && chess % 2 == board[x + xChange][y + yChange]){
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

        while (count >= 3 && x - xChange >= 0 && x - xChange < SIZE1 && y - yChange >= 0 && y - yChange < SIZE1 &&  board[x - xChange][y - yChange] != 0 && chess % 2 == board[x - xChange][y - yChange]){
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


    //判定三三禁。和判定赢的方法相似，若checkcount返回值为3,且isDifferent判定第四个格子为空格，即为活三
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


    //存档，输出当前数组
    public void save() throws FileNotFoundException {
        PrintWriter output = new PrintWriter("saving.txt");
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                output.print(board[i][j]);
            }
        }
        output.close();
    }


    //读档，读取存档的文件后重画棋盘
    public int[][] load() throws FileNotFoundException {
        File file = new File("saving.txt");
        Scanner input = new Scanner(file);
        String input1 = input.nextLine();

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                board[i][j] = Integer.parseInt(input1.substring(i * board.length + j, i * board.length + j + 1));
            }
        }
        return board;
    }


    //人机对战的玩家
    public enum Player {
        COMPUTER, PERSON;
    }



    //人机，随机先手玩家
    public Player randomFirstPlayer(){
        Player player1 = Player.COMPUTER;
        int a = (int)(Math.random()*2);
        if (a % 2 == 1){
            player1 = Player.PERSON;
        }
        return player1;
    }

    //思路：玩家落子后，电脑在其周围选取一空格落子。此为获取随机格子的方法
    public void randomGrid(int xLastStep, int yLastStep){
        int xChange = 0;
        int yChange = 0;
        randomCorperation[0] = xLastStep + xChange;
        randomCorperation[1] = yLastStep + yChange;

        while (board[randomCorperation[0]][randomCorperation[1]] != 0){
            xChange = (int)(Math.random()*3) - 1;
            yChange = (int)(Math.random()*3) - 1;
            randomCorperation[0] = xLastStep + xChange;
            randomCorperation[1] = yLastStep + yChange;
            while (randomCorperation[0] < 0 || randomCorperation[0] > SIZE1
                    || randomCorperation[1] < 0 || randomCorperation[1] > SIZE1){
                xChange = (int)(Math.random()*3) - 1;
                yChange = (int)(Math.random()*3) - 1;
                randomCorperation[0] = xLastStep + xChange;
                randomCorperation[1] = yLastStep + yChange;
            }
        }
    }

    //电脑落子（非第一步）
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
                    StdDraw.text(0.40*(SIZE1 + 1), 0.60*(SIZE1 + 1),"ban");
                    step--;
                    board[steps[step][0]][steps[step][1]] = 0;
                    chess--;
                }
            } else board[x][y] = 2;
            drawChess();
        }
        if (isGameWon(x, y)) {
            gameover = true;
            if (chess % 2 == 1) {
                StdDraw.clear();
                StdDraw.setPenColor(Color.BLACK);
                StdDraw.text(0.50*(SIZE1 + 1), 0.50*(SIZE1 + 1), "Black Win");
            } else {
                StdDraw.setPenColor(Color.BLACK);
                StdDraw.text(0.50 * (SIZE1 + 1), 0.50 * (SIZE1 + 1), "White win");
            }
        }
    }

    //人机对战方法
    public void playWithComputer() throws InterruptedException, FileNotFoundException {
        Player playerOnTurn = randomFirstPlayer();
        while (!gameover){

            //电脑落子
            if (playerOnTurn == Player.COMPUTER){
                chess++;

                //若电脑先手，第一步下在棋盘中间
                if (step == 0){
                    this.x = SIZE1 / 2;
                    this.y = SIZE1 / 2;

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

            //玩家落子
            else {
                if (isMousePressed()){
                    putChess();
                    Thread.sleep(500);
                    playerOnTurn = Player.COMPUTER;
                }
            }
        }

    }

    //PVP对战
    public void playWithPerson() throws InterruptedException, FileNotFoundException {
        while (true){
            while (isMousePressed()){
                putChess();
            }
        }
    }

    public int getSIZE1(){
        return SIZE1;
    }

    public int getChess(){
        return chess;
    }

//    public void showPerSecond(int time){
//        while (time > 0){
//            time--;
//            try {
//                Thread.sleep(1000);
//                int hh = time / 60 / 60;
//                int mm = time / 60 % 60;
//                int ss = time % 60;
//
//                StdDraw.clear();
//                StdDraw.setXscale(0,SIZE1 + 6);
//                StdDraw.setYscale(0,SIZE1 + 6);
//
//                switch (SIZE1) {
//                    case 13:
//                        StdDraw.picture((SIZE1 + 1) / 2, (SIZE1 + 1) / 2, "qipan(2).png", (SIZE1 + 1), (SIZE1 + 1));
//                        break;
//                    case 15:
//                        StdDraw.picture((SIZE1 + 1) / 2, (SIZE1 + 1) / 2, "qipan(1).png", (SIZE1 + 1), (SIZE1 + 1));
//                        break;
//                    case 17:
//                        StdDraw.picture((SIZE1 + 1) / 2, (SIZE1 + 1) / 2, "qipan.png", (SIZE1 + 1), (SIZE1 + 1));
//                        break;
//                }
//
//                StdDraw.setPenColor(StdDraw.ORANGE);
//                StdDraw.filledRectangle(SIZE1-12, SIZE1+3, 0.2*20, 0.03*20);
//                StdDraw.filledRectangle(SIZE1-12, SIZE1+5,0.2*20, 0.03*20);
//                StdDraw.filledRectangle(SIZE1+1, SIZE1+5,0.2*20, 0.03*20);
//                StdDraw.filledRectangle(SIZE1+3.5, SIZE1-4, 0.1*20, 0.03*20);
//                StdDraw.setPenColor(StdDraw.BLACK);
//                StdDraw.text(SIZE1-12, SIZE1+3, "Undo");
//                StdDraw.text(SIZE1-12, SIZE1+5, "save");
//                StdDraw.text(SIZE1+1, SIZE1+5, "load");
//                StdDraw.text(SIZE1+3.5, SIZE1-4, "timer");
//
//                drawChess();
//
//                StdDraw.setPenColor(Color.WHITE);
//                StdDraw.filledRectangle(SIZE1+3.1,SIZE1-2.2,1.1,0.5);
//                StdDraw.setPenColor(Color.BLACK);
//                StdDraw.text(SIZE1+3.1,SIZE1-2.2,    mm + ":" + ss);
//
//                playWithPerson();
//
//            } catch (InterruptedException | FileNotFoundException e) {
//                e.printStackTrace();
//            }
//        }
//    }


    //鼠标监听
    public boolean isMousePressed() throws InterruptedException {
        if (!StdDraw.isMousePressed()) {
            return false;
        } else
            Thread.sleep(100);
        return true;
    }


    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        gomoku gomoku = new gomoku();
        gomoku.show();
    }
}

//class MyTimer {
//    private Calendar c = Calendar.getInstance();
//    private long endtime = c.getTimeInMillis();
//    private Date date = new Date();
//    private long starttime = date.getTime();
//    private long midtime = (endtime - starttime) / 1000;
//    private int time;
//    private double x;
//    private double y;
//
//    private boolean isTimeUp = false;
//
//
//    MyTimer(int time,double x,double y) {
//        this.time = time;
//        this.x = x;
//        this.y = y;
//        c.set(2021, 11, 24, 0, 0, 0);
//    }
//
//    public void timer() {
//        while (time > 0) {
////            if (!StdDraw.isMousePressed()){
//                time--;
//                try {
//                    Thread.sleep(1000);
//                    int hh = time / 60 / 60;
//                    int mm = time / 60 % 60;
//                    int ss = time % 60;
//                    StdDraw.setPenColor(Color.WHITE);
//                    StdDraw.filledRectangle(x+3.1,x-5.2,1.1,0.5);
//                    StdDraw.setPenColor(Color.BLACK);
//                    StdDraw.text(x+3.1, x-5.2,    mm + ":" + ss);
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
////            }else {
////                break;
////            }
//
//        }
//    }
//
//    public int getTime(){
//        return time;
//    }
//
//    public boolean isTimeUp(){
//        if (time <= 0){
//            isTimeUp = true;
//        }
//        return isTimeUp;
//    }
//
////    public void showPerSecond(int SIZE1){
////        while (time > 0){
////            time--;
////            try {
////                Thread.sleep(1000);
////                int hh = time / 60 / 60;
////                int mm = time / 60 % 60;
////                int ss = time % 60;
////
////                StdDraw.clear();
////                StdDraw.setXscale(0,SIZE1 + 6);
////                StdDraw.setYscale(0,SIZE1 + 6);
////
////                switch (SIZE1) {
////                    case 13:
////                        StdDraw.picture((SIZE1 + 1) / 2, (SIZE1 + 1) / 2, "qipan(2).png", (SIZE1 + 1), (SIZE1 + 1));
////                        break;
////                    case 15:
////                        StdDraw.picture((SIZE1 + 1) / 2, (SIZE1 + 1) / 2, "qipan(1).png", (SIZE1 + 1), (SIZE1 + 1));
////                        break;
////                    case 17:
////                        StdDraw.picture((SIZE1 + 1) / 2, (SIZE1 + 1) / 2, "qipan.png", (SIZE1 + 1), (SIZE1 + 1));
////                        break;
////                }
////
////                StdDraw.setPenColor(StdDraw.ORANGE);
////                StdDraw.filledRectangle(SIZE1-12, SIZE1+3, 0.2*20, 0.03*20);
////                StdDraw.filledRectangle(SIZE1-12, SIZE1+5,0.2*20, 0.03*20);
////                StdDraw.filledRectangle(SIZE1+1, SIZE1+5,0.2*20, 0.03*20);
////                StdDraw.filledRectangle(SIZE1+3.5, SIZE1-4, 0.1*20, 0.03*20);
////                StdDraw.setPenColor(StdDraw.BLACK);
////                StdDraw.text(SIZE1-12, SIZE1+3, "Undo");
////                StdDraw.text(SIZE1-12, SIZE1+5, "save");
////                StdDraw.text(SIZE1+1, SIZE1+5, "load");
////                StdDraw.text(SIZE1+3.5, SIZE1-4, "timer");
////
////                drawChess();
////
////                StdDraw.setPenColor(Color.WHITE);
////                StdDraw.filledRectangle(x+3.1,x-5.2,1.1,0.5);
////                StdDraw.setPenColor(Color.BLACK);
////                StdDraw.text(x+3.1, x-5.2,    mm + ":" + ss);
////
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
////        }
////    }
//
//
//}

class Thread1 extends Thread{
    private static gomoku gomoku = new gomoku();
    private int time;
    private double x;
    private double y;



    public Thread1(){
        this.time = time;
        this.x = x;
        this.y = y;
    }

    public void run(){
        try {
            gomoku.show();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



//    {
////        while (time > 0){
////            StdDraw.clear();
////            StdDraw.setXscale(0,gomoku.getSIZE1() + 6);
////            StdDraw.setYscale(0,gomoku.getSIZE1() + 6);
////            StdDraw.picture((gomoku.getSIZE1() + 1)/2,(gomoku.getSIZE1() + 1)/2,"qipan.png",(gomoku.getSIZE1() + 1),(gomoku.getSIZE1() + 1));
////            gomoku.drawChess();
////            StdDraw.setPenColor(StdDraw.ORANGE);
////            StdDraw.filledRectangle(gomoku.getSIZE1()-12, gomoku.getSIZE1()+3, 0.2*20, 0.03*20);
////            StdDraw.filledRectangle(gomoku.getSIZE1()-12, gomoku.getSIZE1()+5,0.2*20, 0.03*20);
////            StdDraw.filledRectangle(gomoku.getSIZE1()+1, gomoku.getSIZE1()+5,0.2*20, 0.03*20);
////            StdDraw.filledRectangle(gomoku.getSIZE1()+3.5, gomoku.getSIZE1()-4, 0.1*20, 0.03*20);
////            StdDraw.setPenColor(StdDraw.BLACK);
////            StdDraw.text(gomoku.getSIZE1()-12, gomoku.getSIZE1()+3, "Undo");
////            StdDraw.text(gomoku.getSIZE1()-12, gomoku.getSIZE1()+5, "save");
////            StdDraw.text(gomoku.getSIZE1()+1, gomoku.getSIZE1()+5, "load");
////            StdDraw.text(gomoku.getSIZE1()+3.5, gomoku.getSIZE1()-4, "timer");
////        while (time > 0) {
////            if (!StdDraw.isMousePressed()){
//            time--;
//            try {
//                Thread.sleep(1000);
//                int hh = time / 60 / 60;
//                int mm = time / 60 % 60;
//                int ss = time % 60;
//                StdDraw.setPenColor(Color.WHITE);
//                StdDraw.filledRectangle(x+3.1,x-5.2,1.1,0.5);
//                StdDraw.setPenColor(Color.BLACK);
//                StdDraw.text(x+3.1, x-5.2,    mm + ":" + ss);
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
////            try {
////                Thread.sleep(1);
////            }catch (InterruptedException e){
////                e.printStackTrace();
////            }
////            }else {
////                break;
////            }
//
////        }
////        }
//
//    }

//    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
//        System.out.println(Thread.currentThread().getName() + "main start");
//        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
//        StdDraw.setXscale(0, gomoku.getSIZE1() + 1);
//        StdDraw.setYscale(0,gomoku.getSIZE1() + 1);
//        StdDraw.setPenColor(StdDraw.WHITE);
//        StdDraw.setFont();
//        StdDraw.picture((gomoku.getSIZE1() +1)/2,(gomoku.getSIZE1() -2)/2,"fengmian.jpg",(gomoku.getSIZE1() + 4),(gomoku.getSIZE1() + 6));
//        //显示封面
//
//        while (true) {
//            if ((StdDraw.mouseX() >= 0.75 * (gomoku.getSIZE1() + 1)) && (StdDraw.isMousePressed()) && (StdDraw.mouseX() <= 0.95 * (gomoku.getSIZE1() + 1)) && (StdDraw.mouseY() <= 0.75 * (gomoku.getSIZE1() + 1)) && (StdDraw.mouseY() >= 0.6 * (gomoku.getSIZE1() + 1))) {
//                StdDraw.clear();
//                StdDraw.picture((gomoku.getSIZE1() +2)/2,(gomoku.getSIZE1() -1)/2,"chicun.jpg",(gomoku.getSIZE1() + 7),(gomoku.getSIZE1() + 8));
//                while (true){
//                    if ((StdDraw.mouseX() >= 0.1*(gomoku.getSIZE1() + 1)) && (StdDraw.isMousePressed()) && (StdDraw.mouseX() <= 0.4*(gomoku.getSIZE1() + 1)) && (StdDraw.mouseY() <= 0.3*(gomoku.getSIZE1() + 1)) && (StdDraw.mouseY() >= 0.0*(gomoku.getSIZE1() + 1))) {
//
//                        StdDraw.clear();
//                        StdDraw.setXscale(0,gomoku.getSIZE1() + 6);
//                        StdDraw.setYscale(0,gomoku.getSIZE1() + 6);
//                        StdDraw.picture((gomoku.getSIZE1() + 1)/2,(gomoku.getSIZE1() + 1)/2,"qipan.png",(gomoku.getSIZE1() + 1),(gomoku.getSIZE1() + 1));
//                        StdDraw.setPenColor(StdDraw.ORANGE);
//                        StdDraw.filledRectangle(gomoku.getSIZE1()-12, gomoku.getSIZE1()+3, 0.2*20, 0.03*20);
//                        StdDraw.filledRectangle(gomoku.getSIZE1()-12, gomoku.getSIZE1()+5,0.2*20, 0.03*20);
//                        StdDraw.filledRectangle(gomoku.getSIZE1()+1, gomoku.getSIZE1()+5,0.2*20, 0.03*20);
//                        StdDraw.filledRectangle(gomoku.getSIZE1()+3.5, gomoku.getSIZE1()-4, 0.1*20, 0.03*20);
//                        StdDraw.setPenColor(StdDraw.BLACK);
//                        StdDraw.text(gomoku.getSIZE1()-12, gomoku.getSIZE1()+3, "Undo");
//                        StdDraw.text(gomoku.getSIZE1()-12, gomoku.getSIZE1()+5, "save");
//                        StdDraw.text(gomoku.getSIZE1()+1, gomoku.getSIZE1()+5, "load");
//                        StdDraw.text(gomoku.getSIZE1()+3.5, gomoku.getSIZE1()-4, "timer");
//                        break;
//                    }
//
//                }
//                Thread1 mth1 = new Thread1(300, gomoku.getSIZE1(), gomoku.getSIZE1() + 3);
//                mth1.start();
//                int time = 300;
//                try {
//                    while (time > 0){
//                        mth1.join();
//                        time--;
//                        if (gomoku.isMousePressed()){
//                            gomoku.playWithPerson();
//                        }
//                    }
//
//
//                }catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//
//
//
//
//
//
//
//
//
////                Thread1 mth2 = new Thread1(30, gomoku.getSIZE1(), gomoku.getSIZE1() + 4);
////                mth2.start();
////                try {
////                    mth2.join();
////                }catch (InterruptedException e){
////                    e.printStackTrace();
////                }
//                int i = 0;
//                i++;
//                StdDraw.text(gomoku.getSIZE1()+i, gomoku.getSIZE1()-4, "!!!!!!");
//            }
//            //进入pvp
//
//        }
//
//    }
}

class MyTimer extends Thread{

    public static int time;
    private int blackTime = 30;
    private int whiteTime = 30;
    private int totalTime = 600;
    private boolean p = true;
    private gomoku gomoku = new gomoku();
    private Thread t;
    public static  int refresh=500;

    MyTimer(){

    }

    public void run() {
        JFrame a = new JFrame();//窗口
        a.setSize(300, 250);
        JPanel b = new JPanel();//容器
        b.setSize(300, 250);
        b.setLayout(null);

        JLabel jl=new JLabel();//标签
        jl.setFont(new Font("宋体",Font.BOLD,20));
        jl.setBounds(0,0,300,50);
        b.add(jl);

        JLabel jl1 = new JLabel();//标签
        jl1.setFont(new Font("宋体", Font.BOLD, 20));
        jl1.setBounds(0, 50, 300, 50);
        b.add(jl1);


        JLabel jl2 = new JLabel();//标签
        jl2.setFont(new Font("宋体", Font.BOLD, 20));
        jl2.setBounds(0, 100, 300, 50);
        b.add(jl2);

        jl1.setText("Black:" + blackTime / 60 % 60 + " min " + blackTime % 60 + "s");
        jl2.setText("White:" + whiteTime / 60 % 60 + " min " + whiteTime % 60 + "s");

        a.add(b);
        a.setLocation(550, 190);//设置窗口居中
        a.setVisible(true);

        while (p){

            totalTime--;

            if (gomoku.getChess() % 2 == 1) {
                blackTime--;
            } else {
                whiteTime--;
            }

            if (blackTime < 0) {
                jl1.setText("White win!");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                p = false;
                a.setVisible(false);
            }

            if (whiteTime < 0) {
                jl2.setText("Black win!");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                p = false;
                a.setVisible(false);
            }

            if (totalTime < 0) {
                jl.setText("time out!");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            p = false;
            a.setVisible(false);
        }

        a.dispose();
    }

    public void start () {
        if (t == null) {
            t = new Thread (this, String.valueOf(totalTime));
            t.start ();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyTimer a=new MyTimer();

        a.run();

    }
}

