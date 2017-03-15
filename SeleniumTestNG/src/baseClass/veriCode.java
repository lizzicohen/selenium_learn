package baseClass;


public class veriCode {

	public static void main(String[] args) {
		
		System.out.println("code from url:");
		ReadCode rc = new ReadCode();
		rc.setFilename("http://42.99.0.158/crm/webapps/pages/code.txt");
		System.out.println(rc.readURLCode());
	}

}
