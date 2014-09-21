/*
reviewed by Xingsheng  2014-9-22
*/
package pb.junit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Pool {

	public static void main(String[] args) {
		File file = new File("Test.txt");
		readData(file);
	}
	
	public static boolean readData(File file){
		try{
			File targetFile = new File("Output.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile));
			if(!file.exists()){
				System.out.println("File doesn't exist!");
				bw.write("File doesn't exist!");
				bw.close();
				return false;
			}
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s = null;
			String welcome = "My name is Han Wang.\r\n"
					+ "Welcome to the swimming pool system!\r\n"
					+ "The painting velocity is 10 square feet per hour and the water filling velocity is 15 cubic feet per hour:";
			System.out.println(welcome);
			bw.write(welcome);
			while((s = br.readLine())!=null){
				checkNum(s, bw);
			}
			br.close();
			bw.close();
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	
	public static boolean checkNum(String s, BufferedWriter bw){
		try{
			int flag = 0;
			String ss[]=s.split(" ");
			String err = "Input error!";
			if(ss.length>5){
				System.out.println("\r\n"+ err +"System can not accept more than 5 inputs!");
				bw.write("\r\n\r\n"+ err +" System can not accept more than 5 inputs!");
				return false;
			}
			if(ss.length<5){
				System.out.println("\r\n"+ err +" System can not accept less than 5 inputs!");
				bw.write("\r\n\r\n"+ err +" System can not accept less than 5 inputs!");
				return false;
			}
			String inputInfo = "\r\nInput information:"
					+ "\r\nName\tLength\tWidth\tShallow\tDeep"
					+ "\r\n" + ss[4] + "\t" + ss[0] + "\t" + ss[1] + "\t" + ss[2] + "\t" + ss[3];
			System.out.println(inputInfo);
			bw.write("\r\n" + inputInfo);
			String outputInfo = "Output information:"
					+ "\r\nCustomer Name:" + ss[4];
			System.out.println(outputInfo);
			bw.write("\r\n" + outputInfo);
			List<Integer> numList = new ArrayList<Integer>();
			for(int i = 0; i < ss.length-1; i++){
				Integer num;
				try{
					num = Integer.parseInt(ss[i]);
				}catch(Exception ex){
					System.out.println(err + " Decimals or non-digit characters detected! The numbers must be integers!");
					bw.write("\r\n" + err + " Decimals or non-digit characters detected! The numbers must be integers!");
					flag = 1;
					break;
				}
				if(num <= 0){
					System.out.println(err + " Negative digits detected! The numbers must be positive integers!");
					bw.write("\r\n" + err + " Negative digits detected! The numbers must be positive integers!");
					flag = 1;
					break;
				}
				numList.add(num);
			}
			if(flag == 1){
				return false;
			}
			if(numList.get(2) >= numList.get(3)){
				System.out.println(err + " The shallow depth must not be longer than deep depth!");
				bw.write("\r\n" + err + " The shallow depth must not be longer than deep depth!");
				return false;
			}
			if(numList.get(0) < numList.get(1)){
				System.out.println(err + " The length must be longer than width!");
				bw.write("\r\n" + err + " The length must be longer than width!");
				return false;
			}
			calculateResult(numList,bw);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return true;
	}
	
	public static double calculateResult(List<Integer> numList, BufferedWriter bw){
		double area = Math.sqrt((numList.get(3) - numList.get(2)) ^ 2 + numList.get(0) ^ 2) * numList.get(1) +
				numList.get(1) * numList.get(2) + 
				numList.get(1) * numList.get(3) +
				(numList.get(2) + numList.get(3)) * numList.get(0);
		double cubic = (numList.get(2) + numList.get(3)) * numList.get(0) / 2 * numList.get(1);
		double totalTime = Math.round(area / 10 + cubic / 15 + 8);
		String result = "The total time consuming is: " + totalTime + " hours!";
        System.out.println(result);
        try {
			bw.write("\r\n" + result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return totalTime;
	}

}
