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
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	DataContainer myContainer = null;
	FilePathContainer myPath = new FilePathContainer();
	final JMenuBar menuBar;
	final JTextArea textArea;
	final JLabel lblStatusValue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1600, 100, 480, 480);

		menuBar = new JMenuBar();
		textArea = new JTextArea();
		JPanel panel = new JPanel();
		JPanel statusPanel = new JPanel();
		JLabel lblStatus = new JLabel("Path: ");
		lblStatusValue = new JLabel("/home/jakub/Pulpit/mosaic4.txt");
		JButton btnndLoad = new JButton("2nd Load");
		JPanel panel_1 = new JPanel();
		JLabel statusLabel = new JLabel();

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

		panel.setBackground(Color.GRAY);
		contentPane.add(panel);

		statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		getContentPane().add(statusPanel, BorderLayout.SOUTH);
		statusPanel.setPreferredSize(new Dimension(this.getWidth(), 22));
		statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));

		statusPanel.add(lblStatus);

		statusPanel.add(lblStatusValue);

		statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
		statusPanel.add(statusLabel);

		btnndLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadFlatData();
			}
		});

		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTableData();
			}
		});

		JPanel panel_2 = new JPanel();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(
				gl_panel.createSequentialGroup().addGap(5).addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(5).addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE).addGap(5)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(
				Alignment.LEADING,
				gl_panel.createSequentialGroup()
						.addGap(5)
						.addGroup(
								gl_panel.createParallelGroup(Alignment.LEADING).addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
										.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGap(5)));

		JButton btnThird = new JButton("Third");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_panel_1
						.createSequentialGroup()
						.addGroup(
								gl_panel_1
										.createParallelGroup(Alignment.TRAILING)
										.addGroup(
												Alignment.LEADING,
												gl_panel_1.createSequentialGroup().addContainerGap()
														.addComponent(btnThird, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
										.addGroup(
												Alignment.LEADING,
												gl_panel_1.createSequentialGroup().addContainerGap()
														.addComponent(btnndLoad, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
										.addGroup(
												Alignment.LEADING,
												gl_panel_1.createSequentialGroup().addContainerGap()
														.addComponent(btnLoad, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGap(20)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(
				gl_panel_1.createSequentialGroup().addGap(11).addComponent(btnThird).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnLoad)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnndLoad).addGap(281)));
		panel_1.setLayout(gl_panel_1);
		panel_2.setLayout(null);
		panel.setLayout(gl_panel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 246, 367);
		panel_2.add(scrollPane);

		scrollPane.setViewportView(textArea);

		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);

		setVisible(true);

		/**************************************************************************************************************************
		 * 
		 * START ACTIONS
		 * 
		 **************************************************************************************************************************/
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

			/**************************************************************************************************************************
			 * 
			 * SYSTEM PLATFORM DETECTION
			 * 
			 **************************************************************************************************************************/
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
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		/**************************************************************************************************************************
		 * 
		 * END ACTIONS
		 * 
		 **************************************************************************************************************************/
	}

	public void loadFlatData() {
		try {
			Reader reader = new Reader();
			String[][] tab = reader.readTo2DTable(lblStatusValue.getText());
			DataContainer container = new DataContainer(tab);
			Display display = new Display(container.getData(), textArea);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Select proper file to load.");
		}
	}

	public void loadTableData() {
		try {
			Reader reader = new Reader();
			String[][] tab = reader.readReadyTable(lblStatusValue.getText());
			DataContainer container = new DataContainer(tab);
			Display display = new Display(container.getData(), textArea);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Select proper file to load.");
		}
	}
}
