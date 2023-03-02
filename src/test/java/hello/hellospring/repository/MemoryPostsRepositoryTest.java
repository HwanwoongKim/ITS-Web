package hello.hellospring.repository;

import hello.hellospring.domain.Posts;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemoryPostsRepositoryTest {

    PostsRepository repository = new MemoryPostsRepository();

    @Test
    public void save() {
        Posts posts = new Posts();
        posts.setTitle("spring");

        repository.save(posts);

        Posts result = repository.findById(posts.getId()).get();
        assertThat(posts).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Posts posts1 = new Posts();
        posts1.setTitle("spring1");
        repository.save(posts1);

        Posts posts2 = new Posts();
        posts2.setTitle("spring2");
        repository.save(posts2);

        Posts result = repository.findByTitle("spring1").get();

        assertThat(result).isEqualTo(posts1);
    }
}
