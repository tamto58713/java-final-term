package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Index {

	private JFrame frmQunLPhng;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index window = new Index();
					window.frmQunLPhng.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Index() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmQunLPhng = new JFrame();
		frmQunLPhng.setTitle("Qu\u1EA3n L\u00FD Ph\u00F2ng Tr\u1ECD");
		frmQunLPhng.setBounds(50, 50, 890, 591);
		frmQunLPhng.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmQunLPhng.setVisible(true);
		JPanel panel = new JPanel();
		frmQunLPhng.getContentPane().add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 153, 102));
		
		JPanel panel_2 = new JPanel();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(18))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 796, GroupLayout.PREFERRED_SIZE)
							.addGap(28))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		
		JPanel panel_3 = new JPanel();
		// add event Entered id = 1
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_3.setBackground(new Color(150, 150, 150));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_3.setBackground(new Color(220, 220, 220));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				ThemPhong add = new ThemPhong();
				add.setVisible(true);
				System.out.println(add.EXIT_ON_CLOSE);
				
				
			}
		});
		panel_3.setBackground(new Color(220, 220, 220));
		
		JPanel panel_4 = new JPanel();
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_4.setBackground(new Color(150, 150, 150));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_4.setBackground(new Color(220, 220, 220));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				ThemNguoiThue add = new ThemNguoiThue();
				add.setVisible(true);
				
			}
		});

		panel_4.setBackground(new Color(220, 220, 220));
		
		JLabel lblThmNgiThu = new JLabel("Th\u00EAm Ng\u01B0\u1EDDi Thu\u00EA");
		lblThmNgiThu.setHorizontalAlignment(SwingConstants.CENTER);
		lblThmNgiThu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Index.class.getResource("/image/icons8_add_user_64px_1.png")));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap(32, Short.MAX_VALUE)
					.addComponent(lblThmNgiThu)
					.addGap(22))
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(58)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(47, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
					.addContainerGap(23, Short.MAX_VALUE)
					.addComponent(label_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblThmNgiThu, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_4.setLayout(gl_panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_5.setBackground(new Color(150, 150, 150));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_5.setBackground(new Color(220, 220, 220));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				XemPhong add = new XemPhong();
				add.setVisible(true);
			}
		});

		panel_5.setBackground(new Color(220, 220, 220));
		
		JLabel lblXemPhng = new JLabel("Xem Ph\u00F2ng");
		lblXemPhng.setHorizontalAlignment(SwingConstants.CENTER);
		lblXemPhng.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Index.class.getResource("/image/icons8_room_64px_1.png")));
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGap(0, 169, Short.MAX_VALUE)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap(35, Short.MAX_VALUE)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_5.createSequentialGroup()
							.addComponent(lblXemPhng, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addGap(30))
						.addGroup(Alignment.TRAILING, gl_panel_5.createSequentialGroup()
							.addComponent(label_4)
							.addGap(52))))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGap(0, 128, Short.MAX_VALUE)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblXemPhng, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_5.setLayout(gl_panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_6.setBackground(new Color(150, 150, 150));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_6.setBackground(new Color(220, 220, 220));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Phi add = new Phi();
				add.setVisible(true);
			}
		});

		panel_6.setBackground(new Color(220, 220, 220));
		
		JLabel lblPh = new JLabel("Ph\u00ED");
		lblPh.setHorizontalAlignment(SwingConstants.CENTER);
		lblPh.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(Index.class.getResource("/image/icons8_cost_64px.png")));
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGap(0, 169, Short.MAX_VALUE)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap(35, Short.MAX_VALUE)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_6.createSequentialGroup()
							.addComponent(lblPh, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addGap(30))
						.addGroup(Alignment.TRAILING, gl_panel_6.createSequentialGroup()
							.addComponent(label_6)
							.addGap(52))))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGap(0, 128, Short.MAX_VALUE)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_6)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPh, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_6.setLayout(gl_panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_7.setBackground(new Color(150, 150, 150));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_7.setBackground(new Color(220, 220, 220));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				DoanhThu add = new DoanhThu();
				add.setVisible(true);
			}
		});

		panel_7.setBackground(new Color(220, 220, 220));
		
		JLabel lblDoanhThu = new JLabel("Doanh Thu");
		lblDoanhThu.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoanhThu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(Index.class.getResource("/image/icons8_money_bag_64px.png")));
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGap(0, 169, Short.MAX_VALUE)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap(35, Short.MAX_VALUE)
					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_7.createSequentialGroup()
							.addComponent(lblDoanhThu, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addGap(30))
						.addGroup(Alignment.TRAILING, gl_panel_7.createSequentialGroup()
							.addComponent(label_8)
							.addGap(52))))
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGap(0, 128, Short.MAX_VALUE)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_8)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDoanhThu, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_7.setLayout(gl_panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_8.setBackground(new Color(150, 150, 150));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_8.setBackground(new Color(220, 220, 220));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				LienHe add = new LienHe();
				add.setVisible(true);
			}
		});

		panel_8.setBackground(new Color(220, 220, 220));
		
		JLabel lblLinH = new JLabel("Li\u00EAn H\u1EC7");
		lblLinH.setHorizontalAlignment(SwingConstants.CENTER);
		lblLinH.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(Index.class.getResource("/image/icons8_phone_contact_64px.png")));
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGap(0, 169, Short.MAX_VALUE)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addContainerGap(35, Short.MAX_VALUE)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_8.createSequentialGroup()
							.addComponent(lblLinH, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addGap(30))
						.addGroup(Alignment.TRAILING, gl_panel_8.createSequentialGroup()
							.addComponent(label_10)
							.addGap(52))))
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGap(0, 128, Short.MAX_VALUE)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_10)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblLinH, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_8.setLayout(gl_panel_8);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
					.addGap(109)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
					.addGap(49))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
					.addGap(24))
		);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Index.class.getResource("/image/icons8_plus_math_64px_4.png")));
		
		JLabel lblThmPhng = new JLabel("Th\u00EAm Ph\u00F2ng");
		lblThmPhng.setHorizontalAlignment(SwingConstants.CENTER);
		lblThmPhng.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap(35, Short.MAX_VALUE)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
							.addComponent(lblThmPhng, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addGap(30))
						.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
							.addComponent(label)
							.addGap(52))))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblThmPhng, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_3.setLayout(gl_panel_3);
		panel_2.setLayout(gl_panel_2);
		
		JLabel lblQunLPhng = new JLabel("Qu\u1EA3n L\u00FD Ph\u00F2ng Tr\u1ECD");
		lblQunLPhng.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 30));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblQunLPhng, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(558, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblQunLPhng, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(130, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
	}
}
