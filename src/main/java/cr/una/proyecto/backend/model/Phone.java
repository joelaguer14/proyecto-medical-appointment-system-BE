package cr.una.proyecto.backend.model;

import javax.persistence.*;
import javax.persistence.Id;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of Phone class
 */
@Entity
@Table(name="phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "phone")
    private String phone;
    @Column(name = "phone_type")
    private String phoneType;

    /**
     * Default constructor
     */
    public Phone() {
    }

    /**
     * Constructor with parameters
     *
     * @param id, identity of the address
     * @param phone, phone
     * @param phoneType, phone type
     */
    public Phone(int id, String phone, String phoneType) {
        this.id = id;
        this.phone = phone;
        this.phoneType = phoneType;
    }

    /**
     * Returns id of the phone
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Returns phone
     *
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Returns phone type of the phone
     *
     * @return, phone type of the phone
     */
    public String getPhoneType() {
        return phoneType;
    }

    /**
     * Set id of the phone
     *
     * @param id, id of the phone
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Set phone
     *
     * @param phone, phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Set the phone type of the phone
     *
     * @param phoneType, phone type of the phone
     */
    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    /**
     * Show the attributes of the class
     *
     * @return a string
     */
    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                '}';
    }
}
