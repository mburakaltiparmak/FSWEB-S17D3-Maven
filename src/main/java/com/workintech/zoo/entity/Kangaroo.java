package com.workintech.zoo.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Kangaroo {
    private Integer id;
    private String name;
    private double height;
    private double weight;
    private String gender;
    private boolean isAggressive;


    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getHeight() {
        return this.height;
    }

    public double getWeight() {
        return this.weight;
    }

    public String getGender() {
        return this.gender;
    }

    public boolean getIsAggressive() {
        return this.isAggressive;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setIsAggressive(boolean isAggressive) {
        this.isAggressive = isAggressive;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Kangaroo)) return false;
        final Kangaroo other = (Kangaroo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        if (Double.compare(this.getHeight(), other.getHeight()) != 0) return false;
        if (Double.compare(this.getWeight(), other.getWeight()) != 0) return false;
        final Object this$gender = this.getGender();
        final Object other$gender = other.getGender();
        if (this$gender == null ? other$gender != null : !this$gender.equals(other$gender)) return false;
        if (this.getIsAggressive() != other.getIsAggressive()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Kangaroo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final long $height = Double.doubleToLongBits(this.getHeight());
        result = result * PRIME + (int) ($height >>> 32 ^ $height);
        final long $weight = Double.doubleToLongBits(this.getWeight());
        result = result * PRIME + (int) ($weight >>> 32 ^ $weight);
        final Object $gender = this.getGender();
        result = result * PRIME + ($gender == null ? 43 : $gender.hashCode());
        result = result * PRIME + (this.getIsAggressive() ? 79 : 97);
        return result;
    }

    public String toString() {
        return "Kangaroo(id=" + this.getId() + ", name=" + this.getName() + ", height=" + this.getHeight() + ", weight=" + this.getWeight() + ", gender=" + this.getGender() + ", isAggressive=" + this.getIsAggressive() + ")";
    }
}
