import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CaesarCipher3
{

	public static void main(String[] args) throws IOException 
	{
		Scanner scan= new Scanner(System.in);
		String fileName;
		boolean encrypt=true; //true=enc, false=dec
		int shiftAmount;
		String stringed;
		System.out.print("\nWould you like to encrypt,decrypt,or crack a file?: ");
		String encryptchoice= scan.nextLine();
		
			if(encryptchoice.equals("encrypt"))
			{
			encrypt=true;
			}
			if(encryptchoice.equals("decrypt"))
			{
			encrypt=false;
			}
			if(encryptchoice.equals("crack"))
			{
				encrypt=false;
				System.out.print("\nEnter a filename to encrypt: ");
				fileName= scan.nextLine();
			}
		System.out.print("\nHow many places should the alphabet be shifted?: ");
		shiftAmount= scan.nextInt();
		scan.nextLine();
			if(encrypt==true)
			{
				System.out.print("\nEnter a filename to encrypt: ");
				fileName= scan.nextLine();
				System.out.println(caesar_cipher(fileName,encrypt,shiftAmount));
				String partOfFile= fileName.substring(0, fileName.length()-4);
				System.out.println("Result written to "+partOfFile+"_ENC.txt");
			}
			if(encrypt==false)
			{
				System.out.print("\nEnter a filename to decrypt: ");
				fileName= scan.nextLine();
				System.out.println(caesar_cipher(fileName,encrypt,shiftAmount));
				String partOfFile= fileName.substring(0, fileName.length()-4);
				System.out.println("Result written to "+partOfFile+"_DEC.txt");
				
			}
		
		
		
		
		
		
	}

	
	public static String caesar_cipher(String fileName, 
	boolean encrypt, int shiftAmount) throws IOException
{
		char encryptedchar;
	String stringed="";
		if(encrypt==true)
		{
			Scanner inputFile= new Scanner(new File(fileName)); 
			
			String partOfFile= fileName.substring(0, fileName.length()-4);
			PrintWriter outputfile= new PrintWriter(partOfFile+"_ENC.txt");
			
			
			while (inputFile.hasNext())

				
					{ 
				
					String line = inputFile.nextLine(); 
					char[] linechars= new char[line.length()];
					
					for(int h=0; h<line.length();h++)
					{
						linechars[h]= line.charAt(h);
					}
					
					for(int i=0; i<line.length();i++)
					{
						//subtract 26
						//subtract shiftamount
						//if its less than 0, add 26
						char regularchar=linechars[i];
						//char encryptedchar= (char) (regularchar+((shiftAmount%regularchar)));
						//  HEY- REPLACE WITH ASCII VALUES, REPLACE ALL 26 WITH ASCII VALUES
						//OR DO IF UPPER OR LOWERCASE
						if(regularchar<65)
						{
							stringed+=""+regularchar;
							continue;
						}
						if(regularchar>122)
						{
							stringed+=""+regularchar;
							continue;
						}
						if(regularchar<97&&regularchar>90)
						{
							stringed+=""+regularchar;
							continue;
						}
						 encryptedchar = (char) ((char) (regularchar-26)+26+shiftAmount);
					
						if(encryptedchar<65 )
						{
							encryptedchar=(char) (regularchar+(26-Math.abs(shiftAmount)));
							
						}
						if(encryptedchar>122)
						{
							encryptedchar=regularchar;
						}
						if(encryptedchar<97&&encryptedchar>90)
						{
							encryptedchar=(char) (regularchar+(26-Math.abs(shiftAmount)));
						
						}
						
						outputfile.print(encryptedchar);
						stringed+=""+encryptedchar;
								 
					}
					outputfile.println("\n");
					System.out.println("");

					}
			
			outputfile.close();
			inputFile.close();
			
		}
		
		
		if(encrypt==false)
		{
			if(fileName!=null)
			{
			Scanner inputFile= new Scanner(new File(fileName)); 
			
			String partOfFile= fileName.substring(0, fileName.length()-4);
			PrintWriter outputfile= new PrintWriter(partOfFile+"_DEC.txt");
			
			
			while (inputFile.hasNext())

				
					{ 

					String line = inputFile.nextLine(); 
					char[] linechars= new char[line.length()];
					
					for(int h=0; h<line.length();h++)
					{
						linechars[h]= line.charAt(h);
					}
					
					for(int i=0; i<line.length();i++)
					{
						
						
						
						char regularchar=linechars[i];
						//char decryptedchar= (char) (regularchar+((shiftAmount%regularchar)));
						if(regularchar<65)
						{
							stringed+=""+regularchar;
							continue;
						}
						if(regularchar>122)
						{
							stringed+=""+regularchar;
							continue;
						}
						if(regularchar<97&&regularchar>90)
						{
							stringed+=""+regularchar;
							continue;
						}
						
						char decryptedchar = (char) ((char) (regularchar+26)-26-shiftAmount);
						
						if(decryptedchar<65)
						{
							decryptedchar=(char) (decryptedchar-(26-shiftAmount));	
							
						}
						if(decryptedchar>122)
						{
							decryptedchar=(char) (decryptedchar-(26-shiftAmount));
							
						}
						if(decryptedchar<97&&decryptedchar>90)
						{
							decryptedchar=(char) (decryptedchar-(26-shiftAmount));
							
						}
						
						outputfile.print(decryptedchar);
						stringed+=""+decryptedchar;
								 
					}
					outputfile.println("\n");
					System.out.println("");

					}
			outputfile.close();
			inputFile.close();
			
		}
			else
			{
				
			}
		
		return stringed;	
		
		
		
		
}
	
	
	
	
	
	
	
	
	
}
