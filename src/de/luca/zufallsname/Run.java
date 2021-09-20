package de.luca.zufallsname;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Run extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private static Random randomGenerator = new Random();
	static List<String> zeilenListe;
	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
	
		File liste_txt = new File("liste.txt");
		BufferedReader bufferedReader = new BufferedReader(new FileReader(liste_txt));
		zeilenListe = new ArrayList<String>();
		String zeileString;
		while((zeileString=bufferedReader.readLine())!=null) {
		    zeilenListe.add(zeileString);
		    System.out.println(zeileString);
		}
		bufferedReader.close();
		
		int index = randomGenerator.nextInt(zeilenListe.size());
		
		String randomZeile = zeilenListe.get(index);
		
		
		try {
        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch(Exception e){
	    	e.printStackTrace();
	    }
	    
		try {
			Run dialog = new Run(randomZeile);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Run(String randomZeile) {
		setTitle("Zufalls Name");
		setBounds(100, 100, 227, 102);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblNewLabel = new JLabel(randomZeile);
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener (new ActionListener () {
					 public void actionPerformed (ActionEvent e) {
						  System.exit(0);
						 }
					});
				JButton btnNewButton = new JButton("NEU");
				btnNewButton.addActionListener (new ActionListener () {
					 public void actionPerformed (ActionEvent e) {
						  NeueZeile();
						 }
					});
				buttonPane.add(btnNewButton);

				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	
	private void NeueZeile() {
		int index = randomGenerator.nextInt(zeilenListe.size());
		
		String randomZeile = zeilenListe.get(index);
		
		lblNewLabel.setText(randomZeile);		
	}

}
