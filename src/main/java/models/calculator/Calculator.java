package main.java.models.calculator;

import main.java.models.operators.BinaryOperator;

public class Calculator implements ModelCalculator {
	private double resultado;
	private BinaryOperator operacion;
	
	public Calculator() {
		this.clear();
	}
	
	@Override
	public void clear() {
		this.resultado=0;
		this.operacion=null;
	}
	@Override
	public double getResultado() {
		return this.resultado;
	}
	@Override
	public void nuevaOperacion(BinaryOperator operacion) {
		this.operacion=operacion;
	}
	@Override
	public void nuevoOperando(double operando) {
		if(this.operacion!=null) {
			this.resultado=this.operacion.ejecutar(this.resultado, operando);
			this.operacion=null;
		}
		else
		{
			this.resultado=operando;
			this.operacion=null;
		}
	}
}
