package cr.una.proyecto.backend.model;

import javax.persistence.*;
import javax.persistence.Id;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of Doctor class
 */
@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "premium")
    private boolean premium;
    @Column(name = "medical_code")
    private String medicalCode;


    /**
     * Default constructor
     */
    public Doctor(){
    }

    /**
     * Constructor with parameters
     *
     * @param id, id of the doctor
     * @param name, name of the doctor
     * @param premium, premium of the doctor
     * @param doctorType, doctor type of the doctor
     */
    public Doctor(int id, String name, boolean premium, DoctorType doctorType, String medicalCode) {
        this.id = id;
        this.name = name;
        this.premium = premium;
        this.medicalCode = medicalCode;
    }

    /**
     * Returns id of the doctor
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Returns name of the doctor
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns premium of the doctor
     *
     * @return premium
     */
    public boolean getPremium() {
        return premium;
    }

    /**
     * Returns medical code of the doctor
     *
     * @return medicalCode
     */
    public String getMedicalCode() {
        return medicalCode;
    }

    /**
     * Set id of the doctor
     *
     * @param id, id of the doctor
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Set name of the doctor
     *
     * @param name, name of the doctor
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set premium of the doctor
     *
     * @param premium, premium of the doctor
     */
    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    /**
     * Set medical code of the doctor
     *
     * @param medicalCode, medical code of the doctor
     */
    public void setMedicalCode(String medicalCode) {
        this.medicalCode = medicalCode;
    }

    /**
     * Show the attributes of the class
     *
     * @return a string
     */
    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", premium=" + premium +
                ", medicalCode='" + medicalCode + '\'' +
                '}';
    }
}
