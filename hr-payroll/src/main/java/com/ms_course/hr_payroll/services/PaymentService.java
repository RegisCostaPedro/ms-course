package com.ms_course.hr_payroll.services;

import com.ms_course.hr_payroll.entities.PaymentEntity;
import com.ms_course.hr_payroll.entities.WorkerEntity;
import com.ms_course.hr_payroll.feignClients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public PaymentEntity getPayment(long workerId, int days){
        WorkerEntity worker = workerFeignClient.findById(workerId).getBody();
        return new PaymentEntity(worker.getName(),worker.getDailyIncome(),days);
    }

    // * METODO COM REST TEMPLATE

    /* @Value("${hr-worker.host}")
    private String workerHost;*/

   /* @Autowired
    private RestTemplate restTemplate;*/

 /*   public PaymentEntity getPayment(long workerId, int days){

        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("id",""+workerId);

        WorkerEntity worker = restTemplate.getForObject(workerHost + "/workers/{id}",
                WorkerEntity.class,
                uriVariables);


        return new PaymentEntity(worker.getName(),worker.getDailyIncome(),days);
    }*/
}
