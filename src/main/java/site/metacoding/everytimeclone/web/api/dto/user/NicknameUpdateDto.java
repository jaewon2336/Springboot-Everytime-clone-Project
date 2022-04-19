package site.metacoding.everytimeclone.web.api.dto.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NicknameUpdateDto {

    @NotBlank
    @Size(min = 2, max = 30)
    private String nickname;

}
