public class Board {
    public static final int SIZE = 11;
    //要加别的size
    private Tool[][] board = new Tool[SIZE][SIZE];

    public boolean isGameWon() {
        final Tool[][] b = board;
        //暂时不知道咋遍历
        return true;
    }
    //判断状态，有没有出现赢的情况

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
