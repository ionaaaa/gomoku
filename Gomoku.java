public class Gomoku {
    private Tool playerOnTurn, player1, player2;
    private Board board = new Board();
    private Tool[] ChessX = new Tool[Board.SIZE];
    private Tool[] ChessY = new Tool[Board.SIZE];
    //此处加一个写入，board加了一个不知道这里要不要

    private void randomFirstPlayer(){
        player1 = Tool.BLACK;
        player2 = Tool.WHITE;
        playerOnTurn = player1;
    }
    //动作，开局初始化

    private Tool oppositePlayer(){
        if (playerOnTurn == player1){
            playerOnTurn = player2;
        }else playerOnTurn = player1;
        return playerOnTurn;
    }
    //动作，换玩家

    private void showGameResult(){
        if (board.isGameWon()){
            //显示
        }
        else if (board.isFull()){
            //显示
        }
        //加一个显示错误信息
    }

    private Move getAValidMove(){
        Move move = null;
        while (true){
            try {
                move = new Move(2,2);
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

    private Move getAMove(){
        Move move = null;

        if (playerOnTurn == player1){
            move = getAValidMove();
        }
        else move = getAValidMove();

        return move;
    }
    //动作，得到玩家的棋子
}

