package XWatchShop.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import XWatchShop.DTO.CartDTO;
import XWatchShop.Entity.Bills;

@Service
public interface IBillService {
	public int AddBill(Bills bill);
	public void AddBillDetails(String userID, HashMap<String, CartDTO> cart);
}
