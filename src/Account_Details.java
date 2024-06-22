import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.util.UUID;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;
import javax.swing.border.BevelBorder;

public class Account_Details extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDateChooser dateChooser;
	private JComboBox comboAccType;
	private JCheckBox chkPhBank;
	private JCheckBox chkInvestment;
	private JCheckBox chkDebit;
	private JCheckBox chkSms;
	private JCheckBox chkInsurance;
	private JCheckBox chkOnlineFund;
	private JComboBox comboIncome;

	String facility1 = "";
	String facility2 = "";
	String facility3 = "";
	String facility4 = "";
	String facility5 = "";
	String facility6 = "";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Account_Details frame = new Account_Details();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Account_Details() {
		setForeground(new Color(0, 0, 0));

		setTitle("Account Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, -13, 673, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPin = new JLabel("Pin Code :");
		lblPin.setForeground(new Color(0, 0, 0));
		lblPin.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblPin.setBounds(83, 302, 76, 21);
		contentPane.add(lblPin);

		JLabel lblIncome = new JLabel("Total Income :");
		lblIncome.setForeground(new Color(0, 0, 0));
		lblIncome.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblIncome.setBounds(83, 192, 100, 21);
		contentPane.add(lblIncome);

		JLabel lblOpeningDate = new JLabel("Opening Date :");
		lblOpeningDate.setForeground(new Color(0, 0, 0));
		lblOpeningDate.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblOpeningDate.setBounds(83, 248, 107, 21);
		contentPane.add(lblOpeningDate);

		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertData();
			}
		});
		btnSubmit.setForeground(new Color(245, 255, 250));
		btnSubmit.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btnSubmit.setBorder(null);
		btnSubmit.setBackground(Color.BLACK);
		btnSubmit.setBounds(275, 490, 107, 28);
		contentPane.add(btnSubmit);

		JLabel lblAccType = new JLabel("Account Type :");
		lblAccType.setForeground(new Color(0, 0, 0));
		lblAccType.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblAccType.setBounds(83, 135, 114, 18);
		contentPane.add(lblAccType);

		JLabel lblHeading = new JLabel("Page 2 : Account Details");
		lblHeading.setForeground(Color.BLACK);
		lblHeading.setFont(new Font("Segoe Print", Font.BOLD, 20));
		lblHeading.setBackground(new Color(224, 255, 255));
		lblHeading.setBounds(193, 35, 248, 54);
		contentPane.add(lblHeading);

		comboAccType = new JComboBox();
		comboAccType.setModel(new DefaultComboBoxModel(new String[] { "None", "Current Account", "Saving Account",
				"Mobile Account", "Salary Account", "Student Account", "Senior Citizen Account", "Bussiness Account",
				"Fixed Deposit Account", "Checking Account" }));
		comboAccType.setForeground(new Color(0, 0, 0));
		comboAccType.setFont(new Font("SansSerif", Font.BOLD, 14));
		comboAccType.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0),
				new Color(135, 206, 250), new Color(135, 206, 250)));
		comboAccType.setBackground(new Color(255, 255, 255));
		comboAccType.setBounds(195, 130, 320, 28);
		contentPane.add(comboAccType);

		chkDebit = new JCheckBox("Credit Card");
		chkDebit.setForeground(new Color(0, 0, 0));
		chkDebit.setBackground(new Color(135, 206, 235));
		chkDebit.setFont(new Font("SansSerif", Font.BOLD, 14));
		chkDebit.setBounds(195, 394, 107, 23);
		contentPane.add(chkDebit);

		chkSms = new JCheckBox("SMS Alerts");
		chkSms.setForeground(new Color(0, 0, 0));
		chkSms.setBackground(new Color(135, 206, 235));
		chkSms.setFont(new Font("SansSerif", Font.BOLD, 14));
		chkSms.setBounds(312, 394, 107, 23);
		contentPane.add(chkSms);

		chkInsurance = new JCheckBox("Insurances");
		chkInsurance.setForeground(new Color(0, 0, 0));
		chkInsurance.setBackground(new Color(135, 206, 235));
		chkInsurance.setFont(new Font("SansSerif", Font.BOLD, 14));
		chkInsurance.setBounds(195, 424, 107, 23);
		contentPane.add(chkInsurance);

		chkInvestment = new JCheckBox("Investments");
		chkInvestment.setForeground(new Color(0, 0, 0));
		chkInvestment.setBackground(new Color(135, 206, 235));
		chkInvestment.setFont(new Font("SansSerif", Font.BOLD, 14));
		chkInvestment.setBounds(312, 424, 114, 23);
		contentPane.add(chkInvestment);

		JLabel lblFacilities = new JLabel("Facilitites :");
		lblFacilities.setForeground(Color.BLACK);
		lblFacilities.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblFacilities.setBounds(83, 395, 76, 21);
		contentPane.add(lblFacilities);

		dateChooser = new JDateChooser();
		dateChooser.setFont(new Font("SansSerif", Font.BOLD, 14));
		dateChooser.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0),
				new Color(135, 206, 250), new Color(135, 206, 250)));
		dateChooser.getCalendarButton().setBackground(new Color(135, 206, 235));
		dateChooser.setBackground(new Color(135, 206, 235));
		dateChooser.setBounds(195, 244, 271, 28);
		contentPane.add(dateChooser);

		chkPhBank = new JCheckBox("Phone Banking");
		chkPhBank.setForeground(new Color(0, 0, 0));
		chkPhBank.setFont(new Font("SansSerif", Font.BOLD, 14));
		chkPhBank.setBackground(new Color(135, 206, 235));
		chkPhBank.setBounds(430, 424, 131, 23);
		contentPane.add(chkPhBank);

		chkOnlineFund = new JCheckBox("Online Fund Transfers");
		chkOnlineFund.setForeground(new Color(0, 0, 0));
		chkOnlineFund.setFont(new Font("SansSerif", Font.BOLD, 14));
		chkOnlineFund.setBackground(new Color(135, 206, 235));
		chkOnlineFund.setBounds(430, 394, 183, 23);
		contentPane.add(chkOnlineFund);

		JLabel lblCardNo = new JLabel("Card No :");
		lblCardNo.setForeground(Color.BLACK);
		lblCardNo.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCardNo.setBounds(83, 349, 76, 21);
		contentPane.add(lblCardNo);

		JLabel lblCardA = new JLabel("XXXX-XXXX-XXXX-XXXX");
		lblCardA.setForeground(Color.BLACK);
		lblCardA.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCardA.setBounds(195, 349, 168, 21);
		contentPane.add(lblCardA);

		JLabel lblPinA = new JLabel("XXXX");
		lblPinA.setForeground(Color.BLACK);
		lblPinA.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblPinA.setBounds(195, 302, 36, 21);
		contentPane.add(lblPinA);

		JLabel lblNote = new JLabel("Note : Pin Code and Card No. will be automatically generated");
		lblNote.setForeground(new Color(255, 0, 0));
		lblNote.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNote.setBounds(10, 540, 339, 21);
		contentPane.add(lblNote);

		comboIncome = new JComboBox();
		comboIncome.setModel(new DefaultComboBoxModel(
				new String[] { "0", "10000 > 50000", "51000 > 100000", "110000 > 200000", "More Than 200000" }));
		comboIncome.setForeground(Color.BLACK);
		comboIncome.setFont(new Font("SansSerif", Font.BOLD, 14));
		comboIncome.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0),

				new Color(135, 206, 250), new Color(135, 206, 250)));
		comboIncome.setBackground(Color.WHITE);
		comboIncome.setBounds(193, 188, 320, 28);
		contentPane.add(comboIncome);

	}

	private static String getCardNumber() {
		UUID uuid = UUID.randomUUID();
		String uuids = uuid.toString().replace("-", "");
		BigInteger big = new BigInteger(uuids, 16);
		String num = big.toString();
		return num.substring(0, 16);

	}

	private void insertData() {
		Random random = new Random();
		String pin = "" + (Math.abs((random.nextLong(10000 - 1000) + 1000)));

		if (chkInvestment.isSelected()) {
			facility1 = facility1 + "Investments,";
		} else {
			facility1 = "";

		}

		if (chkDebit.isSelected()) {
			facility2 = facility2 + "Credit Card,";
		} else {
			facility2 = "";

		}

		if (chkSms.isSelected()) {
			facility3 = facility3 + "Sms Alerts,";
		} else {
			facility3 = "";
		}

		if (chkInsurance.isSelected()) {
			facility4 = facility4 + "Insurances,";
		} else {
			facility4 = "";
		}

		if (chkOnlineFund.isSelected()) {
			facility5 = facility5 + "Online Fund Transfers,";
		} else {
			facility5 = "";
		}

		if (chkPhBank.isSelected()) {
			facility6 = facility6 + "Phone Banking";
		} else {
			facility6 = "";

		}

		if (comboAccType.getSelectedItem().toString().equalsIgnoreCase("none")) {
			JOptionPane.showMessageDialog(Account_Details.this, "Please Select the Account Type!", "Message",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (((JTextField) dateChooser.getDateEditor().getUiComponent()).getText().isEmpty()) {
			JOptionPane.showMessageDialog(Account_Details.this, "Please enter the opening date!", "Message",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else {

			String income = (String) comboIncome.getSelectedItem();
			String type = (String) comboAccType.getSelectedItem();
			String openingDate = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
			String cardno = getCardNumber();
			try {
				String query = "INSERT INTO accountdetails(pin,type,income,date,facilities,cardno)" + "values ('" + pin
						+ "','" + type + "','" + income + "','" + openingDate + "','" + facility1 + facility2
						+ facility3 + facility4 + facility5 + facility6 + "','" + cardno + "')";

				if (JOptionPane.showConfirmDialog(null, "Are you sure these details are correct?", "Account Details",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					DBConn con = new DBConn();
					con.statement.executeUpdate(query);
					JOptionPane.showMessageDialog(null,
							"Your Card No. is\n" + cardno + "\nYour Pin is \n" + pin + "\n" + "Please Remember it!");
					JOptionPane.showMessageDialog(null, "Details Successfully Added!");
					setVisible(false);
					new Deposit_Screen(cardno).setVisible(true);
				}

			}

			catch (Exception e) {
				e.printStackTrace();

			}
		}
	}

}
