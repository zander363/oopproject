package basicClass;

/**
 * Created by 132 on 2017/6/24.
 */

public class BigSeat extends Seat{
        public String seatid;
        public String row;
        public int seatNum ;
        public Boolean occupied;
        public String region;
        public BigSeat(){
            seatid="";
            row="";
            seatNum=0;
            occupied=null;
            region="";

        }
        public BigSeat(String a,String b,int c, Boolean d,String e){
            seatid=a;
            row=b;
            seatNum=c;
            occupied=d;
            region=e;
        }

    }


