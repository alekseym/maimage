import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Picture pic = new Picture();
		ImageFile img = new ImageFile();
		Scanner reader = new Scanner(System.in);
		String filePatch = "";
		
		do{
			System.out.println("������� ��� PGM �����: ");
			filePatch = reader.nextLine();
			pic=img.loadPGM(filePatch);
		}
		while(pic==null);	
		
		Filter fl = new Filter();
		Picture out;
		out = fl.process(pic);

		do{
			System.out.println("������� ��� ����� ��� ���������� ����������: ");
			filePatch = reader.nextLine();
		}
		while(!img.savePGM(out, filePatch));	
	}
}

