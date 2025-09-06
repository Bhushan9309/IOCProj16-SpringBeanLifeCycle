package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.CheckingVotingEligibility;

public class SpringBeanLifeCycleTest {

	public static void main(String[] args) 
	{
		//create IOC Container
		try(AnnotationConfigApplicationContext ctx =  new AnnotationConfigApplicationContext(AppConfig.class))
		{
			//get Spring bean class object reference
			CheckingVotingEligibility cve = ctx.getBean("cve",CheckingVotingEligibility.class);
			String result = cve.doCheckVoteCastingEligibility();
			System.out.println("Result is : : "+result);
		}
      catch (Exception e) {
		e.printStackTrace();
	}
	}

}
