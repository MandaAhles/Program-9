import java.util.*;
import java.io.*;

public class ParagraphDriver {
/**
 *updated 11/28
 
 */
	public static void main(String[] args){
		ArrayList<ParaStyle> styles;
		Scanner styleFileIn;
		Scanner docFileIn;
		PrintWriter fileOut;
		Scanner sc=new Scanner(System.in);
		//get style type files
		
		System.out.println("Enter the style file to be used: ");
		//String fileName=sc.next();
		try{
			styleFileIn=new Scanner(new FileReader(sc.next()));
			System.out.println("Enter the document file to be used: ");
			docFileIn= new Scanner (new FileReader(sc.next()));
			System.out.println("Enter output file name: ");
			fileOut=new PrintWriter(sc.next());
		}catch(FileNotFoundException e){
			System.out.println("This file does not exist or cannot be opened.");
			return;
		}catch(IOException e){//this should go somewhere else?
			System.out.println(e.getMessage());
			return;
		}
		styles=readStyles(styleFileIn);
		formatDocument(docFileIn, fileOut, styles);
		
		//read in document one line at a time, using formatDocument()
		
	}//end main
	public static ArrayList<ParaStyle> readStyles(Scanner styleScanner){
		ArrayList<ParaStyle> styles= new ArrayList<ParaStyle>();
		for (int i=0; styleScanner.hasNextLine(); i++){
			styles.add(new ParaStyle(styleScanner.next(), styleScanner.nextInt(), 
					styleScanner.nextInt(), styleScanner.nextInt()));
		}
		return styles;
	}
	public static void formatDocument(Scanner docScanner, PrintWriter outputFileWriter, 
			ArrayList<ParaStyle> styles){
		//variables:
		String nextLine="";
		String firstLine="";
		String styleIndicate="";
		ParaStyle paraStyle=null;
		boolean styleMatch=false;
		boolean endDoc=false;
		Paragraph p;
		String paragraph="";
		int posDotP=0;
		
		//read in from docScanner line by line.
		nextLine=docScanner.nextLine();
		
		//look for ".P"
		//if line has ".P"
		do{
			if (posDotP>=0){//contains ".P"
				//search for the style name (ie: "para1" or "para2" of "para3")
				p=new Paragraph();
				styleIndicate=nextLine.substring(posDotP+2, nextLine.length()).trim();
				styleMatch=false;
				for(int i=0; i<styles.size() && styleMatch==false; i++){
					if(styles.get(i).getName().equals(styleIndicate)){//set paraStyle for use in p.format
						paraStyle=styles.get(i);
						styleMatch=true;
					}
				}
				//get first line after .P line
				nextLine=docScanner.nextLine();
				if(nextLine.indexOf(".P")<0){
					//not a new paragr, first line of paragraph.
					firstLine=nextLine;
					p.startParagraph(firstLine);
					nextLine=docScanner.nextLine();
					
				}
				//keep going.
				while(nextLine.indexOf(".P")<0 && endDoc==false){
					p.addWords(nextLine);
					if(docScanner.hasNext())
						nextLine=docScanner.nextLine();
					else
						endDoc=true;
				}
				//kicked out of loop, so must have ".P". Format paragraph as is first.
				paragraph=p.format(paraStyle);
				//print to output file
				outputFileWriter.println(paragraph);
				outputFileWriter.flush();
			}
		}while(docScanner.hasNext());
		System.out.println("Document fomatting complete.");
	}
 
}
