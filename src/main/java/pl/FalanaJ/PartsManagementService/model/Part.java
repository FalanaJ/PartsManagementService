package pl.FalanaJ.PartsManagementService.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Part {

    @EmbeddedId
    private PartId Id;

    private int quantity;

    public Part() {
    }

    public Part(PartId Id, int quantity) {
        this.Id = Id;
        this.quantity = quantity;
    }

    public PartId getId() {
        return this.Id;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setId(PartId Id) {
        this.Id = Id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Part)) return false;
        final Part other = (Part) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$Id = this.getId();
        final Object other$Id = other.getId();
        if (this$Id == null ? other$Id != null : !this$Id.equals(other$Id)) return false;
        if (this.getQuantity() != other.getQuantity()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Part;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $Id = this.getId();
        result = result * PRIME + ($Id == null ? 43 : $Id.hashCode());
        result = result * PRIME + this.getQuantity();
        return result;
    }

    public String toString() {
        return "Part(Id=" + this.getId() + ", quantity=" + this.getQuantity() + ")";
    }
}
