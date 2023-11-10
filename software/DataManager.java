package software;

import java.io.*;
import javax.swing.*;

public class DataManager{
	private static final String fileName = "user_data.txt";

	public void saveData(String nickname, String password) {
		
		try (FileWriter fileWriter = new FileWriter(fileName, true);
	    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	    PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
	            printWriter.println(nickname);
	            printWriter.println(password);
	            printWriter.println("0");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	public void clear(JTextField nicknameField, JTextField passwordField) {
        nicknameField.setText("");
        passwordField.setText("");
    }
	
	public boolean dataCheck(String inputN, String inputP) {
		try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
			String line;
			while((line = reader.readLine()) != null) {
				String dataName = line;
				String dataPW = reader.readLine();
				reader.readLine();
				
				if(inputN.equals(dataName) && inputP.equals(dataPW)) return true;
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public String[] getData(String inputN) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String dataName = line;
                String dataPW = reader.readLine();
                String score = reader.readLine();

                if (inputN.equals(dataName)) {
                    return new String[]{dataName, score};
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; 
    }
}
