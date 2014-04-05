import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;


// Create a class extends JFrame
public class BMI extends JFrame {
	
	// Create text fields 
	private JTextField oname = new JTextField();
	private JTextField oage = new JTextField();
	private JTextField oweight = new JTextField();
	private JTextField oheight = new JTextField();
	private JTextField bmi = new JTextField();
	private JTextField status = new JTextField();
	
	// Create a button
	private JButton computeBMI = new JButton("Compute BMI");
	
	// Constructor of BMI
	public BMI(){
		
		// Create panel p1 for the text fields and set GridLayout, 4 rows, 2 columns
		JPanel p1 = new JPanel(new GridLayout(4, 2));
		
		// Add labels and text fields to the panel 
		p1.add(new JLabel("Name"));
		p1.add(oname);
		p1.add(new JLabel("Age"));
		p1.add(oage);
		p1.add(new JLabel("Weight(kg)"));
		p1.add(oweight);
		p1.add(new JLabel("Height(m)"));
		p1.add(oheight);
		
		// Set title border to the panel
		p1.setBorder(new TitledBorder("Enter name, age, weight, and height"));
		
		// Create panel p2 for the button and set FlowLayout
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		// Add the button to the panel
		p2.add(computeBMI);
		
		// Create panel p3 for the text fields and set GridLayout, 2 rows, 2 columns 
		JPanel p3 = new JPanel(new GridLayout(2, 2));
		
		// Add labels and text fields to the panel
		p3.add(new JLabel("BMI"));
		p3.add(bmi);
		p3.add(new JLabel("Status"));
		p3.add(status);
		
		// Add panel p1, p2, p3 to the frame and set their location
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		add(p3, BorderLayout.SOUTH);
		
		// Register listener
		computeBMI.addActionListener((ActionListener) new ButtonListener());
	}
	
	// Handle the "computeBMI" button
	private class ButtonListener implements ActionListener{
		
		// Get value from text fields
		public void actionPerformed(ActionEvent e){
			double weight = Double.parseDouble(oweight.getText());
			double height = Double.parseDouble(oheight.getText());
			
			// Compute BMI
			double bmiGet = weight / (height * height);
			
			// Convert the value of BMI to String type and show to the user
			bmi.setText(String.format("%.3f", bmiGet));
			
			// Judge the value of BMI and show the status to the user
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
	
	/** Main method */
	public static void main(String[] args){
		BMI frame = new BMI(); // Create a frame
		frame.pack();
		frame.setSize(350, 235); // Size of the frame
		frame.setTitle("BMI"); // Name of the frame
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true); // Show the frame
	}
}
