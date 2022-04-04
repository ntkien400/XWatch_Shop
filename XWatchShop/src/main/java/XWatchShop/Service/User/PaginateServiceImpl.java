package XWatchShop.Service.User;

import org.springframework.stereotype.Service;

import XWatchShop.DTO.PaginatesDTO;

@Service
public class PaginateServiceImpl implements IPaginateService {
	public PaginatesDTO GetPaginatesData(int totalData, int limit, int currentPage) {
		PaginatesDTO paginates = new PaginatesDTO();
		paginates.setLimit(limit);
		paginates.setTotalPage(SetTotalPage(totalData, limit));
		paginates.setCurrentPage(CheckCurrentPage(currentPage, paginates.getTotalPage()));
		paginates.setStart(FindStart(currentPage, limit));
		paginates.setEnd(FindEnd(paginates.getStart(), limit, totalData));
		return paginates;
	}

	private int FindEnd(int start, int limit, int totalData) {
		return (start + limit) > totalData ? totalData : (start + limit) -1;
	}

	private int FindStart(int currentPage, int limit) {
		return (currentPage-1) * limit ;
	}

	private int CheckCurrentPage(int currentPage, int totalPage) {
		if(currentPage <1)
			return 1;
		if(currentPage > totalPage)
			return totalPage;
		return currentPage;
	}

	private int SetTotalPage(int totalData, int limit) {
		int totalPage = 0;
		totalPage = totalData/limit;
		totalPage = totalPage*limit < totalData ? totalPage +1 : totalPage;
		return totalPage;
	}
}
