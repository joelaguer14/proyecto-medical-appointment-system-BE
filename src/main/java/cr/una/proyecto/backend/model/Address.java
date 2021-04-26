package cr.una.proyecto.backend.model;

import javax.persistence.*;
import javax.persistence.Id;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of Address class
 */
@Entity
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "address")
    private String address;
    @Column(name = "type")
    private String type;

    /**
     * Default constructor
     */
    public Address() {
    }

    /**
     * Constructor with parameters
     *
     * @param id, identity of the address
     * @param address, address
     * @param type, address type
     */
    public Address(int id, String address, String type) {
        this.id = id;
        this.address = address;
        this.type = type;
    }

    /**
     * Set id of the address
     *
     * @param id, id of the address
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Set address
     *
     * @param address, address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Set type of the address
     *
     * @param type, type of the address
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns id of the address
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Returns address
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Returns type of the address
     *
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Show the attributes of the class
     *
     * @return a string
     */
    @Override
    public String toString() {
        return "PatientAddress{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
