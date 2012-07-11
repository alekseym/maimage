public class Test1 {

	public static void main(String[] args) {
		
		System.out.println("Test1: ");
		
		Picture pic = new Picture();
		String url[] = {"in.txt", "#&*$#", ""};
		for(String u: url) {
			if (pic.loadFromFile(u)) 
				System.out.println("OK "); 
			else 
				System.out.println("Fail ");
			System.out.println("");
		}
	}

}
