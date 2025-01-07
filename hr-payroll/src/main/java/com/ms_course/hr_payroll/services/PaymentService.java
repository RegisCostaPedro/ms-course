package com.ms_course.hr_payroll.services;

import com.ms_course.hr_payroll.entities.PaymentEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentEntity getPayment(long workerId, int days){
        return new PaymentEntity("Bob",500.0,days);

    }

}
