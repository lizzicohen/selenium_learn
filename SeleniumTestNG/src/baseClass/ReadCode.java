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
			System.out.println("以行为单位读取文件内容，一次读一整行：");
			reader = new BufferedReader(new FileReader(file));

			int line = 1;
			// 一次读入一行，直到读入null为文件结束
			tempString = reader.readLine();
			// 显示行号
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
