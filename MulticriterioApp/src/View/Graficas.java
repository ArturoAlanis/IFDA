package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.AbstractBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import Control.Controller;

public class Graficas extends JPanel {
	private JLabel lblNameApp;
	private JLabel lblDescription;
	private DefaultCategoryDataset dataset;
	private ArrayList<String> data;
	private JFreeChart boxGrafic;
	private ChartPanel panelGrafic;
	private ButtonGeneral btnAcceptOption;
	private ButtonGeneral btnCancelOption;
	private GridBagConstraints gbc;

	public Graficas(Controller control, String actionSelect, String actionCancel, String nameApp,  String mssDescription, ArrayList<String> data) {
		lblNameApp = new JLabel(nameApp);
		lblDescription = new JLabel(mssDescription);
		btnAcceptOption = new ButtonGeneral("Guardar Gráfica ", 150, 30);
		btnAcceptOption.setActionCommand(actionSelect);
		btnAcceptOption.addActionListener(control);
		btnCancelOption = new ButtonGeneral(150, 30, null, "Cancelar");
		btnCancelOption.setActionCommand(actionCancel);
		btnCancelOption.addActionListener(control);
		
		AbstractBorder border = new TextBubbleBorder(Color.BLACK, 3, 0);
		setBorder(border);
		this.setBackground(Color.WHITE);
		this.setLayout(new GridBagLayout());
		dataset = new DefaultCategoryDataset();
		this.data = data;
		this.assignValues();
//		this.buildGrafic(Color.BLUE, Color.RED);
		this.init();
	}
	
	private void assignValues() {
		Font fuente = new Font("Calibri", 3, 14);
		fuente = new Font("Arial Black", 3, 14);
		lblNameApp.setFont(fuente);
		fuente = new Font("Arial Rounded MT Bold", 3, 14);
		lblDescription.setFont(fuente);
	}

	public void setData(ArrayList<String> data) {
		this.data = data;
	}

	public JPanel buildGrafic(Color colorDegrad1, Color colorDegrad2) {
		removeAll();
		dataset.clear();
		for (int i = 0; i < data.size(); i++) {
			String[] allPart = data.get(i).split(",");
			double value = Double.parseDouble(allPart[0]);
			String nameProyect = allPart[1];
			String nameAlternative = allPart[2];
			dataset.addValue(value, nameProyect, nameAlternative);
		}
		GaugeSpiderWebPlot spiderGrafic = new GaugeSpiderWebPlot(dataset, colorDegrad1, colorDegrad2, 0.5f);
		spiderGrafic.setMaxValue(1);
		spiderGrafic.setTicks(5);
		boxGrafic = new JFreeChart(spiderGrafic);
		panelGrafic = new ChartPanel(boxGrafic);
		panelGrafic.setPreferredSize(new Dimension(600,600));
		panelGrafic.setBackground(Color.WHITE);
		JScrollPane scroll = new JScrollPane(panelGrafic);
		JPanel panel = new JPanel();
		scroll.setBackground(Color.WHITE);
		scroll.setBorder(new TextBubbleBorder(Color.BLACK, 3, 0));
		scroll.setPreferredSize(new Dimension(630,450));
		scroll.repaint();
		GridBagConstraints gbc = new GridBagConstraints();
		panel.setLayout(new GridBagLayout());
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		panel.setBackground(Color.WHITE);
		gbc.insets = new Insets(0, 0, 30, 0);
		panel.add(lblNameApp, gbc);
		panel.add(lblDescription, gbc);
		gbc.insets = new Insets(0, 0, 0, 0);
		panel.add(scroll, gbc);
		panel.repaint();
        return panel;
//		panel.setPreferredSize(new Dimension(800,300));
//		panel.setBackground(Color.WHITE);
//		panel.add(panelGrafic);
//		ChartPanel panel = new ChartPanel(chart);
//		this.add(panelGrafic, BorderLayout.CENTER);
		
	}
	
	public void saveGraphic(String url) throws IOException {
			ChartUtilities.saveChartAsPNG(new File(url), boxGrafic, 600, 600);
	}
	
	private void init() {
		removeAll();
		gbc = new GridBagConstraints();
//		gbc.anchor = GridBagConstraints.CENTER;
//		gbc.gridwidth = GridBagConstraints.REMAINDER;
//		gbc.insets = new Insets(0, 0, 30, 0);
//		add(lblNameApp, gbc);
//		gbc.insets = new Insets(0, 0, 120, 0);
//		add(lblDescription, gbc);
//		gbc.insets = new Insets(0, 0, 0, 0);
//		add(this.buildGrafic(Color.RED, Color.BLUE), gbc);
//		gbc.gridwidth = GridBagConstraints.RELATIVE;
//		add(btnAcceptOption, gbc);
//		add(btnCancelOption, gbc);
//	}
		
//		gbc.gridx = 0;
//		gbc.gridy = 0;
//		gbc.gridwidth = 2;
//		gbc.gridheight = 1;
//		gbc.weighty = 0.2;
//		gbc.insets = new Insets(0, 0, 200, 0);
//		add(lblNameApp, gbc);
//		gbc.gridx = 0;
//		gbc.gridy = 1;
//		gbc.gridwidth = 2;
//		gbc.gridheight = 1;
//		gbc.weightx = gbc.weighty = 0.2;
//		gbc.insets = new Insets(0, 0, 0, 0);
//		add(lblDescription, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		gbc.weightx = gbc.weighty = 0.4;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(this.buildGrafic(Color.RED, Color.BLUE), gbc);
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 0;
		gbc.weightx = 1;
		gbc.weighty=0.7;
		gbc.insets = new Insets(0, 0, 50, 10);
		add(btnAcceptOption, gbc);
		gbc.weightx = 1;
		gbc.weighty=0.7;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 0;
		add(btnCancelOption, gbc);
//		gbc.weightx = 1;
//		gbc.weighty=0.7;
//		gbc.anchor = GridBagConstraints.WEST;
//		gbc.gridx = 2;
//		gbc.gridy = 3;
//		gbc.gridwidth = 1;
//		gbc.gridheight = 0;
//		add(btnSaveGraphic, gbc);
	}
}

