package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.bson.Document;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JTree;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThemPhong extends JFrame {

	private JPanel contentPane;
	private Data data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemPhong frame = new ThemPhong();
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
	private boolean checkPhong(String[] listTen, String ten, String loai) {
		int i = 0;
		
		while (i < listTen.length) {
			
			if (listTen[i].toLowerCase().equals(ten.toLowerCase())) {
				Phong phong = new Phong(listTen[i]);
				if (phong.getLoai().equals(loai))
					return false;
			}	
			i++;
		}
		return true;
		
	}
	
	public ThemPhong() {
		data = new Data();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Th\u00EAm ph\u00F2ng");
		setBounds(100, 100, 620, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblTnPhng = new JLabel("T\u00EAn Ph\u00F2ng:");
		lblTnPhng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel = new JLabel("Lo\u1EA1i:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JTextPane txtTen = new JTextPane();
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(data.getListLoaiPhong()));
		
		JButton btnNewButton = new JButton("Th\u00EAm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtTen.getText().equals(""))
					JOptionPane.showMessageDialog(comboBox, "Hãy Nhập Tên Phòng!");
				else {
					
					String loai = comboBox.getSelectedItem().toString();
					String tenPhong[]= data.getListTenPhong();
					
					if (!checkPhong(tenPhong, txtTen.getText(), loai)) {
						JOptionPane.showMessageDialog(comboBox, "Phòng này đã tồn tại!");
					}
					else {
						data.insertPhong(txtTen.getText(), loai);
						JOptionPane.showMessageDialog(comboBox, "Đã thêm thành công!");
						dispose();
					}
					
//					 
						
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton btnNewButton_1 = new JButton("Tho\u00E1t");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int status = JOptionPane.showConfirmDialog(comboBox,  "Bạn có muốn lưu lại phòng này và thoát?");
				if (status == 0) {
					if (txtTen.getText().equals(""))
						JOptionPane.showMessageDialog(comboBox, "Hãy Nhập Tên Phòng!");
					else {
						
						String loai = comboBox.getSelectedItem().toString();
						String tenPhong[]= data.getListTenPhong();
						
						if (!checkPhong(tenPhong, txtTen.getText(), loai)) {
							JOptionPane.showMessageDialog(comboBox, "Phòng này đã tồn tại!");
						}
						else {
							data.insertPhong(txtTen.getText(), loai);
							JOptionPane.showMessageDialog(comboBox, "Đã thêm thành công!");
							
						}
					}
				}
				else if (status == 1) {
					dispose();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTnPhng, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(btnNewButton_1))
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTen))
					.addContainerGap(236, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblTnPhng, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(85)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(76, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
}
