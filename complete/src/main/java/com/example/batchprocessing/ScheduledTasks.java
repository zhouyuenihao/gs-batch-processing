package com.example.batchprocessing;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouyue01
 * @date 2022/8/17
 */
@Component
public class ScheduledTasks {
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job importUserJob;

    @Scheduled(cron = "0/5 * * * * * ")
    public void showCurrentTime() throws Exception {
        System.out.println("定时job");
        Map<String, JobParameter> param = new HashMap<>(2);
        param.put("startTime", new JobParameter(new Date()));
        jobLauncher.run(importUserJob, new JobParameters(param));
        System.out.println("定时job结束");
    }

}
