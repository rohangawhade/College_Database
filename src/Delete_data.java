import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Delete_data extends JFrame {
	public static void delete_info()
	{
		try
		{
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "12345");
		String RNO;
		RNO=textField.getText();
		PreparedStatement pst = conn.prepareStatement("delete from student where rollno='"+RNO+"'");
		int x = pst.executeUpdate();
		if(x!=0)
		JOptionPane.showMessageDialog(null, "Data deleted");
		
		}
		catch(Exception e6)
		{
			System.out.println(e6);
		}
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField textField;
	private static JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void delete_data() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete_data frame = new Delete_data();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Delete_data() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRollno = new JLabel("ROLLNO");
		lblRollno.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblRollno.setBounds(45, 60, 86, 40);
		contentPane.add(lblRollno);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblName.setBounds(45, 161, 86, 35);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				try
				{
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","12345");
					String rollno2=textField.getText();
					String name2="";
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("select * from student where rollno='"+rollno2+"'");
					while(rs.next())
					{
						name2=rs.getString("name");
						textField_1.setText(name2);
					}
				}
				catch(Exception e5)
				{
					System.out.println(e5);
				}
			}
		});
		textField.setBounds(157, 60, 208, 45);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(157, 161, 208, 40);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("DELETE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_info();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(56, 242, 98, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options.main(null);
				setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.setBounds(257, 242, 98, 40);
		contentPane.add(btnNewButton_1);
	}
}
