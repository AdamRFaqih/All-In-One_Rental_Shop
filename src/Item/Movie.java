package Item;

public class Movie extends Item{
    private String title;
    private String genre;
    private int releaseYear;
    private String director;
    private String condition;

    public Movie() {
    }

    public Movie(int itemID, String name, String description, double rentalChargePerDay, boolean availbility) {
        super(itemID, name, description, rentalChargePerDay, availbility);
    }

    public Movie(String title, String genre, int releaseYear, String director, String condition) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.director = director;
        this.condition = condition;
    }

    public Movie(int itemID, String name, String description, double rentalChargePerDay, boolean availbility, String title, String genre, int releaseYear, String director, String condition) {
        super(itemID, name, description, rentalChargePerDay, availbility);
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.director = director;
        this.condition = condition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
