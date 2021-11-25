class Chess{
    private int blackwhite; //odd is black
    private int x;
    private int y;
    int count;

    Chess(){
        count = 1;
        count ++;
        blackwhite = count % 2;
    }

    Chess(int x, int y){
        count = 1;
        count ++;
        blackwhite = count % 2;
        this.x = x;
        this.y = y;
    }
    //constructors

    public int getBlackwhite(){
        return blackwhite;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

}




