package com.cier.girl.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TestTask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//    @Scheduled(fixedRate = 1000)
    @Scheduled(cron = "4-10 * * * * ? ")
    public void reportCurrentTime(){
        System.out.println("现在时间: "+ dateFormat.format(new Date()));
    }
}
