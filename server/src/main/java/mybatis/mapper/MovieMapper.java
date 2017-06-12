package mybatis;

public interface MovieMapper{
	@Select("select * from Movie")
	Movie selectMovie();	
	
	@Select("select * from Movie where id =#{id}")
	Movie selectMovieId(int id);	

	@Select("select * from Movie where rate >=#{rate}")
	Movie selectMovieRate(double rate);	
}
