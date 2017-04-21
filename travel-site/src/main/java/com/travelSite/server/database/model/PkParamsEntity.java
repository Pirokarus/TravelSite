package com.travelSite.server.database.model;

import javax.persistence.*;

@Entity
@Table(name = "pk_params", schema = "public", catalog = "sitedb")
public class PkParamsEntity {
    private int paramsId;
    private String textValue;
    private Double numberValue;
    private PkObjectsEntity pkObjectsByObjectId;
    private PkAttributesEntity pkAttributesByAttributeId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "params_id", nullable = false)
    public int getParamsId() {
        return paramsId;
    }

    public void setParamsId(int paramsId) {
        this.paramsId = paramsId;
    }

    @Basic
    @Column(name = "text_value", nullable = true, length = -1)
    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    @Basic
    @Column(name = "number_value", nullable = true)
    public Double getNumberValue() {
        return numberValue;
    }

    public void setNumberValue(Double numberValue) {
        this.numberValue = numberValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PkParamsEntity that = (PkParamsEntity) o;

        if (paramsId != that.paramsId) return false;
        if (textValue != null ? !textValue.equals(that.textValue) : that.textValue != null) return false;
        if (numberValue != null ? !numberValue.equals(that.numberValue) : that.numberValue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = paramsId;
        result = 31 * result + (textValue != null ? textValue.hashCode() : 0);
        result = 31 * result + (numberValue != null ? numberValue.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "object_id", referencedColumnName = "object_id", nullable = false)
    public PkObjectsEntity getPkObjectsByObjectId() {
        return pkObjectsByObjectId;
    }

    public void setPkObjectsByObjectId(PkObjectsEntity pkObjectsByObjectId) {
        this.pkObjectsByObjectId = pkObjectsByObjectId;
    }

    @ManyToOne
    @JoinColumn(name = "attribute_id", referencedColumnName = "attribute_id", nullable = false)
    public PkAttributesEntity getPkAttributesByAttributeId() {
        return pkAttributesByAttributeId;
    }

    public void setPkAttributesByAttributeId(PkAttributesEntity pkAttributesByAttributeId) {
        this.pkAttributesByAttributeId = pkAttributesByAttributeId;
    }

    public PkParamsEntity() {
    }

    public PkParamsEntity(String textValue, PkObjectsEntity pkObjectsByObjectId, PkAttributesEntity pkAttributesByAttributeId) {
        this.textValue = textValue;
        this.pkObjectsByObjectId = pkObjectsByObjectId;
        this.pkAttributesByAttributeId = pkAttributesByAttributeId;
    }

    public PkParamsEntity(Double numberValue, PkObjectsEntity pkObjectsByObjectId, PkAttributesEntity pkAttributesByAttributeId) {
        this.numberValue = numberValue;
        this.pkObjectsByObjectId = pkObjectsByObjectId;
        this.pkAttributesByAttributeId = pkAttributesByAttributeId;
    }
}
