package com.jsule.demo_xa_db.delivery;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Wither;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC, onConstructor = @__(@PersistenceConstructor))
public class Delivery {

    private @Id @Wither Long id;
    private String name;
    private String address;
    private LocalDate sentDate;

    public Delivery(String name, String address, LocalDate sentDate) {
        this.name = name;
        this.address = address;
        this.sentDate = sentDate;
    }
}
