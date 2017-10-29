package claculator;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Stack;


public class MyPanel extends JPanel {
	private JButton[] numberButton = new JButton[10];
	private JButton[] calculateButton = new JButton[6];
	private JButton[] functionButton = new JButton[2];
	
	private JPanel p1, p2, p3;
	private JLabel label;
	
	public MyPanel() {
		setPreferredSize(new Dimension(400,600));
		setLayout(new BorderLayout());
		ButtonListener listener = new ButtonListener();
		
		p1 = new JPanel();
		p1.setLayout(new GridLayout(4,4));
		p1.setBorder(BorderFactory.createRaisedBevelBorder());
		
		numberButton[0] = new JButton("0");
		numberButton[1] = new JButton("1");
		numberButton[2] = new JButton("2");
		numberButton[3] = new JButton("3");
		numberButton[4] = new JButton("4");
		numberButton[5] = new JButton("5");
		numberButton[6] = new JButton("6");
		numberButton[7] = new JButton("7");
		numberButton[8] = new JButton("8");
		numberButton[9] = new JButton("9");
		calculateButton[0] = new JButton("+");
		calculateButton[1] = new JButton("-");
		calculateButton[2] = new JButton("*");
		calculateButton[3] = new JButton("/");
		calculateButton[4] = new JButton(".");
		calculateButton[5] = new JButton("=");
		functionButton[0] = new JButton("C");	//Clear
		functionButton[1] = new JButton("U");	//Undo
		
		Font font = new Font("Source Code Pro", Font.BOLD, 24);
		for ( int i=0; i<10; i++ ) {
			numberButton[i].addActionListener(listener);
			numberButton[i].setFont(font);
		}
		for ( int i=0; i<6; i++ ) {
			calculateButton[i].addActionListener(listener);
			calculateButton[i].setFont(font);
		}
		for ( int i=0; i<2; i++ ) {
			functionButton[i].addActionListener(listener);
			functionButton[i].setFont(font);
		}
		
		p1.add(numberButton[1]);
		p1.add(numberButton[2]);
		p1.add(numberButton[3]);
		p1.add(calculateButton[0]);
		
		p1.add(numberButton[4]);
		p1.add(numberButton[5]);
		p1.add(numberButton[6]);
		p1.add(calculateButton[1]);
		
		p1.add(numberButton[7]);
		p1.add(numberButton[8]);
		p1.add(numberButton[9]);
		p1.add(calculateButton[2]);
		
		p1.add(calculateButton[4]);
		p1.add(numberButton[0]);
		p1.add(functionButton[0]);
		p1.add(calculateButton[3]);
		
		p2 = new JPanel();
		p2.setBackground(Color.GRAY);
		p2.setBorder(BorderFactory.createLoweredBevelBorder());
		label = new JLabel("");
//		label.setBackground(Color.GRAY);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Source Code Pro", Font.BOLD, 20));
		label.setHorizontalAlignment(SwingConstants.LEFT);
		p2.add(label);
		
		p3 = new JPanel();
		p3.setLayout(new GridLayout(1,2));
//		p3.setPreferredSize(new Dimension(80,80));
		p3.setBackground(Color.YELLOW);
		p3.add(functionButton[1]);
		p3.add(calculateButton[5]);
		add(p2, BorderLayout.NORTH);
		add(p1, BorderLayout.CENTER);
		add(p3, BorderLayout.SOUTH);
		
		
	}
	
	private class ButtonListener implements ActionListener {
		private String s1, s2, ans;
		
		public void actionPerformed(ActionEvent event) {
			if ( event.getSource() == functionButton[0] )	//Clear
				label.setText("");
			else if ( event.getSource() == functionButton[1] ) {	//Undo
				s1 = label.getText();
				s2 = s1.substring(0, s1.length()-1);
				label.setText(s2);
			}
			else if ( event.getSource() == numberButton[0] )
				label.setText(label.getText() + "0");
			else if ( event.getSource() == numberButton[1] )
				label.setText(label.getText() + "1");
			else if ( event.getSource() == numberButton[2] )
				label.setText(label.getText() + "2");
			else if ( event.getSource() == numberButton[3] )
				label.setText(label.getText() + "3");
			else if ( event.getSource() == numberButton[4] )
				label.setText(label.getText() + "4");
			else if ( event.getSource() == numberButton[5] )
				label.setText(label.getText() + "5");
			else if ( event.getSource() == numberButton[6] )
				label.setText(label.getText() + "6");
			else if ( event.getSource() == numberButton[7] )
				label.setText(label.getText() + "7");
			else if ( event.getSource() == numberButton[8] )
				label.setText(label.getText() + "8");
			else if ( event.getSource() == numberButton[9] )
				label.setText(label.getText() + "9");
			else if ( event.getSource() == calculateButton[0] )
				label.setText(label.getText() + "+");
			else if ( event.getSource() == calculateButton[1] )
				label.setText(label.getText() + "-");
			else if ( event.getSource() == calculateButton[2] )
				label.setText(label.getText() + "*");
			else if ( event.getSource() == calculateButton[3] )
				label.setText(label.getText() + "/");
			else if ( event.getSource() == calculateButton[4] )	//dot
				label.setText(label.getText() + ".");
			else if ( event.getSource() == calculateButton[5] ) {	//equal
				ans = label.getText() + " = " + calculate(label.getText());
				label.setText(ans);
			}
		}
		
