package main.java.controllers;

import java.awt.event.*;
import main.java.views.ViewCalculator;
import main.java.models.calculator.ModelCalculator;
import main.java.models.operators.*;

public class ControllerCalculator {
	private ViewCalculator vista;
	private ModelCalculator modelo;
	
	//true: decimal point
	private boolean editDecimal=false;
	
	//true: editing display , false: start edit valor
	private boolean editDisplay=false;

	public ControllerCalculator(ViewCalculator vista, ModelCalculator modelo) {
		super();
		this.vista = vista;
		this.modelo = modelo;

		vista.addOyenteTeclaClear(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				teclaClearPulsada();
			}
		});
		
		vista.addOyenteTeclaIgual(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				teclaIgualPulsada();
			}
		});
		
		vista.addOyenteTeclaDiv(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				teclaDivPulsada();
			}
		});
		vista.addOyenteTeclaPor(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				teclaPorPulsada();
			}
		});
		vista.addOyenteTeclaMenos(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				teclaMenosPulsada();
			}
		});
		vista.addOyenteTeclaMas(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				teclaMasPulsada();
			}
		});
		vista.addOyenteTeclaDecimal(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				teclaDecimalPulsada();
			}
		});
		
		for(int i=0;i<10;i++) {
			final int n_i=i;
			vista.addOyenteTeclaDigito(n_i, new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					teclaDigitoPulsada(String.valueOf(n_i));
				}
			});
		}
		
	}


	private void Operar (BinaryOperator op) {
		if(this.editDisplay) {//si se esta editando un valor
			modelo.nuevoOperando(Double.parseDouble(this.vista.getDisplay())); 
			modelo.nuevaOperacion(op);
			this.setEditDisplay(false);
			this.setEditDecimal(false);
			
			if(Double.toString(this.modelo.getResultado()).length()>10) {
				this.vista.setDisplay(Double.toString(this.modelo.getResultado()).substring(0, 10));
			}
			else this.vista.setDisplay(Double.toString(this.modelo.getResultado()));
			System.out.println(Double.toString(this.modelo.getResultado()));
		}
		else {
			modelo.nuevaOperacion(op);
		}
	}
	
	protected void teclaMasPulsada() {
		Addition op=new Addition();
		this.Operar(op);
	}

	protected void teclaMenosPulsada() {
		Subtraction op=new Subtraction();
		this.Operar(op);
	}

	protected void teclaPorPulsada() {
		Multiplication op=new Multiplication();
		this.Operar(op);
	}

	protected void teclaDivPulsada() {
		Division op=new Division();
		this.Operar(op);
	}

	protected void teclaIgualPulsada() {
		this.modelo.nuevoOperando(Double.parseDouble(this.vista.getDisplay()));
		this.setEditDisplay(false);//start edit
		this.setEditDecimal(false);
		
		if(Double.toString(this.modelo.getResultado()).length()>10) {
			this.vista.setDisplay(Double.toString(this.modelo.getResultado()).substring(0, 10));
		}
		else this.vista.setDisplay(Double.toString(this.modelo.getResultado()));
		System.out.println(Double.toString(this.modelo.getResultado()));
	}

	protected void teclaClearPulsada() {
		this.modelo.clear();
		this.setEditDecimal(false);
		this.setEditDisplay(false);
		this.vista.setDisplay("0");
	}

	protected void teclaDigitoPulsada(String digito) {
		if(this.vista.getDisplay()=="0" || !this.editDisplay) {
			this.vista.setDisplay(digito);
			this.setEditDisplay(true);
		}
		else {
			this.vista.setDisplay(this.vista.getDisplay()+digito);
		}
	}

	protected void teclaDecimalPulsada() {
		if(!this.editDecimal) {
			this.setEditDecimal(true);
			if(this.editDisplay) {//editing display
				this.vista.setDisplay(this.vista.getDisplay()+".");
			}
			else {
				this.setEditDisplay(true);
				this.vista.setDisplay("0.");
			}
		}
	}

	public void setEditDecimal(boolean editDecimal) {
		this.editDecimal = editDecimal;
	}

	public void setEditDisplay(boolean editDisplay) {
		this.editDisplay = editDisplay;
	}

}
