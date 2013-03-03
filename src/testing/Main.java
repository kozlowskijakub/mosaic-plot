package testing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JComboBox;
import javax.swing.JList;


import com.sun.java.swing.plaf.nimbus.ComboBoxComboBoxArrowButtonPainter;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnClear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1600, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		final JPanel panel = new JPanel();
		panel.setForeground(Color.black);
		contentPane.add(panel);
		panel.setLayout(null);
		getContentPane().setBackground(Color.red);

		final JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 12, 275, 240);
		panel.add(panel_1);

		JButton btnPaint = new JButton("Paint");

		btnPaint.setBounds(302, 174, 117, 25);
		panel.add(btnPaint);

		textField = new JTextField();
		textField.setText("0");
		textField.setBounds(302, 12, 114, 19);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setText("0");
		textField_1.setBounds(302, 43, 114, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setText("200");
		textField_2.setBounds(302, 74, 114, 19);
		panel.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setText("200");
		textField_3.setBounds(302, 105, 114, 19);
		panel.add(textField_3);
		textField_3.setColumns(10);

		btnClear = new JButton("Clear");

		btnClear.setBounds(302, 211, 117, 25);
		panel.add(btnClear);

		Color colors[] = { Color.black, Color.blue, Color.cyan, Color.darkGray, Color.gray, Color.green, Color.lightGray, Color.magenta, Color.orange,
				Color.pink, Color.red, Color.white, Color.yellow };

		final JComboBox comboBox = new JComboBox(colors);
		comboBox.setBounds(287, 136, 151, 25);
		panel.add(comboBox);
		for (int i = 0; i < comboBox.getItemCount(); i++) {

		}

		/**************************************************************************************************************************************************************************
		 * ACTIONS
		 **************************************************************************************************************************************************************************/
		btnPaint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paintJPanel(panel_1, comboBox,(Color)comboBox.getSelectedItem());
			}
		});
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear(panel_1);
			}
		});

		/**************************************************************************************************************************************************************************
		 * ACTIONS
		 **************************************************************************************************************************************************************************/
	}

	public void paintBackground(JComboBox cb, int i) {
		Graphics2D g = (Graphics2D) cb.getGraphics();
		Color c = (Color) cb.getItemAt(i);
		
	}

	public void paintJPanel(JPanel newPanel, JComboBox cb,Color c) {
		Dimension d = new Dimension(Integer.valueOf(textField_2.getText()), Integer.valueOf(textField_3.getText()));
		Point p = new Point(Integer.valueOf(textField.getText()), Integer.valueOf(textField_1.getText()));
		Painter myPainter = new Painter(newPanel, d, p,c);

	}

	public void clear(JPanel newPanel) {
		Painter myPainter = new Painter(newPanel);
	}
}

/*
 * 
 * 
 * 
 * EOF
 */

