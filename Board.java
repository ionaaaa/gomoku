public class Board {
    public static final int SIZE = 11;
    //要加别的size
    private Tool[][] board = new Tool[SIZE][SIZE];
    int x = (int)(StdDraw.mouseX());
    int y = (int)(StdDraw.mouseY());
    //瞎写的，要写具体换算关系

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

    //做33禁

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
        return board[r - 1][c - 1] == Tool.EMPTY;
    }
    //判断动作状态，这一步能不能下

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
}

//针对棋盘状态的类，有状态，有动作
