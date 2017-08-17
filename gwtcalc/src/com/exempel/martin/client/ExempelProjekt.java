package com.exempel.martin.client;
import java.util.logging.Logger;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */


public class ExempelProjekt implements EntryPoint {
	
	
  
	private final String COMMON_WIDTH = "400px";
	private Logger logger = Logger.getLogger("NameOfYourLogger");
	private Label header = new Label();
	private TextBox displayArea = new TextBox();
	private FlexTable numberTable = new FlexTable();
	private FlexTable operandTable = new FlexTable();
	private VerticalPanel mainPanel = new VerticalPanel();
	private String[] syms = new String[] { "/", "*", "-", "+", "=" };
	private String[] clears = new String[] { "AC", "+/-", "%" };
	private String[] botRow = new String[] { "0", "." };
	private Button btn;
    private String equation=""; 
    
	public void onModuleLoad() {
		
		
		
		int row = 0;
		int column = 0;
		for (int i = 1; i < 15; i++) {
			
			if (row == 0) 
			{
				final String value = String.valueOf(i+6);
                
				btn = new Button(value); 
				btn.addClickHandler(new ClickHandler() {
               
					@Override
					public void onClick(ClickEvent event) {
						addToDisplay(value);	
					}
					
				}); 	
				
			} 
			else if (row== 1) {
				
                final String value = String.valueOf(i-1);
                
				btn = new Button(value); 
				btn.addClickHandler(new ClickHandler() {
               
					@Override
					public void onClick(ClickEvent event) {
						addToDisplay(value);	
					}
					
				}); 	
				
				
			}
			
            else if (row== 2) {
				
                final String value = String.valueOf(i-8);
                
				btn = new Button(value); 
				btn.addClickHandler(new ClickHandler() {
					               
					@Override
					public void onClick(ClickEvent event) {
						addToDisplay(value);	
					}
					
				}); 	
				
				
			}
			
			else if (row == 3) {
				if (i != 16) {
					final String value = botRow[column];
					

					btn = new Button(value);
                  
                   
					btn.addClickHandler(new ClickHandler() {	

						@Override
						public void onClick(ClickEvent event) {
							addToDisplay(value);
							
						}
					});
				}
			} else if (column == 3) {
				btn = null;
			} else {
				int adjusted = i - row;
				final String value = String.valueOf(adjusted);
				btn = new Button(value);
				btn.addClickHandler(new ClickHandler() {	

					@Override
					public void onClick(ClickEvent event) {
						addToDisplay(value);
						
					}
				});
			}

			numberTable.setWidget(row, column, btn);
			column++;

			if ((i % 4) == 0) {
				row++;
				column = 0;
			}
			
		}
       
		operandTable.setWidget(0, 0, new Button(clears[0], new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				addToDisplay(clears[0]);
				
			}
		}));

		operandTable.setWidget(0, 1, new Button(clears[1], new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				addToDisplay(clears[1]);
				
			}
		}));

		operandTable.setWidget(0, 2, new Button(clears[2], new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				addToDisplay(clears[2]);
				
			}
		}));
		
        operandTable.setWidget(0, 3, new Button(syms[0], new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				addToDisplay(syms[0]);
				
			}
		}));
        
         numberTable.setWidget(0, 3, new Button(syms[1], new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				addToDisplay(syms[1]);
				
			}
		}));
         
         numberTable.setWidget(1, 3, new Button(syms[2], new ClickHandler() {
 			
 			@Override
 			public void onClick(ClickEvent event) {
 				addToDisplay(syms[2]);
 				
 			}
 		}));
		
         numberTable.setWidget(2, 3, new Button(syms[3], new ClickHandler() {
 			
 			@Override
 			public void onClick(ClickEvent event) {
 				addToDisplay(syms[3]);
 				
 			}
 		}));
         numberTable.setWidget(3,2, new Button(syms[4], new ClickHandler() {
 			
 			@Override
 			public void onClick(ClickEvent event) {
 				addToDisplay(syms[4]);
 				
 			}
 			
 		}));
         
        
        
		numberTable.setWidth(COMMON_WIDTH);
		numberTable.getFlexCellFormatter().setColSpan(3,0,2);
		numberTable.getWidget(3,0).setStyleName("zero");
		numberTable.getWidget(3,2).setStyleName("equals");
		header.setWidth(COMMON_WIDTH);

		// Construct the mainPanel in order (top to bottom)
		mainPanel.add(header);
		mainPanel.add(displayArea);
		mainPanel.add(operandTable);
		mainPanel.add(numberTable);
		
		
		// add styles
		mainPanel.setStyleName("main");
		displayArea.addStyleName("display");
		numberTable.addStyleName("numTable");
		operandTable.addStyleName("operandTable");
		
		// add the mainPanel to the page
		RootPanel.get("calc").add(mainPanel);
	}

	private void addToDisplay(String addText) 
	{
		
		equation+=addText; 
		displayArea.setText(equation);

	}
	
	/*

		private void calculate() {
			
			final String operator = operatorTextBox.getText().trim();
			calculateButton.setFocus(true);
			if ((!operator.equals("*") && !operator.equals("+") && !operator.equals("%")) || !isInteger(operand1TextBox.getText().trim())|| !isInteger(operand2TextBox.getText().trim())) {
		        Window.alert("You have entered a non valid binary operator or one of the operands is not an integer");
		        
		        return;
		      }
			
			 int operand1=Integer.parseInt(operand1TextBox.getText());
			 int operand2=Integer.parseInt(operand2TextBox.getText());
			 int answer;
			 //Multiplication
			 if(operator.equals("*"))
			 {
				 answer=operand1*operand2;
				 Window.alert("The answer is: " + answer);
				 
			 }
			 //Modulo
			 else if (operator.equals("%"))
			 {
				 answer=operand1%operand2;
				 Window.alert("The answer is: " + answer);
				 
			 }
			 //addition
			 else {
				 
				 answer=operand1+operand2;
				 Window.alert("The answer is: " + answer);
				 
			 }
			 
			}
		//Checkes if a String could be seen as an integer
		public boolean isInteger( String input )
		{
		   try
		   {
		      Integer.parseInt( input );
		      return true;
		   }
		   catch(NumberFormatException e)
		   {
		      return false;
		   }
		}
			
	*/	
}