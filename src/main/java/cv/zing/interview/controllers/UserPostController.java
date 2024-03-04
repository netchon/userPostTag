package cv.zing.interview.controllers;

import cv.zing.interview.dto.CreateUserPostDto;
import cv.zing.interview.dto.UserPostDto;
import cv.zing.interview.models.UserPost;
import cv.zing.interview.services.IUserPost;
import cv.zing.interview.utilities.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/user")
public class UserPostController {

    private final IUserPost userPostService;


    public UserPostController(IUserPost userPostService) {
        this.userPostService = userPostService;
    }


    @GetMapping
    public ResponseEntity<ApiResponse> getAllUsers(){
        List<UserPostDto> userPostList = this.userPostService.toDto();
        ApiResponse apiResponse = new ApiResponse.Builder().withStatus(true)
                .withDetails(Collections.singletonList(userPostList))
                .withStatusText("sucesso").build();
        return ResponseEntity.ok(apiResponse);
    }


    @PostMapping
    public ResponseEntity<ApiResponse> saveUser(@RequestBody CreateUserPostDto userPostDto){
        UserPost userPost = this.userPostService.toEntity(userPostDto);
        this.userPostService.saveUser(userPost);
        ApiResponse apiResponse = new ApiResponse.Builder().withStatus(true).withStatusText("SUCESS").build();
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getUserById(@PathVariable Long id){
        UserPostDto userPostDto = this.userPostService.getUserDtoById(id);
        ApiResponse apiResponse = new ApiResponse.Builder()
                .withStatus(true)
                .withStatusText("SUCCESS")
                .withDetails(Collections.singletonList(userPostDto)).build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<ApiResponse> getUserByUsername(@PathVariable String username){
        UserPostDto userPostDto = this.userPostService.getUserDtoByUsername(username);
        ApiResponse apiResponse = new ApiResponse.Builder()
                .withStatus(true)
                .withStatusText("SUCESSO")
                .withDetails(Collections.singletonList(userPostDto)).build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteUserById(@PathVariable Long id){
        this.userPostService.deleteUser(id);
        ApiResponse apiResponse = new ApiResponse.Builder()
                .withStatus(true)
                .withStatusText("SUCESSO").build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
