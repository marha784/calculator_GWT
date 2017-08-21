package com.exempel.martin.client;



public class Calculation {
	
	
	private int number1;
	private String operand;
	private int number2;
	private String result;
	private double double1;
	private double double2; 

	public Calculation(int number1,String operand, int number2)
	{
		this.number1=number1; 
		this.operand=operand; 
		this.number2=number2; 
	}
	
	public Calculation(double double1,String operand, double double2)
	{
		this.double1=double1;  
		this.operand=operand; 
		this.double2=double2; 
	}
	
	
	public String calculate() 
	{
		
		if(operand.equals("+")) 
		{	
			
		   result= add(); 
		}
		if(operand.equals("-")) 
		{	
			result=subtract(); 
		}
		if(operand.equals("*"))
		{	
			result=multiply(); 
		}
		if(operand.equals("/"))
		{	
			result=divide(); 
		}
		if(operand.equals("%"))
		{	
			result=modulo(); 
		}
		
		return result;	
		
	}
	
	public String calculateDouble() 
	{
		
		if(operand.equals("+")) 
		{	
			
		   result= addDouble(); 
		}
		if(operand.equals("-")) 
		{	
			result=subtractDouble(); 
		}
		if(operand.equals("*"))
		{	
			result=multiplyDouble(); 
		}
		if(operand.equals("/"))
		{	
			result=divideDouble(); 
		}
		if(operand.equals("%"))
		{	
			result=moduloDouble(); 
		}
		
		return result;	
		
	}
	
	

	public String add() {
		 return result=Integer.toString(number1+number2); 
	}
	public String subtract() {
		 return result=Integer.toString(number1-number2); 
	}
	public String multiply() {
		 return result=Integer.toString(number1*number2); 
	}
	public String divide() {
		if(number2==0)
		{
		result="FEL"; 	
		}
		else
		result=Double.toString(((double)number1)/((double)number2)); 
		return result; 
	}
	
	
	public String addDouble() {
		 return result=Double.toString(double1+double2); 
	}
	public String subtractDouble() {
		 return result=Double.toString(double1-double2); 
	}
	public String multiplyDouble() {
		 return result=Double.toString(double1*double2); 
	}
	public String divideDouble() {
		
		result=Double.toString(double1/double2); 
		return result; 
	}
	public String modulo() {
		 return result=Integer.toString(number1%number2); 
	}
	
	private String moduloDouble() {
		return result=Double.toString(double1%double2);
	}

}
