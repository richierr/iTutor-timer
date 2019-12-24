package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class App extends JFrame {

	private JPanel contentPane;
	private JButton btn1Min;
	private JButton btn2Min;
	private JButton btn3Min;
	private JButton btn4Min;
	private JButton btn5Min;
	private JLabel lblTime=new JLabel("00:00");;
	private StopWatchClass stopw=new StopWatchClass(lblTime);
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
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
	public App() {
		stopw.setApp(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 109);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		btn3Min = new JButton("3 min");
		btn3Min.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopw.buttonPressed(Duration.THREEMIN);
			}
		});
		
		btn4Min = new JButton("4 min");
		btn4Min.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopw.buttonPressed(Duration.FOURMIN);
			}
		});
		

		
		btn5Min = new JButton("5 min");
		btn5Min.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopw.buttonPressed(Duration.FIVEMIN);
			}
		});
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel.setLayout(new GridLayout(0, 5, 5, 3));
		
		label = new JLabel("");
		panel.add(label);
		
		label_1 = new JLabel("");
		panel.add(label_1);
		panel.add(lblTime);
		
		btn2Min = new JButton("2 min");
		btn2Min.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopw.buttonPressed(Duration.TWOMIN);
			}
		});
		
		btn1Min = new JButton("1 min");
		
		btn1Min.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopw.buttonPressed(Duration.ONEMIN);
				
			}
		});
		
		label_2 = new JLabel("");
		panel.add(label_2);
		
		label_3 = new JLabel("");
		panel.add(label_3);
		panel.add(btn1Min);
		panel.add(btn2Min);
		panel.add(btn3Min);
		panel.add(btn4Min);
		panel.add(btn5Min);
	}
}
