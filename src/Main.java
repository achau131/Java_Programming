import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Singers singer1 = new Singers();
        Singers singer2 = new Singers(1234, "Saurav","micah chonaa" ,   69 );
        System.out.println(singer1);
        System.out.println(singer2);

        }
    }
    class Singers
    {
        public int Id;
        public int getId() {
            return Id;
        }
        public void setId(int id) {
            Id = id;
        }

        public String _name;
        public String get_name() {
            return _name;
        }
        public void set_name(String _name) {
            this._name = _name;
        }



        public String _address;
        public String get_address() {
            return _address;
        }
        public void set_address(String _address) {
            this._address = _address;
        }


        public Date _dateOfBirth;
        public Date get_dateOfBirth() {
            return _dateOfBirth;
        }

        public void set_dateOfBirth(Date _dateOfBirth) {
            this._dateOfBirth = _dateOfBirth;
        }


        public int _numvbersOfAlbums;
        public int get_numvbersOfAlbums() {
            return _numvbersOfAlbums;
        }
        public void set_numvbersOfAlbums(int _numvbersOfAlbums) {
            this._numvbersOfAlbums = _numvbersOfAlbums;
        }


        public Singers(int id, String name, String address, Date dateOfBirth, int numvbersOfAlbums)
        {
            this.Id = id;
            this._name = name;
            this._address = address;
            this._dateOfBirth = dateOfBirth;
            this._numvbersOfAlbums = numvbersOfAlbums;

        }
        public Singers( String name, String address, Date dateOfBirth, int numvbersOfAlbums)
        {

            this._name = name;
            this._address = address;
            this._dateOfBirth = dateOfBirth;
            this._numvbersOfAlbums = numvbersOfAlbums;

        }
        public Singers(int id,String name, String address,  int numvbersOfAlbums)
        {
            this.Id = id;
            this._name = name;
            this._address = address;
            this._numvbersOfAlbums = numvbersOfAlbums;

        }
        public Singers()
        {
            this.Id = 0000;
            this._address = "None";
            this._numvbersOfAlbums = 00;

        }
        public String toString() {

            return "Singers{" +
                    "id=" + Id +
                    ", name='" + _name + '\'' +
                    ", address='" + _address;
                    }

                    ;
        }





