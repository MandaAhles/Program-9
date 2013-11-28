/**
 * Comp Sci 251
 * sec 805
 * 		
 * created by Amanda McTavish
 * updated 11/28
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
		else{ //(first line indent is 0)
			firstLine=allLineIndent+firstLineIndent;
		}
		//add it all as the paragraph.
		words=firstLine+words;
		
		if (words.length()<=ps.getLineLength()){
			paragraph=words;
		}
		
		else{
			do{
				//find last space between 0-ps.getLineLength, break substring at that space
				int posLineBreak=(words).lastIndexOf(" ", (ps.getLineLength()));
				
				//add \n to end of firstLine, and end of nextLine
				lineBreak=words.substring(0, posLineBreak+1);
					
				paragraph+=lineBreak+"\n"+allLineIndent;
				nextLine=words.substring(posLineBreak+1);
				
				words=nextLine;
			}while(words.length()>=ps.getLineLength());
			
			paragraph+=nextLine;
		}
		paragraph+="\n";//final space after paragraph.
		return paragraph;
	}//end format

}
