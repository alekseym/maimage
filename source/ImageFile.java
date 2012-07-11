import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

public class ImageFile {
	
	private Scanner sc;
	private Formatter fr;
	
	public Picture loadPGM(String url) {
		
		Picture pgm = null;
		
		try{
			sc = new Scanner(new File(url));
		}
		catch(Exception e){
			System.out.println("Ошибка! Файл не найден.");
			return null;
		}	
		
		int k = 0, i = 0, j = 0, x, y, max;
		try{
			while (!sc.hasNextInt()) {
				sc.next();
			}
			x = sc.nextInt();
			y = sc.nextInt();
			max = sc.nextInt();
			pgm = new Picture(x, y);
			pgm.setMaxValue(max);
			while( sc.hasNextInt() &&  (k<x*y) ){
				
				pgm.setValue(j, i, sc.nextInt());	
				j++;
				if(j == x){
					i++;
					j = 0;
				}
				k++;
			}
		}
		
		catch(Exception e){
			System.out.println("Ошибка чтения файла!");
			sc.close();
			return null;
		}
		
		sc.close();
		return pgm;
		
	}
	
public boolean savePGM(Picture pic, String url) {
		try{
			fr = new Formatter(url);
		}
		catch(Exception e){
			System.out.println("Ошибка! Не удалось создать файл. ");
			return false;
		}
		try{
			fr.out().append("P2\r\n"+pic.getSize()[0]+" "+pic.getSize()[1]+"\r\n");
			fr.out().append(pic.getMaxValue()+"\r\n");
			for(int y = 0; y < pic.getSize()[1]; y++) {
				for(int x = 0; x < pic.getSize()[0]; x++) {
					fr.out().append(pic.getValue(x, y)+"");
					if (x != pic.getSize()[0]-1) fr.out().append(" ");
				}
				if (y != pic.getSize()[1]-1) fr.out().append("\r\n");
			}
			
			System.out.println("Результат сохранен в файл "+url);
			fr.close();
			return true;
		}
		catch(Exception e){
			System.out.println("Ошибка! Изображение не было сохранено. ");
			fr.close();
			return false;
		}
		
	}

}
