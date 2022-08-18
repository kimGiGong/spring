package com.spring.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class SampleDTO {
	
	private String id;
	private String pw;
	private int age;
	private Timestamp reg;
	
	
}
