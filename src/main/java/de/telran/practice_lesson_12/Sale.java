package de.telran.practice_lesson_12;

import java.util.Objects;

public class Sale {
    private Integer idManager;
    private Integer sumSale;

    public Sale(Integer idManager, Integer sumSale) {
        this.idManager = idManager;
        this.sumSale = sumSale;
    }

    public Integer getIdManager() {
        return idManager;
    }

    public Integer getSumSale() {
        return sumSale;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "idManager=" + idManager +
                ", sumSale=" + sumSale +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return Objects.equals(idManager, sale.idManager) && Objects.equals(sumSale, sale.sumSale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idManager, sumSale);
    }
}
