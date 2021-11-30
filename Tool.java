public enum Tool {

    BLACK, WHITE, EMPTY;

    private static String[] SHOW_AS = {"BLACK", "WHITE", "EMPTY"};

    public String toString(){
        return SHOW_AS[ordinal()];
    }
}
