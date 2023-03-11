package vn.cloudnix.backend_redis.model;

import lombok.Data;

@Data
public class StudentResponse {
    private Integer id;
    private String name;
    private String address;
    private int grade;
}
