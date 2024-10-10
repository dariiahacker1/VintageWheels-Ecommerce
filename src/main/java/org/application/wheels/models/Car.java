package org.application.wheels.models;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Setter;
import lombok.Getter;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "cars")
public class Car {
    @Nonnull
    @Id
    private String carId;

    @Nonnull
    private String model;

    private int price;

    @Nullable
    private String description;

    @Nonnull
    private String sellerId;

    @Nullable
    private String locationId;
}
