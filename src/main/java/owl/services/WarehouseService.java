package owl.services;

import org.springframework.stereotype.Service;
import owl.repository.WarehouseRepository;

@Service
public class WarehouseService {
    private final WarehouseRepository warehouseRepository;

    public WarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }
}
