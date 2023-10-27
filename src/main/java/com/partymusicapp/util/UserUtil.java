package com.partymusicapp.util;

import com.partymusicapp.models.User;
import com.partymusicapp.models.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserUtil {

    public User getUpdatedUserBasedOnDTO(User user, UserDTO userDTO){
        if(userDTO.getUsername()!=null) user.setUsername(userDTO.getUsername());
        if(userDTO.getEmail()!=null) user.setEmail(userDTO.getEmail());
        if(userDTO.getBirthDate()!=null) user.setBirthDate(userDTO.getBirthDate());
        if(userDTO.getRating()!=0) user.setRating(userDTO.getRating());
        if(userDTO.getNoOfSuggestedSongs()!=0) user.setNoOfSuggestedSongs(userDTO.getNoOfSuggestedSongs());
        if(userDTO.getNoOfPlayedSongs()!=0) user.setNoOfPlayedSongs(userDTO.getNoOfPlayedSongs());
        if(userDTO.getNoOfJoinedParties()!=0) user.setNoOfJoinedParties(userDTO.getNoOfJoinedParties());
        if(userDTO.getNoOfHostedParties()!=0) user.setNoOfHostedParties(userDTO.getNoOfHostedParties());

        return user;
    }

    public User changePassword(User user, String newPassword){
        user.setPassword(newPassword);
        return user;
    }
}
