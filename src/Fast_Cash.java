import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class Fast_Cash extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String cardNo;
	private JButton btn500;
	private JButton btn1000;
	private JButton btn2000;
	private JButton btn3000;
	private JButton btn5000;
	private JButton btn8000;
	private JButton btn10000;
	private JButton btn20000;
	private JButton btnBack;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fast_Cash frame = new Fast_Cash("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Fast_Cash(String card) {
		this.cardNo = card;
		setForeground(new Color(0, 0, 0));

		setTitle("Fast Cash");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, -29, 397, 480);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);

		btn500 = new JButton("Rs 500");
		btn500.setFont(new Font("SansSerif", Font.BOLD, 15));
		btn500.setForeground(new Color(255, 255, 255));
		btn500.setBorder(null);
		btn500.setBackground(new Color(0, 0, 0));
		btn500.setBounds(64, 113, 94, 40);
		btn500.addActionListener(this);
		contentPane.add(btn500);

		JLabel lblHeading = new JLabel("FAST CASH");
		lblHeading.setForeground(Color.BLACK);
		lblHeading.setFont(new Font("Segoe Print", Font.BOLD, 26));
		lblHeading.setBounds(113, 40, 155, 27);
		contentPane.add(lblHeading);

		btn1000 = new JButton("Rs 1000");
		btn1000.setFont(new Font("SansSerif", Font.BOLD, 15));
		btn1000.setForeground(Color.WHITE);
		btn1000.setBorder(null);
		btn1000.setBackground(Color.BLACK);
		btn1000.setBounds(222, 113, 94, 40);
		btn1000.addActionListener(this);
		contentPane.add(btn1000);

		btn3000 = new JButton("Rs 3000");
		btn3000.setFont(new Font("SansSerif", Font.BOLD, 15));
		btn3000.setForeground(Color.WHITE);
		btn3000.setBorder(null);
		btn3000.setBackground(Color.BLACK);
		btn3000.setBounds(222, 191, 94, 40);
		btn3000.addActionListener(this);
		contentPane.add(btn3000);

		btn2000 = new JButton("Rs 2000");
		btn2000.setFont(new Font("SansSerif", Font.BOLD, 15));
		btn2000.setForeground(Color.WHITE);
		btn2000.setBorder(null);
		btn2000.setBackground(Color.BLACK);
		btn2000.setBounds(64, 191, 94, 40);
		btn2000.addActionListener(this);
		contentPane.add(btn2000);

		btn20000 = new JButton("Rs 20000");
		btn20000.setFont(new Font("SansSerif", Font.BOLD, 15));
		btn20000.setForeground(Color.WHITE);
		btn20000.setBorder(null);
		btn20000.setBackground(Color.BLACK);
		btn20000.setBounds(222, 343, 94, 40);
		btn20000.addActionListener(this);
		contentPane.add(btn20000);

		btn10000 = new JButton("Rs 10000");
		btn10000.setFont(new Font("SansSerif", Font.BOLD, 15));
		btn10000.setForeground(Color.WHITE);
		btn10000.setBorder(null);
		btn10000.setBackground(Color.BLACK);
		btn10000.setBounds(64, 343, 94, 40);
		btn10000.addActionListener(this);
		contentPane.add(btn10000);

		btn8000 = new JButton("Rs 8000");
		btn8000.setFont(new Font("SansSerif", Font.BOLD, 15));
		btn8000.setForeground(Color.WHITE);
		btn8000.setBorder(null);
		btn8000.setBackground(Color.BLACK);
		btn8000.setBounds(222, 265, 94, 40);
		btn8000.addActionListener(this);
		contentPane.add(btn8000);

		btn5000 = new JButton("Rs 5000");
		btn5000.setFont(new Font("SansSerif", Font.BOLD, 15));
		btn5000.setForeground(Color.WHITE);
		btn5000.setBorder(null);
		btn5000.setBackground(Color.BLACK);
		btn5000.setBounds(64, 265, 94, 40);
		btn5000.addActionListener(this);
		contentPane.add(btn5000);

		btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(Fast_Cash.class.getResource("/Images/back.png")));
		btnBack.setForeground(UIManager.getColor("Button.darkShadow"));
		btnBack.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnBack.setBorder(null);
		btnBack.setBackground(new Color(135, 206, 235));
		btnBack.setBounds(10, 11, 27, 27);
		btnBack.addActionListener(this);
		contentPane.add(btnBack);

		JLabel lblBack = new JLabel("Back");
		lblBack.setForeground(Color.BLACK);
		lblBack.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblBack.setBounds(43, 15, 40, 18);
		contentPane.add(lblBack);

	}
	

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnBack) {
			setVisible(false);
			new Home_Screen(cardNo).setVisible(true);
		} else {
			String amount = ((JButton) ae.getSource()).getText().substring(3); // Rs 1000
			try {
				DBConn con = new DBConn();
				String query = "select * from transactions where acc_no = '" + cardNo + "'";
				int balance = 0;
				ResultSet rs = con.statement.executeQuery(query);
				while (rs.next()) {
					if (rs.getString("type").equalsIgnoreCase("deposit")) {
						balance += Integer.parseInt(rs.getString("amount"));
					} else {
						balance -= Integer.parseInt(rs.getString("amount"));
					}
				}
				if (ae.getSource() != btnBack && balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(Fast_Cash.this, "Insufficent Balance in your account!", "Message",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				Date date = new Date();
				String query1 = "INSERT INTO transactions(acc_no,amount,date,type) values ('" + cardNo + "','" + amount
						+ "','" + date + "','Withdraw')";
				con.statement.executeUpdate(query1);
				JOptionPane.showMessageDialog(null, "'" + amount + "' Successfully Withdrawn");
				setVisible(false);
				new Home_Screen(cardNo).setVisible(true);

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

	}
}
