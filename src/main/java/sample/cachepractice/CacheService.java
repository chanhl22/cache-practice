package sample.cachepractice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CacheService {

    private final CacheRepository cacheRepository;

    @Cacheable("cacheStoreV1")
    public String findNameV1By(long id) {
        log.info("서비스 로직 호출");

        delay();

        CacheEntity cacheEntity = cacheRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);

        return cacheEntity.getName();
    }

    @Cacheable(value = "cacheStoreV2", key = "#id")
    public String findNameV2By(long id) {
        log.info("서비스 로직 호출");

        delay();

        CacheEntity cacheEntity = cacheRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);

        return cacheEntity.getName();
    }

    @CacheEvict("cacheStoreV1")
    public void deleteCacheV1() {
        log.info("캐시 삭제 V1");
    }

    @CacheEvict("cacheStoreV1")
    public void deleteCacheV2(long id) {
        log.info("캐시 삭제 V2");
    }

    @CacheEvict(value = "cacheStoreV1", key = "#id")
    public void deleteCacheV3(long id) {
        log.info("캐시 삭제 V3");
    }

    @CacheEvict(value = "cacheStoreV1", allEntries = true)
    public void deleteCacheV4() {
        log.info("캐시 삭제 V4");
    }

    private static void delay() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
