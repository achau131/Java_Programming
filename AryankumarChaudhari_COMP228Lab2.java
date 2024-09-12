
//LAB 1
//Aryankumar Chaudhari
//301430998


import java.time.LocalDate;


public class AryankumarChaudhari_COMP228Lab2
{
    public static void main(String[] args)
    {
        //Creating the object
        Singers singer1 = new Singers();

        //Printing the Object with the help of ToString()
        System.out.println("Singer 1: " + singer1);

        //Setting Values to the Empty object
        singer1.set_id(34536);
        singer1.set_name("Manthan");
        singer1.set_address("69 Pinery trail");
        singer1.set_dateOfBirth(2004, 12, 4);
        singer1.set_albums(3);

        //Printing the object again
        System.out.println("Singer 1: " + singer1);
    }

}
    class Singers
    {
        //fields or Instance Variables
        private int _id;
        private String _name;
        private String _address;
        private LocalDate _dateOfBirth;
        private int _albums;

        //Getters
        public int get_albums()
        {
            return _albums;
        }
        public int get_id()
        {
            return _id;
        }
        public String get_address()
        {
            return _address;
        }
        public String get_name()
        {
            return _name;
        }
        public LocalDate get_dateOfBirth()
        {
            return _dateOfBirth;
        }



        //Setters
        public void set_id(int _id)
        {
            this._id = _id;
        }
        public void set_name(String _name)
        {
            this._name = _name;
        }
        public void set_address(String _address)
        {
            this._address = _address;
        }
        public void set_dateOfBirth(int year, int month, int day)
        {
            this._dateOfBirth = LocalDate.of(year, month, day);
        }
        public void set_albums(int _albums)
        {
            this._albums = _albums;
        }

        //Setter that allows to set values to all the fields
        public void setAllValues(int _id, String _name, String _address, LocalDate _dateOfBirth, int _albums)
        {
            this._id = _id;
            this._name = _name;
            this._address = _address;
            this._dateOfBirth = _dateOfBirth;
            this._albums = _albums;
        }


        //Constructors

        //with no arguments
        public Singers()
        {
            this._id = 0000;
            this._name = "Unknown";
            this._address = "Unknown";
            this._dateOfBirth = LocalDate.of(1111,1,11);
            this._albums = 00;
        }

        //With 1 argument
        public Singers(int id)
        {
            this._id = id;
            this._name = "Unknown";
            this._address = "Unknown";
            this._dateOfBirth = LocalDate.of(1111,0,11);
            this._albums = 00;
        }

        //with 2 arguments
        public Singers(int id, String name)
        {
            this._id = id;
            this._name = name;
            this._address = "Unknown";
            this._dateOfBirth = LocalDate.of(1111,0,11);
            this._albums = 00;
        }

        //With 3 arguments
        public Singers(int id, String name, String address)
        {
            this._id = id;
            this._name = name;
            this._address = address;
            this._dateOfBirth = LocalDate.of(0000,0,00);
            this._albums = 00;
        }

        //With 4 arguments
        public Singers(int id, String name, String address, LocalDate dateOfBirth)
        {
            this._id = id;
            this._name = name;
            this._address = address;
            this._dateOfBirth = dateOfBirth;
            this._albums = 00;
        }

        //With 5 arguments
        public Singers(int id, String name, String address, LocalDate dateOfBirth, int albums)
        {
            this._id = id;
            this._name = name;
            this._address = address;
            this._dateOfBirth = dateOfBirth;
            this._albums = albums;
        }

        //ToString()
        @Override //this is new for me (in C# we used to override string like (public override string ToString()))
        public String toString() {
            return "ID: " + _id +", Name: " + _name + ", Address: " + _address + ", Date Of Birth: " + _dateOfBirth + ", Albums: " + _albums;
        }
    }






