package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dev {
	@Qualifier("laptop")
	@Autowired
	private Computer computer;
	
	
	public void build() {
	System.out.println("Building A Spring Project ");
	computer.compile();
	}
}
