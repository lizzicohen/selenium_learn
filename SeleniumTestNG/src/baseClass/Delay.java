package baseClass;

public class Delay {

	int n;
	public Delay() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static void delay(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void delay(int n){
		try {
			Thread.sleep(n*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
