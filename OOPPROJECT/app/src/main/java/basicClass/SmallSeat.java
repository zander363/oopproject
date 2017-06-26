package basicClass;

/**
 * Created by 132 on 2017/6/24.
 */

public class SmallSeat extends Seat{
    public String seatid;
    public String row;
    public int seatNum ;
    public Boolean occupied;

    public String getSeatid() {
        return seatid;
    }

    public void setSeatid(String seatid) {
        this.seatid = seatid;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public Boolean getOccupied() {
        return occupied;
    }

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }

    public SmallSeat(){

        seatid="";
        row="";
        seatNum=0;
        occupied=null;


    }
    public SmallSeat(String a,String b,int c, Boolean d){
        seatid=a;
        row=b;
        seatNum=c;
        occupied=d;
    }

}
