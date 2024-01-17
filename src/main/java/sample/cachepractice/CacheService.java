package sample.cachepractice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CacheService {

    private final CacheRepository cacheRepository;

    @Cacheable("cacheStore")
    public String cacheNameBy(long id) {
        log.info("서비스 로직 호출");

        delay();

        CacheEntity cacheEntity = cacheRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);

        return cacheEntity.getName();
    }

    private static void delay() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
