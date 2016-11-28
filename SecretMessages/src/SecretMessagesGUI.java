import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class SecretMessagesGUI {

	private JFrame frmSecretMessages;
	private JTextField txtCipher;
	private static JTextField txtMessage;
	private static JTextField txtResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecretMessagesGUI window = new SecretMessagesGUI();
					window.frmSecretMessages.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SecretMessagesGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSecretMessages = new JFrame();
		frmSecretMessages.setTitle("Secret Messages");
		frmSecretMessages.setBounds(100, 100, 555, 372);
		frmSecretMessages.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSecretMessages.getContentPane().setLayout(null);
		
		JButton btnEncode = new JButton("Encode");
		btnEncode.setFont(new Font("Arial", Font.PLAIN, 14));
		btnEncode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Scanner input = new Scanner(System.in);
				String seed = null, msg, answer, cipherDone, encodeDone = null, decodeDone = null;
				
				seed = txtCipher.getText();
				
				//Assigns the result in the CreateCipher method to the local variable cipher
				cipherDone = CreateCipher(seed);
				
				encodeDone = encode(cipherDone);
				
				txtCipher.setText("");
				txtMessage.setText("");
				
			}
		});
		btnEncode.setBounds(151, 239, 97, 25);
		frmSecretMessages.getContentPane().add(btnEncode);
		
		JButton btnDecode = new JButton("Decode");
		btnDecode.setFont(new Font("Arial", Font.PLAIN, 14));
		btnDecode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Scanner input = new Scanner(System.in);
				String seed = null, msg, answer, cipherDone, encodeDone = null, decodeDone = null;
				
				seed = txtCipher.getText();
				
				//Assigns the result in the CreateCipher method to the local variable cipher
				cipherDone = CreateCipher(seed);
				
				decodeDone = decode(cipherDone);
				
				txtCipher.setText("");
				txtMessage.setText("");
				
			}
		});
		btnDecode.setBounds(312, 239, 97, 25);
		frmSecretMessages.getContentPane().add(btnDecode);
		
		JLabel lblCipher = new JLabel("Cipher");
		lblCipher.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCipher.setBounds(71, 23, 42, 25);
		frmSecretMessages.getContentPane().add(lblCipher);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setFont(new Font("Arial", Font.PLAIN, 14));
		lblResult.setBounds(71, 179, 42, 16);
		frmSecretMessages.getContentPane().add(lblResult);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMessage.setBounds(50, 93, 63, 16);
		frmSecretMessages.getContentPane().add(lblMessage);
		
		txtCipher = new JTextField();
		txtCipher.setBounds(127, 24, 326, 22);
		frmSecretMessages.getContentPane().add(txtCipher);
		txtCipher.setColumns(10);
		
		txtMessage = new JTextField();
		txtMessage.setColumns(10);
		txtMessage.setBounds(125, 69, 326, 64);
		frmSecretMessages.getContentPane().add(txtMessage);
		
		txtResult = new JTextField();
		txtResult.setEditable(false);
		txtResult.setColumns(10);
		txtResult.setBounds(127, 155, 326, 64);
		frmSecretMessages.getContentPane().add(txtResult);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSecretMessages.setVisible(false); //you can't see me!
				frmSecretMessages.dispose(); //Destroy the JFrame object
			}
		});
		btnExit.setFont(new Font("Arial", Font.PLAIN, 14));
		btnExit.setBounds(236, 282, 97, 25);
		frmSecretMessages.getContentPane().add(btnExit);
	}
	
public static String CreateCipher (String cipher) {
		
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		
		cipher = cipher.toLowerCase();
		cipher = cipher.replaceAll("\\s+","");
		cipher = cipher.replaceAll("[\\s.]", "");
		cipher = cipher + alphabet;
		
		char[] chars = cipher.toCharArray();
		Set<Character> charSet = new LinkedHashSet<Character>();
		for (char c : chars) {
		    charSet.add(c);
		}

		StringBuilder sb = new StringBuilder();
		for (Character character : charSet) {
		    sb.append(character);
		}
		
		cipher = sb.toString();
		
		return cipher;
	}
	
