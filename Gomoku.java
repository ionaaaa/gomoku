public class Gomoku {
    private Tool playerOnTurn, player1, player2;
    private int x = (int) (StdDraw.mouseX() / 0.05) + 1;
    private int y = (int) (StdDraw.mouseY() / 0.05) + 1;
    //对应数组，应该要再看看
    private Board board = new Board();
    private Tool[] ChessX = new Tool[255];
    private Tool[] ChessY = new Tool[255];
    private int countX, countY;
    //undo
    private boolean isBlack = true;
    private boolean canPlay = true;

    private int wholeGameTime = 600;
    private int blackTime = 30;
    private int whiteTime = 30;
    //计时器

    public void randomFirstPlayer(){
        player1 = Tool.BLACK;
        player2 = Tool.WHITE;
        playerOnTurn = player1;
    }
    //动作，开局初始化

    public Tool oppositePlayer(){
        if (playerOnTurn == player1){
            playerOnTurn = player2;
        }else playerOnTurn = player1;
        return playerOnTurn;
    }
    //动作，换玩家

    public void showGameResult(){
        if (board.isGameWon()){
            //显示的语句
        }
        else if (board.isFull()){
            //显示的语句
        }
        //加一个显示错误信息
    }

    public Move getAValidMove(Tool tool){
        Move move = null;
        while (true){
            try {
                move = new Move(2,2, tool);
                //瞎搞的数据，要换成写入

                if (board.isValid(move)){
                    return move;
                }
            }
            catch (Exception e){
                //不给放
            }
        }
    }
    //动作，让玩家放valid棋子

    public Move getAMove(){
        Move move = null;

        if (playerOnTurn == player1){
            move = getAValidMove(player1);
        }
        else move = getAValidMove(player2);

        return move;
    }
    //动作，得到玩家的棋子




    public void play(){
        board.show();
        //从这里
    }
}

