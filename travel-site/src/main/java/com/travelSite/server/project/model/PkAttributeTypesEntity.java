package com.travelSite.server.project.model;

import javax.persistence.*;

@Entity
@Table(name = "pk_attribute_types", schema = "public", catalog = "sitedb")
public class PkAttributeTypesEntity {
    private int attributeTypeId;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attribute_type_id", nullable = false)
    public int getAttributeTypeId() {
        return attributeTypeId;
    }

    public void setAttributeTypeId(int attributeTypeId) {
        this.attributeTypeId = attributeTypeId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PkAttributeTypesEntity that = (PkAttributeTypesEntity) o;

        if (attributeTypeId != that.attributeTypeId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = attributeTypeId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public PkAttributeTypesEntity(String name) {
        this.name = name;
    }

    public PkAttributeTypesEntity() {
    }
}
