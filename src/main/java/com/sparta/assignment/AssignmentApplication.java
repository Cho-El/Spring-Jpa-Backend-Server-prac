package com.sparta.assignment;

import com.sparta.assignment.models.Post;
import com.sparta.assignment.models.PostRepository;
import com.sparta.assignment.service.PostService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class AssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}
//	@Bean
//	public CommandLineRunner demo(PostRepository postRepository, PostService postService) {
//		return (args) -> {
//			postRepository.save(new Post("코딩잘하는 법1", "윤", "12345", "메롱메롱1"));
//			postRepository.save(new Post("코딩잘하는 법2", "성", "12345", "메롱메롱2"));
//			postRepository.save(new Post("코딩잘하는 법3", "조", "12345", "메롱메롱3"));
//			postRepository.save(new Post("코딩잘하는 법4", "윤2", "12345", "메롱메롱4"));
//		};
//	}
}
