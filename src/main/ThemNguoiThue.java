package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class ThemNguoiThue extends JFrame {

	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtQueQuan;
	private JTextField txtCmt;
	private JTextField txtSoNguoi;
	private JComboBox cbNamSinh;
	private JComboBox cbPhong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemNguoiThue frame = new ThemNguoiThue();
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
	public static boolean isNumeric(String strNum) {
	    return strNum.matches("-?\\d+(\\.\\d+)?");
	}	
	
	public ThemNguoiThue() {
		setTitle("Th\u00EAm ng\u01B0\u1EDDi thu\u00EA");
		setBounds(100, 100, 492, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblTn = new JLabel("T\u00EAn:");
		lblTn.setBounds(15, 30, 49, 18);
		lblTn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblPhngThu = new JLabel("Ph\u00F2ng thu\u00EA:");
		lblPhngThu.setBounds(15, 175, 110, 18);
		lblPhngThu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblSNgi = new JLabel("S\u1ED1 ng\u01B0\u1EDDi:");
		lblSNgi.setBounds(15, 205, 76, 18);
		lblSNgi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblWifi = new JLabel("Wifi:");
		lblWifi.setBounds(15, 234, 109, 18);
		lblWifi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JButton btnNewButton = new JButton("Th\u00EAm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtTen.getText().equals("") || txtQueQuan.getText().equals("") || txtCmt.getText().equals("") || txtSoNguoi.getText().equals(""))
					JOptionPane.showMessageDialog(txtCmt, "Vui lòng điền đủ thông tin cần thiết");
				else {
					if (!isNumeric(txtCmt.getText()))
						JOptionPane.showMessageDialog(txtCmt, "Số CMT phải là các chữ số!");
					else
					{
						JOptionPane.showMessageDialog(txtCmt, "ok");
					}
				}
					
				
			}
		});
		btnNewButton.setBounds(187, 264, 93, 33);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblNmSinh = new JLabel("N\u0103m sinh:");
		lblNmSinh.setBounds(15, 58, 119, 18);
		lblNmSinh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblQuQun = new JLabel("Qu\u00EA qu\u00E1n");
		lblQuQun.setBounds(15, 102, 74, 18);
		lblQuQun.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblNewLabel = new JLabel("Ch\u1EE9ng minh th\u01B0: ");
		lblNewLabel.setBounds(15, 143, 110, 18);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		txtTen = new JTextField();
		txtTen.setBounds(187, 30, 222, 20);
		txtTen.setColumns(10);
		
		List<String> list = new ArrayList<String>();
		for (int i = 1900; i < 2002; i++) {
			list.add(Integer.toString(i));
		}
		String year[] = list.toArray(new String[0]);

		
		cbNamSinh = new JComboBox();
		cbNamSinh.setBounds(318, 58, 91, 20);
		
		
		cbNamSinh.setModel(new DefaultComboBoxModel(year));
		cbNamSinh.setSelectedItem("1990");
		
		txtQueQuan = new JTextField();
		txtQueQuan.setBounds(187, 102, 222, 20);
		txtQueQuan.setColumns(10);
		
		txtCmt = new JTextField();
		txtCmt.setBounds(187, 143, 222, 20);
		txtCmt.setColumns(10);
		
		cbPhong = new JComboBox();
		cbPhong.setBounds(381, 174, 28, 22);
		
		txtSoNguoi = new JTextField();
		txtSoNguoi.setBounds(187, 203, 222, 20);
		txtSoNguoi.setColumns(10);
		
		JRadioButton wifiY = new JRadioButton("C\u00F3");
		wifiY.setBounds(184, 230, 111, 27);
		wifiY.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JRadioButton wifiN = new JRadioButton("Kh\u00F4ng");
		wifiN.setBounds(318, 230, 111, 27);
		wifiN.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		// chọn 1 trong 2
		ButtonGroup btn_group = new ButtonGroup();
			btn_group.add(wifiY);
			btn_group.add(wifiN);
		
		JButton btnNewButton_1 = new JButton("Tho\u00E1t");
		btnNewButton_1.setBounds(318, 264, 91, 33);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.setLayout(null);
		contentPane.add(cbNamSinh);
		contentPane.add(lblTn);
		contentPane.add(txtQueQuan);
		contentPane.add(txtTen);
		contentPane.add(txtCmt);
		contentPane.add(cbPhong);
		contentPane.add(lblQuQun);
		contentPane.add(lblNewLabel);
		contentPane.add(lblPhngThu);
		contentPane.add(lblNmSinh);
		contentPane.add(lblWifi);
		contentPane.add(lblSNgi);
		contentPane.add(wifiY);
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton_1);
		contentPane.add(wifiN);
		contentPane.add(txtSoNguoi);
	}
}
