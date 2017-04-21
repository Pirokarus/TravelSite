package com.travelSite.server.database.model;

import javax.persistence.*;

@Entity
@Table(name = "pk_attribute_binds", schema = "public", catalog = "sitedb")
public class PkAttributeBindsEntity {
    private int attributeBindsId;
    private String description;
    private PkAttributesEntity pkAttributes;
    private PkObjectTypesEntity pkObjectTypes;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attribute_binds_id", nullable = false)
    public int getAttributeBindsId() {
        return attributeBindsId;
    }

    public void setAttributeBindsId(int attributeBindsId) {
        this.attributeBindsId = attributeBindsId;
    }

    @Basic
    @Column(name = "description", nullable = true, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne
    @JoinColumn(name = "attribute_id", referencedColumnName = "attribute_id", nullable = false)
    public PkAttributesEntity getPkAttributes() {
        return pkAttributes;
    }

    public void setPkAttributes(PkAttributesEntity pkAttributes) {
        this.pkAttributes = pkAttributes;
    }

    @ManyToOne
    @JoinColumn(name = "object_type_id", referencedColumnName = "object_type_id", nullable = false)
    public PkObjectTypesEntity getPkObjectTypes() {
        return pkObjectTypes;
    }

    public void setPkObjectTypes(PkObjectTypesEntity pkObjectTypes) {
        this.pkObjectTypes = pkObjectTypes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PkAttributeBindsEntity that = (PkAttributeBindsEntity) o;

        if (attributeBindsId != that.attributeBindsId) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = attributeBindsId;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public PkAttributeBindsEntity() {
    }

    public PkAttributeBindsEntity(String description, PkAttributesEntity pkAttributes, PkObjectTypesEntity pkObjectTypes) {
        this.description = description;
        this.pkAttributes = pkAttributes;
        this.pkObjectTypes = pkObjectTypes;
    }

    public PkAttributeBindsEntity(PkObjectTypesEntity pkObjectTypes, PkAttributesEntity pkAttributes) {
        this.pkAttributes = pkAttributes;
        this.pkObjectTypes = pkObjectTypes;
    }
}
