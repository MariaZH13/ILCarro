package models;

public class Search {
    String city;
    String dates;

    public String getCity() {
        return city;
    }

    public String getDates() {
        return dates;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public Search withCity(String city) {
        this.city = city;
        return this;
    }

    public Search withDates(String dates) {
        this.dates = dates;
        return this;
    }
}
