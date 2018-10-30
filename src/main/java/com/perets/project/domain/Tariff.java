package com.perets.project.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.StringJoiner;

public class Tariff {

    private Long id;
    private String descr;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Tariff tariff = (Tariff) o;

        return new EqualsBuilder()
                .append(id, tariff.id)
                .append(descr, tariff.descr)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(descr)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Tariff.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("descr='" + descr + "'")
                .toString();
    }
}
