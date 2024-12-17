public class ScienceBook extends Book
{

    public double _discountedPrice;

    ScienceBook(String title, String ISBN, String publisher, double price, int year)
    {
        super(title,ISBN,publisher,price,year);
        this._genre = "Science";
    }

    @Override
    public double setPrice()
    {
        _discountedPrice = _price - (_price * 0.1);
        return _discountedPrice;
    }

    public String getGenre()
    {
        return _genre;
    }
    @Override
    public String ToString() {
        return "Title: "+ _title + ", ISBN: " + _ISBN + ", Publisher: "+
                _publisher+ ", Price: "+ setPrice() + ", Year: "+ _year +
                ", Genre: " + _genre;
    }
}
