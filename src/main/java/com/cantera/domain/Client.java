package com.cantera.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    private String id;
    private String nombre;
    private String email;

}
