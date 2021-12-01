public class Gomoku {
    private Tool playerOnTurn, player1, player2;
    private Board board = new Board();
    private Tool[] ChessX = new Tool[Board.SIZE];
    private Tool[] ChessY = new Tool[Board.SIZE];
    //undo
    //此处还加一个鼠标写入，board加了一个不知道这里要不要

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
            //显示的语句
        }
        else if (board.isFull()){
            //显示的语句
        }
        //加一个显示错误信息
    }

    private Move getAValidMove(Tool tool){
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

    private Move getAMove(){
        Move move = null;

        if (playerOnTurn == player1){
            move = getAValidMove(player1);
        }
        else move = getAValidMove(player2);

        return move;
    }
    //动作，得到玩家的棋子



    private void play(){

    }
}

