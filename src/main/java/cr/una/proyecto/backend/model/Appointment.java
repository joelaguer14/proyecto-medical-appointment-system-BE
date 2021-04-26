package cr.una.proyecto.backend.model;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of Appointment class
 */
@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinTable(name = "appointment_patient", joinColumns = @JoinColumn(name = "id"))
    private Patient patient;
    @ManyToOne
    @JoinTable(name = "appointment_doctor_office", joinColumns = @JoinColumn(name = "id"))
    private DoctorOffice doctorOffice;
    @ManyToOne
    @JoinTable(name = "appointment_doctor", joinColumns = @JoinColumn(name = "id"))
    private Doctor doctor;
    @Column(name = "service")
    private String service;
    @Column(name = "date")
    private Date date;
    @Column(name = "confirmed")
    private boolean confirmed;
    @Column(name = "total_cost" )
    private float totalCost;


    /**
     * Default constructor
     */
    public Appointment() {
    }

    /**
     * Constructor with parameters
     *
     * @param patient, patient of the appointment
     * @param doctorOffice, doctorOffice of the appointment
     * @param date, date of the appointment
     * @param doctor, doctor of the appointment
     * @param service
     */
    public Appointment(Patient patient, DoctorOffice doctorOffice, Date date, Doctor doctor, String service) {
        this.patient = patient;
        this.doctorOffice = doctorOffice;
        this.date = date;
        confirmed = false;
        this.doctor = doctor;
        this.service=service;
    }

    /**
     * Returns id of the appointment
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Returns patient of the appointment
     *
     * @return patient
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Returns doctor office of the appointment
     *
     * @return doctor office
     */
    public DoctorOffice getDoctorOffice() {
        return doctorOffice;
    }

    /**
     * Returns doctor of the appointment
     *
     * @return doctor
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * Returns date of the appointment
     *
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Returns confirmed of the appointment
     *
     * @return confirmed
     */
    public boolean isConfirmed() {
        return confirmed;
    }

    /**
     * Returns service of the appointment
     *
     * @return service
     */
    public String getService() {
        return service;
    }

    /**
     * Returns total cost of the appointment
     *
     * @return totalCost
     */
    public float getTotalCost() {
        return totalCost;
    }

    /**
     * Set id of the appointment
     *
     * @param id, id of the appointment
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Set patient of the appointment
     *
     * @param patient, patient of the appointment
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * Set doctor office of the appointment
     *
     * @param doctorOffice, doctor office of the appointment
     */
    public void setDoctorOffice(DoctorOffice doctorOffice) {
        this.doctorOffice = doctorOffice;
    }

    /**
     * Set doctor of the appointment
     *
     * @param doctor, doctor of the appointment
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    /**
     * Set date of the appointment
     *
     * @param date, date of the appointment
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Set confirmed of the appointment
     *
     * @param confirmed, confirmed of the appointment
     */
    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    /**
     * Set service type of the appointment
     *
     * @param service, service type of the appointment
     */
    public void setService(String service) {
        this.service = service;
    }

    /**
     * Set total cost type of the appointment
     *
     * @param totalCost, total cost type of the appointment
     */
    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    /**
     * Show the attributes of the class
     *
     * @return a string
     */
    @Override
    public String toString() {
        return "Appointment{" +
                "patient=" + patient +
                ", doctorOffice=" + doctorOffice +
                ", date=" + date +
                ", confirmed=" + confirmed +
                '}';
    }
}