package model;

public class Book {


    private int id;


    private String  book_name ;

    private String  book_author ;

    private int price;

    private boolean  is_borrowed ;

    public Book(String  book_name , String  book_author , int price, boolean  is_borrowed ) {
        this. book_name  =  book_name ;
        this. book_author  =  book_author ;
        this.price = price;
        this. is_borrowed  = false;
    }

    public Book(int id, String  book_name , String  book_author , int price, boolean  is_borrowed ){
        this.id=id;
        this. book_name = book_name ;
        this. book_author = book_author ;
        this.price=price;
        this. is_borrowed = is_borrowed ;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;

    }

    public String getbook_name (){
        return  book_name ;
    }

    public void setbook_name (String  book_name ){
        this. book_name = book_name ;
    }

    public String getbook_author (){
        return  book_author ;
    }

    public void setbook_author (String  book_author ){
        this. book_author = book_author ;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price=price;
    }

    public boolean  is_borrowed () {
        return  is_borrowed ;
    }

    public void setBorrowed(boolean borrowed) {
         is_borrowed  = borrowed;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ",  book_name ='" +  book_name  + '\'' +
                ",  book_author ='" +  book_author  + '\'' +
                ", price=" + price +
                '}';
    }
}
