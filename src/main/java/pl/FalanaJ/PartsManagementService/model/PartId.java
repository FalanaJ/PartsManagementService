package pl.FalanaJ.PartsManagementService.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PartId implements Serializable {
    private String materialNumber;
    private String serialNumber;
    private String supplierNumber;

    public PartId(String materialNumber, String serialNumber, String supplierNumber) {
        this.materialNumber = materialNumber;
        this.serialNumber = serialNumber;
        this.supplierNumber = supplierNumber;
    }

    public PartId() {
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PartId;
    }

    public String getMaterialNumber() {
        return this.materialNumber;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public String getSupplierNumber() {
        return this.supplierNumber;
    }

    public void setMaterialNumber(String materialNumber) {
        this.materialNumber = materialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setSupplierNumber(String supplierNumber) {
        this.supplierNumber = supplierNumber;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PartId)) return false;
        final PartId other = (PartId) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$materialNumber = this.getMaterialNumber();
        final Object other$materialNumber = other.getMaterialNumber();
        if (this$materialNumber == null ? other$materialNumber != null : !this$materialNumber.equals(other$materialNumber))
            return false;
        final Object this$serialNumber = this.getSerialNumber();
        final Object other$serialNumber = other.getSerialNumber();
        if (this$serialNumber == null ? other$serialNumber != null : !this$serialNumber.equals(other$serialNumber))
            return false;
        final Object this$supplierNumber = this.getSupplierNumber();
        final Object other$supplierNumber = other.getSupplierNumber();
        if (this$supplierNumber == null ? other$supplierNumber != null : !this$supplierNumber.equals(other$supplierNumber))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $materialNumber = this.getMaterialNumber();
        result = result * PRIME + ($materialNumber == null ? 43 : $materialNumber.hashCode());
        final Object $serialNumber = this.getSerialNumber();
        result = result * PRIME + ($serialNumber == null ? 43 : $serialNumber.hashCode());
        final Object $supplierNumber = this.getSupplierNumber();
        result = result * PRIME + ($supplierNumber == null ? 43 : $supplierNumber.hashCode());
        return result;
    }

    public String toString() {
        return "PartId(materialNumber=" + this.getMaterialNumber() + ", serialNumber=" + this.getSerialNumber() + ", supplierNumber=" + this.getSupplierNumber() + ")";
    }
}
