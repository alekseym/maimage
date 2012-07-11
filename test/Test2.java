public class Test2 {

	public static void main(String[] args) {
		
		System.out.println("Test2: ");
		
		Picture pic = new Picture();
		pic.loadFromFile("in.txt");
		
		int mas[][] = {{0, 6, 23}, {11, 78 ,83}, {0, 0, 5}, {89, 37, 66}, {2, 7, 23}};
		Boolean f = true;
		for (int y = 0; y < pic.getSize()[1]; y++) {
			for (int x = 0; x < pic.getSize()[0]; x++) {
				if (pic.getValue(x, y) != mas[y][x]) {
					f = false;
					break;
				}
				if (!f) break;
			}
		}
		if (f) System.out.println("OK"); else System.out.println("Fail");
		
	}

}
