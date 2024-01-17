package sample.cachepractice;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CacheController {

    private final CacheService cacheService;

    @PostMapping("/cache")
    public String cache(@RequestBody long id) {
        return cacheService.cacheNameBy(id);
    }

}
