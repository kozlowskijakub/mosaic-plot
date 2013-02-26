package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;

public class MyFrame extends JFrame {

	private JPanel contentPane;
	DataContainer myContainer = new DataContainer();
	FilePathContainer myPath = new FilePathContainer();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame();
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
	public MyFrame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1600, 100, 480, 480);

		final JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmLoad = new JMenuItem("Load");
		mnFile.add(mntmLoad);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmAutor = new JMenuItem("About Autor");
		mnHelp.add(mntmAutor);

		JMenuItem mntmAboutProgram = new JMenuItem("About Program");
		mnHelp.add(mntmAboutProgram);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setLayout(null);
		contentPane.add(panel);

		JButton btnLoad = new JButton("Load");
		btnLoad.setBounds(328, 12, 128, 21);
		panel.add(btnLoad);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 264, 251);
		panel.add(scrollPane);

		final JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane.setViewportView(textArea);

		JButton btnPaint = new JButton("Paint");
		btnPaint.setBounds(328, 45, 128, 21);
		panel.add(btnPaint);

		JPanel statusPanel = new JPanel();
		statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		getContentPane().add(statusPanel, BorderLayout.SOUTH);
		statusPanel.setPreferredSize(new Dimension(this.getWidth(), 22));
		statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));

		JLabel lblStatus = new JLabel("Path: ");
		statusPanel.add(lblStatus);

		final JLabel lblStatusValue = new JLabel("path");
		statusPanel.add(lblStatusValue);

		JLabel statusLabel = new JLabel();
		statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
		statusPanel.add(statusLabel);

		setVisible(true);

		/************************************************************* START ACTIONS *************************************************************/
		mntmLoad.addActionListener(new ActionListener() {
			private String OS = System.getProperty("os.name").toLowerCase();

			public void actionPerformed(ActionEvent e) {
				TreeFrame loadData = null;
				if (isWindows()) {
					loadData = new TreeFrame("\\", myPath, lblStatusValue);
				} else if (isUnix()) {
					loadData = new TreeFrame("/", myPath, lblStatusValue);
				}
				loadData.setVisible(true);
				loadData.setLocationRelativeTo(menuBar);
			}

			public boolean isWindows() {
				return (OS.indexOf("win") >= 0);
			}

			public boolean isUnix() {
				return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);
			}
		});
		mntmAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutAutor aboutAutor = new AboutAutor();
				aboutAutor.setVisible(true);
				aboutAutor.setLocationRelativeTo(menuBar);
			}
		});
		mntmAboutProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutProgram aboutProgram = new AboutProgram();
				aboutProgram.setVisible(true);
				aboutProgram.setLocationRelativeTo(menuBar);
			}
		});
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reader reader = new Reader();
				reader.readToDataContainer(lblStatusValue.getText(), myContainer);

				Display display = new Display(myContainer, textArea);
			}
		});
		btnPaint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblStatusValue.setText(myPath.getFilePath());
			}
		});
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		/************************************************************* END ACTIONS *************************************************************/
	}
}
