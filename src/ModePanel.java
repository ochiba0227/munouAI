import javax.swing.JFrame;
import javax.swing.JOptionPane;


@SuppressWarnings("serial")
public class ModePanel extends JFrame{
	private String modetext;
	private int option;
	
	public ModePanel(){
		JFrame frame = new JFrame();
		String selectvalues[] = {"�������s���[�h", "�w�K���[�h"};
		option = JOptionPane.showOptionDialog(frame,"���[�h��ݒ肵�Ă�������","���[�h�ݒ���",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,selectvalues,selectvalues[0]);
		if (option == JOptionPane.CLOSED_OPTION){
			modetext="�I�����ꂸ�ɕ����܂���";
		}
		else{
			modetext=selectvalues[option]+"�ɐݒ肳��܂���";
		}
	}
	public String getModetext(){
		return modetext;
	}
	public int getOption(){
		return option;
	}
}
