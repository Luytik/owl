package owl.services;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import owl.models.UserOrder;
import owl.models.Status;
import owl.repository.OrderRepository;


@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Transactional
    public long findOpenedOrder(long id){
        List<UserOrder> orderList = orderRepository.findAllByUserId(id);
        for(UserOrder order : orderList){
            if (order.getStatus() == Status.CART) {
                return order.getId();
            }
        }
        return -1;
    }

    @Transactional
    public UserOrder findUserOrderById(long id){        
        return orderRepository.findUserOrderById(id);
    }

    @Transactional
    public void addOrder(UserOrder userOrder){
        orderRepository.save(userOrder);
    }

    @Transactional
    public void changeStatusInOrder(Status status, UserOrder userOrder){
        userOrder.setStatus(status);
        Date date = new Date();
        userOrder.setOrderDate(date);
        orderRepository.save(userOrder);
    }

    @Transactional
    public List<UserOrder> getAllOrders(){
        return orderRepository.findAll();
    }
}
