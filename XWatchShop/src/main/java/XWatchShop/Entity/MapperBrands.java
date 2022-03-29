package XWatchShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperBrands implements RowMapper<Brands>{

	@Override
	public Brands mapRow(ResultSet rs, int rowNum) throws SQLException {
		Brands brands = new Brands();
		brands.setBrandID(rs.getInt("brandID"));
		brands.setBrandname(rs.getString("brandname"));
		return brands;
	}

}
