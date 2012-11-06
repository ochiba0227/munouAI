import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Main extends JFrame implements KeyListener, ActionListener{
	private static int WIDTH;
	private static int HEIGHT;

	private TextPanel tpanel;
	private Chatbot chatbot = new Chatbot("AIちゃん");
	private ModePanel modepanel;

	private String response;
	private Timer timer;
	
	private int currentmode=1;

	public Main() {    	
		int TextHEIGHT=100;
		Dimension display = Toolkit.getDefaultToolkit().getScreenSize();
		WIDTH=display.width/2;
		HEIGHT=display.height;
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setTitle("AIちゃんとあそぼ");
		frame.setLocationRelativeTo(null);
		frame.addKeyListener(this);
		frame.setVisible(true);
		Insets inset = frame.getInsets();

		JPanel mpanel = new JPanel();
		mpanel.setLayout(null);

		GraphicPanel gpanel = new GraphicPanel(WIDTH-inset.right-inset.left, HEIGHT-inset.top-TextHEIGHT);
		tpanel = new TextPanel(WIDTH-inset.left-inset.right,TextHEIGHT-inset.bottom);

		gpanel.setBounds(0, 0, WIDTH-inset.right-inset.left, HEIGHT-inset.top-TextHEIGHT);
		tpanel.setBounds(0, HEIGHT-inset.top-TextHEIGHT, WIDTH-inset.right-inset.left, TextHEIGHT-inset.bottom);

		mpanel.add(gpanel);
		mpanel.add(tpanel);
		frame.add(mpanel);
		frame.validate();
		
		if(currentmode==0){
			timer = new Timer(1000 , this);
		}
		else if(currentmode==1){
			timer = new Timer(3000 , this);
		}
		timer.start();
		
		writeDialogue("いらっしゃい");
		writeDialogue("今日もいっぱいお勉強しましょうね");
		writeDialogue("それじゃあ、はじめましょうか");
		response = chatbot.getResponse();
		writeDialogue();
	}

	public static void main(String[] args) {
		new Main();
	}

	public void writeDialogue(){
		tpanel.getDialogueArea().append(chatbot.getName() + "\t" + response + "\n");
		tpanel.getDialogueArea().setCaretPosition(tpanel.getDialogueArea().getText().length());	
	}

	public void writeDialogue(String text){
		tpanel.getDialogueArea().append(chatbot.getName() + "\t" + text + "\n");
		tpanel.getDialogueArea().setCaretPosition(tpanel.getDialogueArea().getText().length());	
	}
	
	public void keyPressed(KeyEvent arg0) {
		int key = arg0.getKeyCode();
		if(key == KeyEvent.VK_1){
			response = chatbot.getgResponse();
			writeDialogue();
		}
		else if(key == KeyEvent.VK_2){
			response = chatbot.getoResponse();
			writeDialogue();
		}
		else if(key == KeyEvent.VK_3){
			response = chatbot.getbResponse();
			writeDialogue();
		}
/*		else if(key == KeyEvent.VK_ENTER){
			response = chatbot.getResponse();
			writeDialogue();
		}*/
		else if(key == KeyEvent.VK_M){
			timer.stop();
			modepanel = new ModePanel();
			tpanel.getDialogueArea().append("システムメッセージ:"+modepanel.getModetext()+"\n");
			tpanel.getDialogueArea().setCaretPosition(tpanel.getDialogueArea().getText().length());	
			if(modepanel.getOption()!=JOptionPane.CLOSED_OPTION){
				currentmode=modepanel.getOption();
			}
			if(currentmode==0){
				timer.setDelay(1000);
			}
			else if(currentmode==1){
				timer.setDelay(3000);
			}
			timer.start();
		}
		else if(key == KeyEvent.VK_ESCAPE){
			timer.stop();
			new EndDialog();
			timer.start();
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
	}
	@Override
	public void keyTyped(KeyEvent arg0) {		
	}
	public void actionPerformed(ActionEvent e){
		
	}
}
