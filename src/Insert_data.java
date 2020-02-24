import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.sql.*;
public class Insert_data extends JFrame {
	
	public void insert_info() 
	{
		try {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","12345");
		PreparedStatement pst = conn.prepareStatement("insert into student values(?,?)");
		pst.setString(1, textField1.getText());
		pst.setString(2, textField2.getText());
		@SuppressWarnings("unused")
		int x = pst.executeUpdate();
		JOptionPane.showMessageDialog(null,"Information Inserted");
		}
		catch(Exception e2)
		{
			System.out.println(e2);
		}
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;

	/**
	 * Launch the application.
	 */
	public static void insert() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert_data frame = new Insert_data();
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
	public Insert_data() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRollNo = new JLabel("ROLL NO");
		lblRollNo.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblRollNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollNo.setBounds(71, 83, 87, 42);
		contentPane.add(lblRollNo);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(71, 180, 87, 42);
		contentPane.add(lblName);
		
		textField1 = new JTextField();
		textField1.setBounds(207, 85, 140, 42);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setBounds(207, 186, 140, 34);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					insert_info();
			}
		});
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSave.setBounds(71, 281, 97, 34);
		contentPane.add(btnSave);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options.main(null);
				setVisible(false);
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnBack.setBounds(246, 281, 101, 34);
		contentPane.add(btnBack);
	}
}
