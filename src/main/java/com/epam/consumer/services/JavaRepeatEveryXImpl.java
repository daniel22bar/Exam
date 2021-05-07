package com.epam.consumer.services;

import com.epam.infra.InjectValue;

import java.util.Timer;
import java.util.TimerTask;

public class JavaRepeatEveryXImpl implements JavaRepeatEveryX {
    @InjectValue("schedule_delay")
    private String scheduleDelay;
    @InjectValue("schedule_period")
    private String schedulePeriod;

    public void timerTaskWrapper(Runnable task) {
        Timer timer = new Timer();
        TimerTask taskToRun = new TimerTask(){
            public void run(){
                task.run();
                System.out.println(Thread.currentThread());
            }
        };
        timer.scheduleAtFixedRate(taskToRun,Integer.parseInt(scheduleDelay),Integer.parseInt(schedulePeriod));
    }
}
