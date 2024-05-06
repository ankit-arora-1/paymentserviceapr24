package dev.ankit.paymentservice.services.paymentgateway;

import com.razorpay.PaymentLink;
import org.springframework.stereotype.Service;
import org.json.JSONObject;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Service
public class RazorpayGateway implements PaymentGateway {
    @Override
    public String generatePaymentLink() {
        try {
            RazorpayClient razorpay =
                    new RazorpayClient("rzp_test_jIL7muukEhgYUH", "Cqvl6pFWmA84R2uyhZOuQdiq");

            JSONObject paymentLinkRequest = new JSONObject();
            paymentLinkRequest.put("amount",1000);
            paymentLinkRequest.put("currency","INR");
            paymentLinkRequest.put("accept_partial",false);

            paymentLinkRequest.put("expire_by",1715184876);
            paymentLinkRequest.put("reference_id","TS1989003");
            paymentLinkRequest.put("description","Payment for policy no #23456");

            JSONObject customer = new JSONObject();
            customer.put("contact","+917337057594");
            customer.put("name","Ankit Arora");
            customer.put("email","arora.ankit7@gmail.com");
            paymentLinkRequest.put("customer",customer);

            JSONObject notify = new JSONObject();
            notify.put("sms",true);
            notify.put("email",true);
            paymentLinkRequest.put("notify",notify);

            paymentLinkRequest.put("callback_url","https://google.com/");
            paymentLinkRequest.put("callback_method","get");

            PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);

            return payment.toString();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return null;

    }

}
