import java.io.*;
import java.util.*;

public class Picture {
	
	private int pic[][];
	private Scanner sc;
	private Formatter fr;
	private int maxvalue = 0;
	
	public Picture() {
		this(0, 0);
	}
	
	public Picture(int x, int y) {
		pic = new int[y][x];
	}

	public void setMaxValue(int m) {
		maxvalue = m;
	}
	
	public int getMaxValue() {
		return maxvalue;
	}
	
	public int[] getSize(){
		int[] xy = { pic[0].length, pic.length};
		return xy;
	}
	
	public int getValue(int x, int y) {
		return pic[y][x];
	}
	
	public void setValue(int x, int y, int val) {
		pic[y][x] = val;
	}
	
	public boolean loadFromFile(String url){
		
		try{
			sc = new Scanner(new File(url));
		}
		catch(Exception e){
			System.out.println("Ошибка! Файл не найден.");
			return false;
		}	
		
		int k = 0, i = 0, j = 0, x, y;
		try{
			x = sc.nextInt();
			y = sc.nextInt();
		}
		catch(Exception e){
			System.out.println("Ошибка! Неверно заданы размеры массива.");
			return false;
		}
		
		try{
			pic = new int[y][x];
			while( sc.hasNextInt() &&  (k<x*y) ){
				
				pic[i][j] = sc.nextInt();
				
				if(pic[i][j]>255 || pic[i][j]<0){
					System.out.println("Ошибка! Числа должны находиться в диапазоне от 0 до 255.");
					return false;
				}
				
				j++;
				if(j == x){
					i++;
					j = 0;
				}
				k++;
			}
			
			if(k<x*y){
				System.out.println("Ошибка. Неправильный формат данных.");
				return false;
			}
			
		}
		catch(Exception e){
			System.out.println("Ошибка чтения из файла!");
			return false;
		}
		
		sc.close();
		return true;
		
	}
	

	public void show(){
		for(int row[]: pic){
			for(int a: row)
				System.out.print(a+"\t");
			System.out.println();
		}
	}
	

	public boolean saveInFile(String url){
		try{
			fr = new Formatter(url);
			fr.out().append(pic[0].length+"\r\n"+pic.length+"\r\n");
			for(int row[]: pic){
				for(int a: row)
					fr.out().append(a+" ");
				fr.out().append("\r\n");
			}
			
			System.out.println("Результат сохранен в файл "+url);
			fr.close();
			return true;
		}
		catch(Exception e){
			System.out.println("Ошибка! Файл не был создан. ");
			return false;
		}
	}

	
}
