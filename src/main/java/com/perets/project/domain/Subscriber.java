package com.perets.project.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;
import java.util.StringJoiner;

public class Subscriber {

    private Long id;
    private String name;
    private Tariff tariff;
    private List<Payment> payments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Subscriber that = (Subscriber) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(name, that.name)
                .append(tariff, that.tariff)
                .append(payments, that.payments)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .append(tariff)
                .append(payments)
                .toHashCode();
    }

    @Override
    public String
    toString() {
        return new StringJoiner(", ", Subscriber.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("tariff=" + tariff)
                .add("payments=" + payments)
                .toString();
    }
}
