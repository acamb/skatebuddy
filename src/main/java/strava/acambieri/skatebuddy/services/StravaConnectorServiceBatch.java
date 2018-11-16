package strava.acambieri.skatebuddy.services;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
@Qualifier("batch")
@Scope("batch")
public class StravaConnectorServiceBatch extends StravaConnectorService implements FactoryBean<IStravaConnectorService> {
    @Nullable
    @Override
    public IStravaConnectorService getObject() throws Exception {
        return getService();
    }
    @Nullable
    @Override
    public Class<?> getObjectType() {
        return IStravaConnectorService.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
