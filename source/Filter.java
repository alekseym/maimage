import java.util.Arrays;

public class Filter {	
	public Picture process(Picture in) {
		
		int xn = in.getSize()[0];
		int yn = in.getSize()[1];
		Picture out = new Picture(xn, yn);
		out.setMaxValue(in.getMaxValue());
		
		for (int y = 0; y < yn; y++)
			for (int x = 0; x < xn; x++) {
				int k = 0;
				int a[] = new int[9];
				for (int yi = y-1; yi <= y+1; yi++) {
					for (int xi = x-1; xi <= x+1; xi++) {

						int xx = xi, yy = yi;
						if (xi == -1) xx++;
						if (xi == xn) xx--;
						if (yi == -1) yy++;
						if (yi == yn) yy--;
						a[k] = in.getValue(xx, yy);
						k++;
						
					}
				}
				
				Arrays.sort(a);
				out.setValue(x, y, a[4]);
				
			}
		
		return out;
		
	}
}
