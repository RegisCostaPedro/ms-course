package com.ms_couse.hr_worker.resources;

import com.ms_couse.hr_worker.entities.WorkerEntity;
import com.ms_couse.hr_worker.repositories.WorkerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

    @Value("${test.config}")
    private String testConfig;

    @Autowired
    private Environment env;

    @Autowired
    private WorkerRepository repository;

    @GetMapping(value = "/configs")
    public ResponseEntity<Void> getConfigs() {
        logger.info("CONFIG= " + testConfig);
        return ResponseEntity.noContent().build();
    }


    @GetMapping
    public ResponseEntity<List<WorkerEntity>> findAll(){
        List<WorkerEntity> workerList = repository.findAll();

        return new ResponseEntity<>(workerList,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<WorkerEntity> findById(@PathVariable Long id){
//       try {
//            Thread.sleep(3000L);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//       }

        logger.info("PORT = " + env.getProperty("local.server.port"));
        WorkerEntity workerObj = repository.findById(id).get();
        return new ResponseEntity<>(workerObj,HttpStatus.OK);
    }



}
