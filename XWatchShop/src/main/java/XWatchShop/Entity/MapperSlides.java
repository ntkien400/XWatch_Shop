package XWatchShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperSlides implements RowMapper<Slides>{

	@Override
	public Slides mapRow(ResultSet rs, int rowNum) throws SQLException {
		Slides slide = new Slides();
		slide.setId(rs.getInt("id"));
		slide.setImage(rs.getString("image"));
		return slide;
	}

}