		/*
		private String calculate(String input) {
			String str[];
			str = input.split(" ");
			Stack<Double> s = new Stack<Double>();
			double m = Double.parseDouble(str[0]);
			s.push(m);
			for ( int i=1;i<str.length;i++ ) {
				if (i%2==1) {  
	                if (str[i].compareTo("+")==0) {  
	                    double help = Double.parseDouble(str[i+1]);  
	                    s.push(help);  
	                }  
	                if (str[i].compareTo("-")==0) {  
	                    double help = Double.parseDouble(str[i+1]);  
	                    s.push(-help);  
	                }  
	                if(str[i].compareTo("*")==0) {  
	                    double help = Double.parseDouble(str[i+1]);  
	                    double ans = s.peek();//取出栈顶元素  
	                    s.pop();//消栈  
	                    ans*=help;  
	                    s.push(ans);  
	                } 
	                if(str[i].compareTo("/")==0) {  
	                    double help = Double.parseDouble(str[i+1]);  
	                    double ans = s.peek();  
	                    s.pop();  
	                    ans/=help;  
	                    s.push(ans);  
	                }  
	            }
			}
			double ans = 0d;  
	        while(!s.isEmpty()) {  
	            ans+=s.peek();  
	            s.pop();  
	        }  
	        String result = String.valueOf(ans);
	        return result;
		}
		*/
		
		private String calculate(String str) {
			String result = "Wrong Expression!";
			String temp = "";
			
			if ( (str.charAt(0) != '-') && !(str.charAt(0) <= '9' && str.charAt(0) >= '0')) {
				return result;
			}
			LinkedList<Double> list = new LinkedList<Double>();
			LinkedList<Character> optList = new LinkedList<Character>();
			Double doubleTemp;
	        boolean isFormerOpt = true;
	        for (int index = 0; index <= str.length() - 1; index++) {
	            if (index == 0) {
	                isFormerOpt = true;
	            } else {
	                if (str.charAt(index - 1) > '9' || str.charAt(index - 1) < '0') {
	                    isFormerOpt = true;
	                } else {
	                    isFormerOpt = false;
	                }
	            }
	            if (str.charAt(index) != '+' && str.charAt(index) != '*'
	                    && str.charAt(index) != '/'
	                    && (!(str.charAt(index) == '-' && isFormerOpt == false))) {
	                temp += str.charAt(index);
	            } else {
	                doubleTemp = new Double(temp);
	                list.add(doubleTemp);
	                temp = "";
	                optList.add(str.charAt(index));
	            }
	        }
	        doubleTemp = new Double(temp);
	        list.add(doubleTemp);
	        temp = "";
	        /*
	         * for (int index = 0; index <= list.size() - 1; index++) {
	         * System.out.println(list.get(index)); } for (int index = 0; index <=
	         * optList.size() - 1; index++) {
	         * System.out.println(optList.get(index)); }
	         */
	        boolean isThereHigherOpt = true;
	        while (isThereHigherOpt == true) {
	            /*
	             * for (Iterator<Character> it = optList.iterator(); it.hasNext();)
	             * { if (it.next() == '*' || it.next() == '/') { isThereHigherOpt =
	             * true; int index = optList.indexOf(it.next());
	             * 
	             * break; } }
	             */
	            isThereHigherOpt = false;
	            for (int index = 0; index <= optList.size() - 1; index++) {
	                if (optList.get(index) == '*') {
	                    Double t = list.get(index) * list.get(index + 1);
	                    list.remove(index + 1);
	                    list.set(index, t);
	                    optList.remove(index);
	                    isThereHigherOpt = true;
	                    break;
	                }
	                if (optList.get(index) == '/') {
	                    Double t = list.get(index) / list.get(index + 1);
	                    list.remove(index + 1);
	                    list.set(index, t);
	                    optList.remove(index);
	                    isThereHigherOpt = true;
	                    break;
	                }
	            }
	        }
	        while (optList.isEmpty() == false) {
	            for (int index = 0; index <= optList.size() - 1; index++) {
	                if (optList.get(index) == '+') {
	                    Double t = list.get(index) + list.get(index + 1);
	                    list.remove(index + 1);
	                    list.set(index, t);
	                    optList.remove(index);
	                    break;
	                }
	                if (optList.get(index) == '-') {
	                    Double t = list.get(index) + 0.0 - list.get(index + 1);
	                    list.remove(index + 1);
	                    list.set(index, t);
	                    optList.remove(index);
	                    break;
	                }
	            }
	        }
	        /*
	         * System.out.println("/////////////////////////////////"); for (int
	         * index = 0; index <= optList.size() - 1; index++) { //
	         * System.out.println(index); System.out.println(list.get(index));
	         * System.out.println(optList.get(index));
	         * System.out.println(list.get(index + 1)); }
	         */
	        if (list.size() == 1) {
	            result = list.get(0).toString();
	        }
	        return result;
		}
	}
}
