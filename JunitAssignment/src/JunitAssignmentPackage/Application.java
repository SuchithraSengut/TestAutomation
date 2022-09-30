package JunitAssignmentPackage;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class Application {
	@Test
	public void validateMatchingText() throws IOException {
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(
					"C:\\Users\\hariharan\\eclipse-workspace\\Assignment\\Assignment source\\Test File Finance.txt"));
			String contentLine = br.readLine();
			while (contentLine != null) {

				String[] words = contentLine.split("\\s+");

				for (int i = 0; i < words.length; i++) {

					if ((words[i].equalsIgnoreCase("Sample")) == true)
						assertTrue(words[i + 1].equalsIgnoreCase("Company"));
				}
				contentLine = br.readLine();
			}
		}

		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		br.close();

	}


	@Test
	public void validateMatchingTextFromUser() throws IOException {
		System.out.println("Enter Text to find in Document");
		Scanner sc = new Scanner(System.in);
		String textFromUser = sc.nextLine();
		String ActualString="";
		BufferedReader br = null;
		System.out.println("Text entered by user is "+textFromUser);
		try {
			br = new BufferedReader(new FileReader(
					"C:\\Users\\hariharan\\eclipse-workspace\\Assignment\\Assignment source\\Test File Finance.txt"));
			String contentLine = br.readLine();
			while (contentLine != null) 
			{
				String[] words = contentLine.split("\\s+");
				for (int i = 0; i < words.length; i++) 
				{
					//System.out.println(" Text from doc  is "+words[i]);
					String temp =String.join(" ", words[i]);
					if ((temp.equals(textFromUser)) == true)
					{	
					ActualString = temp;
					
					}	
				}
				contentLine = br.readLine();
				}
			System.out.println("Actual Text from document  is "+ActualString);
			System.out.println("User Text  is "+textFromUser);
			assertEquals(ActualString, textFromUser);
			
			}

		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		br.close();
	}
	
	@Test
	public void validateMatchingRegExpFromUser() throws IOException {
		BufferedReader br = null;
		System.out.println("Enter RegExp to find in Document");
		Scanner sc = new Scanner(System.in);
		String textFromUser = sc.nextLine();
		Boolean Actual = false;
		//String pattern = textFromUser;
	Pattern pattern = Pattern.compile(textFromUser, Pattern.LITERAL);
	br = new BufferedReader(new FileReader(
			"C:\\Users\\hariharan\\eclipse-workspace\\Assignment\\Assignment source\\Test File Finance.txt"));
	String contentLine = br.readLine();
	while (contentLine != null) 
	{
		Matcher matcher = pattern.matcher(contentLine);
		 //boolean matches = Pattern.matches(textFromUser, contentLine);

		boolean matchFound = matcher.find();
		if (matchFound == true)
			Actual= true;
		contentLine = br.readLine();
	}
	assertTrue(Actual);
	
	}
	
	
}


