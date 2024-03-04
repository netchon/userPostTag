package cv.zing.interview.services.implementations;

import cv.zing.interview.dto.CreateUserPostDto;
import cv.zing.interview.dto.UserPostDto;
import cv.zing.interview.exceptions.EntityNotFoundException;
import cv.zing.interview.models.UserPost;
import cv.zing.interview.repositories.UserPostRepository;
import cv.zing.interview.services.IUserPost;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserImpl implements IUserPost {

    private final UserPostRepository userPostRepository;

    public UserImpl(UserPostRepository userPostRepository) {
        this.userPostRepository = userPostRepository;
    }

    @Override
    public void saveUser(UserPost userPost) {
        this.userPostRepository.save(userPost);
    }

    @Override
    public List<UserPost> users() {
        return this.userPostRepository.findAll();
    }

    @Override
    public UserPost getUserById(Long id) {
        return this.userPostRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not Found"));
    }

    @Override
    public UserPostDto getUserDtoById(Long id) {
        UserPost userPost = this.getUserById(id);
        return toDto(userPost);
    }

    @Override
    public UserPost getUserByUsername(String username) {
        return this.userPostRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("Username Not Found"));
    }

    @Override
    public UserPostDto getUserDtoByUsername(String username) {
        UserPost userPost = this.getUserByUsername(username);
        return toDto(userPost);
    }

    @Override
    public void deleteUser(Long id) {
        UserPost userPost = this.getUserById(id);
        this.userPostRepository.delete(userPost);
    }

    @Override
    public UserPostDto toDto(UserPost userPost) {
        UserPostDto userPostDto = new UserPostDto();
        userPostDto.setId(userPost.getId());
        userPostDto.setEmail(userPost.getEmail());
        userPostDto.setUsername(userPost.getUsername());
        return userPostDto;
    }

    @Override
    public UserPost toEntity(CreateUserPostDto dto) {
        UserPost userPost = new UserPost();
        userPost.setEmail(dto.getEmail());
        userPost.setUsername(dto.getUsername());
        return userPost;
    }

    @Override
    public List<UserPost> toEntity() {
        return null;
    }

    @Override
    public List<UserPostDto> toDto() {
        return this.users().stream().map(user -> {
            UserPostDto userPost = new UserPostDto();
            userPost.setId(user.getId());
            userPost.setUsername(user.getUsername());
            userPost.setEmail(user.getEmail());
            return userPost;
        }).collect(Collectors.toList());
    }


}