public static String encode (String msg) {
		
		Scanner input = new Scanner(System.in);
		String cipher = msg.toString();
		
		String message, newMessage, alphabet = "abcdefghijklmnopqrstuvwxyz";
		
		message = txtMessage.getText();
		
		StringBuilder builder = new StringBuilder(message);
		
		//Creates all individual letters
		int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, g = 0, h = 0, i = 0, j = 0, k = 0, l = 0, m = 0, n = 0, o = 0,
				p = 0, q = 0, r = 0, s = 0, t = 0, u = 0, v = 0, w = 0, x = 0, y = 0, z = 0;
		
		//Tells each letter to which corresponding cipher position
		a = alphabet.indexOf('a');
		char newCharA = cipher.charAt(a);
		b = alphabet.indexOf('b');
		char newCharB = cipher.charAt(b);
		c = alphabet.indexOf('c');
		char newCharC = cipher.charAt(c);
		d = alphabet.indexOf('d');
		char newCharD = cipher.charAt(d);
		e = alphabet.indexOf('e');
		char newCharE = cipher.charAt(e);
		f = alphabet.indexOf('f');
		char newCharF = cipher.charAt(f);
		g = alphabet.indexOf('g');
		char newCharG = cipher.charAt(g);
		h = alphabet.indexOf('h');
		char newCharH = cipher.charAt(h);
		i = alphabet.indexOf('i');
		char newCharI = cipher.charAt(i);
		j = alphabet.indexOf('j');
		char newCharJ = cipher.charAt(j);
		k = alphabet.indexOf('k');
		char newCharK = cipher.charAt(k);
		l = alphabet.indexOf('l');
		char newCharL = cipher.charAt(l);
		m = alphabet.indexOf('m');
		char newCharM = cipher.charAt(m);
		n = alphabet.indexOf('n');
		char newCharN = cipher.charAt(n);
		o = alphabet.indexOf('o');
		char newCharO = cipher.charAt(o);
		p = alphabet.indexOf('p');
		char newCharP = cipher.charAt(p);
		q = alphabet.indexOf('q');
		char newCharQ = cipher.charAt(q);
		r = alphabet.indexOf('r');
		char newCharR = cipher.charAt(r);
		s = alphabet.indexOf('s');
		char newCharS = cipher.charAt(s);
		t = alphabet.indexOf('t');
		char newCharT = cipher.charAt(t);
		u = alphabet.indexOf('u');
		char newCharU = cipher.charAt(u);
		v = alphabet.indexOf('v');
		char newCharV = cipher.charAt(v);
		w = alphabet.indexOf('w');
		char newCharW = cipher.charAt(w);
		x = alphabet.indexOf('x');
		char newCharX = cipher.charAt(x);
		y = alphabet.indexOf('y');
		char newCharY = cipher.charAt(y);
		z = alphabet.indexOf('z');
		char newCharZ = cipher.charAt(z);
		
		//Actually assigns each letter to which corresponding cipher position
		for (int count = 0 ; count<message.length() ; count++) {
	        if (message.charAt(count) == 'a') {
	            builder.setCharAt(count, newCharA);
	        }
	        if (message.charAt(count) == 'b') {
	            builder.setCharAt(count, newCharB);
	        }
	        if (message.charAt(count) == 'c') {
	            builder.setCharAt(count, newCharC);
	        }
	        if (message.charAt(count) == 'd') {
	            builder.setCharAt(count, newCharD);
	        }
	        if (message.charAt(count) == 'e') {
	            builder.setCharAt(count, newCharE);
	        }
	        if (message.charAt(count) == 'f') {
	            builder.setCharAt(count, newCharF);
	        }
	        if (message.charAt(count) == 'g') {
	            builder.setCharAt(count, newCharG);
	        }
	        if (message.charAt(count) == 'h') {
	            builder.setCharAt(count, newCharH);
	        }
	        if (message.charAt(count) == 'i') {
	            builder.setCharAt(count, newCharI);
	        }
	        if (message.charAt(count) == 'j') {
	            builder.setCharAt(count, newCharJ);
	        }
	        if (message.charAt(count) == 'k') {
	            builder.setCharAt(count, newCharK);
	        }
	        if (message.charAt(count) == 'l') {
	            builder.setCharAt(count, newCharL);
	        }
	        if (message.charAt(count) == 'm') {
	            builder.setCharAt(count, newCharM);
	        }
	        if (message.charAt(count) == 'n') {
	            builder.setCharAt(count, newCharN);
	        }
	        if (message.charAt(count) == 'o') {
	            builder.setCharAt(count, newCharO);
	        }
	        if (message.charAt(count) == 'p') {
	            builder.setCharAt(count, newCharP);
	        }
	        if (message.charAt(count) == 'q') {
	            builder.setCharAt(count, newCharQ);
	        }
	        if (message.charAt(count) == 'r') {
	            builder.setCharAt(count, newCharR);
	        }
	        if (message.charAt(count) == 's') {
	            builder.setCharAt(count, newCharS);
	        }
	        if (message.charAt(count) == 't') {
	            builder.setCharAt(count, newCharT);
	        }
	        if (message.charAt(count) == 'u') {
	            builder.setCharAt(count, newCharU);
	        }
	        if (message.charAt(count) == 'v') {
	            builder.setCharAt(count, newCharV);
	        }
	        if (message.charAt(count) == 'w') {
	            builder.setCharAt(count, newCharW);
	        }
	        if (message.charAt(count) == 'x') {
	            builder.setCharAt(count, newCharX);
	        }
	        if (message.charAt(count) == 'y') {
	            builder.setCharAt(count, newCharY);
	        }
	        if (message.charAt(count) == 'z') {
	            builder.setCharAt(count, newCharZ);
	        }
		}
		
		//Puts it all together       
        txtResult.setText(builder.toString());

		return msg;
	}

