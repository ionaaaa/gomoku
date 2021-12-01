public class Move {
    private int row, column;
    Tool tool;

    public Move(int row, int column, Tool tool) throws IllegalAccessException {
        if (row < 1 || Board.SIZE < row || column < 1 || Board.SIZE < column){
            throw new IllegalAccessException();
        }
        this.row = row;
        this.column = column;
    }

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return column;
    }

    public Tool getTool(){
        return tool;
    }

    //针对下棋这个动作设的类，新建的是动作
}
