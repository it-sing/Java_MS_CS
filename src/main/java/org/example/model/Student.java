package org.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Student{

    private Integer id;
    private Integer stuCode;
    private String name;
    private String gender;
    private String birth;
    private String address;
    private String generation;
    private String room;

}
