package clien;
import java.time.LocalTime;
import java.util.*;


public class FakeDataGenerator extends Thread{
	private static String data;
	public FakeDataGenerator(String data) {
		this.data=data;
	}
	@Override
	public void run()
	{
		
		    Random random = new Random();
		        char[] word = new char[10]; // words of length 3 through 10. (1 and 2 letter words are boring.)
		        for(int j = 0; j < word.length; j++)
		        {
		            word[j] = (char)('a' + random.nextInt(26));
		        }
		        String next_word = new String(word);	        
		    try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
	}
	public static String getData() {
		return data;
	}	
}