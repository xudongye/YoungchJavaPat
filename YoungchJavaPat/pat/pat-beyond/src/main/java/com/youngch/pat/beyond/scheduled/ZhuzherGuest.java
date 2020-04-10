package com.youngch.pat.beyond.scheduled;

public class ZhuzherGuest {
    private String customer_id;
    private String member_id;
    private String name;
    private String gender;
    private String id_card_type;
    private String id_card_no;
    private String birth_date;
    private String tel;
    private String email;

    @Override
    public String toString() {
        return "ZhuzherGuest{" +
                "customer_id='" + customer_id + '\'' +
                ", member_id='" + member_id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", id_card_type='" + id_card_type + '\'' +
                ", id_card_no='" + id_card_no + '\'' +
                ", birth_date='" + birth_date + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId_card_type() {
        return id_card_type;
    }

    public void setId_card_type(String id_card_type) {
        this.id_card_type = id_card_type;
    }

    public String getId_card_no() {
        return id_card_no;
    }

    public void setId_card_no(String id_card_no) {
        this.id_card_no = id_card_no;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
