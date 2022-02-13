package com.study.springcore.case01;

public class RAM {

	private Integer gb;

	public Integer getGb() {
		return gb;
	}

	public RAM() {
		
	}
	
	public RAM(Integer gb) {
		this.gb = gb;
	}

	public void setGb(Integer gb) {
		this.gb = gb;
	}

	@Override
	public String toString() {
		return "RAM [gb=" + gb + "]";
	}
	
}
