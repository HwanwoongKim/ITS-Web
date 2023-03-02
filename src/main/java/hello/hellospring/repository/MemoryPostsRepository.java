package hello.hellospring.repository;

import hello.hellospring.domain.Posts;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class MemoryPostsRepository implements PostsRepository {

    private static Map<Long, Posts> store = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public Posts save(Posts posts) {
        posts.setId(++sequence);
        store.put(posts.getId(), posts);
        return posts;
    }

    @Override
    public Optional<Posts> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Posts> findByTitle(String title) {
        return store.values().stream()
               // .filter(member -> member.getTitle().equals(title))
                .filter(post -> post.getTitle().equals(title))
                .findAny();
    }

    @Override
    public List<Posts> findAll() {
        return new ArrayList<>(store.values());
    }
}
