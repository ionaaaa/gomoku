import java.util.Calendar;
import java.util.Date;

public class MyTimer {
    public static void main(String[] args) {
        Calendar c;
        c = Calendar.getInstance();
        c.set(2021, 11, 24, 0, 0, 0);
        long endtime = c.getTimeInMillis();
        Date date = new Date();
        long starttime = date.getTime();
        long midtime = (endtime - starttime) / 1000;
        // basic settings


        time(60);
        time(600);

    }

    private static void time(int time){
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
}
