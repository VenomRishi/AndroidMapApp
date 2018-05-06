package com.example.acer.googlemap2;

public class Register {
    String regId,fname,lname,dob,gen,mobile,altmobile,email,bg,password;
    public Register()
    {

    }
    public Register(String regId,String fname,String lname,String dob,String gen,String mobile,String altmobile,String email,String bg,String password)
    {
        this.regId=regId;
        this.fname=fname;
        this.lname=lname;
        this.dob=dob;
        this.gen=gen;
        this.mobile=mobile;
        this.altmobile=altmobile;
        this.email=email;
        this.bg=bg;
        this.password=password;

    }

    public String getRegId() {
        return regId;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getDob() {
        return dob;
    }

    public String getGen() {
        return gen;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAltmobile() {
        return altmobile;
    }

    public String getEmail() {
        return email;
    }

    public String getBg() {
        return bg;
    }

    public String getPassword() {
        return password;
    }
}

