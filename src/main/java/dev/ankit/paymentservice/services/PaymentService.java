package dev.ankit.paymentservice.services;

import dev.ankit.paymentservice.services.paymentgateway.PaymentGateway;
import dev.ankit.paymentservice.services.paymentgateway.PaymentGatewaySelector;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private PaymentGatewaySelector paymentGatewaySelector;

    public PaymentService(PaymentGatewaySelector paymentGatewaySelector) {
        this.paymentGatewaySelector = paymentGatewaySelector;
    }

    public String generatePaymentLink() {
        // write logic to add details in the database


        return paymentGatewaySelector
                .getPaymentGateway()
                .generatePaymentLink();
    }
}
