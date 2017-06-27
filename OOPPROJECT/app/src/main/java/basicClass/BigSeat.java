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
        public BigSeat(String seatid,String row,int seatNum, Boolean occupied,String region){
            this.seatid=seatid;
            this.row=row;
            this.seatNum=seatNum;
            this.occupied=occupied;
            this.region=region;
        }

    }


