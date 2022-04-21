package doAnCK;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class AppDoAnCK {

	private JFrame frmMyApp;
	private JTextField textField_ID;
	private JTextField textField_name;
	private JTextField textField_date;
	private JTextField textField_phone;
	private JTextField textField_email;
	private JTextField textField_houseID;
	private static JTable table;
	private static DefaultTableModel model;
	private static JTable table_1;
	private static DefaultTableModel model_1;
	private static DefaultListModel<String> listModel;
	private JTextField textField_customerSearch;
	
	// private static String[] line = new String[1000];

	private JTextField textField_apartID;
	private JTextField textField_area;
	private JTextField textField_floor;
	private JTextField searchApart;

	static ArrayList<Customer> cusList = new ArrayList<>();
	static ArrayList<Apartment> apartList = new ArrayList<>();
	
	private JTextField textField_calID;
	private JTextField textField_1;
	private static JTextField textField_pay;
	private JTextField textField_unSold;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		createFile("C:\\Users\\Admin\\Desktop\\customer.txt");
		loadFile(cusList, "C:\\Users\\Admin\\Desktop\\customer.txt");
		createFile2("C:\\Users\\Admin\\Desktop\\apartment.txt");
		loadFile2(apartList,"C:\\Users\\Admin\\Desktop\\apartment.txt");
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppDoAnCK window = new AppDoAnCK();
					window.frmMyApp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Write to a file
	public static void writeFile(String id, String name, String date, String phone, String email, String houseID) {
		try {
			FileWriter myWriter = new FileWriter("C:\\Users\\Admin\\Desktop\\customer.txt", true);

			myWriter.write(id);
			myWriter.write(System.getProperty("line.separator"));
			myWriter.write(name);
			myWriter.write(System.getProperty("line.separator"));
			myWriter.write(date);
			myWriter.write(System.getProperty("line.separator"));
			myWriter.write(phone);
			myWriter.write(System.getProperty("line.separator"));
			myWriter.write(email);
			myWriter.write(System.getProperty("line.separator"));
			myWriter.write(houseID);
			myWriter.write(System.getProperty("line.separator"));
			myWriter.write("");
			myWriter.write(System.getProperty("line.separator"));
			myWriter.close();
			// System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	public static void writeFile2(String id, String name, String date, String phone, String email, String houseID, String a) {
		try {
			FileWriter myWriter = new FileWriter("C:\\Users\\Admin\\Desktop\\apartment.txt", true);

			myWriter.write(id);
			myWriter.write(System.getProperty("line.separator"));
			myWriter.write(name);
			myWriter.write(System.getProperty("line.separator"));
			myWriter.write(date);
			myWriter.write(System.getProperty("line.separator"));
			myWriter.write(phone);
			myWriter.write(System.getProperty("line.separator"));
			myWriter.write(email);
			myWriter.write(System.getProperty("line.separator"));
			myWriter.write(houseID);
			myWriter.write(System.getProperty("line.separator"));
			myWriter.write(a);
			myWriter.write(System.getProperty("line.separator"));
			myWriter.write("");
			myWriter.write(System.getProperty("line.separator"));
			myWriter.close();
			// System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	// Create a default file
	public static void createFile(String address) {
		try {
			File myObj = new File(address);
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
				writeFile("q123", "Quang", "09/06/2000", "0901787111", "quang@gmail.com", "2B01");
				writeFile("h153", "Hai", "07/16/2000", "0901787222", "hai@gmail.com", "3B01");
				writeFile("t784", "Tuan", "21/05/2000", "0901787333", "tuan@gmail.com", "2B02");
				writeFile("b321", "Binh", "15/08/2000", "0901787444", "binh@gmail.com", "PH01");

			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void createFile2(String address) {
		try {
			File myObj = new File(address);
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
				writeFile2("3B02", "1.5", "no", "15", "Three Bed", "2.5","yes");
				writeFile2("PH03", "2.3", "yes", "30", "Pent House", "5", "no");
				writeFile2("2B01", "1.9", "yes", "25", "Two Bed", "1.5","yes");
				writeFile2("3B03", "1.1", "no", "2", "Three Bed", "2.5","no");
				writeFile2("PH02", "2.8", "no", "30", "Pent House", "5", "no");
				writeFile2("2B03", "3", "yes", "12", "Two Bed", "1.5","yes");
				writeFile2("3B04", "1.6", "no", "40", "Three Bed", "2.5","no");
				writeFile2("2B02", "2", "yes", "33", "Two Bed", "1.5","no");
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	// Load the data from the file
	public static void /* ArrayList<Customer> */ loadFile(ArrayList<Customer> cusList, String address) {
		int i = 0;
		ArrayList<String> tempList = new ArrayList<>();
		try {
			Scanner scanner = new Scanner(new File(address));
			while (scanner.hasNextLine()) {
				tempList.add(i, scanner.nextLine());
				i++;
			}
			scanner.close();
		} catch (FileNotFoundException er) {
			er.printStackTrace();
		}
		tempList.removeAll(Arrays.asList("", null)); // loai bo cac phan tu khong co gia tri trong list

		for (i = 0; i < tempList.size(); i += 6)
			cusList.add(new Customer(tempList.get(i), tempList.get(i + 1), tempList.get(i + 2), tempList.get(i + 3),
					tempList.get(i + 4), tempList.get(i + 5)));
		cusList.removeAll(Arrays.asList("", null));
		// print to test
		for (i = 0; i < (cusList.size()); i++) {
			System.out.println(cusList.get(i));
		}
		System.out.println("");
	}

	public static void /* ArrayList<Customer> */ loadFile2(ArrayList<Apartment> apartList, String address) {
		int i = 0;
		ArrayList<String> tempList = new ArrayList<>();
		try {
			Scanner scanner = new Scanner(new File(address));
			while (scanner.hasNextLine()) {
				tempList.add(i, scanner.nextLine());
				i++;
			}
			scanner.close();
		} catch (FileNotFoundException er) {
			er.printStackTrace();
		}
		tempList.removeAll(Arrays.asList("", null)); // loai bo cac phan tu khong co gia tri trong list
//		for (i = 0; i < tempList.size(); i++)
//			System.out.println(tempList.get(i));
		for (i = 0; i < tempList.size(); i += 7)
			apartList.add(new Apartment(tempList.get(i).toString(), Double.parseDouble(tempList.get(i + 1).toString()),
					(tempList.get(i + 2).equals("yes") ? true : false),
					Integer.parseInt(tempList.get(i + 3).toString()), tempList.get(i + 4).toString(),
					Double.parseDouble(tempList.get(i + 5).toString()), tempList.get(i + 6).toString()));
		apartList.removeAll(Arrays.asList("", null));
		// print to test
		for (i = 0; i < (apartList.size()); i++) {
			System.out.println(apartList.get(i));
		}
		System.out.println("");
	}

//	public static void readFile() {
//		int i = 0;
//		try {
//			Scanner scanner = new Scanner(new File("C:\\Users\\Admin\\Desktop\\customer.txt"));
//			while (scanner.hasNextLine()) {
//				line[i] = scanner.nextLine();
//				i++;				
//			}
//			scanner.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//	}

	public static void loadFileFrom() {

	}

	// Is an integer number
	public static boolean isInteger(String s, int radix) {
		// Decimal: radix=10
		if (s.isEmpty())
			return false;
		for (int i = 0; i < s.length(); i++) {
			if (i == 0 && s.charAt(i) == '-') {
				if (s.length() == 1)
					return false;
				else
					continue;
			}
			if (Character.digit(s.charAt(i), radix) < 0)
				return false;
		}
		return true;
	}

	// Is a number
	public static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			double d = Double.parseDouble(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	// how long the file is
	public static long countLineBufferedReader(String fileName) {
		long lines = 0;
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			while (reader.readLine() != null)
				lines++;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

	// clear file
	public static void clearFile(String address) {
		try {
			FileWriter clearFile = new FileWriter(address, false);
			clearFile.write("");
			clearFile.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	// save data to file
	public static void saveDataTo() {
		for (int i = 0; i < table.getRowCount(); i++) {
			for (int j = 0; j < table.getColumnCount(); j++) {
				try {
					FileWriter myWriter = new FileWriter("C:\\Users\\Admin\\Desktop\\customer.txt", true);
					myWriter.write(model.getValueAt(table.convertRowIndexToModel(i), j).toString());
					myWriter.write(System.getProperty("line.separator"));
					if (j == 5) {
						myWriter.write("");
						myWriter.write(System.getProperty("line.separator"));
					}
					myWriter.close();
				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void saveDataTo2() {
		for (int i = 0; i < table_1.getRowCount(); i++) {
			for (int j = 0; j < table_1.getColumnCount(); j++) {
				try {
					FileWriter myWriter = new FileWriter("C:\\Users\\Admin\\Desktop\\apartment.txt", true);
					myWriter.write(model_1.getValueAt(table_1.convertRowIndexToModel(i), j).toString());
					myWriter.write(System.getProperty("line.separator"));
					if (j == table_1.getColumnCount()-1) {
						myWriter.write("");
						myWriter.write(System.getProperty("line.separator"));
					}
					myWriter.close();
				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
			}
		}
	}
	
	public static String calculate(int i) {
		String a = "";
		if (model_1.getValueAt((i), 4).toString().equals("Two Bed")) {
			TwoBed two = new TwoBed(model_1.getValueAt((i), 0).toString(),
					Double.parseDouble(model_1.getValueAt((i), 1).toString()),
					(model_1.getValueAt((i), 2).toString().equals("yes") ? true : false),
					Integer.parseInt(model_1.getValueAt((i), 3).toString()));
			//System.out.println(two.toString());
			String[] result2 = two.payment();
			textField_pay.setText(result2[0]);

			a = "Two Bed" + System.getProperty("line.separator") + "Original price: " + two.price
					+ System.getProperty("line.separator") + "Has balcony: +" + Double.parseDouble(result2[1]) * 0.1
					+ System.getProperty("line.separator") + "Floor = " + two.floor + ": " + " +" + result2[2];

		}
		else if (model_1.getValueAt((i), 4).toString().equals("Three Bed")) {
			ThreeBed three = new ThreeBed(model_1.getValueAt((i), 0).toString(),
					Double.parseDouble(model_1.getValueAt((i), 1).toString()),
					(model_1.getValueAt((i), 2).toString().equals("yes") ? true : false),
					Integer.parseInt(model_1.getValueAt((i), 3).toString()));
			//System.out.println(three.toString());
			String[] result3 = three.payment();
			textField_pay.setText((result3[0]));

			a = "Three Bed" + System.getProperty("line.separator") + "Original price: " + three.price
					+ System.getProperty("line.separator") + "Has balcony: +" + Double.parseDouble(result3[1]) * 0.2
					+ System.getProperty("line.separator") + "Floor = " + three.floor + ": " + " +" + (result3[2]);
		}
		else {
			PentHouse pent = new PentHouse(model_1.getValueAt((i), 0).toString(),
					Double.parseDouble(model_1.getValueAt((i), 1).toString()),
					(model_1.getValueAt((i), 2).toString().equals("yes") ? true : false),
					Integer.parseInt(model_1.getValueAt((i), 3).toString()));
			//System.out.println(pent.toString());
			String[] result4 = pent.payment();
			textField_pay.setText(result4[0]);

			a = "Penthouse" + System.getProperty("line.separator") + "Original price: " + pent.price
					+ System.getProperty("line.separator") + "Has balcony: +" + Double.parseDouble(result4[1]) * 0.2
					+ System.getProperty("line.separator") + "Floor = " + pent.floor + ": " + " +" + result4[2];
		}
		
		return a;
	}

	// 5.0 -> 5
	public static String fmt(double d) {
		if (d == (long) d)
			return String.format("%d", (long) d);
		else
			return String.format("%s", d);
	}

	// sort
	public static class CompareByCusID implements Comparator<Customer> {
		@Override
		public int compare(Customer o1, Customer o2) {
			return o1.getCusID().compareTo(o2.getCusID());
		}
	}

	public static void sortCusID(ArrayList<Customer> list) {
		Collections.sort(list, new CompareByCusID());
	}

	public static class CompareByApartID implements Comparator<Apartment> {
		@Override
		public int compare(Apartment o1, Apartment o2) {
			return o1.apartID.compareTo(o2.apartID);
		}
	}

	public static void sortApartID(ArrayList<Apartment> list) {
		Collections.sort(list, new CompareByApartID());
	}

	/**
	 * Create the application.
	 */
	public AppDoAnCK() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		createFile();
//		readFile();

		frmMyApp = new JFrame();
		frmMyApp.setTitle("MY APP");
		frmMyApp.setResizable(false);
		frmMyApp.setBounds(100, 100, 1001, 598);
		frmMyApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMyApp.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 985, 559);
		frmMyApp.getContentPane().add(tabbedPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		tabbedPane.addTab("CUSTOMER", null, panel, null);
		tabbedPane.setBackgroundAt(0, new Color(255, 255, 255));
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(50, 107, 81, 23);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(50, 141, 81, 23);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Date of Birth:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(50, 175, 81, 23);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Phone Number:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(21, 209, 110, 23);
		panel.add(lblNewLabel_3);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(50, 243, 81, 23);
		panel.add(lblEmail);

		JLabel lblHouseId = new JLabel("House ID:");
		lblHouseId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHouseId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHouseId.setBounds(50, 277, 81, 23);
		panel.add(lblHouseId);

		textField_ID = new JTextField();
		textField_ID.setBounds(155, 105, 183, 28);
		panel.add(textField_ID);
		textField_ID.setColumns(10);

		textField_name = new JTextField();
		textField_name.setColumns(10);
		textField_name.setBounds(155, 139, 183, 28);
		panel.add(textField_name);

		textField_date = new JTextField();
		textField_date.setColumns(10);
		textField_date.setBounds(155, 173, 183, 28);
		panel.add(textField_date);

		textField_phone = new JTextField();
		textField_phone.setColumns(10);
		textField_phone.setBounds(155, 207, 183, 28);
		panel.add(textField_phone);

		textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(155, 241, 183, 28);
		panel.add(textField_email);

		textField_houseID = new JTextField();
		textField_houseID.setColumns(10);
		textField_houseID.setBounds(155, 275, 183, 28);
		panel.add(textField_houseID);

		JLabel lblNewLabel_4 = new JLabel("CUSTOMER INFORMATION");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(73, 71, 265, 23);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_4_1_1 = new JLabel("CUSTOMER MANAGEMENT");
		lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_1_1.setBounds(10, 11, 960, 23);
		panel.add(lblNewLabel_4_1_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(410, 69, 542, 395);
		panel.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//int i = table.getSelectedRow();
				textField_ID.setText(model.getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), 0).toString());
				textField_name.setText(model.getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), 1).toString());
				textField_date.setText(model.getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), 2).toString());
				textField_phone.setText(model.getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), 3).toString());
				textField_email.setText(model.getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), 4).toString());
				textField_houseID.setText(model.getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), 5).toString());
				
			}
		});
		table.setAutoCreateRowSorter(true);
		table.setBackground(new Color(230, 230, 250));
		model = new DefaultTableModel();
		Object[] column = { "ID", "Name", "Date of Birth", "Phone Number", "Email", "House ID" };
		Object[] row = new Object[6];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(85);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(134);
		table.getColumnModel().getColumn(5).setPreferredWidth(60);

		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_ID.getText().equals("") || textField_name.getText().equals("")
						|| textField_date.getText().equals("") || textField_phone.getText().equals("")
						|| textField_email.getText().equals("") || textField_houseID.getText().equals("")) {
					JOptionPane.showMessageDialog(frmMyApp, "Please Fill All The Information!");
				}else if (!isNumeric(textField_phone.getText())) {
					JOptionPane.showMessageDialog(frmMyApp, "Please Fill \"Phone number\" With Numbers!");					
				} else {
					// add row
					row[0] = textField_ID.getText();
					row[1] = textField_name.getText();
					row[2] = textField_date.getText();
					row[3] = textField_phone.getText();
					row[4] = textField_email.getText();
					row[5] = textField_houseID.getText();
					model.addRow(row);
					// clear text field
					textField_ID.setText("");
					textField_name.setText("");
					textField_date.setText("");
					textField_phone.setText("");
					textField_email.setText("");
					textField_houseID.setText("");
					JOptionPane.showMessageDialog(frmMyApp, "Added Successfully!");
				}
			}
		});
		btnAdd.setBounds(73, 330, 122, 28);
		panel.add(btnAdd);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.convertRowIndexToModel(table.getSelectedRow());
				if (i >= 0) {
					model.removeRow(i);
					JOptionPane.showMessageDialog(frmMyApp, "Deleted Successfully!");
				} else {
					JOptionPane.showMessageDialog(frmMyApp, "Please Select A Customer You Want To Delete!");
				}
			}
		});
		btnDelete.setBounds(216, 330, 122, 28);
		panel.add(btnDelete);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.convertRowIndexToModel(table.getSelectedRow()) ;
				model.setValueAt(textField_ID.getText(), i, 0);
				model.setValueAt(textField_name.getText(), i, 1);
				model.setValueAt(textField_date.getText(), i, 2);
				model.setValueAt(textField_phone.getText(), i, 3);
				model.setValueAt(textField_email.getText(), i, 4);
				model.setValueAt(textField_houseID.getText(), i, 5);
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnUpdate.setBounds(73, 375, 122, 28);
		panel.add(btnUpdate);

		JButton btnClearText = new JButton("Clear Text");
		btnClearText.setVerticalAlignment(SwingConstants.BOTTOM);
		btnClearText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_ID.setText("");
				textField_name.setText("");
				textField_date.setText("");
				textField_phone.setText("");
				textField_email.setText("");
				textField_houseID.setText("");
			}
		});
		btnClearText.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnClearText.setBounds(216, 375, 122, 28);
		panel.add(btnClearText);

		JLabel lblIdSearching = new JLabel("Search:");
		lblIdSearching.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdSearching.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdSearching.setBounds(642, 38, 103, 23);
		panel.add(lblIdSearching);

		textField_customerSearch = new JTextField();
		textField_customerSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				DefaultTableModel jtable = (DefaultTableModel) table.getModel();
				String search = textField_customerSearch.getText();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(jtable);
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter("(?i)" + search)); // "(?i)" -> Ignore case
			}
		});
		textField_customerSearch.setColumns(10);
		textField_customerSearch.setBounds(769, 36, 183, 28);
		panel.add(textField_customerSearch);

		JButton btnSaveDataTo = new JButton("Save Data To File");
		btnSaveDataTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_customerSearch.getText().equals("")) {
					clearFile("C:\\Users\\Admin\\Desktop\\customer.txt");
					saveDataTo();
					JOptionPane.showMessageDialog(frmMyApp, "The Table's Current Data Has Been Saved Successfully!");
				} else {
					JOptionPane.showMessageDialog(frmMyApp, "Please Clear \"Search\" Before Saving!");
				}
			}
		});
		btnSaveDataTo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSaveDataTo.setBounds(628, 480, 157, 28);
		panel.add(btnSaveDataTo);

		JButton btnLoadDateFrom = new JButton("Load Data From File");
		btnLoadDateFrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cusList.clear(); // clear list
				loadFile(cusList, "C:\\Users\\Admin\\Desktop\\customer.txt"); // update list
				cusList.removeAll(Arrays.asList("", null));
				model.setRowCount(0); // clear table
				for (int k = 0; k < cusList.size(); k++) {
					row[0] = cusList.get(k).getCusID();
					row[1] = cusList.get(k).getName();
					row[2] = cusList.get(k).getBirth();
					row[3] = cusList.get(k).getPhone();
					row[4] = cusList.get(k).getMail();
					row[5] = cusList.get(k).getBuyApartment();
					model.addRow(row); // add row to table
				}
				JOptionPane.showMessageDialog(frmMyApp, "Load The File Successfully!");
			}
		});
		btnLoadDateFrom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLoadDateFrom.setBounds(795, 480, 157, 28);
		panel.add(btnLoadDateFrom);

		
		// sort customer id botton
