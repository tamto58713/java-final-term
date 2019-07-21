package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class XemPhong extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public String choose;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XemPhong frame = new XemPhong();
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
	public void refresh(JComboBox comboBox) {
		choose = comboBox.getSelectedItem().toString();
		Data data = new Data();
		data.getData(choose);
		
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{data.getIdPhong() , data.getLoai(), data.getTenPhong(), data.getTenNguoiThue(), data.getNamSinh() , data.getQueQuan(), data.getCmt(), data.getSoNguoi(), data.isWifi()},
				},
				new String[] {
					"ID  Ph\u00F2ng", "Lo\u1EA1i Ph\u00F2ng", "T\u00EAn Ph\u00F2ng", "Ng\u01B0\u1EDDi Thu\u00EA", "N\u0103m Sinh", "Qu\u00EA Qu\u00E1n", "CM Th\u01B0", "S\u1ED1 Ng\u01B0\u1EDDi", "Wifi"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class, Integer.class, String.class, String.class, Integer.class, Boolean.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
		
		
		System.out.println(choose);
	}
	
	
	
	public XemPhong() {
		
		Data data = new Data();
		//data.getPhong();
		//System.out.println(phong.getTen());
		setTitle("Xem ph\u00F2ng");
		setBounds(80, 80, 921, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(data.getPhong()));
		choose = comboBox.getSelectedItem().toString();
		System.out.println(choose);
		comboBox.addItemListener(new ItemListener() {
            // Listening if a new items of the combo box has been selected.
            public void itemStateChanged(ItemEvent event) {
                JComboBox comboBoxEvent = (JComboBox) event.getSource();

                // The item affected by the event.
                Object item = event.getItem();

                comboBox.setSelectedItem(event.getItem());
                
                if (event.getStateChange() == ItemEvent.SELECTED) {
                	choose = comboBox.getSelectedItem().toString();
                	refresh(comboBox);
                }
            }
        });
		
		
		
		
		
		
		
		JButton btnFirst = new JButton("First");
		btnFirst.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton btnPrev = new JButton("Prev");
		btnPrev.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton btnNext = new JButton("Next");
		btnNext.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton btnLast = new JButton("Last");
		btnLast.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton btnThot = new JButton("Tho\u00E1t");
		btnThot.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(btnFirst, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addGap(85)
							.addComponent(btnPrev, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 784, Short.MAX_VALUE)
							.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addGap(79)
							.addComponent(btnLast, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addGap(82)
							.addComponent(btnThot, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 1507, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnFirst)
							.addComponent(btnPrev, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnThot, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnLast, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
					.addGap(23))
		);
		
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setEnabled(false);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.setDefaultRenderer(String.class, centerRenderer);
		table.setDefaultRenderer(Integer.class, centerRenderer);
		scrollPane.setViewportView(table);
		
		String a = "1212";
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{a , "12", "12", "12", Integer.toString(2002), "12", "12", Integer.toString(2), null},
			},
			new String[] {
				"ID  Ph\u00F2ng", "Lo\u1EA1i Ph\u00F2ng", "T\u00EAn Ph\u00F2ng", "Ng\u01B0\u1EDDi Thu\u00EA", "N\u0103m Sinh", "Qu\u00EA Qu\u00E1n", "CM Th\u01B0", "S\u1ED1 Ng\u01B0\u1EDDi", "Wifi"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, Integer.class, String.class, String.class, Integer.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
;
		
		
		
		contentPane.setLayout(gl_contentPane);
	}
}
