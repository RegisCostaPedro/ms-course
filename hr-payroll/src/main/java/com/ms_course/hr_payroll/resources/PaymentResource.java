package com.ms_course.hr_payroll.resources;


import com.ms_course.hr_payroll.entities.PaymentEntity;
import com.ms_course.hr_payroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    @Autowired
    private PaymentService service;

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<PaymentEntity> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
        PaymentEntity payment = service.getPayment(workerId, days);

        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    public ResponseEntity<PaymentEntity> getPaymentAlternative(Long workerId, Integer days) {
        PaymentEntity payment = new PaymentEntity("Brann", 400.0, days);

        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

}



