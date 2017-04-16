package com.travelSite.server.project.model;

import javax.persistence.*;

@Entity
@Table(name = "pk_object_types", schema = "public", catalog = "sitedb")
public class PkObjectTypesEntity {
    private int objectTypeId;
    private String name;
    private String discription;
    private PkObjectTypesEntity pkObjectTypesByParentTypeId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "object_type_id", nullable = false)
    public int getObjectTypeId() {
        return objectTypeId;
    }

    public void setObjectTypeId(int objectTypeId) {
        this.objectTypeId = objectTypeId;
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
    @Column(name = "discription", nullable = true, length = -1)
    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PkObjectTypesEntity that = (PkObjectTypesEntity) o;

        if (objectTypeId != that.objectTypeId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (discription != null ? !discription.equals(that.discription) : that.discription != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = objectTypeId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (discription != null ? discription.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "parent_type_id", referencedColumnName = "object_type_id")
    public PkObjectTypesEntity getPkObjectTypesByParentTypeId() {
        return pkObjectTypesByParentTypeId;
    }

    public void setPkObjectTypesByParentTypeId(PkObjectTypesEntity pkObjectTypesByParentTypeId) {
        this.pkObjectTypesByParentTypeId = pkObjectTypesByParentTypeId;
    }

    public PkObjectTypesEntity() {
    }

    public PkObjectTypesEntity(String name) {
        this.name = name;
    }
}
