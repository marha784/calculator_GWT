package se.jensen.calculator.client; 

import com.google.gwt.core.client.EntryPoint;
import java.util.ArrayList;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Calculator implements EntryPoint {

	private final String WIDTH = "400px";
	private Label header = new Label();
	private TextBox displayArea = new TextBox();
	private FlexTable numberTable = new FlexTable();
	private FlexTable resultTable = new FlexTable();
	private FlexTable operandTable = new FlexTable();
	private VerticalPanel mainPanel = new VerticalPanel();
	private VerticalPanel resultPanel = new VerticalPanel();
	private String[] operators = new String[]{"/", "*", "-", "+", "="};
	private String[] clears = new String[]{"AC", "+/-", "%"};
	private String[] bottomRow = new String[]{"0", "."};
	private Button btn;
	private String number = "";
	private ArrayList<String> numberList = new ArrayList<String>();
	private ArrayList<String> operandList = new ArrayList<String>();

	public void onModuleLoad() {

		int row = 0;
		int column = 0;
		for (int i = 1; i < 15; i++) {

			if (row == 0) {
				final String value = String.valueOf(i + 6);

				btn = new Button(value);
				btn.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						addToDisplay(value);
						displayArea.setFocus(true);
					}

				});

			} else if (row == 1) {

				final String value = String.valueOf(i - 1);

				btn = new Button(value);
				btn.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						addToDisplay(value);
						displayArea.setFocus(true);
					}

				});

			}

			else if (row == 2) {

				final String value = String.valueOf(i - 8);

				btn = new Button(value);
				btn.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						addToDisplay(value);
						displayArea.setFocus(true);
					}

				});

			}

			else if (row == 3) {
				if (i != 16) {
					final String value = bottomRow[column];

					btn = new Button(value);

					btn.addClickHandler(new ClickHandler() {

						@Override
						public void onClick(ClickEvent event) {
							addToDisplay(value);
							displayArea.setFocus(true);

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
						displayArea.setFocus(true);

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

		operandTable.setWidget(0, 3, new Button(operators[0], new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				addToDisplay(operators[0]);

			}
		}));

		numberTable.setWidget(0, 3, new Button(operators[1], new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				addToDisplay(operators[1]);

			}
		}));

		numberTable.setWidget(1, 3, new Button(operators[2], new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				addToDisplay(operators[2]);

			}
		}));

		numberTable.setWidget(2, 3, new Button(operators[3], new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				addToDisplay(operators[3]);

			}
		}));
		numberTable.setWidget(3, 2, new Button(operators[4], new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				addToDisplay(operators[4]);

			}

		}));

		displayArea.addKeyDownHandler(new KeyDownHandler() {

			@Override
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {

					doCalculation();
				}
			}
		});

		numberTable.setWidth(WIDTH);
		numberTable.getFlexCellFormatter().setColSpan(3, 0, 2);
		numberTable.getWidget(3, 0).setStyleName("zero");
		numberTable.getWidget(3, 2).setStyleName("equals");
		header.setWidth(WIDTH);

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
		setupResultTable();

		// add the mainPanel to the page
		RootPanel.get("calc").add(mainPanel);
		RootPanel.get("result").add(resultPanel);
	}

	private void setupResultTable() {

		resultTable.setWidth(WIDTH);
		resultPanel.setStylePrimaryName("resultPanel");

	}

	private void updateResultTable(String string) {

		int row = resultTable.getRowCount();
		resultPanel.add(resultTable);
		resultTable.setText(row, 0, string);
		resultTable.getCellFormatter().addStyleName(row, 0, "resultPanel");

	}

	private void addToDisplay(String addText) {

		if (addText.matches("[0-9]") || addText.equals(".")) {
			number += addText;
			displayArea.setText(number);
		}

		else if (addText.matches("[/,+,*,%,-]")) {
			displayArea.setText("");
			if (number.length() == 0) {
				// do something
			}
			if (number.length() != 0) {
				numberList.add(number);
				operandList.add(addText);
				number = "";
			}
		} else if (addText.equals("AC")) {
			number = "";
			operandList.clear();
			numberList.clear();
			displayArea.setText("");
		} else if (addText.equals("+/-")) {
			if(Integer.parseInt(number)>0) 
			{
			number = "-" + number;
			}
			displayArea.setText(number);
		} else if (addText.equals("=")) {

			doCalculation();

		}
	}

	public void doCalculation() {

		numberList.add(number);
		number = "";
		String result = "";
		String output = "";
       
		CalculationHandler sort = new CalculationHandler(numberList,operandList);
		output=sort.getEquationResult();
		result=sort.sortAndCalculate();
		updateResultTable(output);
		displayArea.setText(result);
		operandList.clear();
		numberList.clear();

	}

}