
public class ParaStyle {
	private String name;//style name ie: para1
	private int leftIndent;
	private int lineLength;
	private int firstLineAdjustment;
	
	public ParaStyle(String name, int leftIndent, int lineLength, int firstLineAdjustment){
		this.name=name;
		this.leftIndent=leftIndent;
		this.lineLength=lineLength;
		this.firstLineAdjustment=firstLineAdjustment;
	}
	public String getName(){
		return name;
	}

	public int getLeftIndent() {
		return leftIndent;
	}

	public void setLeftIndent(int leftIndent) {
		this.leftIndent = leftIndent;
	}

	public int getLineLength() {
		return lineLength;
	}

	public void setLineLength(int lineLength) {
		this.lineLength = lineLength;
	}

	public int getFirstLineAdjustment() {
		return firstLineAdjustment;
	}

	public void setFirstLineAdjustment(int firstLineAdjustment) {
		this.firstLineAdjustment = firstLineAdjustment;
	}
	
	public String toString(){
		String str="";
		str+="\n"+name+" "+leftIndent+" "+lineLength+" "+firstLineAdjustment;
		return str;
		
	}
}
