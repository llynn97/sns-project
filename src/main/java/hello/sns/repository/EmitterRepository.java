package hello.sns.repository;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
@Slf4j
public class EmitterRepository {

    private Map<String, SseEmitter> emitterMap = new HashMap<>();

    public SseEmitter save(Integer userId, SseEmitter seeEmitter) {
        final String key = getKey(userId);
        emitterMap.put(key, seeEmitter);
        log.info("Set emitterMap {}", key);
        return seeEmitter;
    }

    public Optional<SseEmitter> get(Integer userId) {
        final String key = getKey(userId);
        log.info("Set emitterMap {}", key);
        return Optional.of(emitterMap.get(key));
    }

    public void delete(Integer userId) {
         emitterMap.remove(getKey(userId));
    }

    public String getKey(Integer userId) {
        return "Emitter:UID:" + userId;
    }
}
