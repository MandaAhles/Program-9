import java.util.*;
//import java.io.*;

public class ParagraphDriver {
/**
 * read style file card create objects for them
 * reading lines(getty.txt)
 */
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		//System.out.println("Enter the style file to be used: ");
		//String fileName=sc.next();
		//String para1="0 70 0";
		String para2="5 65 5";//left indent=5, line length=65, firstLineAdjustment=5
		String para3="5 70 -3";
		
		ParaStyle style1=new ParaStyle("para1", 0, 70, 0);
		ParaStyle style2=new ParaStyle("para2", 5, 65, 5);
		
		//test the format with double "paragraphs"
		String words=".P para1 " +
				"It is a truth universally acknowledged, that a single man in possession" +
				" of a good fortune, must be in want of a wife. " +
				".P para2 " +
				"However little known the feelings or views of such a man may be on his first entering a neighbourhood, " +
				"this truth is so well fixed in the minds of the surrounding families, that he is considered the rightful " +
				"property of some one or other of their daughters.";
		String format="";
		System.out.println(words);
		int posDotP=words.indexOf(".P");
		String first=words.substring(posDotP, words.indexOf(".P", posDotP+1));
		Paragraph p1=new Paragraph();
		p1.startParagraph(first);
		
		posDotP=words.indexOf(".P", posDotP+1);
		
		String second=words.substring(posDotP, words.indexOf(".P", posDotP+1));
		Paragraph p2=new Paragraph();
		p2.startParagraph(second);
		System.out.println(p1.format(style1));
		System.out.println(p2.format(style2));
		
	
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
}
