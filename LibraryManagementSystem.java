//Library management system
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Book{
    String title;
    String author;
    String isbn;
    boolean  isBorrowed;

    //constructor
    public Book(String title,String author,String isbn)
    {
        this.title=title;
        this.author=author;
        this.isbn=isbn;
        this.isBorrowed=false;

    }
    //method
    public String  getTitle(){
        return title;

    }
    public String getAuthor(){

        return author;
    }

    public String  getIsbn(){
        return isbn;

    }
    public  boolean isBorrowed(){
        return isBorrowed;
    }
    public void setBorrowed(boolean borrowed){
        isBorrowed=borrowed;
    }
    public String toString(){
        return "Title"+title+",Author"+author+",ISBN:"+isbn+",Borrowed:"+isBorrowed;
    }
    
}
public class LibraryManagementSystem{
    private List<Book> books;
    private Scanner scanner;
    //constructor
    public LibraryManagementSystem(){   
    books=new ArrayList<>();
    scanner = new Scanner(System.in);
    books.add(new Book("Rich dad  poor dad","Ankush","9876-43467"));
    books.add(new Book("HarryPotter","Rohi","6447-485789"));
    books.add(new Book("Criminal Justice","Sonu","9888-6097"));
    books.add(new Book("Atomic Habit","Ankush","1897-8e127"));
    }
    //curd operation
    public void addBook(){
        System.out.println("Enter Title");
        String title = scanner.nextLine();
        System.out.println("Author Name");
        String author = scanner.nextLine();
        System.out.println("Enter ISBN");
        String isbn = scanner.nextLine();
        Book newBook = new Book(title,author,isbn);
        books.add(newBook);
        System.out.println("Book added  successfully!!!!");
    }
    public void viewAllBooks(){
        if(books.isEmpty()){
            System.out.print("No, book in the library");
            return;
        }
        System.out.println("\n All Books ------");
        for(Book book:books){
            System.out.println(book);
        }
    }
    public void  updateBookStatus(){
        System.out.print("Enter ISBN of the Book to update:");
        String isbn = scanner.nextLine();
        int index = findBookByisbn(isbn);
        if(index!= -1){
            Book book = books.get(index);
            System.out.println("Is the book borrowe? (true/false)");
            boolean borrowed = Boolean.parseBoolean(isbn);
            book.setBorrowed(borrowed);
            System.out.println("Book Status update!!!!");
        }else{
            System.out.println("Book not Found!!!");
        }
    }
    public void deleteBook(){
        System.out.println("Enter ISBN of the Book to delete: ");
        String isbn = scanner.nextLine();

        Iterator<Book>iterator = books.iterator();
        boolean found = false;
        while(iterator.hasNext()){
            Book book = iterator.next();
            if(book.getIsbn().equals(isbn)){
                iterator.remove();
                found = true;
                System.out.println("Book deleted successfully!!!");
                break;
            }
            if(!found){
                System.out.println("Book not found!!!");
            }
        }
    }
    //sorting
    public void sortBookByTitle(){
        Collections.sort(books, Comparator.comparing(Book::getTitle));
        System.out.println("Books sorted by Title");
        viewAllBooks();
    }
    public void sortBookByAuthor(){
        Collections.sort(books, Comparator.comparing(Book::getAuthor));
        System.out.println("Books sorted by Author");
        viewAllBooks();
    }
    public void searchBookByIsbn(){
        System.out.println("Enter Isbn to search:");
        String isbnToSearch = scanner.nextLine();
        Collections.sort(books,Comparator.comparing(Book::getIsbn));
        Book dummyBook = new Book("","",isbnToSearch);
        int index = Collections.binarySearch(books,dummyBook, Comparator.comparing(Book::getIsbn));
        if(index >= 0){
            System.out.println("Book found"+books.get(index));
        }else{
            System.out.println("Book not found");
        }
    } 
    private int findBookByisbn(String  isbn){
        for(int i = 0;i< books.size();i++){
            if(books.get(i).getIsbn().equals(isbn)){
                return i;
            }
        }
        return -1;
    }
    public void displayMenu(){
        System.out.println("\n Library Management System--- ");
        System.out.println("1.Add Book");
        System.out.println("2.View all books");
        System.out.println("3.Update the book Status(Borrowed/Returned)");
        System.out.println("4.Delete book");
        System.out.println("5.Sort book by Title");
        System.out.println("6.Sort book by Author");
        System.out.println("7.Search boosks by Isbn");
        System.out.println("8.Exit");
        System.out.println("Enter your choice");  
    }
        public static void main(String[] args) {
             LibraryManagementSystem library = new LibraryManagementSystem();
             int choice;
             do{
                library.displayMenu();
                choice = Integer.parseInt(library.scanner.nextLine());
                switch (choice) {
                    case 1:
                    library.addBook();
                        break;
                    case 2:
                    library.viewAllBooks();
                        break;

                    case 3:
                    library.updateBookStatus();
                        break;
                    case 4:
                    library.deleteBook();
                        break;    
                    case 5:
                    library.sortBookByTitle();
                        break;
                    case 6:
                    library.sortBookByAuthor();
                        break;
                    case 7:
                    library.searchBookByIsbn();
                        break; 
                    case 8:
                    System.out.println("Exiting the library System! GoodBye");
                        break;           

                    default:
                    System.out.println("Invalid choice,Please try again");
                   
                    
                }
            }while(choice!= 8);
                library.scanner.close();
        }
        
    }

