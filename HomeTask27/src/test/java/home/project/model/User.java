package home.project.model;

public class User {
    private int id;
    private String name;
    private String lastName;
    private String nickname;
    private String birthday;

    public static Builder newEntity() {
        return new User().new Builder();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public String getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "User:: " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }

    public class Builder {
        private Builder() {
        }

        public Builder withId(int id) {
            User.this.id = id;
            return this;
        }

        public Builder withName(String name) {
            User.this.name = name;
            return this;
        }

        public Builder withLastName(String lastName) {
            User.this.lastName = lastName;
            return this;
        }

        public Builder withNickname(String nickname) {
            User.this.nickname = nickname;
            return this;
        }

        public Builder withBirthday(String birthday) {
            User.this.birthday = birthday;
            return this;
        }

        public User build() {
            return User.this;
        }
    }
}
