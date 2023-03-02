package hello.hellospring.repository;

import hello.hellospring.domain.Posts;

import java.util.List;
import java.util.Optional;

public interface PostsRepository {
    Posts save(Posts posts);
    Optional<Posts> findById(Long id);
    Optional<Posts> findByTitle(String title);
    List<Posts> findAll();
}
