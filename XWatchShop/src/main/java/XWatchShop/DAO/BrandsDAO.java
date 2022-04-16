package XWatchShop.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import XWatchShop.Entity.Brands;
import XWatchShop.Entity.MapperBrands;
import XWatchShop.Entity.MapperSeries;
import XWatchShop.Entity.Series;

@Repository
public class BrandsDAO extends BaseDAO{
	public List<Brands> GetDataBrands(){
		String sql ="SELECT * FROM brands";
		List<Brands> list = new ArrayList<Brands>(); 
		list = jdbcTemplate.query(sql, new MapperBrands());
		return list;
	}
	public List<Series> GetSeries() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM series ");
		List<Series> listSeries = jdbcTemplate.query(sql.toString(), new MapperSeries());
		return listSeries;
	}
}