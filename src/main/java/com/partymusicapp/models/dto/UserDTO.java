package com.partymusicapp.models.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserDTO {

    private String id;

    private String username;

    private String email;

    private String birthDate;

    private int rating;

    private int noOfSuggestedSongs;

    private int noOfPlayedSongs;

    private int noOfJoinedParties;

    private int noOfHostedParties;
}
