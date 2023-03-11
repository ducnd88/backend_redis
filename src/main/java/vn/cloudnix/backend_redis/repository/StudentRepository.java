package vn.cloudnix.backend_redis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.cloudnix.backend_redis.entiry.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
}
