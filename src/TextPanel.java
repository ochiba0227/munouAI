import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class TextPanel extends JPanel{
	// メッセージ履歴表示エリア
	private JTextArea dialogueArea;

	public TextPanel(int Width,int Height) {
		setPreferredSize(new Dimension(Width, Height));
		initGUI();
	}

	/**
	 * GUIを初期化する
	 */
	private void initGUI() {
		setLayout(new BorderLayout());

		// メッセージ履歴表示エリア
		setDialogueArea(new JTextArea());
		getDialogueArea().setEditable(false);
		getDialogueArea().setLineWrap(true);
		getDialogueArea().append("AIちゃんとあそぼ\n");
		// パネルに追加
		JScrollPane scrollPane = new JScrollPane(getDialogueArea());
		scrollPane.setAutoscrolls(true);
		this.add(scrollPane);
	}

	public JTextArea getDialogueArea() {
		return dialogueArea;
	}

	public void setDialogueArea(JTextArea dialogueArea) {
		this.dialogueArea = dialogueArea;
	}
}
