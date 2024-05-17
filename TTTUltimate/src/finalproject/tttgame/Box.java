package finalproject.tttgame;

public class Box {
	private int row;
	private int col;
	private final static String DASH = "-";
	private String placeHolder = Box.DASH;
	
	
	Box(int row, int col){
		this.row = row;
		this.col = col;
	}
	
	String getPlaceHolder() {
		return placeHolder;
	}
	
	boolean setPlaceHolder(String placeHolder) {
		if(isAvailable()) {
			this.placeHolder = placeHolder;
			return true;
	}
	return false;
	}
	
	boolean isAvailable() {
		return this.placeHolder.equals(Box.DASH);
	}
	
	void print() {
		System.out.println("row:" + row + " col:" + col + "placeholder:" + placeHolder);
		System.out.print(placeHolder + " ");
	}
}
