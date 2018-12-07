package pvt.finalproject.model;

import java.util.Arrays;

public class Email {
	private String id;
	private String subject;
	private String text;
	private String[] receivers;
	
	public static Builder newEntity() { 
		return new Email().new Builder();
	}

    public String getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }

    public String[] getReceivers() {
        return receivers;
    }

    @Override
    public String toString() {
        return "Email{" +
                "id='" + id + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                ", receivers=" + Arrays.toString(receivers) +
                '}';
    }

    public class Builder {
        private Builder() {
        }
        
        public Builder withId(String id) {
			Email.this.id = id;
        	return this; 
        }
        
        public Builder withSubject(String subject) {
			Email.this.subject = subject;
        	return this; 
        }
        
        public Builder withText(String text) {
			Email.this.text = text;
        	return this; 
        }
        
        public Builder withReceivers(String[] receivers) {
			Email.this.receivers = receivers;
        	return this;
        }
        
        public Email build() {
        	return Email.this;
        }
    }
}
