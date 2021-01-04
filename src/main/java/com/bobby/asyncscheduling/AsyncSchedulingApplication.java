package com.bobby.asyncscheduling;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.swing.text.html.parser.Element;
import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
@EnableScheduling()
public class AsyncSchedulingApplication {
	private static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		context = SpringApplication.run(AsyncSchedulingApplication.class, args);


		System.out.println("==============================================");
		System.out.println("=========== APPLICATION STARTED"+ " on " + Thread.currentThread().getName() +"==============");
		System.out.println("==============================================");


		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				AsyncSchedulingApplication.restart();
			}
		}, 60000);

//		System.out.println("Parsed Null"+Integer.parseInt());


	}

	private static void restart() {
		ApplicationArguments args = context.getBean(ApplicationArguments.class);

		Thread thread = new Thread(() -> {
			context.close();
			context = SpringApplication.run(AsyncSchedulingApplication.class, args.getSourceArgs());
		});

		thread.setDaemon(false);
		thread.start();
	}


}
