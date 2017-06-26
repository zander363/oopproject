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
        settotal_minute();
    }

    public ourtime(int hour, int minute){
        this.hour = hour;
        this.minute = minute;
        settotal_minute();
    }

    public ourtime(String a){
        String[] b=a.split("：");
        hour=Integer.parseInt(b[0]);
        minute=Integer.parseInt(b[1]);
        settotal_minute();
    }

    public void settotal_minute(){
        total_minute=60*hour+minute;
    }

    public boolean isearlierto(ourtime x){
        if(this.total_minute>x.total_minute)return false;
        else return true;

    }

    public String getinfo() {
        String hour= String.valueOf(this.hour);
        String minute=String.valueOf(this.minute);
        if(this.hour/10==0)
            hour="0"+this.hour;
        if(this.minute/10==0)
            minute="0"+this.minute;

        return hour + ":" + minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
        this.settotal_minute();
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
        this.settotal_minute();}

    public boolean refunding() {
        ourtime now = new ourtime();
        if (this.total_minute-now.total_minute > 20)
            return true;
        else
            return false;

    }
}