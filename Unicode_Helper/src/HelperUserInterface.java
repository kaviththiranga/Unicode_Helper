
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;


import decoder.Decoder;
import decoder.DecoderDL;
import decoder.DecoderFM;
import decoder.DecoderSinglish;

/**
 * Kavith Thiranga Lokuhewage
 */
public class HelperUserInterface extends JFrame {

	KeyboardFocusManager keyboardFManager;
	
	JTextArea sourceText, convertedText;
	JButton convertBtn, copyBtn;
	JPanel northPanel, centerPanel;
	
	static Decoder activeDecoder;
	
	DecoderSinglish singlishDecoder;
	DecoderDL dlDecoder;
	DecoderFM fmDecoder;
	
	
	public HelperUserInterface(String title) {
		
		super(title);
		singlishDecoder = new DecoderSinglish();
		dlDecoder = new DecoderDL();
		fmDecoder = new DecoderFM();
		
		HelperUserInterface.activeDecoder = new DecoderSinglish();
	}
	
	public void  setupGUI() {
		
		this.setSize(1000,1000);
		this.setMinimumSize(new Dimension(500,500));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.northPanel= new JPanel();
		this.centerPanel= new JPanel();//new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		
		this.sourceText = new JTextArea(10, 20);		
		this.sourceText.setText("Enter your text here");
		this.sourceText.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.white));
		this.sourceText.setBackground(Color.LIGHT_GRAY);
		this.centerPanel.add(this.addScroll(this.sourceText));
		
		this.convertedText = new JTextArea(10,20);
		this.convertedText.setFont(new javax.swing.plaf.FontUIResource("Iskoola pota",Font.PLAIN,18));
		this.convertedText.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.white));
		this.convertedText.setBackground(Color.LIGHT_GRAY);
		this.centerPanel.add(this.addScroll(this.convertedText));
		
		this.convertBtn = new JButton("Convert to Unicode");
		this.convertBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				convertToUnicode();				
			}
		});
		this.northPanel.add(this.convertBtn);
		
		this.add(northPanel, BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
		
	}
	public ImageIcon createImageIcon(String path) {
		
		URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
				return new ImageIcon(imgURL);
		} else {
				System.err.println("Couldn't find file: " + path);
				return null;
		}
	}
	public void createImageBtn(JButton btn,String normalIcon,String rollOverIcon){
		
		btn.setIcon(createImageIcon(normalIcon));
		btn.setFocusPainted(false);
		btn.setRolloverIcon(createImageIcon(rollOverIcon));
		btn.setContentAreaFilled(false);
		btn.setForeground(new Color(255,255,255));
		btn.setBackground(new Color(255,255,255));
		btn.setBorder(BorderFactory.createEmptyBorder(4, 3, 3, 3));
		btn.setPressedIcon(createImageIcon(normalIcon));
	}
	
	public JScrollPane addScroll(JTextArea t){
		JScrollPane scroller=new JScrollPane(t);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		return scroller;
	}
	
	public void convertToUnicode()
	{
		 String convertedText = HelperUserInterface.activeDecoder.process(this.sourceText.getText());
		 
		 this.convertedText.setText(convertedText);
	}
	


}
