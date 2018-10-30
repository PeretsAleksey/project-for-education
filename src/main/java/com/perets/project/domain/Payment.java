package com.perets.project.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.StringJoiner;

public class Payment {

    private Long id;
    private Integer summa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSumma() {
        return summa;
    }

    public void setSumma(Integer summa) {
        this.summa = summa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        return new EqualsBuilder()
                .append(id, payment.id)
                .append(summa, payment.summa)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(summa)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Payment.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("summa=" + summa)
                .toString();
    }
}
