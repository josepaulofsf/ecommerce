package com.ecommerce.service;

import com.ecommerce.model.Order;
import com.ecommerce.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderProcessingService {

    private final OrderRepository orderRepository;
    private final OrderValidator orderValidator;
    private final InvoiceService invoiceService;
    private final OrderNotificationService notificationService;
    private final OrderAuditService auditService;

    public OrderProcessingService(OrderRepository orderRepository,
                                  OrderValidator orderValidator,
                                  InvoiceService invoiceService,
                                  OrderNotificationService notificationService,
                                  OrderAuditService auditService) {
        this.orderRepository = orderRepository;
        this.orderValidator = orderValidator;
        this.invoiceService = invoiceService;
        this.notificationService = notificationService;
        this.auditService = auditService;
    }

    public void processOrderAndDoEverything(Order order) {
        orderValidator.validate(order);
        order.setStatus("PROCESSED");
        orderRepository.save(order);
        invoiceService.generate(order);
        notificationService.notifyCustomer(order);
        auditService.record(order);
    }
}
