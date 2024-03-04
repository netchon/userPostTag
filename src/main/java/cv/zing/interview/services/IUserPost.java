package cv.zing.interview.services;

import cv.zing.interview.dto.CreateUserPostDto;
import cv.zing.interview.dto.UserPostDto;
import cv.zing.interview.models.UserPost;

import java.util.List;

public interface IUserPost {

    void saveUser(UserPost userPost);

    List<UserPost> users();

    UserPost getUserById(Long id);

    UserPostDto getUserDtoById(Long id);

    UserPost getUserByUsername(String username);

    UserPostDto getUserDtoByUsername(String username);

    void deleteUser(Long id);

    UserPostDto toDto(UserPost userPost);

    UserPost toEntity(CreateUserPostDto userPostDto);

    List<UserPost> toEntity();

    List<UserPostDto> toDto();

}
