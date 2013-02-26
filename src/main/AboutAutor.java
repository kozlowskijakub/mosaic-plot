package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class AboutAutor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutAutor frame = new AboutAutor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AboutAutor() {
		setSize(new Dimension(300, 200));
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(12, 22, 44, 15);
		panel.add(lblAutor);

		JLabel lblJakubKozowski = new JLabel("Jakub Kozłowski");
		lblJakubKozowski.setBounds(111, 22, 114, 15);
		panel.add(lblJakubKozowski);

		JLabel lblEducation = new JLabel("Education:");
		lblEducation.setBounds(12, 47, 85, 15);
		panel.add(lblEducation);

		JLabel lblStudent = new JLabel("Student");
		lblStudent.setBounds(111, 47, 70, 15);
		panel.add(lblStudent);

		JButton btnCloase = new JButton("Close");
		btnCloase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				// System.exit(0);
			}
		});
		btnCloase.setBounds(159, 127, 117, 25);
		panel.add(btnCloase);
	}
}
