/**
 * Comp Sci 251
 * sec 805
 * 		
 * created by Amanda McTavish
 * updated 11/21
 * notes: the formatting is primitavely working. 
 * 
 *
 */
public class Paragraph {
	private String words;
	
	public Paragraph(){
		words="";
	}
	public String startParagraph(String beginning){
		words+=beginning;
		return words;
	}
	public String addWords(String moreWords){
		words+=" "+moreWords.trim();
		return words;
	}
	/*Format method
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
	*/
	public String format(ParaStyle ps){
		String firstLineIndent="";
		String allLineIndent="";
		String firstLine="";
		String nextLine="";
		String paragraph="";
		String lineBreak="";
		
		//create indents for first line.
		if (ps.getLeftIndent()>0){
			for (int i=0; i<ps.getLeftIndent(); i++){
				allLineIndent+=" ";
			}
		}
		if (ps.getFirstLineAdjustment()>0){
			for (int i=0; i<ps.getFirstLineAdjustment(); i++){
				firstLineIndent+=" ";
			}
			firstLine+=allLineIndent+firstLineIndent;
		}
		else if(ps.getFirstLineAdjustment()<0){
			for (int i=(ps.getLeftIndent()+ps.getFirstLineAdjustment()); i>0; i--){
				firstLineIndent+=" ";
			}
			firstLine+=firstLineIndent;
			//this only works if the left indent+first line indent is greater than 0.
		}
		else //(first line indent is 0)
			firstLine=allLineIndent+firstLineIndent;
		
		//add it all as the paragraph.
		words=firstLine+words;
			//System.out.println(words+"\n");
		
		if (words.length()<=ps.getLineLength()){
			paragraph=words;
				//System.out.println("this is short enough)");
		}
		
		else{
			do{
				//find last space between 0-ps.getLineLength, break substring at that space
				int posLineBreak=(words).lastIndexOf(" ", (ps.getLineLength()));
					//System.out.println(posLineBreak);
				
				//add \n to end of firstLine, and end of nextLine
				lineBreak=words.substring(0, posLineBreak+1);
					//System.out.println(lineBreak);
				paragraph+=lineBreak+"\n"+allLineIndent;
				nextLine=words.substring(posLineBreak+1);
				//paragraph+=nextLine;
				words=nextLine;
			}while(words.length()>=ps.getLineLength());
			//paragraph+=firstLine+nextLine;
			paragraph+=nextLine;
			
		}
		//paragraph+=firstLine+words;
		//System.out.println();
		paragraph+="\n";//final space after paragraph.
		return paragraph;
	}//end format
	
	/*public String toString(String p){
		String str="";
		str+=p;
		return p;
	}*/

}
