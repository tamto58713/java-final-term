Skip to content
 
Search or jump to…

Pull requests
Issues
Marketplace
Explore
 
@tamto58713 
0
0 0 tamto58713/java-final-term
 Code  Issues 0  Pull requests 0  Projects 0  Wiki  Security  Insights  Settings
java-final-term/src/main/XemPhong.java
@tamto58713 tamto58713 adding add room
ac7b380 22 hours ago
199 lines (171 sloc)  7.3 KB
    
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
import javax.swing.table.TableColumnModel;
import javax.swing.JScrollPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class XemPhong extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public String choose;
	private Data data;
	private JComboBox comboBox;
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
		System.out.println(choose);
		data.setData(choose);
		setModelComboBox();
	}
	
	public void setModelComboBox() {
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{data.getIdPhong(), data.getLoai(), data.getTenPhong(), data.getTenNguoiThue(), data.getNamSinh(), data.getQueQuan(), data.getCmt(), data.getSoNguoi(), data.isWifi()},
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
	}
	public void setting() {
		
		comboBox.setModel(new DefaultComboBoxModel(data.getListTenPhong()));
		choose = comboBox.getSelectedItem().toString();
		data.setData(choose);
		choose = comboBox.getSelectedItem().toString();
		setModelComboBox();
		comboBox.addItemListener(new ItemListener() {
            // Listening if a new items of the combo box has been selected.
            public void itemStateChanged(ItemEvent event) {
                JComboBox comboBoxEvent = (JComboBox) event.getSource();

                // The item affected by the event.
                Object item = event.getItem();

                comboBox.setSelectedItem(item);
                System.out.println(item);
                if (event.getStateChange() == ItemEvent.SELECTED) {
                	choose = comboBox.getSelectedItem().toString();
                	
                	System.out.println(choose + "choose");
                	refresh(comboBox);
                }
            }
        });
		
		
	}
	
	
	
	public XemPhong() {
		
		setTitle("Xem ph\u00F2ng");
		setBounds(80, 80, 921, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		comboBox = new JComboBox();
		
		JButton btnFirst = new JButton("First");
		btnFirst.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton btnPrev = new JButton("Prev");
		btnPrev.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton btnNext = new JButton("Next");
		btnNext.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton btnLast = new JButton("Last");
		btnLast.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton btnThot = new JButton("Tho\u00E1t");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThot.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
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
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setSurrendersFocusOnKeystroke(true);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.setDefaultRenderer(String.class, centerRenderer);
		table.setDefaultRenderer(Integer.class, centerRenderer);
		scrollPane.setViewportView(table);
		
		data = new Data();
		setting();
		contentPane.setLayout(gl_contentPane);
	}
}

