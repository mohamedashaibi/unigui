/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "instructor", catalog = "university", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instructor.findAll", query = "SELECT i FROM Instructor i")
    , @NamedQuery(name = "Instructor.findById", query = "SELECT i FROM Instructor i WHERE i.id = :id")
    , @NamedQuery(name = "Instructor.findByFname", query = "SELECT i FROM Instructor i WHERE i.fname = :fname")
    , @NamedQuery(name = "Instructor.findByMname", query = "SELECT i FROM Instructor i WHERE i.mname = :mname")
    , @NamedQuery(name = "Instructor.findByLname", query = "SELECT i FROM Instructor i WHERE i.lname = :lname")
    , @NamedQuery(name = "Instructor.findByDob", query = "SELECT i FROM Instructor i WHERE i.dob = :dob")
    , @NamedQuery(name = "Instructor.findByStartingDate", query = "SELECT i FROM Instructor i WHERE i.startingDate = :startingDate")
    , @NamedQuery(name = "Instructor.findByDegree", query = "SELECT i FROM Instructor i WHERE i.degree = :degree")
    , @NamedQuery(name = "Instructor.findBySocialnumber", query = "SELECT i FROM Instructor i WHERE i.socialnumber = :socialnumber")
    , @NamedQuery(name = "Instructor.findByAccountNumber", query = "SELECT i FROM Instructor i WHERE i.accountNumber = :accountNumber")
    , @NamedQuery(name = "Instructor.findByBankName", query = "SELECT i FROM Instructor i WHERE i.bankName = :bankName")
    , @NamedQuery(name = "Instructor.findByNationality", query = "SELECT i FROM Instructor i WHERE i.nationality = :nationality")
    , @NamedQuery(name = "Instructor.findByMedicalstate", query = "SELECT i FROM Instructor i WHERE i.medicalstate = :medicalstate")})
public class Instructor implements Serializable {

    @Basic(optional = false)
    @Column(name = "starting_date")
    private String startingDate;

    @Basic(optional = false)
    @Column(name = "dob")
    private String dob;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fname")
    private String fname;
    @Basic(optional = false)
    @Column(name = "mname")
    private String mname;
    @Basic(optional = false)
    @Column(name = "lname")
    private String lname;
    @Basic(optional = false)
    @Column(name = "degree")
    private String degree;
    @Basic(optional = false)
    @Column(name = "socialnumber")
    private int socialnumber;
    @Basic(optional = false)
    @Column(name = "account_number")
    private String accountNumber;
    @Basic(optional = false)
    @Column(name = "bank_name")
    private String bankName;
    @Basic(optional = false)
    @Column(name = "nationality")
    private int nationality;
    @Column(name = "medicalstate")
    private String medicalstate;
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Department departmentId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructorId")
    private List<Course> courseList;
    @OneToOne(mappedBy = "instructorId")
    private Department department;

    public Instructor() {
    }

    public Instructor(Integer id) {
        this.id = id;
    }

    public Instructor(Integer id, String fname, String mname, String lname, String dob, String startingDate, String degree, int socialnumber, String accountNumber, String bankName, int nationality) {
        this.id = id;
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.dob = dob;
        this.startingDate = startingDate;
        this.degree = degree;
        this.socialnumber = socialnumber;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.nationality = nationality;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }


    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getSocialnumber() {
        return socialnumber;
    }

    public void setSocialnumber(int socialnumber) {
        this.socialnumber = socialnumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getNationality() {
        return nationality;
    }

    public void setNationality(int nationality) {
        this.nationality = nationality;
    }

    public String getMedicalstate() {
        return medicalstate;
    }

    public void setMedicalstate(String medicalstate) {
        this.medicalstate = medicalstate;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
    }

    @XmlTransient
    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instructor)) {
            return false;
        }
        Instructor other = (Instructor) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    public String getName(){
        return this.getFname() + " " + this.getMname() + " " + this.getLname();
    }
    
    @Override
    public String toString() {
        return this.getId() + ". " + this.getFname() + " " + 
                this.getMname() + " " + this.getLname();
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
