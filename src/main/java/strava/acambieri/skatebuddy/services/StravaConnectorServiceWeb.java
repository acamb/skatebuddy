package strava.acambieri.skatebuddy.services;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Primary;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
@Primary
public class StravaConnectorServiceWeb extends StravaConnectorService implements FactoryBean<IStravaConnectorService> {
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
