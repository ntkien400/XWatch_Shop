package XWatchShop.Service.User;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import XWatchShop.DAO.BillsDAO;
import XWatchShop.DTO.CartDTO;
import XWatchShop.Entity.BillDetails;
import XWatchShop.Entity.Bills;
import XWatchShop.Entity.MapperUsers;
@Service
public class BillServiceImpl implements IBillService {
	@Autowired
	private BillsDAO billsDAO = new BillsDAO();

	@Override
	public int AddBill(Bills bill) {
		return billsDAO.AddBill(bill);
	}

	@Override
	public void AddBillDetails(String userId, HashMap<String, CartDTO> cart) {
		int billID = billsDAO.GetIDBillByUser(userId);
		for(Map.Entry<String, CartDTO> itemCart : cart.entrySet()) {
			BillDetails billDetails = new BillDetails();
			billDetails.setBillID(billID);
			billDetails.setProductID(itemCart.getValue().getProduct().getProductID());
			billDetails.setQuantity(itemCart.getValue().getQuantity());
			billDetails.setTotal(itemCart.getValue().getTotalPrice());
			billsDAO.AddBillDetails(billDetails);
		}

	}

}
