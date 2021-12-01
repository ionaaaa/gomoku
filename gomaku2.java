
public class gomaku2 {
    public static boolean isMousePressed() throws InterruptedException {
        if (!StdDraw.isMousePressed()) {
            return false;
        }
        else
            Thread.sleep(90);
        return StdDraw.isMousePressed();
    }
    public static void main(String[] args) throws InterruptedException {
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


        while (true) {
            if ((StdDraw.mouseX() % 0.05 <= 0.03) && (StdDraw.mouseY() % 0.05 <= 0.03)
                    && (StdDraw.mouseX() > 0.04) && (StdDraw.mouseY() > 0.04)
                    && (StdDraw.mouseX() < 0.96) && (StdDraw.mouseY() < 0.96)) {
                int x = 0;
                int y = 0;
                x = (int) (StdDraw.mouseX() / 0.05);
                y = (int) (StdDraw.mouseY() / 0.05);
                int i = 0;
                while(isMousePressed()){
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledCircle(x * 0.05, y * 0.05, 0.015);
                    i++;
                }
                if(i==1){
                    StdDraw.setPenColor(StdDraw.CYAN);
                    StdDraw.filledCircle(x * 0.05, y * 0.05, 0.015);
                }
//                while (isMousePressed()) {
//                    i++;
//                    System.out.println(i);
//                    if (i % 2 == 0) {
//                        StdDraw.setPenColor(StdDraw.BLACK);
//                    } else {
//                        StdDraw.setPenColor(StdDraw.CYAN);
//                    }
//                    StdDraw.filledCircle(x * 0.05, y * 0.05, 0.015);
//                }
            }
        }
    }
}
