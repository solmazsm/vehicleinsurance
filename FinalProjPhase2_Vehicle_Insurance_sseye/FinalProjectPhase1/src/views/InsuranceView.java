package views;

/**
 * @author (Solmaz Seyed Monir) Sunday, April 21,2018 InsuranceView.java Fianl Project
 *         package views  To write a program that to implement phase1 idea into 
 *         an MVC format.
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComponent;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.sql.PreparedStatement;
import application.InsuranceMainController;
import carsInsurance.InsuranceCompany;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.awt.Dimension;
import models.DBConnect;
import models.DaoModel;
import java.awt.Component;
import javax.swing.Action;
import javax.sql.RowSetEvent;
import javax.sql.rowset.CachedRowSet;
import javax.swing.AbstractButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import java.util.Collection;

/*
 * shows JTable output
 */
public class InsuranceView extends JPanel implements ActionListener {

	JLabel username1, password1, state1, zipcode1, insuredName1, vin1, policyNumber1;
	JTextField usernametxt, passwordtxt, statetxt, zipcodetxt, insuredNametxt, vintxt, policyNumbertxt;
	JButton btnInsert, btnDelete, btnUpdate;

	String username, password, state, zipcode, insuredName, vin, policyNumber;
	JScrollPane jscroll;
	// ResultSet resultset2;

