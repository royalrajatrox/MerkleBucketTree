package MainPackage;


import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.util.stream.*;
public class Driver implements ActionListener {
	public static ArrayList<String> ar = new ArrayList<String>();
	public static ArrayList<String> ar2 = new ArrayList<String>();
	public static ArrayList<String> ar3 = new ArrayList<String>();
	public static String[] argsArray;
	public static String[] args5Array;
	public static String[] args6Array;
	public static String[] args7Array;
	static JTextField textfield;
	static JTextField textfield2;
	static JTextField textfield3;
	static JTextField textfield4;
	static JTextField textfield5;
	static JTextField textfield6;
	static JTextField textfield7;
	static JFrame frame;
	static String args = "";
	static String args2 = "";
	static String args3 = "";
	static String args4 = "";
	static String args5 = "";
	static String args6 = "";
	static String args7 = "";
	static JButton button;
	static JButton button2;
	static JButton button3;
	static JButton button4;
	static JLabel label;
	static JLabel label2;
	static JLabel label3;
	static JLabel label4;
	static JLabel label5;
	static JLabel label6;
	static JLabel label7;
	static JScrollPane scroll;
	static JTextArea textArea;
	static JTextArea textArea2;
	static JTextArea textArea3;
	static JTextArea textArea4;

	// Create a Java swing based user interface with buttons that signal various
	// actions
	public static void createUserInterface() {
		Driver te = new Driver();
		button = new JButton("Create a Merkle Tree");
		button.setBackground(Color.BLACK);
		button.setForeground(Color.GRAY);
		button.addActionListener(te);
		button2 = new JButton("Compare Files");
		button2.setBackground(Color.BLACK);
		button2.setForeground(Color.GRAY);
		button2.addActionListener(te);
		button4 = new JButton("Compare Merkle Trees");
		button4.setBackground(Color.BLACK);
		button4.setForeground(Color.GRAY);
		button4.addActionListener(te);

		label = new JLabel("Specify the path of the file you wish to make a Merkle Bucket Tree out of (for multiple files, seperate by comma):");
		label.setVerticalTextPosition(JLabel.BOTTOM);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setToolTipText("Step 1");
		label2 = new JLabel("Specify the path of the file you wish to compare against:");
		label2.setVerticalTextPosition(JLabel.BOTTOM);
		label2.setHorizontalTextPosition(JLabel.CENTER);
		label2.setToolTipText("Step 2");
		label3 = new JLabel("Specify the path of the file you wish to compare:");
		label3.setVerticalTextPosition(JLabel.BOTTOM);
		label3.setHorizontalTextPosition(JLabel.CENTER);
		label3.setToolTipText("Step 3");
		label6 = new JLabel("Specify merkle tree array you wish to compare against:");
		label6.setVerticalTextPosition(JLabel.BOTTOM);
		label6.setHorizontalTextPosition(JLabel.CENTER);
		label6.setToolTipText("Step 4");
		label7 = new JLabel("Specify the merkle tree array you wish to compare:");
		label7.setVerticalTextPosition(JLabel.BOTTOM);
		label7.setHorizontalTextPosition(JLabel.CENTER);
		label7.setToolTipText("Step 5");

		textfield = new JTextField(80);
		textfield.setPreferredSize(new Dimension(0, 27));
		textfield.setVisible(true);

		textfield2 = new JTextField(42);
		textfield2.setPreferredSize(new Dimension(0, 27));
		textfield2.setVisible(true);

		textfield3 = new JTextField(42);
		textfield3.setPreferredSize(new Dimension(0, 27));
		textfield3.setVisible(true);

		textfield6 = new JTextField(39);
		textfield6.setPreferredSize(new Dimension(0, 27));
		textfield6.setVisible(true);

		textfield7 = new JTextField(39);
		textfield7.setPreferredSize(new Dimension(0, 27));
		textfield7.setVisible(true);

		textArea = new JTextArea(20, 147);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setVisible(true);

		textArea2 = new JTextArea(1, 149);
		textArea2.setLineWrap(true);
		textArea2.setEditable(false);
		textArea2.setVisible(true);

		textArea4 = new JTextArea(1, 149);
		textArea4.setLineWrap(true);
		textArea4.setEditable(false);
		textArea4.setVisible(true);

		JPanel panel = new JPanel();


		panel.add(label);
		panel.add(textfield);
		panel.add(button);
		panel.add(textArea);
		panel.setBackground(Color.GRAY);


		scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel.add(scroll);

		panel.add(label2);
		panel.add(textfield2);
		panel.add(label3);
		panel.add(textfield3);
		panel.add(button2);
		panel.add(textArea2);
		panel.add(label6);
		panel.add(textfield6);
		panel.add(label7);
		panel.add(textfield7);
		panel.add(button4);
		panel.add(textArea4);



		frame = new JFrame("MainSwingFrame");
		frame.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Merkle Bucket Tree GUI");
		frame.pack();
		frame.setVisible(true);
		frame.setBackground(Color.BLUE);
	}


