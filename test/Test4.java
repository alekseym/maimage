public class Test4 {

	public static void main(String[] args) {
		
		System.out.println("Test4: ");
		
		Picture pic = new Picture();
		pic.loadFromFile("in.txt");
		
		if ((pic.getSize()[0] == 3) && (pic.getSize()[1] == 5))
			System.out.println("OK");
		else
			System.out.println("Fail");
		
	}

}