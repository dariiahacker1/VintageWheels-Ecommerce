package org.application.wheels.models;

import java.util.List;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.*;
import jakarta.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Table(name= "users")
public class User {
    @Nonnull
    @Id
    private final String login;

    @Nonnull
    private final String password;

    @Nonnull
    private String userName;

    @Nullable
    @OneToMany(mappedBy = "sellerId", cascade= CascadeType.ALL, orphanRemoval = true)
    private List<Car> userCars;

    @Nullable
    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Location> userLocations;
}