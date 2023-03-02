package hello.hellospring.controller;

import hello.hellospring.domain.Posts;
import hello.hellospring.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class PostsController {

    private final PostsService postsService;

    @Autowired
    public PostsController(PostsService postsService) {
        this.postsService = postsService;
    }

    @GetMapping("/posts/new")
    public String createForm() {
        return "posts/createPostsForm";
    }

    @PostMapping("/posts/new")
    public String create(PostsForm form) {
        Posts posts = new Posts();
        posts.setTitle(form.getTitle());
        posts.setContents(form.getContents());

        postsService.join(posts);

        return "redirect:/";
    }

    @GetMapping("posts/{id}")
    public String showContents(Model model, @PathVariable("id") Long id) {
        Optional<Posts> posts = postsService.findOne(id);
        Posts post = posts.get();
        model.addAttribute("posts", post);
        return "posts/postsContents";
    }


    @GetMapping(value = "/posts")
    public String list(Model model) {
        List<Posts> posts = postsService.findPosts();
        model.addAttribute("posts", posts);
        return "posts/postsList";
    }


}