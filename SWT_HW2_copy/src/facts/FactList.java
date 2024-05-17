package facts;

import java.util.ArrayList;
import java.util.Random;


public class FactList{

	private ArrayList<Fact> factList;
	private Random randomGen;

	public FactList()
	{
		this.factList = new ArrayList<Fact>();
		randomGen = new Random (System.currentTimeMillis());
	}

	public void set(Fact f)
	{
		factList.add(f);
	}

	public int getSize(){
		return factList.size();
	}

	public Fact get(int i){
		return (Fact) factList.get (i);
	}

	public FactList search (String searchString, int mode)
	{
		FactList fl = new FactList();
		for (int i = 0; i < factList.size(); i++)
		{
			Fact fact = factList.get(i);
			if (mode == FactSearchMode.AUTHOR_VAL && 
					fact.getAuthor().toLowerCase().indexOf(searchString.toLowerCase()) != -1){  
				fl.set(fact);
			} else if (mode == FactSearchMode.TEXT_VAL && 
					fact.getText().toLowerCase().indexOf(searchString.toLowerCase()) != -1){  
				fl.set(fact);
			} else if (mode == FactSearchMode.TYPE_VAL && 
					fact.getType().toLowerCase().indexOf(searchString.toLowerCase()) != -1){  
				fl.set(fact);
			} else if ((mode == FactSearchMode.ALL_VAL) &&
					(fact.getAuthor().toLowerCase().indexOf (searchString.toLowerCase()) != -1  ||
					fact.getText().toLowerCase().indexOf (searchString.toLowerCase()) != -1 ||
					fact.getType().toLowerCase().indexOf (searchString.toLowerCase()) != -1)){  
				fl.set(fact);
			}
		}
		return fl;
	}

	public Fact getRandom(){
		return factList.get(randomGen.nextInt(factList.size()));
	}
	
	
	// New method to add new facts, only if the fact is valid
	public void addFact(String author, String type, String text) {
		if(isValidFact(author, type, text)) {
			Fact newFact = new Fact(author, type, text);
			set(newFact);
			System.out.println("Fact added");
		} else {
			System.out.println("Fact invalid");
		}
	}
	
	// Data validation method, can be modified based of code requirements
	// I just assumed that each fact should have a non empty author, type, and text
	public boolean isValidFact(String author, String type, String text) {
		if(!author.isEmpty() && !type.isEmpty() && !text.isEmpty()) return true;
		return false;
	}

	public static void main(String[] s ) {

		FactList factlist = new FactList();

		// Changed these test lines to our new addFact rather than set
		factlist.addFact("testAuthor", "testText", "testType");
		System.out.println("list size : " + factlist.getSize());

		System.out.println("search list size : " + factlist.search("test", 1).getSize());
	}

}
