import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class TextPanel extends JPanel{
	// ���b�Z�[�W����\���G���A
	private JTextArea dialogueArea;

	public TextPanel(int Width,int Height) {
		setPreferredSize(new Dimension(Width, Height));
		initGUI();
	}

	/**
	 * GUI������������
	 */
	private void initGUI() {
		setLayout(new BorderLayout());

		// ���b�Z�[�W����\���G���A
		setDialogueArea(new JTextArea());
		getDialogueArea().setEditable(false);
		getDialogueArea().setLineWrap(true);
		getDialogueArea().append("AI�����Ƃ�����\n");
		// �p�l���ɒǉ�
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
