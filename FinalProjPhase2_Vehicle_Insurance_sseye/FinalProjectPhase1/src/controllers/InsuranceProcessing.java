package controllers;

/**
 * @author (Solmaz Seyed Monir) Sunday, April 21,2018 ClaimViewView.java Fianl Project
 *         package views  To write a program that to implement phase1 idea into 
 *         an MVC format.
 */
import java.awt.EventQueue;
import java.sql.ResultSet;
/**
 * @author (Solmaz Seyed Monir) Sunday, April 1,2018 LoanView.java Lab 04
 *         package controllers  To write a program that with a MVC 'simulated approach that
 *         performs a Loan analysis from class objects created in lab #2.
 */
/*
 * For this lab continue using current project folder created for labs 2 & 3 and
 * creat the following packages 
 * ( models, controllers, views) & 
 * their containments in an MVC  style
 */
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import models.ClaimModel;
import models.ClaimModel;
import models.DaoModel;
import views.ClaimView;
import views.InsuranceView;
import views.PieChartFileAmount;

import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import models.ClaimModel;
import carsInsurance.InsuranceCompany;

/*
 * processing for claim view and claim model 
 * Insurance processing class can handle and run 
 * that class and craet relationship between claim view class claim model 
 */
public class InsuranceProcessing extends InsuranceCompany {
	public static void open() {
		// Create the current date and time

		// String timeStamp = new SimpleDateFormat("YYYY/MM/dd
		// HH:mm:ss").format(Calendar.getInstance().getTime());
		InsuranceCompany b = new InsuranceCompany();
		b.readData();
		// DaoModel daomodel = new DaoModel();
		ClaimModel claimModel = new ClaimModel();
		// daomodel.createTable();
		// claimModel.createTable();
	//	claimModel.insertRecords(array1);
		// daomodel.insertRecords(array1);

		// try {
		// new InsuranceView().runView(daomodel);
		// } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		claimModel.insertRecords(array1);

		try {

			new ClaimView().runView(claimModel);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SwingUtilities.invokeLater(() -> {
			PieChartFileAmount example = new PieChartFileAmount("Pie Chart for Vehocle_Insurance FileAmount");
			example.setSize(800, 400);
			example.setLocationRelativeTo(null);
			example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			example.setVisible(true);
		});

		EventQueue.invokeLater(() -> {
			ClaimView ex = new ClaimView();
			ex.setVisible(true);

		});

	}

}
