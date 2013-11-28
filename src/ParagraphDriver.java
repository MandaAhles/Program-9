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
			System.out.println(e.getMessage());
			return;
		}catch(IOException e){//this should go somewhere else.
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
		//read in from docScanner line by line.
		String nextLine="";
		String firstLine="";
		String styleIndicate="";
		ParaStyle paraStyle=null;
		boolean styleMatch=false;
		boolean endDoc=false;
		Paragraph p;
		String paragraph="";
		//put while (docScanner.hasNext()) here
		//look for ".P"
		nextLine=docScanner.nextLine();
		int posDotP=0;
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
				//get next lines.
				nextLine=docScanner.nextLine();
				if(nextLine.indexOf(".P")<0){
					//not a new paragr, first line of paragraph.
					firstLine=nextLine;
					p.startParagraph(firstLine);
					nextLine=docScanner.nextLine();
					
				}
				//no else. always going to be at least one line after .P line.
				
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
		//no else
		
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
