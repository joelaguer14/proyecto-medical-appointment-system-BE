package cr.una.proyecto.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of DoctorType class
 */
public class DoctorType {
    @JsonProperty("_id")
    private Id id;
    @JsonProperty("tipo")
    private String type;
    @JsonProperty("salario")
    private String salary;
    @JsonProperty("moneda")
    private String coin;
    @JsonProperty("codigo-medico")
    private String medicalCode;

    /**
     * Default constructor
     */
    public DoctorType() {
    }

    /**
     * Constructor with parameters
     *
     * @param id, id code of the doctor type
     * @param type, type code of the doctor type
     * @param salary, salary code of the doctor type
     * @param coin, coin code of the doctor type
     * @param medicalCode, medical code of the doctor type
     */
    public DoctorType(Id id, String type, String salary, String coin, String medicalCode) {
        this.id = id;
        this.type = type;
        this.salary = salary;
        this.coin = coin;
        this.medicalCode = medicalCode;
    }

    /**
     * Returns id of the doctor type
     *
     * @return id
     */
    public Id getId() {
        return id;
    }

    /**
     * Returns type of the doctor type
     *
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Returns salary of the doctor type
     *
     * @return salary
     */
    public String getSalary() {
        return salary;
    }

    /**
     * Returns coin of the doctor type
     *
     * @return coin
     */
    public String getCoin() {
        return coin;
    }

    /**
     * Returns medical code of the doctor type
     *
     * @return medical code
     */
    public String getMedicalCode() {
        return medicalCode;
    }

    /**
     * Set id of the doctor type
     *
     * @param id, id of the doctor type
     */
    public void setId(Id id) {
        this.id = id;
    }

    /**
     * Set type of the doctor type
     *
     * @param type, type of the doctor type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Set salary of the doctor type
     *
     * @param salary, salary of the doctor type
     */
    public void setSalary(String salary) {
        this.salary = salary;
    }

    /**
     * Set coin of the doctor type
     *
     * @param coin, coin of the doctor type
     */
    public void setCoin(String coin) {
        this.coin = coin;
    }

    /**
     * Set medical code of the doctor type
     *
     * @param medicalCode, medical code of the doctor type
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
        return "DoctorType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", salary='" + salary + '\'' +
                ", coin='" + coin + '\'' +
                ", medicalCode='" + medicalCode + '\'' +
                '}';
    }
}