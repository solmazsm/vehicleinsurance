package views;
/**
 * @author (Solmaz Seyed Monir) Sunday, April 21,2018 ClaimView.java Fianl Project
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.sql.PreparedStatement;
import application.InsuranceMainController;
import carsInsurance.InsuranceCompany;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.Container;
import java.awt.Dimension;
import models.ClaimModel;
import models.DBConnect;
import models.DaoModel;
import javax.swing.Action;
import javax.sql.RowSetEvent;
import javax.sql.rowset.CachedRowSet;
import javax.swing.AbstractButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import java.util.Collection;
import javax.swing.table.AbstractTableModel;
import javax.swing.Icon;
import java.awt.event.MouseListener;
/*
 * shows JTable output
 */
/*
 * create an dshow claim table 
 * 
 * After users login come to in claim table for
 * insert,update,delete some records
 */
public class ClaimView extends JPanel implements ActionListener {

	JLabel ClaimId1, ClaimDate, ClaimAirbag, PointOfImpact, PolicyNumber;
	JTextField ClaimIdtxt, claimDatetxt, claimAirbagtxt, pointOfImpacttxt, policyNumbertxt, fileAmounttxt,
			isConfirmedtxt;
	JButton btnInsert, btnDelete, btnUpdate;

	String ClaimId, claimDate, claimAirbag, pointOfImpact, policyNumber;
	JScrollPane jscroll;

	public void view_table(ClaimModel claimModel, JFrame fmclaim) {

		ResultSet resultset;
		try {
			resultset = claimModel.retrieveRecords();
			Vector<Vector<Object>> rowdata = new Vector<Vector<Object>>();
			Vector<String> columndata = new Vector<String>();
			ResultSetMetaData mData = resultset.getMetaData();
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
			while (resultset.next()) {
				Vector<Object> rowData = new Vector<Object>(columns1);
				for (int i = 1; i <= columns1; i++)
					rowData.addElement(resultset.getObject(i));
				rowdata.addElement(rowData);
			}

			// DefaultTableModel model = new DefaultTableModel(rowdata, columndata);
			JTable tclaim = new JTable(rowdata, columndata);

			// JTable tclaim = new JTable(model);
			tclaim.setAutoCreateRowSorter(true);

			tclaim.setPreferredScrollableViewportSize(new Dimension(910, 420));
			tclaim.setFillsViewportHeight(true);
			JTableHeader header = tclaim.getTableHeader();
			header.setBackground(Color.blue);

			jscroll = new JScrollPane(tclaim);
			fmclaim.add(jscroll);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void runView(ClaimModel claimModel) throws ClassNotFoundException {
		/*
		 * instantiate vector objects
		 * 
		 */
		JPanel pclaim = new JPanel(new GridLayout(21, 11));

		JFrame fmclaim = new JFrame("Claim View");

		// p.setBackground(Color.green);

		pclaim.setForeground(Color.blue);
		fmclaim.getContentPane().add(pclaim);
		fmclaim.getContentPane().setBackground(Color.blue);
		fmclaim.pack();
/*
 * create menu bar for File,Edit,Help
 */
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem logout = new JMenuItem("Logout");
		// menu.addActionListener((ActionEvent e) -> {
		// System.exit(0);
		// });

		menu.add(logout);
		menubar.add(menu);
		/*
		 * Add action Logout for menu File
		 */
		logout.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.exit(0);
			}
		});

		menu.setMnemonic(KeyEvent.VK_F);

		JMenu edit, help;
		JMenuItem cut, copy, paste, selectAll;
		JTextArea ta;

