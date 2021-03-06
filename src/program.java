 public class program {
     static final int pagesCapacity = 10;
     static final int booksCapacity = 10;
     static final int journalsCapacity = 10;
     static final int newspapersCapacity = 10;
     static final int textCapacity = 150;
     static final int nameCapacity = 50;

    static private class list{
        String text;

        public void setText(String newText){
            text = newText;
        }

        public String getText(){
            return text;
        }

    }

    static private class journal{
        String name;
        list[] pages = new list[pagesCapacity];

        public void fillJournal (String name, list[] pages){
            this.name = name;
            for (int i =0 ; i < pagesCapacity; i++)
                this.pages[i] = pages[i];
        }
        public String getName(){
            return name;
        }
        public list[] getPages(){
            return pages;
        }
    }

    static private class book{
        String name;
        String author;
        list pages[] = new list[pagesCapacity];

        public void fillBook (String author, String name, list[] pages){
            this.author = author;
            this.name = name;
            for (int i = 0; i < pagesCapacity;i++)
                this.pages[i] = pages[i];
        }

        public String getAuthor(){
            return author;
        }

        public String getName(){
            return name;
        }

        public list[] getPages(){
            return pages;
        }

    }

    static private class newspaper{
        String name;
        String text;
        int year;

        public void fillNewspaper(int year, String name, String text){
            this.name = name;
            this.text = text;
            this.year = year;
        }

        public newspaper(String text){
            this.text = text;
        }
        public  newspaper(){

        }

        public String getName(){
            return name;
        }

        public String getText(){
            return text;
        }

        public int getYear(){
            return year;
        }
    }

    static private class library {
        newspaper[] newspapers = new newspaper[newspapersCapacity];
        book[] books = new book[booksCapacity];
        journal[] journals = new journal[journalsCapacity];

        public void fillLibrary(book[] books, journal[] journals, newspaper[] newspapers) {
            for (int i = 0; i < booksCapacity; i++)
                this.books[i] = books[i];
            for (int i = 0; i < journalsCapacity; i++)
                this.journals[i] = journals[i];
            for (int i = 0; i < newspapersCapacity; i++)
                this.newspapers[i] = newspapers[i];

        }

        public void showAll() {
            System.out.println("\n ??????????");
            for (int i = 0; i < booksCapacity; i++) {
                System.out.println(books[i].getAuthor());
                System.out.println(books[i].getName());
            }

            System.out.println("\n ??????????????");
            for (int i = 0; i < journalsCapacity; i++)
                System.out.println(journals[i].getName());

            System.out.println("\n ????????????");
            for (int i = 0; i < newspapersCapacity; i++) {
                System.out.println(newspapers[i].getYear());
                System.out.println(newspapers[i].getName());
            }
        }

        public void showBooks() {
            for (int i = 0; i < booksCapacity; i++)
                System.out.println(books[i].getName());
        }

        public void showJournals() {
            for (int i = 0; i < journalsCapacity; i++)
                System.out.println(journals[i].getName());
        }

        public void showNewspapers() {
            for (int i = 0; i < newspapersCapacity; i++)
                System.out.println(newspapers[i].getName());
        }

        public void openBook(String name, String author, int numberList) {
            for (int i = 0; i < booksCapacity; i++) {
                if ((books[i].getAuthor().equals(author)) && (books[i].getName().equals(name))) {
                    System.out.println( books[i].getPages()[numberList].getText());
                    return;
                }
            }
            System.out.println("?????????? ???? ?????? ??????????????????????");
        }

        public void openJournal(String name, int numberList) {
            for (int i = 0; i < journalsCapacity; i++) {
                if ((journals[i].getName().equals(name))) {
                    System.out.println(journals[i].getPages()[numberList].getText());
                    return;
                }
            }
            System.out.println("?????????? ???? ?????? ??????????????????????");
        }

        public void openNewspaper(String name, int year) {
            for (int i = 0; i < newspapersCapacity; i++) {
                if ((newspapers[i].getName().equals( name)) && newspapers[i].getYear() == year) {
                    System.out.println(newspapers[i].getText());
                    return;
                }
            }
            System.out.println("?????????? ???? ?????? ??????????????????????");
        }

    }
    static public void execution(library testlibrary, book[] testbook, journal[] testjournal, newspaper[] testnewspaper, list[] test) {
        String str;
        String str2;
        for (int i = 0; i < pagesCapacity; i++) {
            str = "?????? ?????????? ";
            test[i].setText(str += i);
        }
        for (int i = 0; i < booksCapacity; i++) {
            str = "???????????? ";
            str2 = "??????????????";
            testbook[i].fillBook(str += i, str2 += (i + 3), test);
        }

        for (int i = 0; i < pagesCapacity; i++) {
            str = "?????? ?????????????? ";
            test[i].setText(str += i);

        }

        for (int i = 0; i < journalsCapacity; i++) {
            str = "????????????????????";
            testjournal[i].fillJournal(str += (i + 1934), test);

        }
        for (int i = 0; i < newspapersCapacity; i++)
            testnewspaper[i].fillNewspaper(1980 + i, "times", "?????? ???????????? ");
        testlibrary.fillLibrary(testbook, testjournal, testnewspaper);
    }

    static public  library fillAll() {
        library testlibrary = new library();
        list[] test = new list[pagesCapacity];
        for (int i = 0; i < pagesCapacity; i++)
            test[i] = new list();
        book[] testbook = new book[booksCapacity];
        for (int i = 0; i < booksCapacity; i++)
            testbook[i] = new book();
        journal[] testjournal = new journal[journalsCapacity];
        for (int i = 0; i < journalsCapacity; i++)
            testjournal[i] = new journal();
        newspaper[] testnewspaper= new newspaper[newspapersCapacity];
        for (int i = 0; i < newspapersCapacity; i++)
            testnewspaper[i] = new newspaper();

        execution(testlibrary, testbook, testjournal, testnewspaper, test);
        return testlibrary;
    }

    public static void main(String[] args) {
        library newlib = fillAll();
        newlib.showAll();
        newlib.openBook("??????????????3", "???????????? 0", 5);
        newlib.openNewspaper("times", 1982);
        newlib.openJournal("??????????????????1924", 3);
        newspaper[] test = new newspaper[10];
        for (int i = 0; i < 10; i++) {
            test[i] = new newspaper("text" + i);
        }
        for (int i = 0 ; i < 10 ; i++)
            System.out.println(test[i].text + '\n');
    }





}
