package vn.cloudnix.backend_redis.entiry;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@RedisHash("Student")
public class Student implements Serializable {
    private Integer id;
    private String name;
    private String address;
    private int grade;
}
