package sample.cachepractice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CacheController {

    private final CacheService cacheService;

    @PostMapping("/cache")
    public String cache(@RequestBody long id) {
        long start = System.currentTimeMillis();
        String name = cacheService.cacheNameBy(id);
        long end = System.currentTimeMillis();

        log.info("수행시간 = {}", end - start);

        return name;
    }

    @PostMapping("/cache/v2")
    public String cacheV2(@RequestBody long id) {
        long start = System.currentTimeMillis();
        String name = cacheService.cacheNameV2By(id);
        long end = System.currentTimeMillis();

        log.info("수행시간 = {}", end - start);

        return name;
    }

}
