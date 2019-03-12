package com.github.candyacao.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask {
    private int count = 0;
    @Scheduled(cron = "* * 23 * * ?")
    private void process(){
        System.out.println("this is scheduler task running" + (count++));
    }
}
