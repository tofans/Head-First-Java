package HeadFirstJava.Chapter3_PrimitiveReference;

class BooksTestDrive {

  public static void main(String[] args) {
    Books[] myBooks = new Books[3];
    int x=0;
    myBooks[0].title = "The Raid The Raid";
    //myBooks[1].title = "The Love";
    //myBooks[2].title = "The Lost";

    myBooks[0].author = "Jamhur";
    //myBooks[1].author = "Sikli";
    //myBooks[2].author = "James";

    while (x<3) {
      System.out.println(myBooks[x].title);
      System.out.println(" By ");
      System.out.println(myBooks[x].author);
      x = x + 1;
    }
  }
}