		cut = new JMenuItem("cut");
		copy = new JMenuItem("copy");
		paste = new JMenuItem("paste");
		selectAll = new JMenuItem("selectAll");
		cut.addActionListener(this);
		copy.addActionListener(this);
		paste.addActionListener(this);
		selectAll.addActionListener(this);
		// JMenuBar mb=new JMenuBar();
		// file=new JMenu("File");
		edit = new JMenu("Edit");
		help = new JMenu("Help");
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		edit.add(selectAll);
		menubar.add(edit);
		menubar.add(help);
		ta = new JTextArea();
		ta.setBounds(5, 5, 360, 320);
		fmclaim.add(menubar);
		fmclaim.add(ta);
		fmclaim.setJMenuBar(menubar);
		fmclaim.setLayout(null);
		// fmclaim.setSize(400,400);
		fmclaim.setVisible(true);
		cut.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (evt.getSource() == cut)
					ta.cut();
			}
		});
		copy.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (evt.getSource() == copy)
					ta.copy();
			}
		});
		paste.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (evt.getSource() == paste)
					ta.paste();
			}
		});
		selectAll.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (evt.getSource() == selectAll)
					ta.selectAll();
			}
		});

		menu.addActionListener((ActionEvent e) -> {

			if (e.getSource() == cut)
				ta.cut();
			if (e.getSource() == paste)
				ta.paste();
			if (e.getSource() == copy)
				ta.copy();
			if (e.getSource() == selectAll)
				ta.selectAll();
		});

		fmclaim.setJMenuBar(menubar);
		fmclaim.setVisible(true);
		fmclaim.getContentPane().setLayout(new FlowLayout());
		// fm.setLayout(new GridLayout(4,4,10,5));

		ClaimIdtxt = new JTextField("", 11);
		claimDatetxt = new JTextField(" ", 11);
		claimAirbagtxt = new JTextField(" ", 11);
		pointOfImpacttxt = new JTextField(" ", 11);
		policyNumbertxt = new JTextField("", 11);
		fileAmounttxt = new JTextField("", 11);
		isConfirmedtxt = new JTextField("", 11);

		JLabel ClaimId1 = new JLabel();

		ClaimId1.setText("ClaimId :");
		ClaimId1.setBounds(400, 400, 200, 30);
		pclaim.add(ClaimId1);
		pclaim.add(ClaimIdtxt);

		JLabel PolicyNumber = new JLabel();
		PolicyNumber.setText("policyNumber :");
		PolicyNumber.setBounds(30, 30, 300, 300);
		// fm.getContentPane().add(zipcode);
		pclaim.add(PolicyNumber);
		pclaim.add(policyNumbertxt);
		// fm.getContentPane().add(policyNumbertxt);

		JLabel ClaimDate = new JLabel();
		ClaimDate.setText("ClaimDate :");
		ClaimDate.setBounds(10, 10, 100, 100);
		// ClaimDate.setBackground(Color.green);
		// fm.getContentPane().add(ClaimDate);
		pclaim.add(ClaimDate);
		pclaim.add(claimDatetxt);
		// fm.getContentPane().add(claimDatetxt);

		JLabel ClaimAirbag = new JLabel();
		ClaimAirbag.setText("ClaimAirbag :");
		ClaimAirbag.setBounds(400, 400, 200, 30);

		// fm.getContentPane().add(password);
		pclaim.add(ClaimAirbag);
		pclaim.add(claimAirbagtxt);

		// fm.getContentPane().add(claimAirbagtxt);
		JLabel PointOfImpact = new JLabel();
		PointOfImpact.setText("PointOfImpact :");
		PointOfImpact.setBounds(300, 300, 200, 30);
		pclaim.add(PointOfImpact);
		pclaim.add(pointOfImpacttxt);
		// fm.getContentPane().add(state
		// );
		// fm.getContentPane().add(pointOfImpacttxt);
		// fm.setLayout(new GridLayout(3,2,10,5));

		JLabel fileAmount = new JLabel();
		fileAmount.setText("FileAmount :");
		fileAmount.setBounds(30, 30, 300, 300);
		// fm.getContentPane().add(zipcode);
		pclaim.add(fileAmount);
		pclaim.add(fileAmounttxt);
		// fm.getContentPane().add(policyNumbertxt);

		JLabel isConfirmed = new JLabel();
		isConfirmed.setText("IsConfirmed :");
		isConfirmed.setBounds(30, 30, 300, 300);
		pclaim.add(isConfirmed);
		pclaim.add(isConfirmedtxt);
		// fm.getContentPane().add(policyNumbertxt);
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

		pclaim.add(btnInsert);
		pclaim.add(btnUpdate);
		pclaim.add(btnDelete);

		view_table(claimModel, fmclaim);

		fmclaim.setSize(2000, 2000);
		// t.setBackground(Color.pink);

		fmclaim.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		fmclaim.pack();
		fmclaim.setVisible(true);

		/*
		 * Button Insert
		 */
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					claimModel.insertClaim(ClaimIdtxt.getText(), policyNumbertxt.getText(), claimDatetxt.getText(),
							claimAirbagtxt.getText(), pointOfImpacttxt.getText(), fileAmounttxt.getText(),
							isConfirmedtxt.getText());

					fmclaim.remove(jscroll);
					view_table(claimModel, fmclaim);
					fmclaim.pack();
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

					claimModel.deleteClaim(ClaimIdtxt.getText());
					// SwingUtilities.updateComponentTreeUI(fmclaim);

					fmclaim.remove(jscroll);
					view_table(claimModel, fmclaim);
					fmclaim.pack();
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

					claimModel.updateClaim(ClaimIdtxt.getText(), policyNumbertxt.getText(), claimDatetxt.getText(),
							claimAirbagtxt.getText(), pointOfImpacttxt.getText(), fileAmounttxt.getText(),
							isConfirmedtxt.getText());
					// JOptionPane.showMessageDialog(null,"Updated successfully");
					fmclaim.remove(jscroll);
					view_table(claimModel, fmclaim);
					fmclaim.pack();

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
