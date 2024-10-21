package org.application.wheels.models;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.*;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "locations")
public class Location {
    @Nonnull
    @Id
    private String locationId;

    @Nonnull
    private String locationName;

    @Nonnull
    private String userId;

    @Nullable
    @OneToMany(mappedBy = "locationId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Car> locationCars;
}
