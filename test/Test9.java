public class Test9 {

	public static void main(String[] args) {
		
		System.out.println("Test9: ");
		Picture pic = new Picture();
		ImageFile img = new ImageFile();
		pic=img.loadPGM("in.pgm");
		
		Filter fl = new Filter();
		Picture out;
		out = fl.process(pic);
		img.savePGM(out, "out.pgm");
		
		int mas[][] = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,3,3,3,0,0,0,7,7,7,0,0,0,11,11,11,0,0,0,15,15,15,15,0},
				{0,0,3,0,0,0,0,0,7,0,0,0,0,0,11,0,0,0,0,0,15,0,0,0},
				{0,0,3,0,0,0,0,7,7,7,0,0,0,11,11,11,0,0,0,0,15,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
		
		Boolean f = true;
		for (int y = 0; y < out.getSize()[1]; y++) {
			for (int x = 0; x < out.getSize()[0]; x++) {
				if (out.getValue(x, y) != mas[y][x]) {
					f = false;
					break;
				}
				if (!f) break;
			}
		}
		if (f) System.out.println("OK"); else System.out.println("Fail");

	
	}

}
