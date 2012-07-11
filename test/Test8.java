public class Test8 {

	public static void main(String[] args) {
		
		System.out.println("Test8: ");
		Picture pic = new Picture();
		ImageFile img = new ImageFile();
		pic=img.loadPGM("in.pgm");
		pic.setMaxValue(100);
		if(pic.getMaxValue()==100) System.out.println("OK"); else System.out.println("Fail");
		
	}

}
