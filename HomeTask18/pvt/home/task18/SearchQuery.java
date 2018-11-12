package pvt.home.task18;

public class SearchQuery {
	public String id;
	public String city;
	public String date;
	public int rating;

	public SearchQuery(String id, String city, String date, int rating) {
		this.id = id;
		this.city = city;
		this.date = date;
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "id: " + id + ", " + date;
	}
}
