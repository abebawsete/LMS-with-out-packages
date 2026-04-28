import java.util.Scanner;
class Book
{
	private  int  id;
	private  String title;
	private  String author;
	private int publishedYear;
	public Book(int id, String title, String author,int publishedYear)
	{
		this.id = id;
		this.title = title;
		this.author = author;
		this.publishedYear = publishedYear;
	}
	//Define getter method to access private data
	int getID()
	{
		return id;
	}
	String getTitle()
	{
		return title;
	}
	String getAuthor()
	{
		return author;
	}
	int getpublishedYear()
	{
		return publishedYear;
	}
	//Define setter method to modify private data
	void setId(int id)
	{
		if(id>0)
		{
			this.id = id;
		}
		else
		{
			System.out.println("Invalid Id!");
		}
		
	}
	void setTitle(String title)
	{
		if (title != null && !title.isEmpty())
		{
			this.title = title;
		}
		else
		{
			System.out.println("Invalid Author Name!");
		}
		
	}
	void setAuthor(String author)
	{
		if (author != null && !author.isEmpty())
		{
			this.author = author;	
		}
		else
		{
		   System.out.println("Invalid!");
		}
	}
	void setpublishedYear(int publishedYear)
	{
		if(publishedYear < 2000 || publishedYear > 2026)
		{
			System.out.println("Invalid year!");
		}
		else
		{
		   this.publishedYear = publishedYear;
		}
	}
	// Method to display book details
	void displayInfo()
	{
		System.out.print("ID: "+id+", Title: "+title+" , Author: "+author+", Published Year:"+publishedYear);
	}
}
class PrintedBook extends Book
{
	//Additional attribute
	private int numberOfPages;
	public PrintedBook(int id, String title, String author, int publishedYear, int numberOfPages)
	{
		// Call parent constructor using super()
		super(id, title, author,publishedYear);
		this.numberOfPages = numberOfPages;
	}
	//Define getter method to access private data
	int getnumberOfPages()
	{
		return numberOfPages;
	}
	//Define setter method to modify private data
	void setNumberOfPages(int numberOfPages)
	{
		if(numberOfPages>0)
		{
			this.numberOfPages = numberOfPages;
		}
		else
		{
			System.out.println("Invalid Pages!");
		}
	}
	@Override
	void displayInfo()
	{
		//super.displayInfo();
		System.out.print("ID: PB" + getID() + ", Title: " + getTitle() + " , Author: " + getAuthor() + ", Published Year: " + getpublishedYear());
		System.out.println(", Pages:  "+numberOfPages+" \n");
	}
}
// Child class using Inheritance
class EBook extends Book
{
	private double fileSize;
	EBook(int id, String title, String author, int publishedYear, double fileSize)
	{
		// Call parent constructor using super()
		super(id, title, author,publishedYear);
		this.fileSize = fileSize;
	}
	double getfileSize()
	{
		return fileSize;
	}
	void setfileSize(double fileSize)
	{
		if(fileSize>0)
		{
		   this.fileSize = fileSize;
		}
		else
		{
			System.out.println("Invalid fileSize!");
		}
	}
	@Override
	void displayInfo()
	{
		
		//super.displayInfo();
		System.out.print("ID: EB" + getID() + ", Title: " + getTitle() + " , Author: " + getAuthor() + ", Published Year: " + getpublishedYear());
		System.out.println(", File Size: "+fileSize+"MB" +"\n");
	}	
}
// Library class using array to store Book objects
class Library
{
	// Array to store Book objects
	private Book[] books;
	//counter to check number of books
	private int count = 0;
	public Library(int size)
	{
		this.books = new Book[size];
	}
	public void addBook(Book book)
	{

		if(count < books.length)
		{
			books[count] = book;
			count++;
		}
		else
		{
			System.out.println("Library has been fulled!");
		}

	}
	public void showBooks()
	{
		if(count == 0)
		{
			System.out.println("No books availabl!");
		}
		for(int i = 0; i < count; i++)
		{
			books[i].displayInfo(); //Polymerphism
			System.out.println("---------------------------");
		}
	}
	public void searchBook(int searchID)
	{
		for(int i = 0; i < count;i++)
		{
			if(books[i].getID()== searchID)
			{
				System.out.println("Search Book with ID "+searchID+ " found!");
				books[i].displayInfo();
				System.out.println("--------------------------");
				return;
			}
		}
		// Only runs if no book found
        System.out.println("The ID : " + searchID + " is not found!");
	}
	public void updateBook(int searchID, Scanner scanner)
	{
		for(int i = 0; i < count; i++)
		{
			if(books[i].getID() == searchID)
			{
				System.out.print("The ID: "+searchID+" found!");

				System.out.print("Enter New Title:");
				String newTitle = scanner.nextLine();
				books[i].setTitle(newTitle);

				System.out.print("Enter New Author:");
				String newAuthor = scanner.nextLine();
				books[i].setAuthor(newAuthor);

				System.out.print("Enter New Year:");
				int newYear = scanner.nextInt();
				books[i].setpublishedYear(newYear);

				if(books[i] instanceof PrintedBook)
				{
					System.out.print("Enter New Pages!: ");
					int newPages = scanner.nextInt();
					scanner.nextLine();
					((PrintedBook)books[i]).setNumberOfPages(newPages);
				}
				if(books[i] instanceof EBook)
				{
					System.out.print("Enter New FileSize!: ");
					double fileSize = scanner.nextDouble();
					scanner.nextLine();
					((EBook)books[i]).setfileSize(fileSize);
				}

			}
		}
	}
	public void deleteBooK(int searchID)
	{
		for(int i = 0; i < count; i++)
		{
			if(books[i].getID() == searchID)
			{
				for(int j = i; j < count-1; j++)
				{
					books[i] = books[j+1];
				}
				books[count-1] = null;
				count--;
				System.out.println("Book with ID " + searchID + " deleted successfully!");
	            return;
			}
			
		}
	}
}
class MiniProject
{
	public static void main(String args[])
	{
		// Create Scanner object to take user input
		Scanner scanner = new Scanner(System.in);
		// Create Library object with size 5
		Library lib = new Library(5);
		int choice;
		do
		{
			// Display menu options
			System.out.println("\n ==== MENU ==== ");
			System.out.println("1. Add Printed Book");
			System.out.println("2. Add EBook");
			System.out.println("3. Show Books");
			System.out.println("4. Search Book");
			System.out.println("5. Update Book");
			System.out.println("6. Delete Book");
			System.out.println("0. Exit");
			System.out.print("Enter your choice: ");

			//Reads an integer number from the user
			choice = scanner.nextInt();
			scanner.nextLine();//clear buffer
			switch(choice)
			{
				// Input details for PrintedBook
				case 1:
					System.out.println("Enter ID:");
					int id = scanner.nextInt();
					scanner.nextLine();

					System.out.println("Enter Title:");
					String title = scanner.nextLine();

					System.out.println("Enter Author:");
					String author = scanner.nextLine();

					
					System.out.println("Enter published year:");
					int year = scanner.nextInt();
					scanner.nextLine();

					System.out.println("Enter pages:");
					int pages = scanner.nextInt();
					scanner.nextLine();

					// Create PrintedBook object
					PrintedBook printed = new PrintedBook(id,title, author,year,pages);

					// Add Printed book to library
					lib.addBook(printed);
					System.out.println("Printed Book Added!");
					break;
					// Input details for e-Book
				case 2:
					System.out.println("Enter ID:");
					int E_id = scanner.nextInt();
					scanner.nextLine();

					System.out.println("Enter Title:");
					String E_title = scanner.nextLine();

					System.out.println("Enter Author:");
					String E_author = scanner.nextLine();

					System.out.println("Enter published year...");
					int E_year = scanner.nextInt();
					scanner.nextLine();

					System.out.println("Enter FileSize!");
					double fileSize = scanner.nextDouble();
					scanner.nextLine();

					// Create EBook object
					EBook ebook = new EBook(E_id, E_title,E_author,E_year,fileSize);

					// Add Ebook to library
					lib.addBook(ebook);
					break;
				case 3:
					// Display all books added
					System.out.println("\n --- Library Books --- ");
					lib.showBooks();
					break;
					// Search book
				case 4:
					System.out.print("Enter Id to search!:");
					int search = scanner.nextInt();
					scanner.nextLine();
					lib.searchBook(search);
					break;
				case 5:
					System.out.print("Enter the ID to be Update!");
					int idUpdate = scanner.nextInt();
					scanner.nextLine();

					lib.updateBook(idUpdate,scanner);
					break;
				case 6:
					System.out.print("Enter the Id to Delete!");
					int idDelete = scanner.nextInt();
					scanner.nextLine();
					lib.deleteBooK(idDelete);
				case 0:
					// Exit message
					System.out.println("Exiting program...");
					break;
			    default:
				System.out.println("Invalid Choice try again...!");
			}
		}while(choice!= 0);
		scanner.close();
	}
}