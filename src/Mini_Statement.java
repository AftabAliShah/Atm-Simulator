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

public class Mini_Statement extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String cardNo;
	private JButton btnBack;
	private JLabel lblCardNo;
	private JLabel lblStatement;
	private JLabel lblBalance;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mini_Statement frame = new Mini_Statement("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Mini_Statement(String card) {
		this.cardNo = card;
		setForeground(new Color(0, 0, 0));

		setTitle("Mini Statement");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, -23, 470, 480);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);

		JLabel lblHeading = new JLabel("SYED'S BANK");
		lblHeading.setForeground(Color.BLACK);
		lblHeading.setFont(new Font("Segoe Print", Font.BOLD, 26));
		lblHeading.setBounds(164, 40, 185, 27);
		contentPane.add(lblHeading);

		btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				new Home_Screen(cardNo).setVisible(true);
			}
		});
		btnBack.setIcon(new ImageIcon(Mini_Statement.class.getResource("/Images/back.png")));
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

		lblCardNo = new JLabel("");
		lblCardNo.setForeground(new Color(0, 0, 0));
		lblCardNo.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblCardNo.setBounds(10, 108, 354, 21);
		contentPane.add(lblCardNo);

		lblStatement = new JLabel("");
		lblStatement.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatement.setForeground(new Color(0, 0, 0));
		lblStatement.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblStatement.setBounds(10, 140, 434, 247);
		contentPane.add(lblStatement);

		lblBalance = new JLabel("");
		lblBalance.setForeground(Color.BLACK);
		lblBalance.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblBalance.setBounds(10, 398, 409, 21);
		contentPane.add(lblBalance);
		getStatement();

	}

	private void getStatement() {
		int bal = 0;
		try {
			DBConn con = new DBConn();
			String query = "select acc_no from transactions where acc_no  = '" + cardNo + "'";
			ResultSet rs = con.statement.executeQuery(query);
			while (rs.next()) {
				lblCardNo.setText("Card No : " + rs.getString("acc_no").substring(0, 4) + "XXXXXXXX"
						+ rs.getString("acc_no").substring(12));

			}
			String query1 = "select * from transactions where acc_no = '" + cardNo + "' order by date desc limit 4";
			ResultSet rs1 = con.statement.executeQuery(query1);
			while (rs1.next()) {
				lblStatement.setText(lblStatement.getText() + "<html>" + rs1.getString("date") + "&nbsp;&nbsp;&nbsp;"
						+ rs1.getString("Type") + "&nbsp;&nbsp;&nbsp;" + rs1.getString("amount") + "<br><br><html>");
			}
			
			String query2 = "select * from transactions where acc_no = '" + cardNo + "'";
			ResultSet rs2 = con.statement.executeQuery(query2);
			while (rs2.next()) {
				if (rs2.getString("type").equalsIgnoreCase("deposit")) {
					bal += Integer.parseInt(rs2.getString("amount"));
				} else {
					bal -= Integer.parseInt(rs2.getString("amount"));
				}
				lblBalance.setText("Your Account Balance is :  " + bal);

		}
		} catch (Exception e1) {
			e1.printStackTrace();

	}

}
}
