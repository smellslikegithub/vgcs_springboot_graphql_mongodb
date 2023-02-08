package dev.vehicle.vehicle.main.model;


import lombok.Data;
import org.springframework.data.mongodb.core.index.TextIndexed;

@Data
public class Service {

    @TextIndexed
    private String serviceName;
    @TextIndexed
    private String status;

    @TextIndexed
    private String reason;


    @TextIndexed
    private String lastUpdate;

    public Service() {

    }

    public Service(String serviceName, String status, String lastUpdate) {
        this.serviceName = serviceName;
        this.status = status;
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Service{" +
                ", serviceName='" + serviceName + '\'' +
                ", status='" + status + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
