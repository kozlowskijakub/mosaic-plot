package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AboutProgram extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					AboutProgram frame = new AboutProgram();
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
	public AboutProgram() {
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(300, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblProgramHasBeen = new JLabel(
				"Has been designed for general purpose.");
		lblProgramHasBeen.setFont(new Font("Dialog", Font.BOLD, 10));
		lblProgramHasBeen.setBounds(0, 30, 288, 15);
		panel.add(lblProgramHasBeen);

		JLabel lblTheMosaicPlot = new JLabel("The mosaic plot chart program:");
		lblTheMosaicPlot.setBounds(0, 12, 288, 15);
		panel.add(lblTheMosaicPlot);

		JLabel lblIsFreeFor = new JLabel("Is free for non-comercial usage.");
		lblIsFreeFor.setFont(new Font("Dialog", Font.BOLD, 10));
		lblIsFreeFor.setBounds(0, 48, 288, 15);
		panel.add(lblIsFreeFor);

		JLabel lblUsesJavaSwing = new JLabel("Uses java swing library .");
		lblUsesJavaSwing.setFont(new Font("Dialog", Font.BOLD, 10));
		lblUsesJavaSwing.setBounds(0, 67, 288, 15);
		panel.add(lblUsesJavaSwing);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(159, 127, 117, 25);
		panel.add(btnClose);
	}
}
