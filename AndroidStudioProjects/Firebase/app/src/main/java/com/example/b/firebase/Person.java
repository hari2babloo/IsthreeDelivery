package com.example.b.firebase;

/**
 * Created by b on 9/3/17.
 */

public class Person {
    public String getBname() {
        return bname;
    }

    public String getBmob() {
        return bmob;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBphno() {
        return bphno;
    }

    public void setBphno(String bphno) {
        this.bphno = bphno;
    }



    public String getBemail() {
        return bemail;
    }

    public void setBemail(String bemail) {
        this.bemail = bemail;
    }

    public String getBwebsite() {
        return bwebsite;
    }

    public void setBwebsite(String bwebsite) {
        this.bwebsite = bwebsite;
    }

    public String getBlat() {
        return blat;
    }

    public void setBlat(String blat) {
        this.blat = blat;
    }

    public String getBlong() {
        return blong;
    }

    public void setBlong(String blong) {
        this.blong = blong;
    }

    public String name;

    public String bname;
    public String bphno;
    public String bmob;

    public void setBmob(String bmob) {
        this.bmob = bmob;
    }

    public String bemail;
    public String bwebsite;
    public String blat;
    public String blong;
    public String brating;
    public String bdescription;
    public String Link1;
    public String Link2;

    public String getLink1() {
        return Link1;
    }

    public void setLink1(String link1) {
        Link1 = link1;
    }

    public String getLink2() {
        return Link2;
    }

    public void setLink2(String link2) {
        Link2 = link2;
    }

    public String getUfname() {
        return ufname;
    }

    public void setUfname(String ufname) {
        this.ufname = ufname;
    }

    public String getUlname() {
        return ulname;
    }

    public void setUlname(String ulname) {
        this.ulname = ulname;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUgender() {
        return ugender;
    }

    public void setUgender(String ugender) {
        this.ugender = ugender;
    }

    public String getUdob() {
        return udob;
    }

    public void setUdob(String udob) {
        this.udob = udob;
    }

    public String getUpic() {
        return upic;
    }

    public void setUpic(String upic) {
        this.upic = upic;
    }

    public String ufname;
    public String ulname;
    public String uemail;
    public String ugender;
    public String udob;
    public String upic;


    public String getBrating() {
        return brating;
    }

    public void setBrating(String brating) {
        this.brating = brating;
    }

    public String getBdescription() {
        return bdescription;
    }

    public void setBdescription(String bdescription) {
        this.bdescription = bdescription;
    }

    public Person(String name, String bname, String bphno, String bmob, String bemail, String bwebsite, String blat, String blong, String pas, String id, String title, String description, String image, String subname, String subimage) {
        this.name = name;
        this.bname = bname;
        this.bphno = bphno;
        this.bmob = bmob;
        this.bemail = bemail;
        this.bwebsite = bwebsite;
        this.blat = blat;
        this.blong = blong;

        this.pas = pas;
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.subname = subname;
        this.subimage = subimage;
    }

    public String pas;
    public String id;

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String title;
    public String description;
    public String image;
    public String subname;
    public String subimage;

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    public String getSubimage() {
        return subimage;
    }

    public void setSubimage(String subimage) {
        this.subimage = subimage;
    }

    public Person() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




    public String getPas() {
        return pas;
    }

    public void setPas(String pas) {
        this.pas = pas;
    }
}
