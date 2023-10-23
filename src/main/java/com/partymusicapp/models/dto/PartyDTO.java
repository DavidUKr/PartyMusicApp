package com.partymusicapp.models.dto;

import com.partymusicapp.models.User;
import java.time.ZonedDateTime;

public class PartyDTO {

    private String id;

    private User ownerId;

    private String mode;

    private ZonedDateTime startTime;

    private ZonedDateTime endTime;

    private boolean isPublic;

    private String iconURL;

    private String theme;
}