//		JButton btnSortById = new JButton("Sort By ID");
//		btnSortById.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				cusList.clear();
//				for (int i = 0; i < table.getRowCount(); i++) {
//					cusList.add(new Customer(model.getValueAt(i, 0).toString(), model.getValueAt(i, 1).toString(),
//							model.getValueAt(i, 2).toString(), model.getValueAt(i, 3).toString(),
//							model.getValueAt(i, 4).toString(), model.getValueAt(i, 5).toString()));
//				}
//				sortCusID(cusList);
//				model.setRowCount(0);
//				for (int i = 0; i < cusList.size(); i++) {
//					row[0] = cusList.get(i).getCusID();
//					row[1] = cusList.get(i).getName();
//					row[2] = cusList.get(i).getBirth();
//					row[3] = cusList.get(i).getPhone();
//					row[4] = cusList.get(i).getMail();
//					row[5] = cusList.get(i).getBuyApartment();
//					model.addRow(row);
//				}
//			}
//		});
//		btnSortById.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		btnSortById.setBounds(410, 480, 122, 28);
//		panel.add(btnSortById);

		JPanel panel_1 = new JPanel();
		// panel_1.setToolTipText("");
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(144, 238, 144));
		tabbedPane.addTab("APARTMENT", null, panel_1, "");
		tabbedPane.setBackgroundAt(1, new Color(255, 255, 255));

		JLabel lblNewLabel_5 = new JLabel("House ID:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(50, 77, 81, 23);
		panel_1.add(lblNewLabel_5);

		JLabel lblNewLabel_1_1 = new JLabel("Area:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(50, 111, 81, 23);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("Has Balcony?");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(50, 145, 81, 23);
		panel_1.add(lblNewLabel_2_1);

		JLabel lblNewLabel_3_1 = new JLabel("Floor Number:");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_1.setBounds(21, 179, 110, 23);
		panel_1.add(lblNewLabel_3_1);

		JLabel lblEmail_1 = new JLabel("Type:");
		lblEmail_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail_1.setBounds(50, 213, 81, 23);
		panel_1.add(lblEmail_1);

		JLabel lblHouseId_1 = new JLabel("Be Sold?");
		lblHouseId_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHouseId_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHouseId_1.setBounds(50, 247, 81, 23);
		panel_1.add(lblHouseId_1);

		textField_apartID = new JTextField();
		// textField_apartID.setToolTipText("");
		textField_apartID.setColumns(10);
		textField_apartID.setBounds(155, 75, 183, 28);
		panel_1.add(textField_apartID);

		textField_area = new JTextField();
		textField_area.setColumns(10);
		textField_area.setBounds(155, 109, 183, 28);
		panel_1.add(textField_area);

		textField_floor = new JTextField();
		textField_floor.setColumns(10);
		textField_floor.setBounds(155, 177, 183, 28);
		panel_1.add(textField_floor);

		JCheckBox box = new JCheckBox("");
		box.setHorizontalAlignment(SwingConstants.CENTER);
		box.setBounds(155, 145, 27, 23);
		panel_1.add(box);

		JCheckBox box_1 = new JCheckBox("");
		box_1.setHorizontalAlignment(SwingConstants.CENTER);
		box_1.setBounds(155, 248, 27, 23);
		panel_1.add(box_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Two Bed", "Three Bed", "Penthouse" }));
		comboBox.setBounds(155, 214, 183, 22);
		panel_1.add(comboBox);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(395, 77, 575, 386);
		panel_1.add(scrollPane_1);

		table_1 = new JTable();
		table_1.setAutoCreateRowSorter(true);
		table_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int i = table_1.convertRowIndexToModel(table_1.getSelectedRow());
				textField_apartID.setText(model_1.getValueAt(i, 0).toString());
				textField_area.setText(model_1.getValueAt(i, 1).toString());
				if (model_1.getValueAt(i, 2).toString().equals("yes"))
					box.setSelected(true);
				else
					box.setSelected(false);
				textField_floor.setText(model_1.getValueAt(i, 3).toString());
				if (model_1.getValueAt(i, 4).toString().equals("Two Bed"))
					comboBox.setSelectedItem("Two Bed");
				else if (model_1.getValueAt(i, 4).toString().equals("Three Bed"))
					comboBox.setSelectedItem("Three Bed");
				else
					comboBox.setSelectedItem("Penthouse");

				// textField_email.setText(model.getValueAt(i, 4).toString());
				if (model_1.getValueAt(i, 6).toString().equals("yes"))
					box_1.setSelected(true);
				else
					box_1.setSelected(false);

				textField_calID.setText(model_1.getValueAt(i, 0).toString());
			}
		});
		table_1.setBackground(new Color(230, 230, 250));
		model_1 = new DefaultTableModel();
		Object[] column_1 = { "ID", "Area", "Balcony", "Floor", "Type", "Original Price", "Sold" };
		Object[] row_1 = new Object[7];
		model_1.setColumnIdentifiers(column_1);
		table_1.setModel(model_1);
		scrollPane_1.setViewportView(table_1);

		JLabel lblNewLabel_4_2 = new JLabel("INFORMATION");
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_2.setBounds(73, 41, 265, 23);
		panel_1.add(lblNewLabel_4_2);

		JLabel lblNewLabel_4_1_1_1 = new JLabel("APARTMENT MANAGEMENT");
		lblNewLabel_4_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_1_1_1.setBounds(10, 11, 960, 23);
		panel_1.add(lblNewLabel_4_1_1_1);

		JButton btnAdd_1 = new JButton("Add");
		btnAdd_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAdd_1.setBounds(73, 289, 122, 28);
		panel_1.add(btnAdd_1);

		JButton btnDelete_1 = new JButton("Delete");
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table_1.convertRowIndexToModel(table_1.getSelectedRow()) ;
				if (i >= 0) {
					model_1.removeRow(i);
					JOptionPane.showMessageDialog(frmMyApp, "Deleted Successfully!");
				} else {
					JOptionPane.showMessageDialog(frmMyApp, "Please Select A Customer You Want To Delete!");
				}
			}
		});
		btnDelete_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDelete_1.setBounds(216, 289, 122, 28);
		panel_1.add(btnDelete_1);

		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table_1.convertRowIndexToModel(table_1.getSelectedRow()) ;
				if (textField_apartID.getText().equals("") || textField_area.getText().equals("")
						|| textField_floor.getText().equals("")) {
					JOptionPane.showMessageDialog(frmMyApp, "Please Fill All The Information!");
				} else if (!isNumeric(textField_area.getText()) || !isNumeric(textField_floor.getText()))
					JOptionPane.showMessageDialog(frmMyApp, "Please Fill Area & Floor With Numbers!");
				else if (!isInteger(textField_floor.getText(), 10))
					JOptionPane.showMessageDialog(frmMyApp, "Please Fill Floor With An Integer Number!");
				else {
					model_1.setValueAt(textField_apartID.getText(), i, 0);
					model_1.setValueAt(textField_area.getText(), i, 1);
					model_1.setValueAt((box.isSelected()) ? "yes" : "no", i, 2);
					model_1.setValueAt(textField_floor.getText(), i, 3);
					model_1.setValueAt(comboBox.getSelectedItem().toString(), i, 4);
					model_1.setValueAt((box_1.isSelected()) ? "yes" : "no", i, 6);
				}
			}
		});
		btnUpdate_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnUpdate_1.setBounds(73, 334, 122, 28);
		panel_1.add(btnUpdate_1);

		JButton btnClearText_1 = new JButton("Clear Text");
		btnClearText_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_apartID.setText("");
				textField_area.setText("");
				box.setSelected(false);
				textField_floor.setText("");
				comboBox.setSelectedItem("Two Bed");
				box_1.setSelected(false);
			}
		});
		btnClearText_1.setVerticalAlignment(SwingConstants.BOTTOM);
		btnClearText_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnClearText_1.setBounds(216, 334, 122, 28);
		panel_1.add(btnClearText_1);

		JLabel lblIdSearching_1 = new JLabel("Search:");
		lblIdSearching_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdSearching_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdSearching_1.setBounds(668, 43, 103, 23);
		panel_1.add(lblIdSearching_1);

		searchApart = new JTextField();
		searchApart.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				DefaultTableModel jtable1 = (DefaultTableModel) table_1.getModel();
				String search_1 = searchApart.getText();
				TableRowSorter<DefaultTableModel> tr1 = new TableRowSorter<DefaultTableModel>(jtable1);
				table_1.setRowSorter(tr1);
				tr1.setRowFilter(RowFilter.regexFilter("(?i)" + search_1));
			}
		});
		searchApart.setColumns(10);
		searchApart.setBounds(781, 41, 189, 28);
		panel_1.add(searchApart);

		JButton btnSaveDataTo_1 = new JButton("Save Data To File");
		btnSaveDataTo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				if (searchApart.getText().equals("")) {
					clearFile("C:\\Users\\Admin\\Desktop\\apartment.txt");
					saveDataTo2();
					JOptionPane.showMessageDialog(frmMyApp, "The Table's Current Data Has Been Saved Successfully!");
				} else {
					JOptionPane.showMessageDialog(frmMyApp, "Please Clear \"Search\" Before Saving!");
				}
				
			}
		});
		btnSaveDataTo_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSaveDataTo_1.setBounds(646, 480, 157, 28);
		panel_1.add(btnSaveDataTo_1);

		JButton btnLoadDateFrom_1 = new JButton("Load Data From File");
		btnLoadDateFrom_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				apartList.clear(); // clear list
				loadFile2(apartList, "C:\\Users\\Admin\\Desktop\\apartment.txt"); // update list
				apartList.removeAll(Arrays.asList("", null));
				model_1.setRowCount(0); // clear table
				for (int i = 0; i < apartList.size(); i++) {
					row_1[0] = apartList.get(i).apartID;
					row_1[1] = fmt(apartList.get(i).apartArea);
					row_1[2] = (apartList.get(i).hasBanCong) ? "yes" : "no";
					row_1[3] = apartList.get(i).floor;
					row_1[4] = apartList.get(i).type;
					row_1[5] = fmt(apartList.get(i).price);
					row_1[6] = apartList.get(i).sold;
					model_1.addRow(row_1);
				}
				JOptionPane.showMessageDialog(frmMyApp, "Load The File Successfully!");

			}
		});
		btnLoadDateFrom_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLoadDateFrom_1.setBounds(813, 480, 157, 28);
		panel_1.add(btnLoadDateFrom_1);

		//sort apartment id button
