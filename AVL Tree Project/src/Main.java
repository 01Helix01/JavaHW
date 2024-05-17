import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String isbnIn;
		String titleIn;
		String authorIn;
		
		// Create the AVL Tree
		AVLTree<Book> tree = new AVLTree<Book>();
		
		// Read books file
		try {
			File books = new File("10_books.txt");
			Scanner reader = new Scanner(books);
			while(reader.hasNextLine()) {
				isbnIn = reader.nextLine();
				titleIn = reader.nextLine();
				authorIn = reader.nextLine();
				
				// Create book object and insert into AVL Tree
				Book newBook = new Book(isbnIn, titleIn, authorIn);
				tree.insert(newBook);
				
				// Print book that was inserted
				// newBook.printBook();
			}
			reader.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Encountered an error when reading books file");
		      e.printStackTrace();
		}
	}
}

//Declare the bookObject class
		class Book implements Comparable<Book> {
			String isbn;
			String title;
			String author;
			
			// Construct an object of book class
		    public Book(String isbn, String title, String author) {
		        this.isbn = isbn;
		        this.title = title;
		        this.author = author;
		    }
		    
		    // Print an object of book class
		    public void printBook() {
				System.out.println("ISBN: " + this.isbn);
				System.out.println("Title: " + this.title);
				System.out.println("Author: " + this.author);
		    }

		    // Compare the current book object to another (based off isbn)
			public int compareTo(Book other) {
				if((this.isbn).compareTo(other.isbn) == 0) {
					return 0;
				}
				else if((this.isbn).compareTo(other.isbn) < 0) {
					return -1;
				}
				else {
					return 1;
				}
			}
			
			// Have toString return ISBN of current book
			@Override
			public String toString () {
				return this.isbn;
			}
		}