public static String decode (String msg) {
		
		Scanner input = new Scanner(System.in);
		String cipher = msg.toString();

		String message, newMessage, alphabet = "abcdefghijklmnopqrstuvwxyz";
		
		message = txtMessage.getText();
		
		StringBuilder builder = new StringBuilder(message);
		
		int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, g = 0, h = 0, i = 0, j = 0, k = 0, l = 0, m = 0, n = 0, o = 0,
				p = 0, q = 0, r = 0, s = 0, t = 0, u = 0, v = 0, w = 0, x = 0, y = 0, z = 0;
		
		a = cipher.indexOf('a');
		char newCharA = alphabet.charAt(a);
		b = cipher.indexOf('b');
		char newCharB = alphabet.charAt(b);
		c = cipher.indexOf('c');
		char newCharC = alphabet.charAt(c);
		d = cipher.indexOf('d');
		char newCharD = alphabet.charAt(d);
		e = cipher.indexOf('e');
		char newCharE = alphabet.charAt(e);
		f = cipher.indexOf('f');
		char newCharF = alphabet.charAt(f);
		g = cipher.indexOf('g');
		char newCharG = alphabet.charAt(g);
		h = cipher.indexOf('h');
		char newCharH = alphabet.charAt(h);
		i = cipher.indexOf('i');
		char newCharI = alphabet.charAt(i);
		j = cipher.indexOf('j');
		char newCharJ = alphabet.charAt(j);
		k = cipher.indexOf('k');
		char newCharK = alphabet.charAt(k);
		l = cipher.indexOf('l');
		char newCharL = alphabet.charAt(l);
		m = cipher.indexOf('m');
		char newCharM = alphabet.charAt(m);
		n = cipher.indexOf('n');
		char newCharN = alphabet.charAt(n);
		o = cipher.indexOf('o');
		char newCharO = alphabet.charAt(o);
		p = cipher.indexOf('p');
		char newCharP = alphabet.charAt(p);
		q = cipher.indexOf('q');
		char newCharQ = alphabet.charAt(q);
		r = cipher.indexOf('r');
		char newCharR = alphabet.charAt(r);
		s = cipher.indexOf('s');
		char newCharS = alphabet.charAt(s);
		t = cipher.indexOf('t');
		char newCharT = alphabet.charAt(t);
		u = cipher.indexOf('u');
		char newCharU = alphabet.charAt(u);
		v = cipher.indexOf('v');
		char newCharV = alphabet.charAt(v);
		w = cipher.indexOf('w');
		char newCharW = alphabet.charAt(w);
		x = cipher.indexOf('x');
		char newCharX = alphabet.charAt(x);
		y = cipher.indexOf('y');
		char newCharY = alphabet.charAt(y);
		z = cipher.indexOf('z');
		char newCharZ = alphabet.charAt(z);
		
		for (int count = 0 ; count<message.length() ; count++) {
	        if (message.charAt(count) == 'a') {
	            builder.setCharAt(count, newCharA);
	        }
	        if (message.charAt(count) == 'b') {
	            builder.setCharAt(count, newCharB);
	        }
	        if (message.charAt(count) == 'c') {
	            builder.setCharAt(count, newCharC);
	        }
	        if (message.charAt(count) == 'd') {
	            builder.setCharAt(count, newCharD);
	        }
	        if (message.charAt(count) == 'e') {
	            builder.setCharAt(count, newCharE);
	        }
	        if (message.charAt(count) == 'f') {
	            builder.setCharAt(count, newCharF);
	        }
	        if (message.charAt(count) == 'g') {
	            builder.setCharAt(count, newCharG);
	        }
	        if (message.charAt(count) == 'h') {
	            builder.setCharAt(count, newCharH);
	        }
	        if (message.charAt(count) == 'i') {
	            builder.setCharAt(count, newCharI);
	        }
	        if (message.charAt(count) == 'j') {
	            builder.setCharAt(count, newCharJ);
	        }
	        if (message.charAt(count) == 'k') {
	            builder.setCharAt(count, newCharK);
	        }
	        if (message.charAt(count) == 'l') {
	            builder.setCharAt(count, newCharL);
	        }
	        if (message.charAt(count) == 'm') {
	            builder.setCharAt(count, newCharM);
	        }
	        if (message.charAt(count) == 'n') {
	            builder.setCharAt(count, newCharN);
	        }
	        if (message.charAt(count) == 'o') {
	            builder.setCharAt(count, newCharO);
	        }
	        if (message.charAt(count) == 'p') {
	            builder.setCharAt(count, newCharP);
	        }
	        if (message.charAt(count) == 'q') {
	            builder.setCharAt(count, newCharQ);
	        }
	        if (message.charAt(count) == 'r') {
	            builder.setCharAt(count, newCharR);
	        }
	        if (message.charAt(count) == 's') {
	            builder.setCharAt(count, newCharS);
	        }
	        if (message.charAt(count) == 't') {
	            builder.setCharAt(count, newCharT);
	        }
	        if (message.charAt(count) == 'u') {
	            builder.setCharAt(count, newCharU);
	        }
	        if (message.charAt(count) == 'v') {
	            builder.setCharAt(count, newCharV);
	        }
	        if (message.charAt(count) == 'w') {
	            builder.setCharAt(count, newCharW);
	        }
	        if (message.charAt(count) == 'x') {
	            builder.setCharAt(count, newCharX);
	        }
	        if (message.charAt(count) == 'y') {
	            builder.setCharAt(count, newCharY);
	        }
	        if (message.charAt(count) == 'z') {
	            builder.setCharAt(count, newCharZ);
	        }
		}
		
		//Puts it all together
        txtResult.setText(builder.toString());
				
		return msg;
	}

}
