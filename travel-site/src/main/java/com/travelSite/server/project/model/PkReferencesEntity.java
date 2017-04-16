package com.travelSite.server.project.model;

import javax.persistence.*;

@Entity
@Table(name = "pk_references", schema = "public", catalog = "sitedb")
public class PkReferencesEntity {
    private int referencesId;
    private PkObjectsEntity pkObjectsByObjectId;
    private PkAttributesEntity pkAttributesByAttributeId;
    private PkObjectsEntity pkObjectsByReferenceId;

    @Id
    @Column(name = "references_id", nullable = false)
    public int getReferencesId() {
        return referencesId;
    }

    public void setReferencesId(int referencesId) {
        this.referencesId = referencesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PkReferencesEntity that = (PkReferencesEntity) o;

        if (referencesId != that.referencesId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return referencesId;
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

    @ManyToOne
    @JoinColumn(name = "reference_id", referencedColumnName = "object_id", nullable = false)
    public PkObjectsEntity getPkObjectsByReferenceId() {
        return pkObjectsByReferenceId;
    }

    public void setPkObjectsByReferenceId(PkObjectsEntity pkObjectsByReferenceId) {
        this.pkObjectsByReferenceId = pkObjectsByReferenceId;
    }
}
