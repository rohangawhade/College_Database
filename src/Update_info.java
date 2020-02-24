import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;



public class Update_info extends JFrame {
	public static void update_data()
	{
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","12345");
			String NAME,RNO;
			NAME=name_field.getText();
			RNO=rno_field.getText();
			Statement st = con.createStatement();
			int x = st.executeUpdate("update student set name='"+NAME+"' where rollno='"+RNO+"'");
			if(x!=0)
			{
				JOptionPane.showMessageDialog(null, "Updated successfully");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"No such data exists");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField rno_field;
	private static JTextField name_field;

	/**
	 * Launch the application.
	 */
	public static void update() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_info frame = new Update_info();
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
	public Update_info() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRollno = new JLabel("Rollno");
		lblRollno.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollno.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblRollno.setBounds(30, 60, 87, 47);
		contentPane.add(lblRollno);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblName.setBounds(30, 155, 87, 47);
		contentPane.add(lblName);
		
		rno_field = new JTextField();
		rno_field.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				try{Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","12345");
				Statement st = con.createStatement();
				String RNO;
				String NAME="";
				RNO=rno_field.getText();
				ResultSet rs = st.executeQuery("select * from student where rollno='"+RNO+"'");
				while(rs.next())
				{
					NAME=rs.getString("name");
				}
				rno_field.setText(RNO);
				name_field.setText(NAME);
				}
				catch(Exception e4)
				{
					System.out.println(e);
				}
			}
		});
		rno_field.setBounds(163, 62, 145, 47);
		contentPane.add(rno_field);
		rno_field.setColumns(10);
		
		name_field = new JTextField();
		name_field.setBounds(163, 163, 148, 47);
		contentPane.add(name_field);
		name_field.setColumns(10);
		
		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update_data();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(30, 257, 145, 47);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options.main(null);
				setVisible(false);
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnBack.setBounds(232, 257, 135, 47);
		contentPane.add(btnBack);
	}
}
