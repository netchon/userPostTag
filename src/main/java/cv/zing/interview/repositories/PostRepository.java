package cv.zing.interview.repositories;

import cv.zing.interview.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
