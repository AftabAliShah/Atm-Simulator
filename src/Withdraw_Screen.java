import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.UIManager;

public class Withdraw_Screen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCash;
	String cardNo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Withdraw_Screen frame = new Withdraw_Screen("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Screen
	public Withdraw_Screen(String card) {
		this.cardNo = card;
		setTitle("Withdraw Screen");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(501, 319);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEnterAmount = new JLabel("Enter Amount :");
		lblEnterAmount.setForeground(new Color(0, 0, 0));
		lblEnterAmount.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblEnterAmount.setBounds(35, 133, 103, 19);
		contentPane.add(lblEnterAmount);

		JButton btnDeposit = new JButton("Withdraw");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertData();
			}
		});
		btnDeposit.setForeground(new Color(255, 255, 255));
		btnDeposit.setBackground(new Color(0, 0, 0));
		btnDeposit.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnDeposit.setBounds(212, 224, 103, 27);
		contentPane.add(btnDeposit);

		txtCash = new JTextField();
		txtCash.setForeground(new Color(0, 0, 0));
		txtCash.setBackground(new Color(135, 206, 235));
		txtCash.setBorder(null);
		txtCash.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtCash.setBounds(148, 127, 295, 30);
		contentPane.add(txtCash);
		txtCash.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(148, 160, 295, 9);
		contentPane.add(separator);

		JLabel lblDepositCash = new JLabel("CASH WITHDRAW");
		lblDepositCash.setForeground(Color.BLACK);
		lblDepositCash.setFont(new Font("Segoe Print", Font.BOLD, 20));
		lblDepositCash.setBounds(148, 28, 189, 27);
		contentPane.add(lblDepositCash);

		JButton backBtn = new JButton("");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Home_Screen(cardNo).setVisible(true);
			}
		});
		backBtn.setIcon(new ImageIcon(Withdraw_Screen.class.getResource("/Images/back.png")));
		backBtn.setForeground(UIManager.getColor("Button.darkShadow"));
		backBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		backBtn.setBorder(null);
		backBtn.setBackground(new Color(135, 206, 235));
		backBtn.setBounds(10, 11, 27, 27);
		contentPane.add(backBtn);

		JLabel lblBack = new JLabel("Back");
		lblBack.setForeground(Color.BLACK);
		lblBack.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblBack.setBounds(43, 15, 40, 18);
		contentPane.add(lblBack);
	}

	private void insertData() {
		String amount = txtCash.getText();
		Date date = new Date();
		int valid = Integer.parseInt(amount);
		if (valid % 500 != 0) {
			JOptionPane.showMessageDialog(Withdraw_Screen.this, "You Can Only Withdraw Multiples of 500 ", "Message",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else if (txtCash.getText().isEmpty()) {
			JOptionPane.showMessageDialog(Withdraw_Screen.this, "Please enter the amount! ", "Message",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else {

			try {

				DBConn con = new DBConn();

				String query1 = "select * from transactions where acc_no = '" + cardNo + "'";
				int balance = 0;
				ResultSet rs = con.statement.executeQuery(query1);
				while (rs.next()) {
					if (rs.getString("type").equalsIgnoreCase("deposit")) {
						balance += Integer.parseInt(rs.getString("amount"));
					} else {
						balance -= Integer.parseInt(rs.getString("amount"));
					}
				}

				if (balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(Withdraw_Screen.this, "Insufficent Balance in your account!",
							"Message", JOptionPane.ERROR_MESSAGE);
					return;
				} else {

					String query = "INSERT INTO transactions(acc_no,amount,date,type)" + "values ('" + cardNo + "','"
							+ amount + "','" + date + "','Withdraw')";

					if (JOptionPane.showConfirmDialog(null,
							"Are you sure this '" + txtCash.getText() + "' amount is correct?", "Withdraw_Screen",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {

						con.statement.executeUpdate(query);
						JOptionPane.showMessageDialog(null, txtCash.getText() + "Successfully Withdrawn");
						setVisible(false);
						new Home_Screen(cardNo).setVisible(true);

					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}
