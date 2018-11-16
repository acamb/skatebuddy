package strava.acambieri.skatebuddy.configuration.scopes;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BatchScope implements Scope {

    private Map<String, Object> scopedObjects
            = Collections.synchronizedMap(new HashMap<String, Object>());
    private Map<String, Runnable> destructionCallbacks
            = Collections.synchronizedMap(new HashMap<String, Runnable>());

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if(!scopedObjects.containsKey(name)) {
            scopedObjects.put(name, objectFactory.getObject());
        }
        return scopedObjects.get(name);
    }

    @Nullable
    @Override
    public Object remove(String s) {
        destructionCallbacks.remove(s);
        return scopedObjects.remove(s);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        destructionCallbacks.put(name, callback);
    }

    @Nullable
    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Nullable
    @Override
    public String getConversationId() {
        return null;
    }

    public void clear(){
        for(String key : destructionCallbacks.keySet()){
            LoggerFactory.getLogger(getClass()).info("Calling destructor for: " + key);
            destructionCallbacks.get(key).run();
        }
        destructionCallbacks.clear();
        scopedObjects.clear();
    }
}
