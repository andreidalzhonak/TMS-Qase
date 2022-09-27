package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateNewProjectDataModel {
    private String projectName;
    private String description;
}
