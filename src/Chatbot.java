import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Chatbot {
	// 人工無脳の名前
	private String name;
	private String regex = "\\A//";
	private int selected;
	// 辞書
	@SuppressWarnings("rawtypes")
	private ArrayList dic,gres,ores,bres;
	// 乱数生成器
	private Random rand;

	@SuppressWarnings("rawtypes")
	public Chatbot(String name) {
		this.name = name;

		dic = new ArrayList();
		gres = new ArrayList();
		ores = new ArrayList();
		bres = new ArrayList();
		rand = new Random(System.currentTimeMillis());

		// 辞書のロード
		loadDic();
	}

	/**
	 * 入力メッセージに対する反応メッセージを返す
	 * 
	 * @param message 入力メッセージ
	 */
	public String getResponse() {
		// 辞書からランダムに会話をひっぱってくる
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
		// 辞書からランダムに会話をひっぱってくる
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
		// 辞書からランダムに会話をひっぱってくる
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
		// 辞書からランダムに会話をひっぱってくる
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
	 * 人工無脳の名前を返す
	 * 
	 * @return 名前
	 */
	public String getName() {
		return name;
	}

	/**
	 * 辞書のロード
	 */
	@SuppressWarnings("unchecked")
	private void loadDic() {
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(getClass().getResourceAsStream("dic/play.txt")));
			String line;
			while ((line = br.readLine()) != null) {
				dic.add(line); // 辞書に追加
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
				gres.add(line); // 辞書に追加
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
				ores.add(line); // 辞書に追加
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
				bres.add(line); // 辞書に追加
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
