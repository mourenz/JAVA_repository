package service.impl;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import service.ITaskService;

@Service
public class TaskService implements ITaskService {

	@Override
	@Scheduled(initialDelay = 1000,fixedDelay = 5000)
	public void task01() {
		// TODO Auto-generated method stub
		System.out.println("启动定时任务......."+new Date());
	}

	@Override
	@Scheduled(cron = "0 58 18 * * ?")
	public void task02() {
		// TODO Auto-generated method stub
		System.out.println("定时任务2....."+new Date());
		
	}

}
