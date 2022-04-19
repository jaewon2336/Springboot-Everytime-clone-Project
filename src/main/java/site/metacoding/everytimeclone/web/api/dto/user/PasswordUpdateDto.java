package site.metacoding.everytimeclone.web.api.dto.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PasswordUpdateDto {

    @Size(min = 4, max = 20)
    @NotBlank
    private String currentPassword;

    @Size(min = 4, max = 20)
    @NotBlank
    private String password;
}