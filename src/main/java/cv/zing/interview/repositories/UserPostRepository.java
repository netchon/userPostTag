package cv.zing.interview.repositories;

import cv.zing.interview.models.UserPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserPostRepository extends JpaRepository<UserPost, Long> {
    Optional<UserPost> findByUsername(String username);
}
