public class GameController {
    public boolean isMousePressed() throws InterruptedException {
        if (!StdDraw.isMousePressed()) {
            return false;
        } else
            Thread.sleep(90);
        return StdDraw.isMousePressed();
    }
}