	public boolean merkleTreeStub(MerkleTree<Object> mt1, MerkleTree<Object> mt2) {// stub used to quickly test whether
		// two merkle trees have a root node
		// that is equal to one another
		if (mt1.getMerkleTree().equals(mt2.getMerkleTree())) {
			return true;
		} else {
			return false;
		}
	}


	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		args = textfield.getText();
		argsArray = args.split(",");
		args2 = textfield2.getText();
		args3 = textfield3.getText();
		args6 = textfield6.getText();
		args7 = textfield7.getText();
		// args6 = args6.replace("[", "");
		// args6 = args6.replace("]", "");
		args6Array = args6.split(",");
		// args7 = args7.replace("[", "");
		// args7 = args7.replace("]", "");
		args7Array = args7.split(",");
		// System.out.println(Arrays.toString(args6Array));

		// create and display a merkle tree from a file
		if (s == "Create a Merkle Tree") {
			textArea.setText("");
			ArrayList<ProcessFileSub> pf = new ArrayList<ProcessFileSub>();
			try {
				for (int i = 0; i < argsArray.length; i++) {
					pf.add(new ProcessFileSub(argsArray[i]));
				}
			} catch (FileNotFoundException e1) {
				ar.clear();
				pf.clear();
				e1.printStackTrace();
			}
			for (int i = 0; i < pf.size(); i++) {
				ar.add(pf.get(i).getFileContents());
			}
			try {
				ar=hashmapp(ar);
				MerkleTree<String> mt = new MerkleTree<String>(ar);
				textArea.setText("Root : "+mt.getMerkleTree().get(0));
				for(int i=1;i<mt.getMerkleTree().size();i++) {
					textArea.setText(textArea.getText()+ "\nhash" +
							" blocks : "+mt.getMerkleTree().get(i));

				}


				File newTextFile = new File(getAlphaNumericString(15)+".txt");
				FileWriter fw = new FileWriter(newTextFile);
				fw.write(textArea.getText());
				fw.close();
				ar.clear();
				pf.clear();
			} catch (NoSuchAlgorithmException | IOException e1) {
				ar.clear();
				pf.clear();
				e1.printStackTrace();
			}
		}
		// compare two files
		else if (s == "Compare Files") {
			textArea2.setText("");
			ProcessFileSub pf = null;
			ProcessFileSub pf2 = null;
			try {
				pf = new ProcessFileSub(args2);
				pf2 = new ProcessFileSub(args3);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			ar.add(pf.getFileContents());
			ar2.add(pf2.getFileContents());
			try {
				MerkleTree<String> mt = new MerkleTree<String>(ar);
				MerkleTree<String> mt2 = new MerkleTree<String>(ar2);
				EvaluateFileEquality<String> feq = new EvaluateFileEquality<String>(mt, mt2);
				if (feq.getEquality() == true) {
					textArea2.setText(feq.getMessage());
				} else {
					textArea2.setText(feq.getMessage());
				}
				ar.clear();
				ar2.clear();
			} catch (NoSuchAlgorithmException e1) {
				e1.printStackTrace();
			}
		}  else if (s == "Compare Merkle Trees") {
			textArea4.setText("");
			boolean checking = false;
			String diff1 = "";
			String diff2 = "";
			for (int i = 0; i < args6Array.length; i++) {
				if (args6Array[i].equals(args7Array[i]))
					checking = true;
				else {
					checking = false;
					diff1 = args6Array[i];
					diff2 = args7Array[i];
					break;
				}
			}
			if (checking) {
				textArea4.setText("Both files are the same");
			} else {
				textArea4.setText("Files are different: \tFile1: " + diff1 + "\tVS. \tFile2: " + diff2);
			}
		}
	}

	static String getAlphaNumericString(int n)
	{

		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "0123456789"
				+ "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index
					= (int)(AlphaNumericString.length()
					* Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString
					.charAt(index));
		}

