package com.alqaraghuli.sharedpreferences;

public class Employee {
    String name;
    String jobTitle;
    String phone;

    public Employee() {
    }

    public Employee(String name, String jobTitle, String phone) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
