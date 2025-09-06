package com.nt.sbeans;

import java.time.LocalDate;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component("cve")
public class CheckingVotingEligibility 
{
	@Value("${voter.name}")
	private String name;
	@Value("${voter.age}")
	private Float age;
	@Value("${voter.addrs}")
	private String addrs;
	private LocalDate dov;
	@PostConstruct
	public void myInit()
	{
		System.out.println("CheckingVotingEligibility.myInit() (custom Init Method)");
		//Initialize left over properties
		dov = LocalDate.now();
		//check whether import properties are injected with correct values or not
		if(name==null || name.contains("$") || age<=0 || age>130)
			throw new IllegalArgumentException("Invalid Inputs for name, age");
	}
	
	//business method
	public String doCheckVoteCastingEligibility() {
		System.out.println("CheckingVotingEligibility.doCheckVoteCastingEligibility()");
		//business logic
		if(age<18)
			return name+ " Voter is not eligible for voting  ---> Verified On : :  "+dov;
		else
			return name+ " Voter is  eligible for voting  ---> Verified On : :  "+dov;
	}
	@PreDestroy
	public void myDestroy()
	{
		System.out.println("CheckingVotingEligibility.myDestroy()");
		//nullify the spring bean properties
		name=null;
		age=null;
		addrs=null;
		dov=null;
		
	}

}
