package com.example.sendo.models.dto.response;

import com.example.sendo.models.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@NoArgsConstructor
public class UserPageDTO {
    private List<User> content;
    private int totalPage;
    private int size;
    private int number;

    public static UserPageDTO toDTO(Page<User> userPage) {
        UserPageDTO userPageDTO = new UserPageDTO();
        userPageDTO.setContent(userPage.getContent());
        userPageDTO.setTotalPage(userPage.getTotalPages());
        userPageDTO.setSize(userPage.getSize());
        userPageDTO.setNumber(userPage.getNumber());
        return userPageDTO;
    }
}