		return sb.toString();
	}

	public static void main(String[] args) throws NoSuchAlgorithmException, FileNotFoundException {




		createUserInterface();
	}

	private static ArrayList<String> hashmapp(ArrayList<String> values ) {
		HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
		hm.put("Bucket1", List.of());
		hm.put("Bucket2", List.of());
		hm.put("Bucket3", List.of());
		hm.put("Bucket4", List.of());
		hm.put("Bucket5", List.of());
		hm.put("Bucket6", List.of());
		hm.put("Bucket7", List.of());
		hm.put("Bucket8", List.of());

		for (int i = 0; i < values.size(); i++) {
			int hashedValue=sfold(values.get(i),100);
			if (hashedValue<10){
//	        	  if(hm.get("Bucket1").size()>=0) {
				List<String> val = new ArrayList<String>(hm.get("Bucket1"));
				val.add(String.valueOf(hashedValue));
				hm.put("Bucket1", val);

			}
			if (hashedValue>=10 && hashedValue<20){
				List<String> val = new ArrayList<String>(hm.get("Bucket2"));
//			        		val.add(.toString());
				val.add(String.valueOf(hashedValue));
				hm.put("Bucket2", val);
			}
			if (hashedValue>=20 && hashedValue<30){
				List<String> val = new ArrayList<String>(hm.get("Bucket3"));
//		        		val.add(.toString());
				val.add(String.valueOf(hashedValue));
				hm.put("Bucket3", val);
			}
			if (hashedValue>=30 && hashedValue<40){
				List<String> val = new ArrayList<String>(hm.get("Bucket4"));
//		        		val.add(.toString());
				val.add(String.valueOf(hashedValue));
				hm.put("Bucket4", val);
			}
			if (hashedValue>=40 && hashedValue<50){
				List<String> val = new ArrayList<String>(hm.get("Bucket5"));
//		        		val.add(.toString());
				val.add(String.valueOf(hashedValue));
				hm.put("Bucket5", val);
			}
			if (hashedValue>=50 && hashedValue<60){
				List<String> val = new ArrayList<String>(hm.get("Bucket6"));
//		        		val.add(.toString());
				val.add(String.valueOf(hashedValue));
				hm.put("Bucket6", val);
			}
			if (hashedValue>=60 && hashedValue<70){
				List<String> val = new ArrayList<String>(hm.get("Bucket7"));
//		        		val.add(.toString());
				val.add(String.valueOf(hashedValue));
				hm.put("Bucket7", val);
			}
			if (hashedValue>=70){
				List<String> val = new ArrayList<String>(hm.get("Bucket8"));
//		        		val.add(.toString());
				val.add(String.valueOf(hashedValue));
				hm.put("Bucket8", val);
			}

		}
		System.out.println("Bucket Structure \n");
		System.out.println(hm);
		System.out.println(hm.size());
		ArrayList<String> listOfStrings = new ArrayList<>(hm.size());
//		List<String> listA = new ArrayList<>();
//
//		Collection<List<String>> ran=hm.values();
//		for(int i = 0; i < ran.size(); i++) {
//			listA.add(ran.toString());
//		}
//		System.out.print("List A"+ listA);





		listOfStrings.add(hm.get("Bucket1").toString());
		listOfStrings.add(hm.get("Bucket2").toString());

		listOfStrings.add(hm.get("Bucket3").toString());
		listOfStrings.add(hm.get("Bucket4").toString());

		listOfStrings.add(hm.get("Bucket5").toString());
		listOfStrings.add(hm.get("Bucket6").toString());

		listOfStrings.add(hm.get("Bucket7").toString());
		listOfStrings.add(hm.get("Bucket8").toString());
		System.out.println(listOfStrings);
		return listOfStrings;
////		List listofVal = new List(hm.values());
////
////		//Creating an ArrayList of values
////
////		ArrayList<String> listOfValues = new ArrayList<>(listofVal);
////		System.out.println("New : "+ listOfValues);
//////		Set<Map.Entry<String, List<String>> > entrySet
//////        = hm.entrySet();
//        Collection<ArrayList<String>> listOfValues
//        = hm.values().stream().collect(
//            Collectors.toCollection(ArrayList::new));
////
////    // Creating an ArrayList of Entry objects
////    ArrayList<Map.Entry<String, List<String>> > listOfEntry
////        = new ArrayList<Entry<String, List<String>>> (entrySet);
////		System.out.println(listOfEntry);
////
//		return listOfValues;



	}

	private static int sfold(String s, int M) {
		long sum = 0, mul = 1;
		for (int i = 0; i < s.length(); i++) {
			mul = (i % 4 == 0) ? 1 : mul * 256;
			sum += s.charAt(i) * mul;
		}
		return (int)(Math.abs(sum) % M);
	}
}