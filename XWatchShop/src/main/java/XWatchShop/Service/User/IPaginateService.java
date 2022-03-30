package XWatchShop.Service.User;

import org.springframework.stereotype.Service;

import XWatchShop.DTO.PaginatesDTO;

@Service
public interface IPaginateService {
	public PaginatesDTO GetPaginatesData(int totalData, int limit, int currentPage);
}
