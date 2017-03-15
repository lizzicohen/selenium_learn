package baseClass;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandCode {
	RandCode(){
		Random random = new Random();
		String sRand = "";
		for (int i = 0; i < 4; i++) {
			if (random.nextInt(10) % 2 == 0) {
				String rand = String.valueOf(random.nextInt(10));
				sRand += rand;
			} else {
				char paramChar = (char) (Math.random() * 26 + 'a');
				sRand += String.valueOf(paramChar);
			}
		}
		System.out.println(sRand);
		FileWriter fw = null;
		File codefile = new File("code.txt");
		try {
			if (!codefile.exists()) {
				codefile.createNewFile();
			}
			fw = new FileWriter(codefile);
			fw.write(sRand);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
