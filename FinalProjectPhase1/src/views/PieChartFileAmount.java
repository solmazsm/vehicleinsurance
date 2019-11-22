package views;
/**
 * @author (Solmaz Seyed Monir) Sunday, April 21,2018 PiechartFileAmountView.java Fianl Project
 *         package views  To write a program that to implement phase1 idea into 
 *         an MVC format.
 */

import java.text.DecimalFormat;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/*
 * create pie chart for File amount in claim table
 * File amount show mony that company should paid for users
 * (customers) after their claims has been approved.
 * insurance make a aggreement with customers users betwween $2000 to $5000
 */
public class PieChartFileAmount extends JFrame {

	private static final long serialVersionUID = 6294689542092367723L;

	public PieChartFileAmount(String title) {
		super(title);

		// Create dataset
		PieDataset dataset = createDataset();

		// Create chart
		JFreeChart chart = ChartFactory.createPieChart("Pie Chart FileAmount for Vehicle_Insurance Company", dataset,
				true, true, false);

		// Format Label
		PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("FileAmount {0} : ({2})",
				new DecimalFormat("0"), new DecimalFormat("0%"));
		((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);

		// Create Panel
		ChartPanel panel = new ChartPanel(chart);
		setContentPane(panel);
	}

	// Create Panel
	private JFreeChart chart;
	ChartPanel panel = new ChartPanel(chart);
	// setContentPane(panel);

	private PieDataset createDataset() {

		DefaultPieDataset datasetFileAmount = new DefaultPieDataset();
		datasetFileAmount.setValue("4500-5000", 1);
		datasetFileAmount.setValue("4000-4500", 1);
		datasetFileAmount.setValue("3500-4000", 2);
		datasetFileAmount.setValue("2500-3500", 3);
		datasetFileAmount.setValue("2000-2500", 2);
		return datasetFileAmount;
	}

}