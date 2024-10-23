package org.application.wheels.models;

import java.util.Map;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.*;
import jakarta.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "cars")
public class Car {
    @Nonnull
    @Id
    private int carId;

    @Nonnull
    private String model;

    @Nonnull
    private Map<String, String> properties;

    private int price;

    @Nullable
    private String description;

    @Nonnull
    private int sellerId;

    @Nullable
    private int locationId;

    @Override
    public String toString() {

        StringBuilder propertiesString = new StringBuilder();

        properties.forEach((key, value) ->
            propertiesString.append(key).append(": ").append(value).append(", ")
        );

        if (propertiesString.isEmpty()) {
            propertiesString.setLength(propertiesString.length() - 2);
        }

        return "Car(" +
                "carId='" + carId + '\'' +
                ", ownerId=" + sellerId +
                ", properties={" + propertiesString.toString() +
                "})";
    }
}
