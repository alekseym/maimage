public class Test3 {

	public static void main(String[] args) {
		
		System.out.println("Test3: ");
		
		Picture pic = new Picture();
		pic.loadFromFile("in.txt");
		
		pic.setValue(0, 0, 123);
		if (pic.getValue(0, 0) == 123) 
			System.out.println("OK");
		else
			System.out.println("Fail");
		
	}

}
