package springprojectdb.demo.listener;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import springprojectdb.demo.service.BackupkayService;
import springprojectdb.demo.service.ScrapService;

import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class CompanyApplicationEventListener {



    @Autowired
    private ScrapService scrapService;

    @Autowired
    BackupkayService backupkayService;



    @EventListener({ContextRefreshedEvent.class})
    public void onContextRefreshedEvent()  {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(backupkayService);
        executorService.submit(scrapService);
        executorService.shutdown ();


    }
}
