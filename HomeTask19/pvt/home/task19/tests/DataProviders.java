package pvt.home.task19.tests;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.testng.annotations.DataProvider;

import pvt.home.task19.model.SearchQuery;

public class DataProviders {

	@DataProvider(name = "query1")
	public static Object[][] searchQuery1() {
		return new Object[][] { 
			{ SearchQuery.newEntity()
				.withId("1").withUrl("https://www.booking.com").withCity("Paris")
				.withStartDate(getFutureDate(3)).withTripDuration(7).withEndDate(getFutureDate(3 + 7))
				.withAdults(2).withChildren(0).withRooms(1).build() },
		};
	}
	
	@DataProvider(name = "query2")
	public static Object[][] searchQuery2() {
		return new Object[][] { 
			{ SearchQuery.newEntity()
				.withId("1").withUrl("https://www.booking.com").withCity("Paris")
				.withStartDate(getFutureDate(3)).withTripDuration(7).withEndDate(getFutureDate(3 + 7))
				.withAdults(4).withChildren(0).withRooms(2).build() },
		};
	}
	
	@DataProvider(name = "order")
	public static Object[][] order() {
		return new Object[][] { 
			{ SearchQuery.newEntity()
				.withId("1").withUrl("https://www.booking.com").withCity("Paris")
				.withStartDate(getFutureDate(3)).withTripDuration(7).withEndDate(getFutureDate(3 + 7))
				.withAdults(4).withChildren(0).withRooms(2).withLastName("Smith")
				.withEmail("smith46651516@gmail.com").withAddress("St. XXXXX")
				.withHomeCity("Minsk").withPhone("3757823654").withCcType("Visa")
				.withCcNumber("4242424242424242").withExpMonth("10").withExpYear("2019")
				.withCvc("303").build() },
		};
	}
	
	private static String getFutureDate(int delta) {
		return LocalDate.from(new Date().toInstant().atZone(ZoneId.of("Europe/Moscow"))).plusDays(delta).toString();
	}
}
