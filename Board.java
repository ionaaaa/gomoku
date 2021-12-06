public class Board {
    public static final int SIZE = 19;
    //要加别的size
    private Tool[][] board = new Tool[SIZE][SIZE];
    private int x = (int) (StdDraw.mouseX() / 0.05);
    private int y = (int) (StdDraw.mouseY() / 0.05);
    private Gomoku gomoku;


    public int checkCount(int xChange, int yChange, Tool tool){
        int count = 1;
        int tempx = xChange;
        int tempy = yChange;
        //移动的格子数的初始值

        while (x + xChange > 1 && x + xChange < Board.SIZE && y + yChange > 1 && y + yChange < Board.SIZE && tool == board[x + xChange][y + yChange]){
            count ++;
            if (xChange == 1 && yChange == 0){
                xChange++;
            }
            else if (xChange == 0 && yChange == 1){
                yChange++;
            }
            else if (xChange == 1 && yChange == 1){
                xChange++;
                yChange++;
            }
            else if (xChange == 1 && yChange == -1){
                xChange++;
                yChange--;
            }
        }
        //四个方向，向正方向判断

        xChange = tempx;
        yChange = tempy;
        //回复初始值

        while (x + xChange > 1 && x + xChange < Board.SIZE && y + yChange > 1 && y + yChange < Board.SIZE && tool == board[x - xChange][y - yChange]){
            count ++;
            if (xChange == 1 && yChange == 0){
                xChange++;
            }
            else if (xChange == 0 && yChange == 1){
                yChange++;
            }
            else if (xChange == 1 && yChange == 1){
                xChange++;
                yChange++;
            }
            else if (xChange == 1 && yChange == -1){
                xChange++;
                yChange--;
            }
        }
        //向负方向判断
        return count;
    }
    //判断状态，几个棋子连起来
    //只有这4种填数的方法！！！

    public boolean isGameWon() {
        final Tool[][] b = board;
        boolean win = false;
        int[] countInFourDirections = new int[4];
        Tool toolInTheGrid = board[x][y];
        countInFourDirections[0] = checkCount(1,0,toolInTheGrid);
        countInFourDirections[1] = checkCount(0,1,toolInTheGrid);
        countInFourDirections[2] = checkCount(1,1,toolInTheGrid);
        countInFourDirections[3] = checkCount(1,-1,toolInTheGrid);
        if (countInFourDirections[0] >= 5 || countInFourDirections[1] >= 5
                || countInFourDirections[2] >= 5 || countInFourDirections[3] >= 5){
            win = true;
        }
        return win;
    }
    //判断状态，有没有出现赢的情况

    public boolean is33Ban(){
        final Tool[][] b = board;
        boolean ban = false;
        int[] countInFourDirections = new int[4];
        Tool toolInTheGrid = board[x][y];
        countInFourDirections[0] = checkCount(1,0,toolInTheGrid);
        countInFourDirections[1] = checkCount(0,1,toolInTheGrid);
        countInFourDirections[2] = checkCount(1,1,toolInTheGrid);
        countInFourDirections[3] = checkCount(1,-1,toolInTheGrid);
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
    //33禁，是连三，不知道做不做跳三


    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == Tool.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
    //判断状态，棋盘有没有满

    public boolean isValid(Move move) {
        int r = move.getRow();
        int c = move.getColumn();
        boolean valid = false;
        if (board[r - 1][c - 1] == Tool.EMPTY){
            if (move.getTool() == Tool.WHITE){
                valid = true;
            }
            else if (move.getTool() == Tool.BLACK){
                if (!is33Ban()){
                    valid = true;
                }
            }
        }
        return valid;
    }
    //判断动作状态，这一步能不能下(包含33禁)

    public void handleMove(Move move, Tool player) {
        int r = move.getRow();
        int c = move.getColumn();

        board[r - 1][c - 1] = player;
        //动作，指定的格子当局玩家下了什么子
    }

    public void clear() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = Tool.EMPTY;
            }
        }
    }

    public void show(){
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        StdDraw.filledRectangle(0.70, 0.750, 0.25, 0.06);
        StdDraw.filledRectangle(0.70, 0.550, 0.25, 0.06);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.setFont();
        StdDraw.text(0.70, 0.750, "Play With People ");
        StdDraw.text(0.70, 0.550, "Exit");

        while (true) {
            if ((StdDraw.mouseX() >= 0.60) && (StdDraw.isMousePressed()) && (StdDraw.mouseX() <= 0.90) && (StdDraw.mouseY() <= 0.90) && (StdDraw.mouseY() >= 0.60)) {
                StdDraw.setPenColor(StdDraw.ORANGE);
                StdDraw.filledRectangle(0.50, 0.50, 0.5, 0.50);
                StdDraw.setPenColor(StdDraw.BLACK);
                for (double i = 0.05; i < 1; i += 0.05) {
                    StdDraw.line(i, 1, i, 0);
                    StdDraw.line(1, i, 0, i);
                }

                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledCircle(0.50, 0.85, 0.005);
                StdDraw.filledCircle(0.15, 0.85, 0.005);
                StdDraw.filledCircle(0.85, 0.15, 0.005);
                StdDraw.filledCircle(0.50, 0.15, 0.005);
                StdDraw.filledCircle(0.15, 0.15, 0.005);
                StdDraw.filledCircle(0.85, 0.85, 0.005);
                StdDraw.filledCircle(0.50, 0.50, 0.005);
                StdDraw.filledCircle(0.15, 0.50, 0.005);
                StdDraw.filledCircle(0.85, 0.50, 0.005);
                StdDraw.setPenColor(StdDraw.BLACK);
                break;
            }
        }
    }
    //画棋盘

    public Tool[][] getBoard(){
        return board;
    }
    //返回棋盘信息，不知道会不会返回空的

    public void drawChess(Tool tool){
        for (int i = 0; i < Board.SIZE; i++) {
            for (int j = 0; j < Board.SIZE; j++) {
                if (tool == Tool.BLACK) {
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledCircle(x * 0.05, y * 0.05, 0.015);
                }
                if (tool == Tool.WHITE) {
                    StdDraw.setPenColor(StdDraw.CYAN);
                    StdDraw.filledCircle(x * 0.05, y * 0.05, 0.015);
                }
            }
        }
    }
    //画棋子

    public static boolean isMousePressed() throws InterruptedException {
        if (!StdDraw.isMousePressed()) {
            return false;
        } else
            Thread.sleep(90);
        return StdDraw.isMousePressed();
    }



}

//针对棋盘状态的类，有状态，有动作
