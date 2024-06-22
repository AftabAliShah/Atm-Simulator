
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class Balance_Enquiry extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String cardNo;
	private JButton btnBack;
	private JLabel lblBalance;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Balance_Enquiry frame = new Balance_Enquiry("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Balance_Enquiry(String card) {
		this.cardNo = card;
		setForeground(new Color(0, 0, 0));

		setTitle("Balance Enquiry");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, -29, 435, 327);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);

		JLabel lblHeading = new JLabel("YOUR ACCOUNT BALANCE IS");
		lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeading.setForeground(Color.BLACK);
		lblHeading.setFont(new Font("SansSerif", Font.BOLD, 22));
		lblHeading.setBounds(50, 114, 319, 27);
		contentPane.add(lblHeading);

		btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Home_Screen(cardNo).setVisible(true);
			}
		});
		btnBack.setIcon(new ImageIcon(Balance_Enquiry.class.getResource("/Images/back.png")));
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

		lblBalance = new JLabel();
		lblBalance.setHorizontalAlignment(SwingConstants.CENTER);
		lblBalance.setForeground(Color.BLACK);
		lblBalance.setFont(new Font("SansSerif", Font.BOLD, 22));
		lblBalance.setBounds(132, 152, 155, 27);
		contentPane.add(lblBalance);
		getBalance();

	}

	private void getBalance() {
		int balance = 0;
		try {
			DBConn con = new DBConn();
			String query = "select * from transactions where acc_no = '" + cardNo + "'";
			ResultSet rs = con.statement.executeQuery(query);
			while (rs.next()) {
				if (rs.getString("type").equalsIgnoreCase("deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));
				} else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
				lblBalance.setText("" + balance);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
