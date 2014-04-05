import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;



public class BMI extends JFrame {
	private JTextField oname = new JTextField();
	private JTextField oage = new JTextField();
	private JTextField oweight = new JTextField();
	private JTextField oheight = new JTextField();
	private JTextField bmi = new JTextField();
	private JTextField status = new JTextField();
	
	private JButton computeBMI = new JButton("Compute BMI");
	
	public BMI(){
		JPanel p1 = new JPanel(new GridLayout(4, 2));
		p1.add(new JLabel("Name"));
		p1.add(oname);
		p1.add(new JLabel("Age"));
		p1.add(oage);
		p1.add(new JLabel("Weight(kg)"));
		p1.add(oweight);
		p1.add(new JLabel("Height(m)"));
		p1.add(oheight);
		p1.setBorder(new TitledBorder("Enter name, age, weight, and height"));
		
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		p2.add(computeBMI);
		
		JPanel p3 = new JPanel(new GridLayout(2, 2));
		p3.add(new JLabel("BMI"));
		p3.add(bmi);
		p3.add(new JLabel("Status"));
		p3.add(status);
		
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		add(p3, BorderLayout.SOUTH);
		
		computeBMI.addActionListener((ActionListener) new ButtonListener());
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			double weight = Double.parseDouble(oweight.getText());
			double height = Double.parseDouble(oheight.getText());
			
			double bmiGet = weight / (height * height);
			bmi.setText(String.format("%.3f", bmiGet));
			
			if (bmiGet < 18.5)
				status.setText("Underweight");
			else if(bmiGet < 25)
				status.setText("Normal");
			else if (bmiGet < 30 )
				status.setText("Overweight");
			else 
				status.setText("Obese");
			
		}
	}
	
	public static void main(String[] args){
		BMI frame = new BMI();
		frame.pack();
		frame.setSize(350, 235);
		frame.setTitle("BMI");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
