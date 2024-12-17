abstract class Book
{
    String _title;
    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }
    String _ISBN;

    public String get_ISBN() {
        return _ISBN;
    }

    public void set_ISBN(String _ISBN) {
        this._ISBN = _ISBN;
    }

    String _publisher;

    public String get_publisher() {
        return _publisher;
    }

    public void set_publisher(String _publisher) {
        this._publisher = _publisher;
    }

    public double _price;

    public double get_price() {
        return _price;
    }

    public void set_price(double _price) {
        this._price = _price;
    }

    int _year;

    public int get_year() {
        return _year;
    }

    public void set_year(int _year) {
        this._year = _year;
    }
    public String _genre;

    public String get_genre() {
        return _genre;
    }

    public void set_genre(String _genre) {
        this._genre = _genre;
    }

    public Book(String title, String ISBN, String publisher, double price, int year)
    {
        this._title = title;
        this._ISBN = ISBN;
        this._publisher = publisher;
        this._price = price;
        this._year = year;
    }

    public abstract double setPrice();
    public abstract String getGenre();

    public String ToString()
    {
        return "Title: "+ _title + ", ISBN: " + _ISBN + ", Publisher: "+
                _publisher+ ", Price: "+ _price+ ", Year: "+ _year;
    }

}