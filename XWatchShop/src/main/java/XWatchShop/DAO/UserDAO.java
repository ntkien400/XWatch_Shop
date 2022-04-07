package XWatchShop.DAO;

import org.springframework.stereotype.Repository;

import XWatchShop.Entity.MapperUsers;
import XWatchShop.Entity.Users;

@Repository
public class UserDAO extends BaseDAO {
	public int AddUser(Users user) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO users ");
		sql.append("( userID ");
		sql.append(", password ");
		sql.append(", role ");
		sql.append(", first_name ");
		sql.append(", last_name ");
		sql.append(", address ");
		sql.append(", phone_number )");
		sql.append("VALUES ");
		sql.append("( '" + user.getUserID() + "' ");
		sql.append(", '" + user.getPassword() + "' ");
		sql.append(", " + user.isRole() + " ");
		sql.append(", '" + user.getFirst_name() + "' ");
		sql.append(", '" + user.getLast_name() + "' ");
		sql.append(", '" + user.getAddress() + "' ");
		sql.append(", '" + user.getPhone_number() + "' )");
		
		int insert = jdbcTemplate.update(sql.toString());
		return insert;
	}
	public Users GetUserByAcc(Users user) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM users ");
		sql.append(" WHERE ");
		sql.append(" userID = '");
		sql.append( user.getUserID()+"'");
		Users result = jdbcTemplate.queryForObject(sql.toString(), new MapperUsers());
		return result;
	}
}
