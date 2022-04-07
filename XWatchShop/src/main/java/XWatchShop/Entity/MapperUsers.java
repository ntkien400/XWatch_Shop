package XWatchShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperUsers implements RowMapper<Users> {

	@Override
	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		Users user = new Users();
		user.setUserID(rs.getString("userID"));
		user.setPassword(rs.getString("password"));
		user.setRole(rs.getBoolean("role"));
		user.setFirst_name(rs.getString("first_name"));
		user.setLast_name(rs.getString("last_name"));
		user.setAddress(rs.getString("address"));
		user.setPhone_number(rs.getString("phone_number"));
		return user;
	}

}
