/*
* The definition of the table
* in the table, the primary key is auto generated
* and each field is corresponded to a column of the table
* */
package com.example.recycling.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Data {
    /*
    * define the primary key of the table
    * */
    @PrimaryKey(autoGenerate = true)
    public int id;

    /*
    * define the column of the table
    * */
    public String area;
    public long jan;
    public long feb;
    public long mar;
    public long apr;
    public long may;
    public long jun;
    public long jul;
    public long aug;
    public long sep;
    public long oct;
    public long nov;
    public long dec;

    /*
    * define the getter and setter method for the table
    * */
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public long getJan() {
        return jan;
    }

    public void setJan(long jan) {
        this.jan = jan;
    }

    public long getFeb() {
        return feb;
    }

    public void setFeb(long feb) {
        this.feb = feb;
    }

    public long getMar() {
        return mar;
    }

    public void setMar(long mar) {
        this.mar = mar;
    }

    public long getApr() {
        return apr;
    }

    public void setApr(long apr) {
        this.apr = apr;
    }

    public long getMay() {
        return may;
    }

    public void setMay(long may) {
        this.may = may;
    }

    public long getJun() {
        return jun;
    }

    public void setJun(long jun) {
        this.jun = jun;
    }

    public long getJul() {
        return jul;
    }

    public void setJul(long jul) {
        this.jul = jul;
    }

    public long getAug() {
        return aug;
    }

    public void setAug(long aug) {
        this.aug = aug;
    }

    public long getSep() {
        return sep;
    }

    public void setSep(long sep) {
        this.sep = sep;
    }

    public long getOct() {
        return oct;
    }

    public void setOct(long oct) {
        this.oct = oct;
    }

    public long getNov() {
        return nov;
    }

    public void setNov(long nov) {
        this.nov = nov;
    }

    public long getDec() {
        return dec;
    }

    public void setDec(long dec) {
        this.dec = dec;
    }
}
