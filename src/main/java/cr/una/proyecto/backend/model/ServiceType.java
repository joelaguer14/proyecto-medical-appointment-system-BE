package cr.una.proyecto.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of ServiceType class
 */
public class ServiceType {
    @JsonProperty("_id")
    private Id id;
    @JsonProperty("servicio")
    private String service;
    @JsonProperty("costo-porcentual")
    private String percentageCost;
    @JsonProperty("codigo-medico")
    private String medicalCode;
    @JsonProperty("costo")
    private String cost;
    @JsonProperty("moneda")
    private String coin;

    /**
     * Default constructor
     */
    public ServiceType() {
    }

    /**
     * Constructor with parameters
     *
     * @param id, id of the service type
     * @param service, service of the service type
     * @param percentageCost, percentage cost of the service type
     * @param medicalCode, medical code of the service type
     * @param cost, cost of the service type
     * @param coin, coin of the service type
     */
    public ServiceType(Id id, String service, String percentageCost, String medicalCode, String cost, String coin) {
        this.id = id;
        this.service = service;
        this.percentageCost = percentageCost;
        this.medicalCode = medicalCode;
        this.cost = cost;
        this.coin = coin;
    }

    /**
     * Returns id of the service type
     *
     * @return id
     */
    public Id getId() {
        return id;
    }

    /**
     * Returns service of the service type
     *
     * @return service
     */
    public String getService() {
        return service;
    }

    /**
     * Returns percentage cost of the service type
     *
     * @return percentageCost
     */
    public String getPercentageCost() {
        return percentageCost;
    }

    /**
     * Returns medical code of the service type
     *
     * @return medical code
     */
    public String getMedicalCode() {
        return medicalCode;
    }

    /**
     * Returns cost of the service type
     *
     * @return cost
     */
    public String getCost() {
        return cost;
    }

    /**
     * Returns coin of the service type
     *
     * @return coin
     */
    public String getCoin() {
        return coin;
    }

    /**
     * Set id of the service type
     *
     * @param id, id of the service type
     */
    public void setId(Id id) {
        this.id = id;
    }

    /**
     * Set service of the service type
     *
     * @param service, service of the service type
     */
    public void setService(String service) {
        this.service = service;
    }

    /**
     * Set percentage cost of the service type
     *
     * @param percentageCost, percentage cost of the service type
     */
    public void setPercentageCost(String percentageCost) {
        this.percentageCost = percentageCost;
    }

    /**
     * Set medical code of the service type
     * @param medicalCode, medical code cost of the service type
     */
    public void setMedicalCode(String medicalCode) {
        this.medicalCode = medicalCode;
    }

    /**
     * Set cost of the service type
     *
     * @param cost, cost of the service type
     */
    public void setCost(String cost) {
        this.cost = cost;
    }

    /**
     * Set coin of the service type
     *
     * @param coin, coin of the service type
     */
    public void setCoin(String coin) {
        this.coin = coin;
    }

    /**
     * Show the attributes of the class
     *
     * @return a string
     */
    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", service='" + service + '\'' +
                ", percentageCost='" + percentageCost + '\'' +
                ", medicalCode='" + medicalCode + '\'' +
                ", cost='" + cost + '\'' +
                ", coin='" + coin + '\'' +
                '}';
    }
}
