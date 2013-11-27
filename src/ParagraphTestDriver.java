import java.util.Scanner;

import java.util.*;
public class ParagraphTestDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//System.out.println("Enter the style file to be used: ");
		//String fileName=sc.next();
		String para1="0 70 0";
		String para2="5 65 5";//left indent=5, line length=65, firstLineAdjustment=5
		String para3="5 70 -3";
		
		ParaStyle style1=new ParaStyle(para1, 5, 65, 2);
		
		//test the format with single "paragraph"
		String words="It is a truth universally acknowledged, that a single man in possession of a good fortune, must be in want of a wife. " +
				"However little known the feelings or views of such a man may be on his first entering a neighbourhood, " +
				"this truth is so well fixed in the minds of the surrounding families, that he is considered the rightful " +
				"property of some one or other of their daughters.";
		String format="";
		System.out.println(words);
		Paragraph p=new Paragraph();
		p.startParagraph(words);
		System.out.println(p.format(style1));
		
		//test the format with double "paragraphs"
		/*
		String words=".P para1 " +
				"It is a truth universally acknowledged, that a single man in possession" +
				" of a good fortune, must be in want of a wife. " +
				".P para2 " +
				"However little known the feelings or views of such a man may be on his first entering a neighbourhood, " +
				"this truth is so well fixed in the minds of the surrounding families, that he is considered the rightful " +
				"property of some one or other of their daughters." +
				".P para3 " +
				"Mr. Bennet was so odd a mixture of quick parts, sarcastic humour, reserve, and caprice, " +
				"that the experience of three-and-twenty years had been insufficient to make his wife understand his " +
				"character. HER mind was less difficult to develop. She was a woman of mean understanding, little " +
				"information, and uncertain temper. When she was discontented, she fancied herself nervous.";
		//String format="";
		//System.out.println(words);
		int posDotP=words.indexOf(".P");
		String first=words.substring(posDotP, words.indexOf(".P", posDotP+1));
		Paragraph p1=new Paragraph();
		p1.startParagraph(first);
		
		String second="";
		String third="";
		posDotP=words.indexOf(".P", posDotP+1);
		if (words.indexOf(".P", (posDotP+1))<0){
			second=words.substring(posDotP+1);
			//print the paragraph: 
			//System.out.println(p1.format(style1));
		}
		else{//but wait, there's more.
			second=words.substring(posDotP+1, words.indexOf(".P", (posDotP
					+1)));
			posDotP=words.indexOf(".P", posDotP+1);
			third=words.substring(posDotP+1);
			
		
		
			Paragraph p2=new Paragraph();
			p2.startParagraph(second);
			
			Paragraph p3=new Paragraph();
			p3.startParagraph(third);
			
			
			//print the paragraphs
			
		}*/
	}

}
