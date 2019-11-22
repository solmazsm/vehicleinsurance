package carsInsurance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InsuranceCompany extends Policy {
	/**
	 * set up static objects for IO arrayList to hold Insurance data
	 */
	protected static ArrayList<InsuranceCompany> array1 = new ArrayList<InsuranceCompany>();
	protected static ArrayList<List<String>> array2 = new ArrayList<>();
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		 * create an instance
		 */
		InsuranceCompany br = new InsuranceCompany();
				/*
				 *  call methods
				 */
			//	br.readData();
				
		/**
		 *  read in all the record data from the data_Vehicle_Crashes_Insurance.csv file in
		 * path into an ArrayList
		 */
       
        try{
        	BufferedReader br1 = new BufferedReader(new FileReader("data_Vehicle_Insurance.csv"));
            String line = null;

            while ((line = br1.readLine()) != null) {
            	array2.add(Arrays.asList(line.split(",")));
              for (List<String> str : array2) {
                System.out.println(str);
              }
            }
            br1.close();
          

        }catch (FileNotFoundException e){

            e.printStackTrace();
        }	
				
				
	}

	/**
	 * readData() method read in all the record data from the data_Vehicle_Crashes_Insurance.csv file in
	 * path into an ArrayList
	 */
	public void readData() {
		/**
		 * initialize reader object and set file path read data from bank-Detail.csv
		 * include a try catch block when reading file
		 */
		try {

			BufferedReader reader = new BufferedReader(new FileReader(new File("data_Vehicle_Insurance.csv")));
			String row;
			while ((row = reader.readLine()) != null) {
				array2.add(Arrays.asList(row.split(",")));
			}
			reader.close();

		} catch (IOException e) {
		}
		//processData();// call processData method for processing
	}

	/*
	 * process data from arrayList create for loop method take all the records from
	 * ArrayList and add the data into fields via setters call setters item by item
	 * get first item
	 */
	
	
}
