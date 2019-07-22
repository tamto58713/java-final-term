package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Phi extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Phi frame = new Phi();
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
	public Phi() {
		setTitle("Ph\u00ED");
		setBounds(100, 100, 556, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblin = new JLabel("\u0110i\u1EC7n:");
		lblin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblNewLabel = new JLabel("N\u01B0\u1EDBc:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblWifi = new JLabel("Wifi:");
		lblWifi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblMiTrng = new JLabel("M\u00F4i tr\u01B0\u1EDDng:");
		lblMiTrng.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel phiDien = new JLabel("value");
		phiDien.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel phiNuoc = new JLabel("value");
		phiNuoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel phiWifi = new JLabel("value");
		phiWifi.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel phiMt = new JLabel("value");
		phiMt.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton btnNewButton = new JButton("Tho\u00E1t");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblin, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblWifi, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(phiDien, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
									.addComponent(phiNuoc, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
									.addComponent(phiWifi, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
								.addGap(248))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblMiTrng, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(phiMt, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
								.addGap(308)))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(211))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblin, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(phiDien))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(phiNuoc, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWifi)
						.addComponent(phiWifi, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMiTrng)
						.addComponent(phiMt, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(79)
					.addComponent(btnNewButton)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
