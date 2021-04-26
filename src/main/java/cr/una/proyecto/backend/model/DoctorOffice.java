package cr.una.proyecto.backend.model;

import javax.persistence.Id;
import javax.persistence.*;
import java.util.List;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of DoctorOffice class
 */
@Entity
@Table(name = "doctor_office")
public class DoctorOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "days")
    private String days;
    @Column(name = "hour")
    private String hour;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "doctor_office_address", joinColumns = @JoinColumn( name = "id"))
    private List<Address> addresses;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name="doctor_office_phone", joinColumns = @JoinColumn( name = "id"))
    private List<Phone> phones;

    /**
     * Default constructor
     */
    public DoctorOffice() {

    }

    /**
     * Constructor with parameters
     *
     * @param id, identity of the doctor office
     * @param name, name of the doctor office
     * @param days, doctor office operating days
     * @param hour, doctor office operating hours
     * @param addresses, list of addresses of the doctor office
     * @param phones, list of phones of the doctor office
     */
    public DoctorOffice(int id, String name, String days, String hour, List<Address> addresses, List<Phone> phones) {
        this.id = id;
        this.name = name;
        this.days = days;
        this.hour = hour;
        this.addresses = addresses;
        this.phones = phones;
    }

    /**
     * Returns id of the doctor offices
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Returns name of the doctor office
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns days of the doctor office
     *
     * @return days
     */
    public String getDays() {
        return days;
    }

    /**
     * Returns hours of the doctor office
     *
     * @return hour
     */
    public String getHour() {
        return hour;
    }

    /**
     * Returns addresses of the doctor office
     *
     * @return addresses
     */
    public List<Address> getAddresses() {
        return addresses;
    }

    /**
     * Returns phones of the doctor office
     *
     * @return phones
     */
    public List<Phone> getPhones() {
        return phones;
    }

    /**
     * Set id of the doctor office
     *
     * @param id, id of the doctor office
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Set name of the doctor office
     *
     * @param name, name of the doctor office
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set days of the doctor office
     *
     * @param days, days of the doctor office
     */
    public void setDays(String days) {
        this.days = days;
    }

    /**
     * Set hours of the doctor office
     *
     * @param hour, hours of the doctor office
     */
    public void setHour(String hour) {
        this.hour = hour;
    }

    /**
     * Set addresses of the doctor office
     *
     * @param addresses, addresses of the doctor office
     */
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    /**
     * Set phones of the doctor office
     *
     * @param phones, phones of the doctor office
     */
    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    /**
     * Show the attributes of the class
     *
     * @return a string
     */
    @Override
    public String toString() {
        return "DoctorOffice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", days='" + days + '\'' +
                ", hour='" + hour + '\'' +
                ", addresses=" + addresses +
                ", phones=" + phones +
                '}';
    }
}
