package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer{

	@Override
	public void compile() {
	System.out.println("Desktop Compile Faster ");
	}

}
