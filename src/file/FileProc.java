package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileProc {

	private File file;
	
	public FileProc(String filename) {
		file = new File("d:\\tmp\\" + filename + ".txt");
	}
	
	public void createFile() {
		try {
			if(file.createNewFile()) {
				System.out.println("파일 생성 성공!");
			}else {
				System.out.println("파일 생성 실패");
			}
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	
	public String[] loadData() {
		
		String datas[] = null;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
		
			// data의 갯수를 조사 -> 배열		list를 사용하면, 이 처리는 필요없음 
			int count = 0;
			String str = "";
			
			while( (str = br.readLine()) != null ) {
				count++;				
			} 
			br.close();
			
			// datas를 할당
			datas = new String[count];
			System.out.println("datas.length = " + datas.length);
			
			// 배열 저장
			int w = 0;
			br = new BufferedReader(new FileReader(file));
			while( (str = br.readLine()) != null ) {
				datas[w] = str;
				w++;
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return datas;
	}
	
	public void saveData(String[] datas) {
		
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			
			for (int i = 0; i < datas.length; i++) {
				pw.println(datas[i]);
			}			
			pw.close();
			
		} catch (IOException e) {			
			e.printStackTrace();
		}		
	}
	public int checkCount() {
		int count=0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
		while(br.readLine()!=null) {
				count++;
		}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;	
	}
	public int checkNumber() {
		String datas[] =loadData();
		int countNumber=0;
		
		for (int i = 0; i < datas.length; i++) {
			String data[]= datas[i].split("-");
			
			if(Integer.parseInt(data[0])<2000) {
				countNumber=(Integer.parseInt(data[0])+1);
			}
					
		}		
		return countNumber;			
	}
}
