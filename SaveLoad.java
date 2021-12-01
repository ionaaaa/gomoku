public class SaveLoad {
    private String[][] boardFile = new String[Board.SIZE][Board.SIZE];
    private Tool tool;


    public void save(Board board){
        for (int i = 0; i < boardFile.length; i++){
            for (int j = 0; j < boardFile[0].length; j++){
                if (board.getBoard()[i][j] == Tool.BLACK){
                    boardFile[i][j] = "1";
                }
                else if (board.getBoard()[i][j] == Tool.WHITE){
                    boardFile[i][j] = "2";
                }
                if (board.getBoard()[i][j] == Tool.EMPTY){
                    boardFile[i][j] = "0";
                }
            }
        }
    }

    public Tool[][] load(String[][] file){
        Tool[][] board = new Tool[Board.SIZE][Board.SIZE];
        for (int i = 0; i < boardFile.length; i++){
            for (int j = 0; j < boardFile[0].length; j++){
                if (file[i][j] == "1"){
                    board[i][j] = Tool.BLACK;
                }
                else if (file[i][j] == "2"){
                    board[i][j] = Tool.WHITE;
                }
                else if (file[i][j] == "0"){
                    board[i][j] = Tool.EMPTY;
                }
            }
        }
        return board;
    }

}

//只有运行机制，不知道读文件那个放哪
