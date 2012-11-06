import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Chatbot {
	// �l�H���]�̖��O
	private String name;
	private String regex = "\\A//";
	private int selected;
	// ����
	@SuppressWarnings("rawtypes")
	private ArrayList dic,gres,ores,bres;
	// ����������
	private Random rand;

	@SuppressWarnings("rawtypes")
	public Chatbot(String name) {
		this.name = name;

		dic = new ArrayList();
		gres = new ArrayList();
		ores = new ArrayList();
		bres = new ArrayList();
		rand = new Random(System.currentTimeMillis());

		// �����̃��[�h
		loadDic();
	}

	/**
	 * ���̓��b�Z�[�W�ɑ΂��锽�����b�Z�[�W��Ԃ�
	 * 
	 * @param message ���̓��b�Z�[�W
	 */
	public String getResponse() {
		// �������烉���_���ɉ�b���Ђ��ς��Ă���
		selected = rand.nextInt(dic.size());
		String response = (String)dic.get(selected);
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(response);
		if(m.find()){
			return getResponse();
		}
		else{
			return response.substring(response.indexOf(':')+1);
		}
	}

	public String getgResponse() {
		// �������烉���_���ɉ�b���Ђ��ς��Ă���
		selected = rand.nextInt(gres.size());
		String response = (String)gres.get(selected);
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(response);
		if(m.find()){
			return getgResponse();
		}
		else{
			return response;
		}
	}

	public String getoResponse() {
		// �������烉���_���ɉ�b���Ђ��ς��Ă���
		selected = rand.nextInt(ores.size());
		String response = (String)ores.get(selected);
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(response);
		if(m.find()){
			return getoResponse();
		}
		else{
			return response;
		}
	}

	public String getbResponse() {
		// �������烉���_���ɉ�b���Ђ��ς��Ă���
		selected = rand.nextInt(bres.size());
		String response = (String)bres.get(selected);
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(response);
		if(m.find()){
			return getbResponse();
		}
		else{
			return response;
		}
	}

	/**
	 * �l�H���]�̖��O��Ԃ�
	 * 
	 * @return ���O
	 */
	public String getName() {
		return name;
	}

	/**
	 * �����̃��[�h
	 */
	@SuppressWarnings("unchecked")
	private void loadDic() {
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(getClass().getResourceAsStream("dic/play.txt")));
			String line;
			while ((line = br.readLine()) != null) {
				dic.add(line); // �����ɒǉ�
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		loadgres();
		loadores();
		loadbres();
	}
	@SuppressWarnings("unchecked")
	private void loadgres() {
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(getClass().getResourceAsStream("dic/good.txt")));
			String line;
			while ((line = br.readLine()) != null) {
				gres.add(line); // �����ɒǉ�
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	private void loadores() {
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(getClass().getResourceAsStream("dic/ok.txt")));
			String line;
			while ((line = br.readLine()) != null) {
				ores.add(line); // �����ɒǉ�
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	private void loadbres() {
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(getClass().getResourceAsStream("dic/bad.txt")));
			String line;
			while ((line = br.readLine()) != null) {
				bres.add(line); // �����ɒǉ�
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
