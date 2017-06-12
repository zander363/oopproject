package basicClass;

/**
 * Created by liuxizhen on 2017/6/9.
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class ourtime {
    private int hour;
    private int minute;
    private int total_minute;

    public ourtime(){
        hour = Integer.parseInt(new SimpleDateFormat("HH").format(new Date()));
        minute = Integer.parseInt(new SimpleDateFormat("mm").format(new Date()));
        settoday_minute();
    }

    public ourtime(int hour, int minute){
        this.hour = hour;
        this.minute = minute;
        settoday_minute();
    }

    public void settoday_minute(){
        total_minute=60*hour+minute;
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

    public boolean refunding() {
        ourtime now = new ourtime();
        if (this.total_minute-now.total_minute > 20)
            return true;
        else
            return false;

    }
}