import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class EndDialog extends JFrame{
	public EndDialog(){
		JFrame frame = new JFrame();
		int option = JOptionPane.showConfirmDialog(frame,"�{���ɏI�����܂����H","���ӁI�I",JOptionPane.YES_NO_OPTION);
		if (option == JOptionPane.YES_OPTION){
			System.exit(0);
		}
		else if (option == JOptionPane.NO_OPTION){
		}
	}
}
