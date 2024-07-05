package de.telran.lesson_07_03;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Join {
    private City city;
    private Country country;

    @Override
    public String toString() {
        return "Join{" +
                "cityID=" + city.getId() + '\'' +
                "cityName=" + city.getName() + '\'' +
                ", cityPopulation=" + city.getPopulation() + '\'' +
                ", cityCode=" + city.getCountryCode() + '\'' +
                ", countryName=" + country.getName() + '\'' +
                ", continent=" + country.getContinent() +
                '}';
    }
}
