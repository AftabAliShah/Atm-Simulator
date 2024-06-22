import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.UIManager;

public class Pin_Change extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passRePin;
	private JLabel icnEye;
	private JLabel icnHide;
	private JPasswordField passPin;
	String card;
	boolean validate = false;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pin_Change frame = new Pin_Change("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Screen Logic
	public Pin_Change(String cardNo) {
		this.card = cardNo;
		setBackground(new Color(135, 206, 235));
		setTitle("Change Pin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 483, 408);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(null);
		contentPane.setBackground(new Color(135, 206, 235));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);

		JLabel lblPin = new JLabel("New Pin");
		lblPin.setBackground(new Color(224, 255, 255));
		lblPin.setForeground(new Color(0, 0, 0));
		lblPin.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblPin.setBounds(56, 143, 68, 18);
		contentPane.add(lblPin);

		JLabel lblRePin = new JLabel("Re-Enter ");
		lblRePin.setBackground(new Color(224, 255, 255));
		lblRePin.setForeground(new Color(0, 0, 0));
		lblRePin.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblRePin.setBounds(56, 222, 68, 23);
		contentPane.add(lblRePin);

		passRePin = new JPasswordField();
		passRePin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pinValid(passRePin);
			}
		});
		passRePin.setEchoChar('*');
		passRePin.setBackground(new Color(255, 255, 255));
		passRePin.setForeground(new Color(0, 0, 0));
		passRePin.setFont(new Font("SansSerif", Font.BOLD, 14));
		passRePin.setBounds(130, 218, 262, 30);
		contentPane.add(passRePin);

		icnHide = new JLabel("");
		icnHide.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				icnEye.setVisible(true);
				icnHide.setVisible(false);
				passRePin.setEchoChar('*');
				passPin.setEchoChar('*');

			}
		});
		icnHide.setIcon(new ImageIcon(Pin_Change.class.getResource("/Images/hide.png")));
		icnHide.setBounds(410, 184, 25, 25);
		icnHide.setVisible(false);
		contentPane.add(icnHide);

		JButton btnChange = new JButton("CHANGE");
		btnChange.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnChange.setForeground(new Color(0, 0, 0));
				btnChange.setBackground(new Color(100, 149, 237));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnChange.setForeground(new Color(255, 255, 255));
				btnChange.setBackground(new Color(0, 0, 0));
			}
		});
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkCredientials();
			}
		});
		btnChange.setForeground(new Color(255, 255, 255));
		btnChange.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnChange.setBackground(new Color(0, 0, 0));
		btnChange.setBounds(194, 293, 89, 26);
		btnChange.setBorder(null);
		contentPane.add(btnChange);
		// Show Password
		icnEye = new JLabel("");
		icnEye.setIcon(new ImageIcon(Pin_Change.class.getResource("/Images/show.png")));
		icnEye.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				icnEye.setVisible(false);
				passRePin.setEchoChar((char) 0);
				passPin.setEchoChar((char) 0);
				icnHide.setVisible(true);
			}
		});
		icnEye.setBounds(410, 184, 25, 25);
		contentPane.add(icnEye);

		JLabel lblHeading = new JLabel("CHANGE YOUR PIN");
		lblHeading.setForeground(new Color(0, 0, 0));
		lblHeading.setFont(new Font("Segoe Print", Font.BOLD, 20));
		lblHeading.setBackground(new Color(224, 255, 255));
		lblHeading.setBounds(132, 28, 202, 54);
		contentPane.add(lblHeading);

		passPin = new JPasswordField();
		passPin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pinValid(passPin);
			}
		});
		passPin.setForeground(Color.BLACK);
		passPin.setFont(new Font("SansSerif", Font.BOLD, 14));
		passPin.setEchoChar('*');
		passPin.setBackground(Color.WHITE);
		passPin.setBounds(130, 137, 262, 30);
		contentPane.add(passPin);
		
		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Home_Screen(cardNo).setVisible(true);
			}
		});
		btnBack.setIcon(new ImageIcon(Pin_Change.class.getResource("/Images/back.png")));
		btnBack.setForeground(UIManager.getColor("Button.darkShadow"));
		btnBack.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnBack.setBorder(null);
		btnBack.setBackground(new Color(135, 206, 235));
		btnBack.setBounds(10, 11, 27, 27);
		contentPane.add(btnBack);
		
		JLabel lblBack = new JLabel("Back");
		lblBack.setForeground(Color.BLACK);
		lblBack.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblBack.setBounds(43, 15, 40, 18);
		contentPane.add(lblBack);
	}

	private void checkCredientials() {

		try {
			String pin = passPin.getText();
			String pin1 = passRePin.getText();
			if (!pin1.equals(pin)) {
				JOptionPane.showMessageDialog(Pin_Change.this, "Pins Doesn't Match", "Message",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (passPin.getText().isEmpty() || passRePin.getText().isEmpty()) {
				JOptionPane.showMessageDialog(Pin_Change.this, "Please fill the all fields", "Message",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (!validate) {
				JOptionPane.showMessageDialog(Pin_Change.this, "Character not allowed\nOnly 4 Numbers Allowed! ", "Message",
						JOptionPane.ERROR_MESSAGE);
				return;
			} else {

				String query = "update accountdetails set pin = '" + pin1 + "' where cardno = '" + card + "'";
				DBConn conn = new DBConn();
				conn.statement.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Pin Updated Successfully");
				setVisible(false);
				Home_Screen hs = new Home_Screen(card);
				hs.setVisible(true);

			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	private void pinValid(JPasswordField field) {
		String regex = "^\\d{4}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(field.getText());
		if (!matcher.matches()) {
			validate = false;
		} else {
			validate = true;
		}
	}
}