package finalproject.ultimatettt;

public class ComputerPlayer {
	
	private String name;
	private String mark;
	
	public ComputerPlayer(String name, String mark) {
		this.setName(name);
		this.setMark(mark);
	}
	
	String getName() {
		return name;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	String getMark() {
		return mark;
	}
	
	void setMark(String mark) {
		this.mark = mark;
	}
}
