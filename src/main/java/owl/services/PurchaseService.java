package owl.services;

import org.springframework.stereotype.Service;
import owl.repository.PurchasesRepository;

@Service
public class PurchaseService {
    private final PurchasesRepository purchasesRepository;

    public PurchaseService(PurchasesRepository purchasesRepository) {
        this.purchasesRepository = purchasesRepository;
    }
}
