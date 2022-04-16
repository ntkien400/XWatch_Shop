package XWatchShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperSeries implements RowMapper<Series> {

	@Override
	public Series mapRow(ResultSet rs, int rowNum) throws SQLException {
		Series series = new Series();
		series.setSeriesID(rs.getInt("seriesID"));
		series.setBrandID(rs.getInt("brandID"));
		series.setSeriesname(rs.getString("seriesname"));
		return series;
	}
	
}
