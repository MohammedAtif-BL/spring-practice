package com.example.user.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user_data")
public class User {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String email;
    private String gender;
    private long salary;
    private String department;
    @ElementCollection
    @CollectionTable(name = "user_hobbies", joinColumns = @JoinColumn(name = "user_id"))
    private List<String> hobbies;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Address> address;

    private LocalDate doj;
}
