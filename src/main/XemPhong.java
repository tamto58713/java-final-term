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
import java.awt.Color;

public class XemPhong extends JFrame {

	private JPanel contentPane;
	public String choose;
	private Data data;
	private JComboBox comboBox;
	private JTable table;
	private JScrollPane scrollPane;
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
		setTableModel();
	}
	
	public void setTableModel() {
		
		String columnNames[] = {
		"ID  Ph\u00F2ng", "Lo\u1EA1i Ph\u00F2ng", "T\u00EAn Ph\u00F2ng", "Ng\u01B0\u1EDDi Thu\u00EA", "N\u0103m Sinh", 
		"Qu\u00EA Qu\u00E1n", "CM Th\u01B0", "S\u1ED1 Ng\u01B0\u1EDDi", "Wifi"};
		String wifi;
		if (data.isWifi())
			wifi = "Có";
		else 
			wifi = "Không";
		String[][] rows = {
				{data.getIdPhong(), data.getLoai(), data.getTenPhong(), data.getTenNguoiThue(), data.getNamSinh(), 
					data.getQueQuan(), data.getCmt(), Integer.toString(data.getSoNguoi()), wifi},
			};
		
		table = new JTable(rows, columnNames);
		table.setSurrendersFocusOnKeystroke(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBounds(100, 100, 300, 400);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(6).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(7).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(8).setCellRenderer( centerRenderer );
		
		table.getColumnModel().getColumn(0).setPreferredWidth(160);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(60);
		table.getColumnModel().getColumn(5).setPreferredWidth(80);
		table.getColumnModel().getColumn(6).setPreferredWidth(60);
		table.getColumnModel().getColumn(7).setPreferredWidth(50);
		table.getColumnModel().getColumn(8).setPreferredWidth(30);
		scrollPane.setViewportView(table);
		
	}
	
	public void setModelComboBox() {
	}
	public void setting() {
		
		comboBox.setModel(new DefaultComboBoxModel(data.getListTenPhong()));
		choose = comboBox.getSelectedItem().toString();
		data.setData(choose);
		choose = comboBox.getSelectedItem().toString();
		setTableModel();
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
		comboBox.setBounds(10, 32, 154, 31);
		
		JButton btnFirst = new JButton("First");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setSelectedIndex(0);
			}
		});
		btnFirst.setBounds(10, 505, 105, 33);
		btnFirst.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton btnPrev = new JButton("Prev");
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = comboBox.getSelectedIndex();
				if (index > 0) {
					comboBox.setSelectedIndex(index - 1);
				}
			}
		});
		btnPrev.setBounds(158, 505, 112, 33);
		btnPrev.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = comboBox.getSelectedIndex();
				if (index < comboBox.getItemCount() - 1) {
					comboBox.setSelectedIndex(index + 1);
				}
			}
		});
		btnNext.setBounds(313, 505, 107, 33);
		btnNext.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton btnLast = new JButton("Last");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setSelectedIndex(comboBox.getItemCount() - 1);
			}
		});
		btnLast.setBounds(462, 505, 112, 33);
		btnLast.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton btnThot = new JButton("Tho\u00E1t");
		btnThot.setBounds(791, 505, 106, 33);
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThot.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 89, 887, 201);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		
		data = new Data();
		setting();
		contentPane.setLayout(null);
		contentPane.add(scrollPane);
		contentPane.add(btnFirst);
		contentPane.add(btnPrev);
		contentPane.add(btnNext);
		contentPane.add(btnLast);
		contentPane.add(btnThot);
		contentPane.add(comboBox);
	}
}

