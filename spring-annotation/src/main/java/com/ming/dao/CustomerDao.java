package com.ming.dao;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {
    private String label = "1";

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "CustomerDao{" +
                "label='" + label + '\'' +
                '}';
    }
}
