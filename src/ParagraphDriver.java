import java.util.*;
import java.io.*;

public class ParagraphDriver {
/**
 *updated 11/27
 *
 * read style file card create objects for them
 * reading lines(getty.txt)
 */
	public static void main(String[] args){
		ArrayList<ParaStyle> styles;
		Scanner styleFileIn;
		Scanner docFileIn;
		PrintWriter fileOut;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the style file to be used: ");
		//String fileName=sc.next();
		try{
			styleFileIn=new Scanner(new FileReader(sc.next()));
			System.out.println("Enter the document file to be used: ");
			docFileIn= new Scanner (new FileReader(sc.next()));
			System.out.println("Enter output file name: ");
			fileOut=new PrintWriter(sc.next());
		}catch(FileNotFoundException e){
			System.out.println(e.getMessage());
			return;
		}catch(IOException e){//this should go somewhere else.
			System.out.println(e.getMessage());
			return;
		}
		styles=readStyles(styleFileIn);
		System.out.println(styles);
		
	}//end main
	public static ArrayList<ParaStyle> readStyles(Scanner styleScanner){
		ArrayList<ParaStyle> styles= new ArrayList<ParaStyle>();
		for (int i=0; styleScanner.hasNextLine(); i++){
			styles.add(new ParaStyle(styleScanner.next(), styleScanner.nextInt(), 
					styleScanner.nextInt(), styleScanner.nextInt()));
		}
		return styles;
	}
 /* (index of for ".P")
 * if line has ".P"
 * search for the style name "para1" or "para2" of "para3"
 * new Paragraph:
 * send it to Paragraph class and read in as one long string (words)
 * 
 * if no .P
 * use addWords method
 * 	words+=" "+moreWords.trim();
 * 
 * Format method
 * while (words not empty)
 * calculate leading spaces
 * first line spaces (hanging indent)
 * left indent and first line adj
 * 
 * not first line
 * left indent
 * 
 * if words.length less than max line length
 * (true)
 * add remaining words to the paragraph
 * 
 * (false)
 * need to cut: don't cut the word.
 * find last space:
 * 	lastIndexOf(" ");
 * 	cut words at that index (substring), add \n to end of substring, to that it will be seperate line.
 * 	add to paragraph
 * 
 * 
 * 
 */
	
}
