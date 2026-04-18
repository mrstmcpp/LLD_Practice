package org.mrstm.models;

import org.mrstm.enums.StaffRole;

public abstract class Staff {
    private String name;
    private int staffId;

    public Staff(String name , int staffId){
        this.name = name;
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }
}
