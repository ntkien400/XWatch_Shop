package XWatchShop.DAO;

import org.springframework.stereotype.Repository;

import XWatchShop.Entity.BillDetails;
import XWatchShop.Entity.Bills;

@Repository
public class BillsDAO extends BaseDAO {
	public int AddBill(Bills bill) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO bills ");
		sql.append("(  ");
		sql.append("userID, phone_number, address, display_name, note, total, quantity ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("'"+bill.getUserID()+"', ");
		sql.append("'"+bill.getPhone_number()+"', ");
		sql.append("'"+bill.getAddress()+"', ");
		sql.append("'"+bill.getDisplay_name()+"', ");
		sql.append("'"+bill.getNote()+"', ");
		sql.append(bill.getTotal()+", ");
		sql.append(bill.getQuantity()+" ");
		sql.append(") ");
		int result = jdbcTemplate.update(sql.toString());
		return result;
	}
	
	public int GetIDBillByUser(String userID) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT MAX(billID) FROM bills ");
		sql.append("WHERE userID = '"+userID+"' ");
		int billID = jdbcTemplate.queryForObject(sql.toString(), new Object[] {}, Integer.class);
		return billID;
	}
	public int AddBillDetails(BillDetails billDetails) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO billdetails ");
		sql.append("(  ");
		sql.append("billID, productID, quantity, total ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append(billDetails.getBillID()+", ");
		sql.append("'"+billDetails.getProductID()+"', ");
		sql.append(billDetails.getQuantity()+", ");
		sql.append(billDetails.getTotal()+" ");
		sql.append(") ");
		int result = jdbcTemplate.update(sql.toString());
		return result;
	}
}
