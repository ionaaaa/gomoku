import java.util.Calendar;
import java.util.Date;

public class MyTimer {
    private Calendar c = Calendar.getInstance();
    private long endtime = c.getTimeInMillis();
    private Date date = new Date();
    private long starttime = date.getTime();
    private long midtime = (endtime - starttime) / 1000;
    private int time;

    MyTimer(int time){
        this.time = time;
        c.set(2021, 11, 24, 0, 0, 0);
    }

    public void timer(){
        while (time > 0){
            time--;
            try {
                Thread.sleep(1000);
                int hh = time / 60 / 60;
                int mm = time / 60 % 60;
                int ss = time % 60;
                System.out.println(hh + ":" + mm + ":" + ss);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer(60);
        myTimer.timer();
    }


}
