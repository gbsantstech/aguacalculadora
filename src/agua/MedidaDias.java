package agua;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MedidaDias extends JFrame implements ActionListener{
	private JLabel labelQuestion;
	private JLabel labelWeight;
	private JTextField fieldWeight;
	private JButton buttonTellMe;
	
	public MedidaDias() {
		super("Água Calculadora");
		
		initComponents();
		
		setSize(240,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void initComponents() {
		labelQuestion = new JLabel("Quanto de água eu devo beber? ");
		labelWeight = new JLabel("Meu peso (kg): ");
		fieldWeight = new JTextField(5);
		buttonTellMe = new JButton("Me conte");
		
		setLayout(new FlowLayout());
		add(labelQuestion);
		add(labelWeight);
		add(fieldWeight);
		add(buttonTellMe);
		
		buttonTellMe.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String message = "Você deve beber %.1f L de água por dia";
		
		float weight = Float.parseFloat(fieldWeight.getText());
		float waterAmount = calculateWaterAmount(weight);
		
		message = String.format(message, waterAmount);
		
		JOptionPane.showMessageDialog(this, message);
	}
	
	private float calculateWaterAmount(float weight) {
		return (weight / 10f) * 0.4f;
	}
	
	public static void main(String[] args) {
		new MedidaDias().setVisible(true);
	}

}
