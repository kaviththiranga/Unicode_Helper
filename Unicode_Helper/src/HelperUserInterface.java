
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.KeyboardFocusManager;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import decoder.Decoder;
import decoder.DecoderDL;
import decoder.DecoderFM;

/**
 * Kavith Thiranga Lokuhewage
 */
public class HelperUserInterface extends JFrame {

	KeyboardFocusManager keyboardFManager;
	
	JTextArea sourceText, convertedText;
	
	DecoderDL decoder;
	
	public HelperUserInterface(String title) {
		
		super(title);
		
		this.decoder = new DecoderDL();
	}
	
	public void  setupGUI() {
		
		this.setSize(900,680);
		this.setMinimumSize(new Dimension(900, 400));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		
		this.sourceText = new JTextArea(20, 20);
		this.convertedText = new JTextArea(20,20);
		this.convertedText.setFont(new javax.swing.plaf.FontUIResource("Iskoola pota",Font.PLAIN,18));

		this.add(this.sourceText, BorderLayout.CENTER);
		this.add(this.convertedText, BorderLayout.CENTER);
		
		this.convertedText.setText(this.decoder.process("ljs;a ;srx. f,dl=fyajdf.a"));
		this.pack();
		this.setVisible(true);
		
	}

}
