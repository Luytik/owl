package owl.services;

import org.springframework.stereotype.Service;
import owl.repository.OrdersRepository;

@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }
}
