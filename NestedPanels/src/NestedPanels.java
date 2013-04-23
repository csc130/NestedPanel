import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class NestedPanels {

	/**
	 * @param args
	 */
	private JButton panel1Button, panel2Button;
	private JLabel label1;
	private JPanel subPanel1, subPanel2;
	
	public NestedPanels() {
		// TODO Auto-generated method stub
		panel1Button = new JButton("Panel1");
		ButtonListener listener = new ButtonListener();
		panel1Button.addActionListener(listener);
		panel2Button = new JButton("Panel2");
		panel2Button.addActionListener(listener);
		
		JFrame frame = new JFrame("Nested Panels");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font font = new Font("ABIGAIL Medium",Font.BOLD, 20);
		
		label1 = new JLabel("Label1");
		label1.setFont(font);
		label1.setForeground(Color.CYAN);
	
		
		subPanel1 = new JPanel();
		subPanel1.setBackground(Color.green);
		subPanel1.setPreferredSize(new Dimension(200,200));
		//http://stackoverflow.com/questions/1783793/java-difference-between-the-setpreferredsize-and-setsize-methods-in-compone
		subPanel1.add(label1);
		
		//label1.setBounds(100, 100, 500, 500);
		subPanel1.add(panel2Button);
		
		subPanel2 = new JPanel();
		subPanel2.setBackground(Color.red);
		subPanel2.setPreferredSize(new Dimension(200,200));
		subPanel2.add(panel1Button);
		subPanel2.setVisible(false);
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.black);
		mainPanel.add(subPanel1);
		mainPanel.add(subPanel2);
		mainPanel.add(label1);
		frame.getContentPane().add(mainPanel);
		frame.pack();
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		new NestedPanels();
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand().equals("Panel1")) {
				subPanel1.setVisible(true);
				subPanel2.setVisible(false);
				label1.setText("Panel1");
			}else if(e.getActionCommand().equals("Panel2")) {
				subPanel2.setVisible(true);
				subPanel1.setVisible(false);
				label1.setText("Panel2");				
			}
		}
		
	}
}
