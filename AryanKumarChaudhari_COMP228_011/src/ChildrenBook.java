public class ChildrenBook extends Book
{
    ChildrenBook(String title, String ISBN, String publisher, double price, int year)
    {
        super(title,ISBN,publisher,price,year);
        this._genre = "Children";
    }

    @Override
    public double setPrice()
    {
        return _price;
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
