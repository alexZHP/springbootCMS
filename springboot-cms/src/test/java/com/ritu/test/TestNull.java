package com.ritu.test;

import org.junit.Test;

import com.sun.istack.internal.Nullable;

public class TestNull {
	Tee t = new Tee();
	
	private class Tee{
		private String name;
	}
	
	@Test
	public void Test1(){
		System.out.println(t.name);
	}
}
