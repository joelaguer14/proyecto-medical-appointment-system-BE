package cr.una.proyecto.backend.model;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of Patient class
 */
@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "fullName")
    private String fullName;
    @Column(name = "observation")
    private String observations;
    @Column(name = "birthDate")
    private Date birthDate;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name="patient_address",joinColumns = @JoinColumn( name = "id"))
    private List<Address> addresses;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name="patient_phone", joinColumns = @JoinColumn( name = "id"))
    private List<Phone> phones;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name="patient_disease",joinColumns = @JoinColumn( name = "id"))
    private List<Disease> diseases;

    /**
     * Default constructor
     */
    public Patient(){
    }

    public Patient(String fullName, String observations, Date birthDate) {
        this.fullName = fullName;
        this.observations = observations;
        this.birthDate = birthDate;
        diseases=new ArrayList<>();
        phones=new ArrayList<>();
        addresses= new ArrayList<>();
    }

    /**
     * Constructor with parameters
     *
     * @param id, identity of the patient
     * @param fullName, full name of the patient
     * @param observations, observations of the patient
     * @param birthDate, birth date of the patient
     * @param addresses, list of addresses of the patient
     * @param phones, list of phones of the patient
     * @param diseases, list of diseases of the patient
     */
    public Patient(int id, String fullName, String observations, Date birthDate, List<Address> addresses, List<Phone> phones, List<Disease> diseases) {
        this.id = id;
        this.fullName = fullName;
        this.observations = observations;
        this.birthDate = birthDate;
        this.addresses = addresses;
        this.phones = phones;
        this.diseases = diseases;
    }

    /**
     * Returns id of the patient
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Returns fullName of the patient
     *
     * @return fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Returns observations of the patient
     *
     * @return observations
     */
    public String getObservations() {
        return observations;
    }

    /**
     * Returns birth date of the patient
     *
     * @return birthDate
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Returns addresses of the patient
     *
     * @return addresses
     */
    public List<Address> getAddresses() {
        return addresses;
    }

    /**
     * Returns phones of the patient
     *
     * @return phones
     */
    public List<Phone> getPhones() {
        return phones;
    }

    /**
     * Returns diseases of the patient
     *
     * @return diseases
     */
    public List<Disease> getDiseases() {
        return diseases;
    }

    /**
     * Set id of the patient
     *
     * @param id, id of the patient
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Set full name of the patient
     *
     * @param fullName, full name of the patient
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Set observations of the patient
     *
     * @param observations, observations of the patient
     */
    public void setObservations(String observations) {
        this.observations = observations;
    }

    /**
     * Set birth date of the patient
     *
     * @param birthDate, birth date of the patient
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Set addresses of the patient
     *
     * @param addresses, addresses of the patient
     */
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    /**
     * Set phones of the patients
     *
     * @param phones, phones of the patient
     */
    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    /**
     * Set diseases of the patient
     *
     * @param diseases, diseases of the patient
     */
    public void setDiseases(List<Disease> diseases) {
        this.diseases = diseases;
    }

    /**
     * Show the attributes of the class
     *
     * @return a string
     */
    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", observations='" + observations + '\'' +
                ", birthDate=" + birthDate +
                ", addresses=" + addresses +
                ", phones=" + phones +
                ", diseases=" + diseases +
                '}';
    }
}