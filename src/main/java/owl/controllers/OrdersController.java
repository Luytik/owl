package owl.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/orders")
public class OrdersController {
    @GetMapping
    public String orderMonitoring(){
        return "monitoringoforders.html";
    }
}
