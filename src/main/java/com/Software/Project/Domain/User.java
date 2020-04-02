package com.Software.Project.Domain;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity
public class User {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto Increment
    private Long ID;
    private String username;
    private String password;
}