//		JButton btnSortById_1 = new JButton("Sort By ID");
//		btnSortById_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				apartList.clear();
//				for (int i = 0; i < table_1.getRowCount(); i++) {
//					apartList.add(new Apartment(model_1.getValueAt(i, 0).toString(),
//							Double.parseDouble(model_1.getValueAt(i, 1).toString()),
//							(model_1.getValueAt(i, 2).toString().equals("yes") ? true : false),
//							Integer.parseInt(model_1.getValueAt(i, 3).toString()), model_1.getValueAt(i, 4).toString(),
//							Double.parseDouble(model_1.getValueAt(i, 5).toString()),
//							model_1.getValueAt(i, 6).toString()));
//
//				}
//				sortApartID(apartList);
////				for (int i = 0; i < table_1.getRowCount(); i++)
////					System.out.println(apartList.get(i).toString());
//				model_1.setRowCount(0);
//				for (int i = 0; i < apartList.size(); i++) {
//					row_1[0] = apartList.get(i).apartID;
//					row_1[1] = fmt(apartList.get(i).apartArea);
//					row_1[2] = (apartList.get(i).hasBanCong) ? "yes" : "no";
//					row_1[3] = apartList.get(i).floor;
//					row_1[4] = apartList.get(i).type;
//					row_1[5] = apartList.get(i).price;
//					row_1[6] = apartList.get(i).sold;
//					model_1.addRow(row_1);
//				}
//			}
//		});
//
//		btnSortById_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		btnSortById_1.setBounds(395, 480, 122, 28);
//		panel_1.add(btnSortById_1);

		JButton btnAdd_1_2 = new JButton("Get Payment");
		btnAdd_1_2.setBackground(new Color(255, 228, 196));
		
		btnAdd_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAdd_1_2.setBounds(216, 244, 122, 28);
		panel_1.add(btnAdd_1_2);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(144, 238, 144));
		panel_6.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "STATISTIC", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6.setBounds(50, 373, 288, 147);
		panel_1.add(panel_6);
		
		listModel = new DefaultListModel<String>();
		
		JButton btnStatistic = new JButton("Show");
		btnStatistic.setBounds(192, 39, 86, 21);
		btnStatistic.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnStatistic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String a="Unsold House:";
