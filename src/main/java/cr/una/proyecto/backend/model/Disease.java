package cr.una.proyecto.backend.model;

import javax.persistence.*;
import javax.persistence.Id;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of Disease class
 */
@Entity
@Table(name = "disease")
public class Disease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "disease")
    private String disease;

    /**
     * Default constructor
     */
    public Disease(){
    }

    /**
     * Constructor with parameters
     *
     * @param id, identity of the disease
     * @param disease, disease
     */
    public Disease(int id, String disease) {
        this.id = id;
        this.disease = disease;
    }

    /**
     * Set id of the disease
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *  Set disease
     *
     * @param disease, disease
     */
    public void setDisease(String disease) {
        this.disease = disease;
    }

    /**
     * Returns id of the disease
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the disease
     *
     * @return disease
     */
    public String getDisease() {
        return disease;
    }

    /**
     * Show the attributes of the class
     *
     * @return a string
     */
    @Override
    public String toString() {
        return "Disease{" +
                "id=" + id +
                ", disease='" + disease + '\'' +
                '}';
    }
}
