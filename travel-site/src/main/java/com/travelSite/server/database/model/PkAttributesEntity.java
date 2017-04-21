package com.travelSite.server.database.model;

import javax.persistence.*;

@Entity
@Table(name = "pk_attributes", schema = "public", catalog = "sitedb")
public class PkAttributesEntity {
    private int attributeId;
    private String name;
    private String details;
    private Integer ismutible;
    private PkAttributeTypesEntity pkAttributeTypesByAttributeTypeId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attribute_id", nullable = false)
    public int getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(int attributeId) {
        this.attributeId = attributeId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "details", nullable = true, length = -1)
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Basic
    @Column(name = "ismutible", nullable = true)
    public Integer getIsmutible() {
        return ismutible;
    }

    public void setIsmutible(Integer ismutible) {
        this.ismutible = ismutible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PkAttributesEntity that = (PkAttributesEntity) o;

        if (attributeId != that.attributeId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (details != null ? !details.equals(that.details) : that.details != null) return false;
        if (ismutible != null ? !ismutible.equals(that.ismutible) : that.ismutible != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = attributeId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (details != null ? details.hashCode() : 0);
        result = 31 * result + (ismutible != null ? ismutible.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "attribute_type_id", referencedColumnName = "attribute_type_id", nullable = false)
    public PkAttributeTypesEntity getPkAttributeTypesByAttributeTypeId() {
        return pkAttributeTypesByAttributeTypeId;
    }

    public void setPkAttributeTypesByAttributeTypeId(PkAttributeTypesEntity pkAttributeTypesByAttributeTypeId) {
        this.pkAttributeTypesByAttributeTypeId = pkAttributeTypesByAttributeTypeId;
    }

    public PkAttributesEntity() {
    }

    public PkAttributesEntity(String name, PkAttributeTypesEntity pkAttributeTypesByAttributeTypeId) {
        this.name = name;
        this.pkAttributeTypesByAttributeTypeId = pkAttributeTypesByAttributeTypeId;
    }
}
