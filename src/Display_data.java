import java.awt.EventQueue;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Display_data extends JFrame {
	public static void display_info()
	{
		try
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "12345");
			PreparedStatement pst = con.prepareStatement("select * from student order by rollno");
			ResultSet rs = pst.executeQuery();
			table_info.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e3)
		{
			System.out.println(e3);
		}
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTable table_info;

	/**
	 * Launch the application.
	 */
	public static void display() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display_data frame = new Display_data();
					frame.setVisible(true);
					display_info();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Display_data() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table_info = new JTable();
		table_info.setBounds(41, 25, 511, 379);
		contentPane.add(table_info);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(556, 25, 17, 379);
		contentPane.add(scrollBar);
		
		JLabel lblNewLabel = new JLabel("ROLL NO");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(54, 10, 91, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NAME");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(364, 10, 85, 13);
		contentPane.add(lblNewLabel_1);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options.main(null);
				setVisible(false);
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnBack.setBounds(97, 442, 130, 37);
		contentPane.add(btnBack);
	}
}
