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

    @PostMapping("/cache/create/v1")
    public String createCacheV1(@RequestBody long id) {
        log.info("시작 -----------------------------");
        log.info("/cache/create/v1 호출, id = {}", id);

        long start = System.currentTimeMillis();
        String name = cacheService.findNameV1By(id);
        long end = System.currentTimeMillis();

        log.info("name = {}, 수행시간 = {}", name, end - start);
        log.info("끝 ------------------------------\n");

        return name;
    }

    @PostMapping("/cache/create/v2")
    public String createCacheV2(@RequestBody long id) {
        log.info("시작 -----------------------------");
        log.info("/cache/create/v2 호출, id = {}", id);

        long start = System.currentTimeMillis();
        String name = cacheService.findNameV2By(id);
        long end = System.currentTimeMillis();

        log.info("name = {}, 수행시간 = {}", name, end - start);
        log.info("끝 ------------------------------\n");

        return name;
    }

    @PostMapping("/cache/delete/v1")
    public String deleteCacheV1() {
        log.info("시작 -----------------------------");
        log.info("/cache/delete/v1 호출");

        cacheService.deleteCacheV1();

        log.info("끝 ------------------------------\n");

        return "delete";
    }

    @PostMapping("/cache/delete/v2")
    public String deleteCacheV2(@RequestBody long id) {
        log.info("시작 -----------------------------");
        log.info("/cache/delete/v2 호출");

        cacheService.deleteCacheV2(id);

        log.info("끝 ------------------------------\n");

        return "delete";
    }

    @PostMapping("/cache/delete/v3")
    public String deleteCacheV3(@RequestBody long id) {
        log.info("시작 -----------------------------");
        log.info("/cache/delete/v3 호출");

        cacheService.deleteCacheV3(id);

        log.info("끝 ------------------------------\n");

        return "delete";
    }

    @PostMapping("/cache/delete/v4")
    public String deleteCacheV4() {
        log.info("시작 -----------------------------");
        log.info("/cache/delete/v4 호출");

        cacheService.deleteCacheV4();

        log.info("끝 ------------------------------\n");

        return "delete";
    }

}
