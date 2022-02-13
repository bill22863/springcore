package com.study.springcore.case02;

public class Size {
	private String scale;
	
	public Size() {
		
	}

	public Size(String scale) {
		this.scale = scale;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	@Override
	public String toString() {
		return "Size [scale=" + scale + "]";
	}
	
}
