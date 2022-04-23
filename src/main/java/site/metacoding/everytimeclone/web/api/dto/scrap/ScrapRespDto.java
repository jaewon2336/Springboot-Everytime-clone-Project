package site.metacoding.everytimeclone.web.api.dto.scrap;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.everytimeclone.domain.scrap.Scrap;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ScrapRespDto {

    private List<Scrap> scraps;
}
