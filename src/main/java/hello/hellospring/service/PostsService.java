package hello.hellospring.service;

import hello.hellospring.domain.Posts;
import hello.hellospring.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Autowired
    public PostsService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }
    public Long join(Posts posts) {

//        validateDuplicateMember(member);
        postsRepository.save(posts);
        return posts.getId();
    }

    /*
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    */


    public List<Posts> findPosts() {
        return postsRepository.findAll();
    }

    public Optional<Posts> findOne(Long memberId) {
        return postsRepository.findById(memberId);
    }
}