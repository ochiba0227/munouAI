import javax.swing.JFrame;
import javax.swing.JOptionPane;


@SuppressWarnings("serial")
public class ModePanel extends JFrame{
	private String modetext;
	private int option;
	
	public ModePanel(){
		JFrame frame = new JFrame();
		String selectvalues[] = {"自律実行モード", "学習モード"};
		option = JOptionPane.showOptionDialog(frame,"モードを設定してください","モード設定画面",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,selectvalues,selectvalues[0]);
		if (option == JOptionPane.CLOSED_OPTION){
			modetext="選択されずに閉じられました";
		}
		else{
			modetext=selectvalues[option]+"に設定されました";
		}
	}
	public String getModetext(){
		return modetext;
	}
	public int getOption(){
		return option;
	}
}
