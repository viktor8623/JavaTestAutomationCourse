package pvt.home.task19.model;

public class SearchQuery {
	private String id;
	private String url;
	private String city;
	private String startDate;
	private int tripDuration;
	public String endDate;
	private int adults;
	private int children;
	private int rooms;
	private String lastName;
	private String email;
	private String address;
	private String homeCity;
	private String phone;
	private String ccType;
	private String ccNumber;
	private String expMonth;
	private String expYear;
	private String cvc;
	
	public static Builder newEntity() { 
		return new SearchQuery().new Builder();
	}

	public String getId() {
		return id;
	}

	public String getUrl() {
		return url;
	}
	
	public String getCity() {
		return city;
	}

	public String getStartDate() {
		return startDate;
	}

	public int getTripDuration() {
		return tripDuration;
	}
	
	public String getEndDate() {
		return endDate;
	}
	
	public int getAdults() {
		return adults;
	}

	public int getChildren() {
		return children;
	}

	public int getRooms() {
		return rooms;
	}
	
	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getHomeCity() {
		return homeCity;
	}
	
	public String getPhone() {
		return phone;
	}

	public String getCcType() {
		return ccType;
	}

	public String getCcNumber() {
		return ccNumber;
	}

	public String getExpMonth() {
		return expMonth;
	}

	public String getExpYear() {
		return expYear;
	}

	public String getCvc() {
		return cvc;
	}

	@Override
	public String toString() {
		return "id: " + id + ", " + startDate;
	}
	
	public class Builder {
        private Builder() {
        }
        
        public Builder withId(String id) {
        	SearchQuery.this.id = id;
        	return this; 
        }
        
        public Builder withUrl(String url) {
        	SearchQuery.this.url = url;
        	return this; 
        }
        
        public Builder withCity(String city) {
        	SearchQuery.this.city = city;
        	return this; 
        }
        
        public Builder withStartDate(String startDate) {
        	SearchQuery.this.startDate = startDate;
        	return this; 
        }
        
        public Builder withTripDuration(int tripDuration) {
        	SearchQuery.this.tripDuration = tripDuration;
        	return this; 
        }
        
        public Builder withEndDate(String endDate) {
        	SearchQuery.this.endDate = endDate;
        	return this;
		}
        
        public Builder withAdults(int adults) {
        	SearchQuery.this.adults = adults;
        	return this; 
        }
        
        public Builder withChildren(int children) {
        	SearchQuery.this.children = children;
        	return this; 
        }
        
        public Builder withRooms(int rooms) {
        	SearchQuery.this.rooms = rooms;
        	return this; 
        }
        
        public Builder withLastName(String lastName) {
        	SearchQuery.this.lastName = lastName;
        	return this; 
        }
        
        public Builder withEmail(String email) {
        	SearchQuery.this.email = email;
        	return this; 
        }
        
        public Builder withAddress(String address) {
        	SearchQuery.this.address = address;
        	return this; 
        }
        
        public Builder withHomeCity(String homeCity) {
        	SearchQuery.this.homeCity = homeCity;
        	return this; 
        }
        
        public Builder withPhone(String phone) {
        	SearchQuery.this.phone = phone;
        	return this; 
        }
        
        public Builder withCcType(String ccType) {
        	SearchQuery.this.ccType = ccType;
        	return this; 
        }
        
        public Builder withCcNumber(String ccNumber) {
        	SearchQuery.this.ccNumber = ccNumber;
        	return this; 
        }
        
        public Builder withExpMonth(String expMonth) {
        	SearchQuery.this.expMonth = expMonth;
        	return this; 
        }
        
        public Builder withExpYear(String expYear) {
        	SearchQuery.this.expYear = expYear;
        	return this; 
        }
        
        public Builder withCvc(String cvc) {
        	SearchQuery.this.cvc = cvc;
        	return this; 
        }
        
        public SearchQuery build() {
        	return SearchQuery.this;
        }
    }
}
