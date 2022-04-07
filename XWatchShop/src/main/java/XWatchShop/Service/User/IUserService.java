package XWatchShop.Service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import XWatchShop.Entity.Users;

@Service
public interface IUserService {
	public int AddUser(Users user);
	public Users CheckAccount(Users user);
}
