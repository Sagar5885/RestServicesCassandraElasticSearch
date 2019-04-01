package com.sagar.cronjob.test;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class CronObjEsJobTest {

	public static void main(String args[]) {
		try {
			//Job1
			JobDetail CronObjEsJob1 = JobBuilder.newJob(CronObjEsJob.class).withIdentity("CronObjEsJob", "CronObjEsJobGroup").build();
			Trigger CronObjEsJobTrigger1 = TriggerBuilder.newTrigger()
					.withIdentity("CronObjEsJobTrigger1", "CronObjEsJobGroup")
					.build();
					
			Scheduler cronObjEsJobScheduler1 = new StdSchedulerFactory().getScheduler();
			cronObjEsJobScheduler1.start();
			cronObjEsJobScheduler1.scheduleJob(CronObjEsJob1, CronObjEsJobTrigger1);
			
			Thread.sleep(10000);
			cronObjEsJobScheduler1.shutdown();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
