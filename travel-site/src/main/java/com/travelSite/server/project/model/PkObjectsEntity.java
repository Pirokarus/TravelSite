package com.travelSite.server.project.model;

import javax.persistence.*;

@Entity
@Table(name = "pk_objects", schema = "public", catalog = "sitedb")
public class PkObjectsEntity {
    private int objectId;
    private String name;
    private String discription;
    private PkObjectTypesEntity pkObjectTypesByObjectTypeId;
    private PkObjectsEntity pkObjectsByContainerId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "object_id", nullable = false)
    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
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

        PkObjectsEntity that = (PkObjectsEntity) o;

        if (objectId != that.objectId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (discription != null ? !discription.equals(that.discription) : that.discription != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = objectId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (discription != null ? discription.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "object_type_id", referencedColumnName = "object_type_id", nullable = false)
    public PkObjectTypesEntity getPkObjectTypesByObjectTypeId() {
        return pkObjectTypesByObjectTypeId;
    }

    public void setPkObjectTypesByObjectTypeId(PkObjectTypesEntity pkObjectTypesByObjectTypeId) {
        this.pkObjectTypesByObjectTypeId = pkObjectTypesByObjectTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "container_id", referencedColumnName = "object_id")
    public PkObjectsEntity getPkObjectsByContainerId() {
        return pkObjectsByContainerId;
    }

    public void setPkObjectsByContainerId(PkObjectsEntity pkObjectsByContainerId) {
        this.pkObjectsByContainerId = pkObjectsByContainerId;
    }

    public PkObjectsEntity() {
    }

    public PkObjectsEntity(String name, PkObjectTypesEntity pkObjectTypesByObjectTypeId) {
        this.name = name;
        this.pkObjectTypesByObjectTypeId = pkObjectTypesByObjectTypeId;
    }
}
