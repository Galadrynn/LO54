/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Aloïs
 */

@Entity
public class Course_Session implements Serializable{
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="coursecode")
    private Course courseCode;
    
    @ManyToOne
    @JoinColumn(name="locationid")
    private Location locationId;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date startDate;
    
    @Column
    @Temporal(TemporalType.DATE)    
    private Date endDate;
    
    @OneToMany
    private List<Client> clients;
    
    public Course_Session() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Course getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(Course courseCode) {
        this.courseCode = courseCode;
    }

    public Location getLocationId() {
        return locationId;
    }

    public void setLocationId(Location locationId) {
        this.locationId = locationId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Course_Session{" + "id=" + id + ", courseCode=" + courseCode + ", locationId=" + locationId + ", startDate=" + startDate + ", endDate=" + endDate + '}';
    }
    
    
}
