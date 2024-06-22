
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
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.UIManager;

public class Deposit_Screen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCash;
	String cardNo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposit_Screen frame = new Deposit_Screen("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Screen
	public Deposit_Screen(String card) {
		this.cardNo = card;
		setTitle("Deposit Screen");

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

		JButton btnDeposit = new JButton("Deposit");
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

		JLabel lblDepositCash = new JLabel("DEPOSIT CASH");
		lblDepositCash.setForeground(Color.BLACK);
		lblDepositCash.setFont(new Font("Segoe Print", Font.BOLD, 20));
		lblDepositCash.setBounds(163, 28, 159, 27);
		contentPane.add(lblDepositCash);

		JButton backBtn = new JButton("");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Home_Screen(cardNo).setVisible(true);
			}
		});
		backBtn.setIcon(new ImageIcon(Deposit_Screen.class.getResource("/Images/back.png")));
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
		int amountValid = Integer.parseInt(amount);

		if (amountValid % 500 != 0 || amountValid < 1000) {
			JOptionPane.showMessageDialog(Deposit_Screen.this,
					"You Can Only Deposit Multiples of 500 and Deposit Starting from 1000 ", "Message",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else if (txtCash.getText().isEmpty()) {
			JOptionPane.showMessageDialog(Deposit_Screen.this, "Please enter the amount! ", "Message",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else {

			try {
				
				
				String query = "INSERT INTO transactions(acc_no,amount,date,type)" + "values ('" + cardNo + "','"
						+ amount + "','" + date + "','Deposit')";
				if (JOptionPane.showConfirmDialog(null,
						"Are you sure this '" + txtCash.getText() + "' amount is correct?", "Deposit_Cash",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {

					DBConn con = new DBConn();
					con.statement.executeUpdate(query);
					JOptionPane.showMessageDialog(null, txtCash.getText() + " Amount Sucessfully Deposited!");
					setVisible(false);
					new Home_Screen(cardNo).setVisible(true);

				}

			} catch (Exception e) {
				e.printStackTrace();

			}
		}

	}
}
