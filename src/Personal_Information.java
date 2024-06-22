import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Personal_Information extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtFName;
	private JTextField txtPhone;
	private JTextField txtCity;
	private JTextField txtCnic;
	private JDateChooser dateChooser;
	private JTextField txtAddress;
	private JTextField txtEmail;
	private JComboBox comboGender;
	private JComboBox comboSource;
	private JComboBox comboMartial;
	private JComboBox comboQualification;
	private JLabel valid;
	private JLabel valid1;
	private JLabel valid2;
	private JLabel valid3;
	private JLabel valid4;
	private JLabel valid5;

	boolean validate = false;
	boolean validate1 = false;
	boolean validate2 = false;
	boolean validate3 = false;
	boolean validate4 = false;
	boolean validate5 = false;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Personal_Information frame = new Personal_Information();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Personal_Information() {
		setForeground(new Color(0, 0, 0));

		setTitle("Form1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, -13, 765, 645);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(255, 255, 255),
				new Color(255, 255, 255), new Color(255, 255, 255)));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(0, 0, 0));
		lblName.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblName.setBounds(70, 121, 47, 21);
		contentPane.add(lblName);

		txtName = new JTextField();
		txtName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				nameValid(txtName, valid);
			}
		});
		txtName.setForeground(new Color(0, 0, 0));
		txtName.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtName.setColumns(10);
		txtName.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0),
				new Color(135, 206, 250), new Color(135, 206, 250)));
		txtName.setBackground(new Color(255, 255, 255));
		txtName.setBounds(70, 143, 264, 28);
		contentPane.add(txtName);

		JLabel lblQualification = new JLabel("Qualification");
		lblQualification.setForeground(new Color(0, 0, 0));
		lblQualification.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblQualification.setBounds(70, 187, 93, 21);
		contentPane.add(lblQualification);

		JLabel lblCity = new JLabel("City");
		lblCity.setForeground(new Color(0, 0, 0));
		lblCity.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCity.setBounds(70, 254, 27, 21);
		contentPane.add(lblCity);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(new Color(0, 0, 0));
		lblAddress.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblAddress.setBounds(70, 320, 58, 21);
		contentPane.add(lblAddress);

		JLabel lblFName = new JLabel("Father's Name");
		lblFName.setForeground(new Color(0, 0, 0));
		lblFName.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblFName.setBounds(407, 121, 100, 21);
		contentPane.add(lblFName);

		txtFName = new JTextField();
		txtFName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				nameValid(txtFName, valid3);
			}
		});
		txtFName.setForeground(new Color(0, 0, 0));
		txtFName.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtFName.setColumns(10);
		txtFName.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0),
				new Color(135, 206, 250), new Color(135, 206, 250)));
		txtFName.setBackground(new Color(255, 255, 255));
		txtFName.setBounds(407, 143, 264, 28);
		contentPane.add(txtFName);

		JLabel lblDOB = new JLabel("Date Of Birth");
		lblDOB.setForeground(new Color(0, 0, 0));
		lblDOB.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDOB.setBounds(407, 320, 100, 21);
		contentPane.add(lblDOB);

		JLabel lblPhoneNo = new JLabel("Phone No.");
		lblPhoneNo.setForeground(new Color(0, 0, 0));
		lblPhoneNo.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblPhoneNo.setBounds(407, 254, 83, 21);
		contentPane.add(lblPhoneNo);

		txtPhone = new JTextField();
		txtPhone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				phoneValid(txtPhone, valid5);
			}
		});
		txtPhone.setForeground(new Color(0, 0, 0));
		txtPhone.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtPhone.setColumns(10);
		txtPhone.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0),
				new Color(135, 206, 250), new Color(135, 206, 250)));
		txtPhone.setBackground(new Color(255, 255, 255));
		txtPhone.setBounds(407, 276, 264, 28);
		contentPane.add(txtPhone);

		JLabel lblCnicNo = new JLabel("CNIC No.");
		lblCnicNo.setForeground(new Color(0, 0, 0));
		lblCnicNo.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCnicNo.setBounds(407, 187, 71, 21);
		contentPane.add(lblCnicNo);

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
		btnSubmit.setBounds(321, 546, 107, 28);
		contentPane.add(btnSubmit);

		txtCity = new JTextField();
		txtCity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				nameValid(txtCity, valid1);
			}
		});
		txtCity.setForeground(new Color(0, 0, 0));
		txtCity.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtCity.setColumns(10);
		txtCity.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0),
				new Color(135, 206, 250), new Color(135, 206, 250)));
		txtCity.setBackground(Color.WHITE);
		txtCity.setBounds(70, 276, 264, 28);
		contentPane.add(txtCity);

		txtCnic = new JTextField();
		txtCnic.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				cnicValid(txtCnic, valid4);
			}
		});
		txtCnic.setForeground(new Color(0, 0, 0));
		txtCnic.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtCnic.setColumns(10);
		txtCnic.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0),
				new Color(135, 206, 250), new Color(135, 206, 250)));
		txtCnic.setBackground(Color.WHITE);
		txtCnic.setBounds(407, 208, 264, 28);
		contentPane.add(txtCnic);

		JLabel lblMartial = new JLabel("Martial Status");
		lblMartial.setForeground(new Color(0, 0, 0));
		lblMartial.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblMartial.setBounds(407, 391, 100, 18);
		contentPane.add(lblMartial);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(new Color(0, 0, 0));
		lblGender.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblGender.setBounds(407, 459, 83, 18);
		contentPane.add(lblGender);

		comboGender = new JComboBox();
		comboGender.setModel(new DefaultComboBoxModel(new String[] { "None", "Male", "Female" }));
		comboGender.setForeground(new Color(0, 0, 0));
		comboGender.setFont(new Font("SansSerif", Font.BOLD, 14));
		comboGender.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0),
				new Color(135, 206, 250), new Color(135, 206, 250)));
		comboGender.setBackground(new Color(255, 255, 255));
		comboGender.setBounds(407, 480, 139, 28);
		contentPane.add(comboGender);

		JButton backBtn = new JButton("");
		backBtn.setIcon(new ImageIcon(Personal_Information.class.getResource("/Images/back.png")));
		backBtn.setForeground(new Color(105, 105, 105));

		Login_Screen ls = new Login_Screen();
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ls.setVisible(true);
			}
		});
		backBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		backBtn.setBorder(null);
		backBtn.setBackground(new Color(135, 206, 235));
		backBtn.setBounds(10, 11, 27, 27);
		contentPane.add(backBtn);

		JLabel lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				ls.setVisible(true);
			}
		});
		lblBack.setForeground(new Color(0, 0, 0));
		lblBack.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblBack.setBounds(43, 15, 40, 18);
		contentPane.add(lblBack);

		dateChooser = new JDateChooser();
		dateChooser.setFont(new Font("SansSerif", Font.BOLD, 14));
		dateChooser.getCalendarButton().setFont(new Font("SansSerif", Font.BOLD, 14));
		dateChooser.getCalendarButton().setBackground(new Color(0, 0, 0));
		dateChooser.getCalendarButton().setForeground(new Color(0, 0, 0));
		dateChooser.setBackground(new Color(135, 206, 235));
		dateChooser.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0),
				new Color(135, 206, 250), new Color(135, 206, 250)));
		dateChooser.setBounds(407, 342, 175, 28);
		contentPane.add(dateChooser);

		JLabel lblPage = new JLabel("Page 1 : Personal Details");
		lblPage.setForeground(Color.BLACK);
		lblPage.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblPage.setBackground(new Color(224, 255, 255));
		lblPage.setBounds(236, 35, 277, 54);
		contentPane.add(lblPage);

		txtAddress = new JTextField();
		txtAddress.setForeground(new Color(0, 0, 0));
		txtAddress.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtAddress.setColumns(10);
		txtAddress.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0),
				new Color(135, 206, 250), new Color(135, 206, 250)));
		txtAddress.setBackground(Color.WHITE);
		txtAddress.setBounds(70, 342, 264, 28);
		contentPane.add(txtAddress);

		comboMartial = new JComboBox();
		comboMartial.setModel(new DefaultComboBoxModel(new String[] { "None", "Married", "Unmarried" }));
		comboMartial.setForeground(new Color(0, 0, 0));
		comboMartial.setFont(new Font("SansSerif", Font.BOLD, 14));
		comboMartial.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0),
				new Color(135, 206, 250), new Color(135, 206, 250)));
		comboMartial.setBackground(new Color(255, 255, 255));
		comboMartial.setBounds(407, 412, 139, 28);
		contentPane.add(comboMartial);

		JLabel lblEmail = new JLabel("Email Address");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblEmail.setBounds(70, 391, 107, 21);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				emailValid(txtEmail, valid2);
			}
		});
		txtEmail.setForeground(Color.BLACK);
		txtEmail.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtEmail.setColumns(10);
		txtEmail.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0),
				new Color(135, 206, 250), new Color(135, 206, 250)));
		txtEmail.setBackground(Color.WHITE);
		txtEmail.setBounds(70, 412, 264, 28);
		contentPane.add(txtEmail);

		comboSource = new JComboBox();
		comboSource.setModel(new DefaultComboBoxModel(new String[] { "None", "Student", "Employed", "Unemployed" }));
		comboSource.setForeground(Color.BLACK);
		comboSource.setFont(new Font("SansSerif", Font.BOLD, 14));
		comboSource.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0),
				new Color(135, 206, 250), new Color(135, 206, 250)));
		comboSource.setBackground(new Color(255, 255, 255));
		comboSource.setBounds(70, 480, 218, 28);
		contentPane.add(comboSource);

		JLabel lblIncome = new JLabel("Source Of Income");
		lblIncome.setForeground(Color.BLACK);
		lblIncome.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblIncome.setBounds(70, 459, 125, 18);
		contentPane.add(lblIncome);

		valid = new JLabel("");
		valid.setBounds(344, 147, 20, 20);
		contentPane.add(valid);

		valid1 = new JLabel("");
		valid1.setBounds(344, 280, 20, 20);
		contentPane.add(valid1);

		valid5 = new JLabel("");
		valid5.setBounds(681, 280, 20, 20);
		contentPane.add(valid5);

		valid4 = new JLabel("");
		valid4.setBounds(681, 212, 20, 20);
		contentPane.add(valid4);

		valid3 = new JLabel("");
		valid3.setBounds(681, 147, 20, 20);
		contentPane.add(valid3);

		valid2 = new JLabel("");
		valid2.setBounds(344, 416, 20, 20);
		contentPane.add(valid2);

		comboQualification = new JComboBox();
		comboQualification.setModel(new DefaultComboBoxModel(new String[] { "None", "Matriculation (10 Years)",
				"Intermediate (12 Years)", "Graduation (14 Years)", "Masters ", "M.Phill", "P.H.D" }));
		comboQualification.setForeground(Color.BLACK);
		comboQualification.setFont(new Font("SansSerif", Font.BOLD, 14));
		comboQualification.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0),
				new Color(135, 206, 250), new Color(135, 206, 250)));
		comboQualification.setBackground(Color.WHITE);
		comboQualification.setBounds(70, 208, 264, 28);
		contentPane.add(comboQualification);

	}

	private void insertData() {
		if (txtName.getText().isEmpty() || txtFName.getText().isEmpty() || txtAddress.getText().isEmpty()
				|| txtCnic.getText().isEmpty() || txtPhone.getText().isEmpty() || txtCity.getText().isEmpty()
				|| ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText().isEmpty()) {
			JOptionPane.showMessageDialog(Personal_Information.this, "SomeThing Is Empty!", "Message",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else if (comboGender.getSelectedItem().toString().equalsIgnoreCase("None")
				|| comboMartial.getSelectedItem().toString().equalsIgnoreCase("None")
				|| comboSource.getSelectedItem().toString().equalsIgnoreCase("None")
				|| comboQualification.getSelectedItem().toString().equalsIgnoreCase("None")) {
			JOptionPane.showMessageDialog(Personal_Information.this, "Fill the All Choices!", "Message",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else if (!validate) {
			JOptionPane.showMessageDialog(Personal_Information.this, "Name is not valid ", "Message",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else if (!validate3) {
			JOptionPane.showMessageDialog(Personal_Information.this, "Father Name is not valid ", "Message",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else if (!validate1) {
			JOptionPane.showMessageDialog(Personal_Information.this, "City is not valid ", "Message",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else if (!validate5) {
			JOptionPane.showMessageDialog(Personal_Information.this, "Phone Number is not valid ", "Message",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else if (!validate4) {
			JOptionPane.showMessageDialog(Personal_Information.this, "CNIC is not valid ", "Message",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else if (!validate2) {
			JOptionPane.showMessageDialog(Personal_Information.this, "Email is not valid ", "Message",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else {

			String name = txtName.getText();
			String fName = txtFName.getText();
			String address = txtAddress.getText();
			String cnic = txtCnic.getText();
			String phone = txtPhone.getText();
			String qualification = (String) comboQualification.getSelectedItem();
			String city = txtCity.getText();
			String gender = (String) comboGender.getSelectedItem();
			String martial = (String) comboMartial.getSelectedItem();
			String source = (String) comboSource.getSelectedItem();
			String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

			try {

				String query = "INSERT INTO personalinformation (name,father_name,address,city,phone,cnic,qualification,gender,date_of_birth,source,martial)"
						+ "values ('" + name + "','" + fName + "','" + address + "','" + city + "','" + phone + "','"
						+ cnic + "','" + qualification + "','" + gender + "','" + dob + "','" + source + "','" + martial
						+ "')";
				

				if (JOptionPane.showConfirmDialog(null, "Are you sure these details are correct?", "Personal Information",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					DBConn con = new DBConn();
					con.statement.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Details Successfully Added!");
					setVisible(false);
					new Account_Details().setVisible(true);	
					}
			}

			catch (Exception e) {
				e.printStackTrace();

			}
		}
	}

	private void nameValid(JTextField field, JLabel label) {
		String regex = "^[a-zA-Z\\s]{0,30}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(field.getText());
		if (!matcher.matches()) {
			label.setIcon(new ImageIcon(Personal_Information.class.getResource("/Images/wrong.png")));

		} else {
			label.setIcon(new ImageIcon(Personal_Information.class.getResource("/Images/right.png")));
			validate = true;
			validate1 = true;
			validate3 = true;
		}
	}

	private void emailValid(JTextField field, JLabel label) {
		String regex = "[a-z\\d]+@+[a-z]+[.com]{4}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(field.getText());
		if (!matcher.matches()) {
			label.setIcon(new ImageIcon(Personal_Information.class.getResource("/Images/wrong.png")));

		} else {
			label.setIcon(new ImageIcon(Personal_Information.class.getResource("/Images/right.png")));
			validate2 = true;
		}
	}

	private void phoneValid(JTextField field, JLabel label) {
		String regex = "^923[0-4]\\d{8}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(field.getText());
		String regex1 = "^03[0-4]\\d{8}$";
		Pattern pattern1 = Pattern.compile(regex1);
		Matcher matcher1 = pattern1.matcher(field.getText());
		if (!matcher.matches() && !matcher1.matches()) {
			label.setIcon(new ImageIcon(Personal_Information.class.getResource("/Images/wrong.png")));

		} else {
			label.setIcon(new ImageIcon(Personal_Information.class.getResource("/Images/right.png")));
			validate5 = true;
		}
	}

	private void cnicValid(JTextField field, JLabel label) {
		String regex = "^\\d{13}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(field.getText());
		if (!matcher.matches()) {
			label.setIcon(new ImageIcon(Personal_Information.class.getResource("/Images/wrong.png")));

		} else {
			label.setIcon(new ImageIcon(Personal_Information.class.getResource("/Images/right.png")));
			validate4 = true;
		}
	}
}
