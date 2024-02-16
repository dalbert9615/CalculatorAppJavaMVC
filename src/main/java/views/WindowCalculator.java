package main.java.views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class WindowCalculator extends JFrame implements ViewCalculator{
	
	private JTextField display;
	private JButton clear;
	private JButton[] teclasNum;
	private JButton teclaPuntoDecimal;
	private JButton teclaIgual;
	private JButton teclaSuma;
	private JButton teclaResta;
	private JButton teclaDivision;
	private JButton teclaMultiplicacion;

	public WindowCalculator() {
		super();
		this.init();
	}
	
	private void init() {
		this.setSize(230,250);
		this.setTitle("Calculadora");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(0, 0);
		this.setResizable(false);
		this.setIconImage(new ImageIcon("src/main/resources/images/calculadora.png").getImage());
		
		JPanel panel=new JPanel(new BorderLayout());
		panel.add(crearPanelDisplay(),BorderLayout.NORTH);
		panel.add(crearPanelClear(),BorderLayout.CENTER);
		panel.add(crearPanelTeclas(),BorderLayout.SOUTH);
		this.setContentPane(panel);
	}
	
	private JPanel crearPanelDisplay() {
		JPanel display=new JPanel();
		this.display=new JTextField("0",10);

		this.display.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));
		this.display.setBackground(Color.WHITE);
		this.display.setFont(new Font("Arial", Font.BOLD, 25));
		this.display.setHorizontalAlignment(JTextField.RIGHT);
		this.display.setEditable(false);
		
		display.add(this.display);
		return display;
	}
	
	private JPanel crearPanelClear() {
		JPanel display=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		this.clear=new JButton("C");	
		this.clear.setBackground(Color.RED);
		this.clear.setForeground(Color.WHITE);	
		display.add(this.clear);
		return display;
	}
	
	private JPanel crearPanelTeclas() {
		JPanel display=new JPanel(new GridLayout(4,4,5,5));
		display.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));
		
		this.teclasNum=new JButton[10];
		for(int i=0;i<this.teclasNum.length;i++) this.teclasNum[i]=new JButton(String.valueOf(i));
		teclaPuntoDecimal=new JButton(".");
		teclaIgual=new JButton("=");
		teclaSuma=new JButton("+");
		teclaResta=new JButton("-");
		teclaDivision=new JButton("/");
		teclaMultiplicacion=new JButton("*");
		
		display.add(this.teclasNum[7]);
		display.add(this.teclasNum[8]);
		display.add(this.teclasNum[9]);
		display.add(this.teclaDivision);
		
		display.add(this.teclasNum[4]);
		display.add(this.teclasNum[5]);
		display.add(this.teclasNum[6]);
		display.add(this.teclaMultiplicacion);
		
		display.add(this.teclasNum[1]);
		display.add(this.teclasNum[2]);
		display.add(this.teclasNum[3]);
		display.add(this.teclaResta);
		
		display.add(this.teclasNum[0]);
		display.add(this.teclaPuntoDecimal);
		display.add(this.teclaIgual);
		display.add(this.teclaSuma);
						
		return display;
	}
	
	@Override
	public void setDisplay(String s) {
		this.display.setText(s);
	}
	@Override
	public String getDisplay() {
		return this.display.getText();
	}
	@Override
	public void addOyenteTeclaDigito(int digito,ActionListener l) {
		this.teclasNum[digito].addActionListener(l);
	}
	@Override
	public void addOyenteTeclaDecimal(ActionListener l) {
		this.teclaPuntoDecimal.addActionListener(l);
	}
	@Override
	public void addOyenteTeclaMas(ActionListener l) {
		this.teclaSuma.addActionListener(l);
	}
	@Override
	public void addOyenteTeclaMenos(ActionListener l) {
		this.teclaResta.addActionListener(l);
	}
	@Override
	public void addOyenteTeclaPor(ActionListener l) {
		this.teclaMultiplicacion.addActionListener(l);
	}
	@Override
	public void addOyenteTeclaDiv(ActionListener l) {
		this.teclaDivision.addActionListener(l);
	}
	@Override
	public void addOyenteTeclaIgual(ActionListener l) {
		this.teclaIgual.addActionListener(l);
	}
	@Override
	public void addOyenteTeclaClear(ActionListener l) {
		this.clear.addActionListener(l);
	}
}
