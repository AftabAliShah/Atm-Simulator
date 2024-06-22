import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home_Screen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String cardNo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_Screen frame = new Home_Screen("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	public Home_Screen(String card) {
		this.cardNo = card;
		setForeground(new Color(0, 0, 0));

		setTitle("Form2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, -29, 675, 570);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);

		JButton btnWithdraw = new JButton("");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Withdraw_Screen(cardNo).setVisible(true);
			}
		});
		btnWithdraw.setIcon(new ImageIcon(Home_Screen.class.getResource("/Images/withdraw.png")));
		btnWithdraw.setBorder(null);
		btnWithdraw.setBackground(new Color(135, 206, 250));
		btnWithdraw.setBounds(90, 140, 110, 110);
		contentPane.add(btnWithdraw);

		JButton btnDeposit = new JButton("");
		btnDeposit.setIcon(new ImageIcon(Home_Screen.class.getResource("/Images/Deposit.png")));
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Deposit_Screen ds = new Deposit_Screen(cardNo);
				ds.setVisible(true);
			}
		});
		btnDeposit.setBorder(null);
		btnDeposit.setBackground(new Color(135, 206, 250));
		btnDeposit.setBounds(276, 140, 110, 110);
		contentPane.add(btnDeposit);

		JButton btnExit = new JButton("");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnExit.setIcon(new ImageIcon(Home_Screen.class.getResource("/Images/exittt.png")));
		btnExit.setBorder(null);
		btnExit.setBackground(new Color(135, 206, 250));
		btnExit.setBounds(609, 514, 40, 40);
		contentPane.add(btnExit);

		JButton btnChangePin = new JButton("");
		btnChangePin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Pin_Change pc = new Pin_Change(cardNo);
				pc.setVisible(true);
			}
		});
		btnChangePin.setIcon(new ImageIcon(Home_Screen.class.getResource("/Images/changepin.png")));
		btnChangePin.setBorder(null);
		btnChangePin.setBackground(new Color(135, 206, 250));
		btnChangePin.setBounds(90, 321, 110, 110);
		contentPane.add(btnChangePin);

		JButton btnWithDraw = new JButton("");
		btnWithDraw.setIcon(new ImageIcon(Home_Screen.class.getResource("/Images/statement.png")));
		btnWithDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				Mini_Statement ms = new Mini_Statement(cardNo);
				ms.setVisible(true);
			}
		});
		btnWithDraw.setBorder(null);
		btnWithDraw.setBackground(new Color(135, 206, 250));
		btnWithDraw.setBounds(473, 311, 110, 110);
		contentPane.add(btnWithDraw);

		JButton btnBalanceEnquiry = new JButton("");
		btnBalanceEnquiry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Balance_Enquiry be = new Balance_Enquiry(cardNo);
				be.setVisible(true);
			}
		});
		btnBalanceEnquiry.setIcon(new ImageIcon(Home_Screen.class.getResource("/Images/balanceenquiry.png")));
		btnBalanceEnquiry.setBorder(null);
		btnBalanceEnquiry.setBackground(new Color(135, 206, 250));
		btnBalanceEnquiry.setBounds(276, 311, 110, 110);
		contentPane.add(btnBalanceEnquiry);

		JButton btnFastCash = new JButton("");
		btnFastCash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Fast_Cash(cardNo).setVisible(true);
			}
		});
		btnFastCash.setIcon(new ImageIcon(Home_Screen.class.getResource("/Images/fastcash.png")));
		btnFastCash.setBorder(null);
		btnFastCash.setBackground(new Color(135, 206, 250));
		btnFastCash.setBounds(473, 140, 110, 110);
		contentPane.add(btnFastCash);

		JLabel lblHeading = new JLabel("HOME PAGE");
		lblHeading.setForeground(Color.BLACK);
		lblHeading.setFont(new Font("Segoe Print", Font.BOLD, 26));
		lblHeading.setBounds(286, 40, 171, 27);
		contentPane.add(lblHeading);

		JLabel lblExit = new JLabel("EXIT");
		lblExit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				setVisible(false);
			}
		});
		lblExit.setForeground(Color.BLACK);
		lblExit.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblExit.setBounds(569, 525, 40, 18);
		contentPane.add(lblExit);

		JLabel lblWithdraw = new JLabel("WITHDRAW");
		lblWithdraw.setForeground(Color.BLACK);
		lblWithdraw.setFont(new Font("SansSerif", Font.BOLD, 19));
		lblWithdraw.setBounds(90, 250, 110, 27);
		contentPane.add(lblWithdraw);

		JLabel lblDeposit = new JLabel("DEPOSIT");
		lblDeposit.setForeground(Color.BLACK);
		lblDeposit.setFont(new Font("SansSerif", Font.BOLD, 19));
		lblDeposit.setBounds(287, 250, 88, 27);
		contentPane.add(lblDeposit);

		JLabel lblFastCash = new JLabel("FAST CASH");
		lblFastCash.setForeground(Color.BLACK);
		lblFastCash.setFont(new Font("SansSerif", Font.BOLD, 19));
		lblFastCash.setBounds(473, 250, 110, 27);
		contentPane.add(lblFastCash);

		JLabel lblMini = new JLabel("MINI");
		lblMini.setForeground(Color.BLACK);
		lblMini.setFont(new Font("SansSerif", Font.BOLD, 19));
		lblMini.setBounds(508, 432, 40, 27);
		contentPane.add(lblMini);

		JLabel lblBalance = new JLabel("BALANCE");
		lblBalance.setForeground(Color.BLACK);
		lblBalance.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblBalance.setBounds(286, 433, 88, 27);
		contentPane.add(lblBalance);

		JLabel lblChange = new JLabel("CHANGE");
		lblChange.setForeground(Color.BLACK);
		lblChange.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblChange.setBounds(106, 438, 78, 27);
		contentPane.add(lblChange);

		JLabel lblEnquiry = new JLabel("ENQUIRY");
		lblEnquiry.setForeground(Color.BLACK);
		lblEnquiry.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblEnquiry.setBounds(289, 455, 83, 27);
		contentPane.add(lblEnquiry);

		JLabel lblPin = new JLabel("PIN");
		lblPin.setForeground(Color.BLACK);
		lblPin.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblPin.setBounds(130, 455, 30, 27);
		contentPane.add(lblPin);

		JLabel lblStatement = new JLabel("STATEMENT");
		lblStatement.setForeground(Color.BLACK);
		lblStatement.setFont(new Font("SansSerif", Font.BOLD, 19));
		lblStatement.setBounds(468, 455, 121, 27);
		contentPane.add(lblStatement);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Home_Screen.class.getResource("/Images/home1.png")));
		lblLogo.setForeground(Color.BLACK);
		lblLogo.setFont(new Font("SansSerif", Font.BOLD, 19));
		lblLogo.setBounds(226, 28, 50, 50);
		contentPane.add(lblLogo);
		
		JLabel btnLogout = new JLabel("LOG OUT");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new Login_Screen().setVisible(true);
			}
		});
		btnLogout.setForeground(new Color(255, 0, 0));
		btnLogout.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnLogout.setBounds(10, 11, 88, 18);
		contentPane.add(btnLogout);

	}
}
