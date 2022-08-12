package com.spring.dto;

import java.beans.ConstructorProperties;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;





//	@Getter
//	@Setter
//	@ToString
//	@NoArgsConstructor	//	기본생성자
@AllArgsConstructor	//	모든 변수를 매개 변수로 갖는 생성자
//	@RequiredArgsConstructor	//	원하는 몇개만 매개변수로 갖게 만들고,
					//	이때 각 변수가 @NonNull 이나 final 일경우 매개변수로 포함.
					

@Data		//	기본생성자 ,getter ,setter, toString 등 여러가지 자동으로 생성

public class SampleTV {
	
//	@NonNull
	private boolean power;
//	@NonNull
	private int ch;
	private final String col;
	
	private Date reg;
	/*
	public SampleTV() {	}
	
	
	@ConstructorProperties({"power","ch","col","reg"})
	public SampleTV(boolean power, int ch , String col, Date reg) {	
		this.power = power ; this.ch = ch ; this.col = col; this.reg = reg;
	}
	
	
	
	
	public Date getReg() {
		return reg;
	}
	public void setReg(Date reg) {
		this.reg = reg;
	}
	
	
	public boolean isPower() {
		return power;
	}
	public void setPower(boolean power) {
		this.power = power;
	}
	public int getCh() {
		return ch;
	}
	public void setCh(int ch) {
		this.ch = ch;
	}
	public String getCol() {
		return col;
	}
	public void setCol(String col) {
		this.col = col;
	}
	
*/	

}
