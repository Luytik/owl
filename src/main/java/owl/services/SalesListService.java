package owl.services;

import org.springframework.stereotype.Service;
import owl.models.SalesList;
import owl.repository.SalesListRepository;

@Service
public class SalesListService {
    private final SalesListRepository salesListRepository;

    public SalesListService(SalesListRepository salesListRepository) {
        this.salesListRepository = salesListRepository;
    }

    public void addGoodsForSaling(SalesList salesList){
        salesListRepository.save(salesList);
    }
}
