package mybatis;

import org.apache.ibatis.annotations.*;

public interface MovieMapper{
    @Select("select * from Movie")
	String selectMovie();	
	
	@Select("select * from Movie where id =#{id}")
	String selectMovieId(int id);	

	@Select("select * from Movie where rate >=#{rate}")
	String selectMovieRate(double rate);	
}
