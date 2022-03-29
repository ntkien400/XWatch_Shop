package XWatchShop.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import XWatchShop.Entity.MapperSlides;
import XWatchShop.Entity.Slides;

@Repository
public class SlidesDAO extends BaseDAO{
	public List<Slides> GetDataSlide(){
		String sql ="SELECT * FROM slides";
		List<Slides> list = new ArrayList<Slides>(); 
		list = jdbcTemplate.query(sql, new MapperSlides());
		return list;
	}
}
