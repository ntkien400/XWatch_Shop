package XWatchShop.Service.User;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import XWatchShop.DAO.UserDAO;
import XWatchShop.Entity.Users;
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserDAO userDAO = new UserDAO();
	@Override
	public int AddUser(Users user) {
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(5)));
		return userDAO.AddUser(user);
	}
	@Override
	public Users CheckAccount(Users user) {
		String pass = user.getPassword();
		user = userDAO.GetUserByAcc(user);
		if(user != null) {
			if(BCrypt.checkpw(pass, user.getPassword())) {
				return user;
			}
			else {
				return null;
			}
		}
		return null;
	}

}
