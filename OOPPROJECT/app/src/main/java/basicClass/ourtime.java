package basicClass;

/**
 * Created by liuxizhen on 2017/6/9.
 */


public class ourtime {
    private int hour;
    private int minute;
    private int today_minute;

    public void settoday_minute(){
        today_minute=60*hour+minute;
    }

    public String getinfo() {
        return hour + ":" + minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
        this.settoday_minute();
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
        this.settoday_minute();}

    public boolean refunding(ourtime realtime) {

        if (  this.today_minute-realtime.today_minute > 20)
            return true;
        else
            return false;

    }
    public static void main(String[] args) {
        ourtime t1=new ourtime();
        t1.setHour(9);
        t1.setMinute(40);

        ourtime t2=new ourtime();
        t2.setHour(10);
        t2.setMinute(1);

        System.out.println(t1.today_minute);
        System.out.println(t2.today_minute);
        System.out.println(t1.refunding(t2));
        System.out.println(t2.refunding(t1));

    }

}
