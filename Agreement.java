package com.aiven.kafka.publisher;

import java.util.UUID;

public class Agreement {

    public UUID getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(UUID agreementId) {
        this.agreementId = agreementId;
    }

    public String getAgreementType() {
        return agreementType;
    }

    public void setAgreementType(String agreementType) {
        this.agreementType = agreementType;
    }

    public String getAgreementName() {
        return agreementName;
    }

    public void setAgreementName(String agreementName) {
        this.agreementName = agreementName;
    }

    public String getAgreementStatus() {
        return agreementStatus;
    }

    public void setAgreementStatus(String agreementStatus) {
        this.agreementStatus = agreementStatus;
    }

    public String getCounterPartyLongName() {
        return counterPartyLongName;
    }

    public void setCounterPartyLongName(String counterPartyLongName) {
        this.counterPartyLongName = counterPartyLongName;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    private UUID agreementId;

    private String agreementType;

    private String agreementName;

    private String agreementStatus;

    private String counterPartyLongName;

    private String created;
}
