import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class Login_Screen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCardNo;
	private JPasswordField txtPin;
	private JLabel icnEye;
	private JLabel icnHide;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Screen frame = new Login_Screen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Screen Logic
	public Login_Screen() {
		setBackground(new Color(135, 206, 235));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 483, 443);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(null);
		contentPane.setBackground(new Color(135, 206, 235));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCardNo = new JLabel("Card No :");
		lblCardNo.setBackground(new Color(224, 255, 255));
		lblCardNo.setForeground(new Color(0, 0, 0));
		lblCardNo.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCardNo.setBounds(41, 143, 68, 18);
		contentPane.add(lblCardNo);

		txtCardNo = new JTextField();
		txtCardNo.setColumns(10);
		txtCardNo.setBackground(new Color(135, 206, 235));
		txtCardNo.setForeground(new Color(0, 0, 0));
		txtCardNo.setBorder(null);
		txtCardNo.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtCardNo.setBounds(133, 139, 292, 30);
		contentPane.add(txtCardNo);

		JLabel lblPin = new JLabel("PIn Code :");
		lblPin.setBackground(new Color(224, 255, 255));
		lblPin.setForeground(new Color(0, 0, 0));
		lblPin.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblPin.setBounds(41, 222, 75, 23);
		contentPane.add(lblPin);

		txtPin = new JPasswordField();
		txtPin.setEchoChar('*');
		txtPin.setBackground(new Color(135, 206, 235));
		txtPin.setForeground(new Color(0, 0, 0));
		txtPin.setBorder(null);
		txtPin.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtPin.setBounds(133, 218, 262, 30);
		contentPane.add(txtPin);

		 icnHide = new JLabel("");
		icnHide.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				icnEye.setVisible(true);
				icnHide.setVisible(false);
				txtPin.setEchoChar('*');
				
			}
		});
		icnHide.setIcon(new ImageIcon(Login_Screen.class.getResource("/Images/hide.png")));
		icnHide.setBounds(400, 222, 25, 25);
		icnHide.setVisible(false);
		contentPane.add(icnHide);
		
		JButton btnLogin = new JButton("SIGN IN");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setForeground(new Color(0, 0, 0));
				btnLogin.setBackground(new Color(100, 149, 237));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnLogin.setForeground(new Color(255, 255, 255));
				btnLogin.setBackground(new Color(0, 0, 0));
			}
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkCredientials();
			}
		});
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnLogin.setBackground(new Color(0, 0, 0));
		btnLogin.setBounds(204, 293, 89, 26);
		btnLogin.setBorder(null);
		contentPane.add(btnLogin);
		// Show Password
		icnEye = new JLabel("");
		icnEye.setIcon(new ImageIcon(Login_Screen.class.getResource("/Images/show.png")));
		icnEye.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				icnEye.setVisible(false);
				txtPin.setEchoChar((char) 0);
				icnHide.setVisible(true);
			}
		});
		icnEye.setBounds(400, 222, 25, 25);
		contentPane.add(icnEye);

		JButton btnRegister = new JButton("Create account?");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegister.setForeground(new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnRegister.setForeground(new Color(0, 0, 0));
			}
		});
		// changing the screen while pressing register button.
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
                Personal_Information pi = new Personal_Information();
                pi.setVisible(true);
			}
		});
		btnRegister.setBackground(new Color(135, 206, 235));
		btnRegister.setBorder(null);
		btnRegister.setForeground(new Color(0, 0, 0));
		btnRegister.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnRegister.setBounds(327, 355, 118, 15);
		contentPane.add(btnRegister);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(133, 170, 292, 8);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(0, 0, 0));
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBounds(133, 252, 292, 8);
		contentPane.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(328, 370, 116, 23);
		contentPane.add(separator_2);


		JLabel lblHeading = new JLabel("Welcome to Bank Management System");
		lblHeading.setForeground(new Color(0, 0, 0));
		lblHeading.setFont(new Font("Segoe Print", Font.BOLD, 20));
		lblHeading.setBackground(new Color(224, 255, 255));
		lblHeading.setBounds(37, 28, 392, 54);
		contentPane.add(lblHeading);
	}

	private void checkCredientials() {

		try {
			String cardNo = txtCardNo.getText();
			String pin = txtPin.getText();
			String query = "select * from accountdetails where cardno = '" + cardNo + "' and pin = '" + pin + "'";
			DBConn conn = new DBConn();
			ResultSet rs = conn.statement.executeQuery(query);
			if (rs.next()) {
				setVisible(false);
				Home_Screen hs = new Home_Screen(cardNo);
				hs.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Card Number OR Pin Is Incorrect");
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}