	// private javax.swing.JTextField[] usernametxt1, passwordtxt1, statetxt1,
	// zipcodetxt1, insuredNametxt1, vintxt1, policyNumbertxt1; //array of
	// JTextField
	/*
	 * View table from policy that can insert-delete-update by Agent show a Agent
	 * functionality for insert, update of a record, and the deletion of a record.
	 * After Agent login ----> show a policy table
	 */
	public void view_table(DaoModel daomodel, JFrame fm) {

		ResultSet resultset2;
		try {
			resultset2 = daomodel.retrieveRecords();
			Vector<Vector<Object>> rowdata = new Vector<Vector<Object>>();
			Vector<String> columndata = new Vector<String>();
			ResultSetMetaData mData = resultset2.getMetaData();
			int columns1 = mData.getColumnCount();
			/*
			 * get column names from table
			 * 
			 */
			String column = "";
			for (int i = 1; i <= columns1; i++) {
				column = mData.getColumnName(i);
				columndata.add(column);
			}
			/*
			 * get row data
			 * 
			 */
			while (resultset2.next()) {
				Vector<Object> rowData = new Vector<Object>(columns1);
				for (int i = 1; i <= columns1; i++)
					rowData.addElement(resultset2.getObject(i));
				rowdata.addElement(rowData);
			}

			// DefaultTableModel model = new DefaultTableModel(rowdata, columndata);
			JTable t = new JTable(rowdata, columndata);
			t.setAutoCreateRowSorter(true);

			t.setPreferredScrollableViewportSize(new Dimension(910, 420));
			t.setFillsViewportHeight(true);
			JTableHeader header = t.getTableHeader();
			header.setBackground(Color.blue);

			jscroll = new JScrollPane(t);
			fm.add(jscroll);
			// fm.setSize(2000, 1500);
			// fm.add(new JScrollPane(t));
			t.setBackground(Color.pink);

			// fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void runView(DaoModel daomodel) throws ClassNotFoundException {
		/*
		 * instantiate vector objects
		 * 
		 */
		JPanel p = new JPanel(new GridLayout(21, 11));

		JFrame fm = new JFrame("Policy View");

		// p.setBackground(Color.green);

		// view_table(daomodel, fm);
		p.setForeground(Color.blue);
		fm.getContentPane().add(p);
		fm.getContentPane().setBackground(Color.orange);
		fm.pack();
		// fm.setVisible(true);
		// fm.getContentPane().setLayout(new FlowLayout());
		// fm.setLayout(new GridLayout(4,4,10,5));
		/*
		 * create menuBar
		 */
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem logout = new JMenuItem("Logout");
		// menu.addActionListener((ActionEvent e) -> {
		// System.exit(0);
		// });

		menu.add(logout);
		menubar.add(menu);
		logout.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.exit(0);
			}
		});
		fm.setJMenuBar(menubar);
		fm.setVisible(true);
		fm.getContentPane().setLayout(new FlowLayout());
		// fm.setLayout(new GridLayout(4,4,10,5));
		policyNumbertxt = new JTextField("", 11);
		usernametxt = new JTextField(" ", 11);
		passwordtxt = new JTextField(" ", 11);
		statetxt = new JTextField(" ", 11);
		zipcodetxt = new JTextField("", 11);
		insuredNametxt = new JTextField("", 11);
		vintxt = new JTextField("", 11);

		JLabel policyNumber1 = new JLabel();

		policyNumber1.setText("PlicyNumber :");
		policyNumber1.setBounds(400, 400, 200, 30);
		p.add(policyNumber1);
		p.add(policyNumbertxt);

		JLabel username1 = new JLabel();
		username1.setText("Username :");
		username1.setBounds(10, 10, 100, 100);
		// username1.setBackground(Color.green);
		// fm.getContentPane().add(username);
		p.add(username1);
		p.add(usernametxt);
		// fm.getContentPane().add(usernametxt);

		JLabel password1 = new JLabel();
		password1.setText("Password :");
		password1.setBounds(400, 400, 200, 30);

		// fm.getContentPane().add(password);
		p.add(password1);
		p.add(passwordtxt);

		// fm.getContentPane().add(passwordtxt);
		JLabel state1 = new JLabel();
		state1.setText("State :");
		state1.setBounds(300, 300, 200, 30);
		p.add(state1);
		p.add(statetxt);
		// fm.getContentPane().add(state
		// );
		// fm.getContentPane().add(statetxt);
		// fm.setLayout(new GridLayout(3,2,10,5));
		JLabel zipcode1 = new JLabel();
		zipcode1.setText("Zipcode :");
		zipcode1.setBounds(30, 30, 300, 300);
		// fm.getContentPane().add(zipcode);
		p.add(zipcode1);
		p.add(zipcodetxt);
		// fm.getContentPane().add(zipcodetxt);
		JLabel insuredName1 = new JLabel();
		insuredName1.setText("InsuredName :");
		insuredName1.setBounds(400, 400, 200, 30);

		p.add(insuredName1);
		p.add(insuredNametxt);
		// fm.setLayout(new GridLayout(3,2,10,5));

		JLabel vin1 = new JLabel();
		vin1.setText("Vin :");
		vin1.setBounds(400, 400, 200, 30);

		// fm.getContentPane().add(password);
		p.add(vin1);
		p.add(vintxt);

		// fm.getContentPane().add(password);
		/*
		 * create buttons for insert,update,delete
		 */
		btnInsert = new JButton("Insert");
		// btnInsert.setBorder(BorderFactory.createLineBorder(Color.blue , 1));
		btnUpdate = new JButton("Update");
		// btnUpdate.setBorder(BorderFactory.createLineBorder(Color.BLUE , 1));
		btnDelete = new JButton("Delete");
		// btnDelete.setBorder(BorderFactory.createLineBorder(Color.BLUE , 1));

		// btnInsert.setAction( event);
		/*
		 * Add buttons to panel
		 */
		p.add(btnInsert);
		p.add(btnUpdate);
		p.add(btnDelete);
		view_table(daomodel, fm);

		fm.setSize(2000, 2000);
		// t.setBackground(Color.pink);

		fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		fm.pack();
		fm.setVisible(true);

		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					daomodel.insertPolicy(policyNumbertxt.getText(), usernametxt.getText(), passwordtxt.getText(),
							statetxt.getText(), zipcodetxt.getText(), insuredNametxt.getText(), vintxt.getText());
					fm.remove(jscroll);
					view_table(daomodel, fm);
					fm.pack();
					// view_table(daomodel, fm);
					// JOptionPane.showMessageDialog(null, "data inserted to the database!");

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

		});

		// Button Delete

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					daomodel.deletePolicy(policyNumbertxt.getText());
					fm.remove(jscroll);
					view_table(daomodel, fm);
					fm.pack();
					// view_table(daomodel, fm);
					// JOptionPane.showMessageDialog(null, "Row deleted from the database!");

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

		});

		// Button Update

		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					daomodel.updatePolicy(policyNumbertxt.getText(), usernametxt.getText(), passwordtxt.getText(),
							statetxt.getText(), zipcodetxt.getText(), insuredNametxt.getText(), vintxt.getText());
					fm.remove(jscroll);
					view_table(daomodel, fm);
					fm.pack();

					// view_table(daomodel, fm);
					// JOptionPane.showMessageDialog(null,"Updated successfully");

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
