package ru.task.domain;

public class CD {
    private String title;
    private String artist;
    private String country;
    private String company;
    private String price;
    private String year;


    public CD(String title, String artist, String country, String company, String price, String year) {
        this.title = title;
        this.artist = artist;
        this.country = country;
        this.company = company;
        this.price = price;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CD cd = (CD) o;

        if (artist != null ? !artist.equals(cd.artist) : cd.artist != null) return false;
        if (company != null ? !company.equals(cd.company) : cd.company != null) return false;
        if (country != null ? !country.equals(cd.country) : cd.country != null) return false;
        if (price != null ? !price.equals(cd.price) : cd.price != null) return false;
        if (title != null ? !title.equals(cd.title) : cd.title != null) return false;
        if (year != null ? !year.equals(cd.year) : cd.year != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (artist != null ? artist.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("CD");
        sb.append("{title='").append(title).append('\'');
        sb.append(", artist='").append(artist).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", company='").append(company).append('\'');
        sb.append(", price='").append(price).append('\'');
        sb.append(", year='").append(year).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