//	public static void main(String[] args) {
//		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//		ArrayList<String> x = new ArrayList<String>();
//		x.add("0.202439208,Alt1,Alternativa 1");
//		x.add("0.327554563,Alt1,Alternativa 2");
//		x.add("0.598106105,Alt1,Alternativa 3");
//		x.add("0.603518253,Alt1,Alternativa 4");
//		x.add("0.77038541,Alt1,Alternativa 5");
//		x.add("0.354358979,Alt1,Alternativa 6");
//		x.add("0,Alt1,Alternativa 7");
//		x.add("0,Alt1,Alternativa 8");
//		x.add("0,Alt1,Alternativa 9");
//		for (int i = 0; i < x.size(); i++) {
//			String[] allPart = x.get(i).split(",");
//			double value = Double.parseDouble(allPart[0]); // 123
//			String nameProyect = allPart[1];
//			String nameAlternative = allPart[2];
//			dataset.addValue(value, nameProyect, nameAlternative);
//		}
//	        dataset.addValue(0.202439208, "Alt1", "Alternativa 1");
//	        dataset.addValue(0.327554563, "Alt1", "Alternativa 2");
//	        dataset.addValue(0.598106105, "Alt1", "Alternativa 3");
//	        dataset.addValue(0.603518253, "Alt1", "Alternativa 4");
//	        dataset.addValue(0.77038541, "Alt1", "Alternativa 5");
//	        dataset.addValue(0.354358979, "Alt1", "Alternativa 6");
//	        dataset.addValue(0.3454358979, "Alt1", "Alternativa 6");
//	        dataset.addValue(0.4358979, "Alt1", "Alternativa 7");
//	        dataset.addValue(0.58979, "Alt1", "Alternativa 8");
//	        dataset.addValue(0.58979, "Alt1", "Alternativa 9");
//	        dataset.addValue(0.58979, "Alt1", "Alternativa 10");
//	        dataset.addValue(0.58979, "Alt1", "Alternativa 11");
//	        dataset.addValue(0.58979, "Alt1", "Alternativa 12");
//	        dataset.addValue(0.58979, "Alt1", "Alternativa 13");
//	        dataset.clear();
//	        dataset.addValue(0.5, "Alt2", "Alternativa 1");
//	        dataset.addValue(0.888, "Alt2", "Alternativa 2");
//	        dataset.addValue(0.888, "Alt2", "Alternativa 2");
//	        dataset.addValue(0.888, "Alt2", "Alternativa 3");
//	        dataset.addValue(0.888, "Alt2", "Alternativa 4");
//	        dataset.addValue(0.888, "Alt2", "Alternativa 5");
//	        dataset.addValue(0.888, "Alt2", "Alternativa 6");
//		GaugeSpiderWebPlot plotMegaPro = new GaugeSpiderWebPlot(dataset, Color.blue, Color.RED, 0.5f);
//		plotMegaPro.setMaxValue(1);
//		plotMegaPro.setTicks(5);
//		JFreeChart chart = new JFreeChart(plotMegaPro);
//		ChartPanel panel = new ChartPanel(chart);
//		JFrame frame = new JFrame();
//		Graficas graficas = new Graficas();
//		graficas.setData(x);
//		graficas.buildGrafic(Color.BLUE, Color.RED);
//		frame.setLayout(new BorderLayout());
//		
//		frame.add(graficas, BorderLayout.CENTER);
//		frame.setSize(700, 600);
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		try {
//			System.out.println("ant");
//			Thread.sleep(3000);
//			System.out.println("ant2");
//
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
////		frame.remove(graficas);
//		x.clear();
//		x.add("0.202439208,Alt1,Alternativa 1");
//		x.add("0.327554563,Alt1,Alternativa 2");
//		x.add("0.598106105,Alt1,Alternativa 3");
//		x.add("0.603518253,Alt1,Alternativa 4");
//		x.add("0.77038541,Alt1,Alternativa 5");
//		x.add("0.354358979,Alt1,Alternativa 6");
////		graficas.setVisible(false);
////		graficas = null;
////		graficas = new Graficas();
//		graficas.setData(x);
//		graficas.buildGrafic(Color.GREEN, Color.GRAY);
////		graficas.setVisible(true);
////		graficas.updateUI();
//		frame.setSize(701, 600);
//		frame.add(graficas, BorderLayout.CENTER);
//	}


//}
