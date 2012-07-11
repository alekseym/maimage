public class Test5 {

	public static void main(String[] args) {
		
		System.out.println("Test5: ");
		
		Picture pic = new Picture();
		pic.loadFromFile("in.txt");
		
		Filter fl = new Filter();
		Picture out = fl.process(pic);
		
		int res[][] = {{6, 11, 23}, {0, 6 ,23}, {11, 37, 66}, {2, 7, 23}, {7, 23, 23}};
		
		Boolean f = true;
		for (int y = 0; y < out.getSize()[1]; y++) {
			for (int x = 0; x < out.getSize()[0]; x++) {
				if (out.getValue(x, y) != res [y][x]) {
					f = false;
					break;
				}
				if (!f) break;
			}
		}
		if (f) System.out.println("OK"); else System.out.println("Fail");
		
	}

}