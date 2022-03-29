package XWatchShop.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import XWatchShop.Entity.MapperBrands;
import XWatchShop.Entity.MapperMenus;
import XWatchShop.Entity.Menus;

@Repository
public class MenusDAO extends BaseDAO{
	public List<Menus> GetDataMenus(){
		String sql ="SELECT * FROM menus";
		List<Menus> list = new ArrayList<Menus>(); 
		list = jdbcTemplate.query(sql, new MapperMenus());
		return list;
	}
}