//				textArea_Statistic.append(a);
				listModel.clear();
				int count=0;
				for (int i = 0; i < table_1.getRowCount(); i++) {
					if (model_1.getValueAt(table_1.convertRowIndexToModel(i), 6).equals("no")) {
						listModel.addElement( model_1.getValueAt(table_1.convertRowIndexToModel(i), 0).toString());
						count++;
					}
				}
				textField_unSold.setText(String.valueOf(count) + " Unsold House(s):");

				
			}
		});	
		panel_6.setLayout(null);
		panel_6.add(btnStatistic);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 21, 172, 115);
		panel_6.add(scrollPane_2);
		
		//DefaultListModel<String> listModel = new DefaultListModel<>();
//		JList<String> list = new JList<>( model );
//
//		for ( int i = 0; i < customers.length; i++ ){
//		  model.addElement( customers[i].getName() );
//		}
		//String[] week = {"mondey", "tuesday","adasd","asdadasdadadadasda"};
		//JList<String> unsoldList = new JList<String>(listModel);
		JList<String> unsoldList = new JList<String>();
		unsoldList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				for (int i = 0; i < table_1.getRowCount(); i++) {
					int a=table_1.convertRowIndexToView(i);
					System.out.println(a);

					if (model_1.getValueAt(a, 0).equals(unsoldList.getSelectedValue()))
					{
//						System.out.println(table_1.convertRowIndexToModel(i));
//						System.out.println(model_1.getValueAt(table_1.convertRowIndexToModel(i), 0));
						table_1.setRowSelectionInterval(table_1.convertRowIndexToView(a),table_1.convertRowIndexToView(a));				
					}	
				}
				textField_calID.setText(model_1.getValueAt(table_1.convertRowIndexToModel(table_1.getSelectedRow()), 0).toString());
			}
		});

		scrollPane_2.setViewportView(unsoldList);
		unsoldList.setModel(listModel);
		
		unsoldList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		textField_unSold = new JTextField();
		scrollPane_2.setColumnHeaderView(textField_unSold);
		textField_unSold.setEditable(false);
		textField_unSold.setColumns(10);
		
		JButton btnCl = new JButton("Clear");
		btnCl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModel.clear();
				textField_unSold.setText("");
			}
		});
		btnCl.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCl.setBounds(192, 80, 86, 21);
		panel_6.add(btnCl);
		
		

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(250, 235, 215));
		tabbedPane.addTab("PAYMENT", null, panel_2, null);
		tabbedPane.setBackgroundAt(2, new Color(255, 255, 255));
		panel_2.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(122, 90, 310, 188);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_5_1 = new JLabel("House ID:");
		lblNewLabel_5_1.setBounds(6, 64, 81, 23);
		panel_3.add(lblNewLabel_5_1);
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 13));

		textField_calID = new JTextField();
		textField_calID.setBounds(97, 62, 183, 28);
		panel_3.add(textField_calID);
		
		textField_calID.setColumns(10);

		JLabel lblNewLabel_4_2_2 = new JLabel("BY HOUSE ID");
		lblNewLabel_4_2_2.setBounds(10, 11, 284, 23);
		panel_3.add(lblNewLabel_4_2_2);
		lblNewLabel_4_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2_2.setFont(new Font("Tahoma", Font.BOLD, 13));

		

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(547, 90, 310, 188);
		panel_2.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_2_1_1 = new JLabel("Has Balcony?");
		lblNewLabel_2_1_1.setBounds(6, 113, 81, 23);
		panel_4.add(lblNewLabel_2_1_1);
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JLabel lblEmail_1_1 = new JLabel("Type:");
		lblEmail_1_1.setBounds(6, 45, 81, 23);
		panel_4.add(lblEmail_1_1);
		lblEmail_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));

		textField_1 = new JTextField();
		textField_1.setBounds(97, 76, 183, 28);
		panel_4.add(textField_1);
		textField_1.setColumns(10);

		JCheckBox box_2 = new JCheckBox("");
		box_2.setBounds(97, 113, 27, 23);
		panel_4.add(box_2);
		box_2.setHorizontalAlignment(SwingConstants.CENTER);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(97, 46, 183, 22);
		panel_4.add(comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Two Bed", "Three Bed", "Penthouse"}));

		JLabel lblNewLabel_4_2_2_1 = new JLabel("BY INFORMATION");
		lblNewLabel_4_2_2_1.setBounds(10, 11, 290, 23);
		panel_4.add(lblNewLabel_4_2_2_1);
		lblNewLabel_4_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lblEmail_1_1_1 = new JLabel("Floor:");
		lblEmail_1_1_1.setBounds(6, 79, 81, 23);
		panel_4.add(lblEmail_1_1_1);
		lblEmail_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JButton btnCal_1 = new JButton("Calculate");
		
		btnCal_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCal_1.setBounds(97, 149, 108, 28);
		panel_4.add(btnCal_1);

		JLabel lblNewLabel_4_2_2_2 = new JLabel("CALCULATE RECEIPT");
		lblNewLabel_4_2_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_2_2_2.setBounds(10, 36, 960, 23);
		panel_2.add(lblNewLabel_4_2_2_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 228, 196));
		panel_5.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Receipt", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(338, 289, 292, 188);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(37, 25, 221, 99);
		panel_5.add(textArea);
		textArea.setBackground(new Color(230, 230, 250));
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField_pay = new JTextField();
		textField_pay.setBounds(103, 135, 78, 28);
		panel_5.add(textField_pay);
		textField_pay.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_pay.setFont(new Font("Tahoma", Font.BOLD, 18));
		// textField_pay.setToolTipText("");
		textField_pay.setColumns(10);
		
				JLabel lblNewLabel_5_1_1 = new JLabel("TOTAL PAY:");
				lblNewLabel_5_1_1.setBounds(27, 139, 70, 23);
				panel_5.add(lblNewLabel_5_1_1);
				lblNewLabel_5_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
				lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
				
						JLabel lblNewLabel_6 = new JLabel("(Billion VND)");
						lblNewLabel_6.setBounds(184, 145, 74, 14);
						panel_5.add(lblNewLabel_6);
		
		btnAdd_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table_1.convertRowIndexToModel(table_1.getSelectedRow()) < 0)
					JOptionPane.showMessageDialog(frmMyApp, "Please Select The Row First!");
				else {
					tabbedPane.setSelectedIndex(2);
					int i = table_1.convertRowIndexToModel(table_1.getSelectedRow()) ;
					textArea.setText("");
					textArea.append(calculate(i));
				}
				
			}
		});
		
		JButton btnCal = new JButton("Calculate");
		btnCal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=0;
				for (int i=0;i<model_1.getRowCount();i++) {	
					int n = table_1.convertRowIndexToView(i);
					if (textField_calID.getText().equals(model_1.getValueAt((n), 0).toString())) {
						textArea.setText("");
						textArea.append(calculate(n));
						a=0;
						break;
					}
					else
						a=-1;
				}
				if (a==-1)
					JOptionPane.showMessageDialog(frmMyApp, "Can't Find A House With This ID!");
			}
		});
		btnCal.setBounds(97, 132, 108, 28);
		panel_3.add(btnCal);
		btnCal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		
		btnCal_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isInteger(textField_1.getText(), 10))
					JOptionPane.showMessageDialog(frmMyApp, "Please Fill Floor With An Unsigned Integer Number!");
				else if (Integer.parseInt(textField_1.getText())<0) 
					JOptionPane.showMessageDialog(frmMyApp, "Please Fill Floor With An Unsigned Integer Number!");
				else{

					if (comboBox_1.getSelectedItem().toString().equals("Two Bed")) {
						TwoBed two = new TwoBed("", 0000, (box_2.isSelected()), Integer.parseInt(textField_1.getText()));
						String[] result2 = two.payment();
						textField_pay.setText(result2[0]);

						textArea.setText("");
						textArea.append( "Two Bed" + System.getProperty("line.separator") + "Original price: " + two.price
								+ System.getProperty("line.separator") + "Has balcony: +" + Double.parseDouble(result2[1]) * 0.1
								+ System.getProperty("line.separator") + "Floor = " + two.floor + ": " + " +" + result2[2]);
					} else if (comboBox_1.getSelectedItem().toString().equals("Three Bed")) {
						ThreeBed three = new ThreeBed("", 0000, (box_2.isSelected()),
								Integer.parseInt(textField_1.getText()));
						String[] result3 = three.payment();
						textField_pay.setText(result3[0]);

						textArea.setText("");
						textArea.append( "Three Bed" + System.getProperty("line.separator") + "Original price: " + three.price
								+ System.getProperty("line.separator") + "Has balcony: +" + Double.parseDouble(result3[1]) * 0.2
								+ System.getProperty("line.separator") + "Floor = " + three.floor + ": " + " +" + result3[2]);
					} else {
						PentHouse pent = new PentHouse("", 0000, (box_2.isSelected()),
								Integer.parseInt(textField_1.getText()));
						String[] result4 = pent.payment();
						textField_pay.setText(result4[0]);

						textArea.setText("");
						textArea.append( "Penthouse" + System.getProperty("line.separator") + "Original price: " + pent.price
								+ System.getProperty("line.separator") + "Has balcony: +" + Double.parseDouble(result4[1]) * 0.2
								+ System.getProperty("line.separator") + "Floor = " + pent.floor + ": " + " +" + result4[2]);
					}
				}

			}
		});
		
		
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_apartID.getText().equals("") || textField_area.getText().equals("")
						|| textField_floor.getText().equals("")) {
					JOptionPane.showMessageDialog(frmMyApp, "Please Fill All The Information!");
				} else if (!isNumeric(textField_area.getText()) || !isNumeric(textField_floor.getText()))
					JOptionPane.showMessageDialog(frmMyApp, "Please Fill Area & Floor With Numbers!");
				else if (!isInteger(textField_floor.getText(), 10))
					JOptionPane.showMessageDialog(frmMyApp, "Please Fill Floor With An Integer Number!");
				else {
					// add row
					row_1[0] = textField_apartID.getText();
					row_1[1] = textField_area.getText();
					if (box.isSelected())
						row_1[2] = "yes";
					else
						row_1[2] = "no";
					row_1[3] = textField_floor.getText();
					row_1[4] = comboBox.getSelectedItem().toString();
					if (comboBox.getSelectedItem().toString().equals("Two Bed"))
						row_1[5] = "1.5";
					else if (comboBox.getSelectedItem().toString().equals("Three Bed"))
						row_1[5] = "2.5";
					else
						row_1[5] = "5";
					if (box_1.isSelected())
						row_1[6] = "yes";
					else
						row_1[6] = "no";
					model_1.addRow(row_1);
					// clear text field
					textField_apartID.setText("");
					textField_area.setText("");
					textField_floor.setText("");
					comboBox.setSelectedItem("Two Bed");
					box.setSelected(false);
					box_1.setSelected(false);
					JOptionPane.showMessageDialog(frmMyApp, "Added Successfully!");
				}
			}
		});
	}
}
