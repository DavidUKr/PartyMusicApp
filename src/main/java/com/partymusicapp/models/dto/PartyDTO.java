package com.partymusicapp.models.dto;

import com.partymusicapp.models.Theme;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class PartyDTO {

    private String id;

    private String ownerUsername;

    private Theme themeId;

    private String mode;

    private ZonedDateTime startTime;

    private ZonedDateTime endTime;

    private boolean isPublic;

    private String iconURL;

    private String title;

}
