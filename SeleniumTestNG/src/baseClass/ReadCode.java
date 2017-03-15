package baseClass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ReadCode {
	public void setFilename(String filename) {
		this.filename = filename;
	}

	String filename;
	String tempString;

	ReadCode() {
		super();
		this.filename = null;
		this.tempString = null;
	}

	public String readFileCode() {
		File file = new File(filename);
		BufferedReader reader = null;

		try {
			System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���У�");
			reader = new BufferedReader(new FileReader(file));

			int line = 1;
			// һ�ζ���һ�У�ֱ������nullΪ�ļ�����
			tempString = reader.readLine();
			// ��ʾ�к�
			System.out.println("line " + line + ": " + tempString);

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return tempString;
	}

	public String readURLCode() {
		String URL = filename;
		try {
			URL url = new URL(URL);
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			tempString = reader.readLine();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tempString;
	}
	public String readURLCode(String filename) {	
		try {
			URL url = new URL(filename);
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			tempString = reader.readLine();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tempString;
	}
}
