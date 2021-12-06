public class Gomoku19 {
    private int x = (int) (StdDraw.mouseX() / 0.05) + 1;
    private int y = (int) (StdDraw.mouseY() / 0.05) + 1;

    private Tool[][] board = new Tool[19][19];
    private boolean canPlay = true;
    private Tool playerOnTurn;
    private Tool player1 = Tool.BLACK;
    private Tool player2 = Tool.WHITE;

    private int[] chessX = new int[255];
    private int[] chessY = new int[255];
    private int countX = 0;
    private int countY = 0;

    private int wholeGameTime = 600;
    private int blackTime = 30;
    private int whiteTime = 30;
    //计时器



    public Gomoku19(){
        playerOnTurn = player1;
    }
    //constructor



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
    //画棋盘+棋子

    public void showChess(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == Tool.BLACK) {
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledCircle(x * 0.05, y * 0.05, 0.015);
                }
                if (board[i][j] == Tool.WHITE) {
                    StdDraw.setPenColor(StdDraw.CYAN);
                    StdDraw.filledCircle(x * 0.05, y * 0.05, 0.015);
                }
            }
        }
    }



    public void mousePressed(boolean p){
        if(canPlay){
            if (board[x][y] == Tool.EMPTY){
                chessX[countX++] = x;
                chessY[countY++] = y;
                if (playerOnTurn == player1){
                    board[x][y] = player1;
                    playerOnTurn = player2;
                }
                else {
                    board[x][y] = player2;
                    playerOnTurn = player1;
                }
                showChess();

                if (isGameWon()){
                    showGameResult();
                    canPlay = false;
                }
            }
        }
    }

    public void showGameResult(){
        if (isGameWon()){
            //显示的语句
        }
        else if (isFull()){
            //显示的语句
        }
        //加一个显示错误信息
    }

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

    public static void main(String[] args) {
        Gomoku19 gomoku19 = new Gomoku19();
        gomoku19.show();
    }

}
