package com.dxc.prime;

public class Prime {
	private Integer nth;
	private Long value;

	public Prime() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Prime(Integer nth, Long value) {
		super();
		this.nth = nth;
		this.value = value;
	}

	public Integer getNth() {
		return nth;
	}

	public void setNth(Integer nth) {
		this.nth = nth;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

}
