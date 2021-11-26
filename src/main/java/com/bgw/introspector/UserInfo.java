package com.bgw.introspector;

public class UserInfo {

    private Long userId;
    private String userName;
    private Integer age;
    private String email;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public static UserInfoBuilder builder() {
        return new UserInfoBuilder();
    }


    public static class UserInfoBuilder {

        private final UserInfo userInfo;

        public UserInfoBuilder() {
            this.userInfo = new UserInfo();
        }

        public UserInfoBuilder userId(Long userId) {
            userInfo.setUserId(userId);
            return this;
        }
        public UserInfoBuilder userName(String userName) {
            userInfo.setUserName(userName);
            return this;
        }
        public UserInfoBuilder age(Integer age) {
            userInfo.setAge(age);
            return this;
        }

        public UserInfoBuilder email(String email) {
            userInfo.setEmail(email);
            return this;
        }

        public UserInfo build() {
            return userInfo;
        }
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
