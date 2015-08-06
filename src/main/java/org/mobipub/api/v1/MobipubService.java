package org.mobipub.api.v1;

import org.mobipub.api.v1.dao.*;
import org.mobipub.api.v1.resources.*;
import org.mobipub.api.v1.utils.Authorize;
import org.mobipub.api.v1.utils.AuthorizeMobile;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.jdbi.DBIFactory;
import org.skife.jdbi.v2.DBI;

public class MobipubService extends Service<MobipubServiceConfiguration> {
    public static void main(String[] args) throws Exception {
        new MobipubService().run(args);
    }

    @Override
    public void initialize(Bootstrap<MobipubServiceConfiguration> mobipubServiceConfigurationBootstrap) {
        mobipubServiceConfigurationBootstrap.setName("MobipubService");
    }

    @Override
    public void run(MobipubServiceConfiguration configuration, Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDatabaseConfiguration(), "postgresql");

        final int tokenTimeout = configuration.getTokenTimeout();

        final AuthTokenDAO authTokenDAO = jdbi.onDemand(AuthTokenDAO.class);
        final UserDAO userDAO = jdbi.onDemand(UserDAO.class);
        final UserRoleDAO userRoleDAO = jdbi.onDemand(UserRoleDAO.class);

        final BaseDAO baseDAO = jdbi.onDemand(BaseDAO.class);
        final CategoryDAO categoryDAO = jdbi.onDemand(CategoryDAO.class);
        final ContentDAO contentDAO = jdbi.onDemand(ContentDAO.class);
        final ContentAttributeDAO contentAttributeDAO = jdbi.onDemand(ContentAttributeDAO.class);
        final ContentElementDAO contentElementDAO = jdbi.onDemand(ContentElementDAO.class);

        final BaseLangDAO baseLangDAO = jdbi.onDemand(BaseLangDAO.class);

        final MobileUserLocationDAO mobileUserLocationDAO = jdbi.onDemand(MobileUserLocationDAO.class);
        final MobileUserAppStartDAO mobileUserAppStartDAO = jdbi.onDemand(MobileUserAppStartDAO.class);
        final MobileUserFormDataDAO mobileUserFormDataDAO = jdbi.onDemand(MobileUserFormDataDAO.class);
        final MobileUserDAO mobileUserDAO = jdbi.onDemand(MobileUserDAO.class);

        final Authorize authorize = new Authorize(authTokenDAO, userDAO, userRoleDAO, tokenTimeout, categoryDAO, contentDAO);
        final AuthorizeMobile authorizeMobile = new AuthorizeMobile(mobileUserDAO);

        environment.addResource(new UserAuthResource(authorize));

        environment.addResource(new BaseResource(baseDAO));

        environment.addResource(new BaseLangResource(baseLangDAO));

        environment.addResource(new CategoryCountResource(authorize, categoryDAO));
        environment.addResource(new CategoryListResource(authorize, categoryDAO));
        environment.addResource(new CategoryResource(authorize, categoryDAO));

        environment.addResource(new ContentCountResource(authorize, contentDAO));
        environment.addResource(new ContentListResource(authorize, contentDAO));
        environment.addResource(new ContentResource(authorize, contentDAO));

        environment.addResource(new ContentAttributeListResource(authorize, contentAttributeDAO));
        environment.addResource(new ContentElementListResource(authorize, contentElementDAO));

        environment.addResource(new MobileUserRegisterResource(authorize, mobileUserDAO));
        environment.addResource(new MobileUserAuthResource(authorize, authorizeMobile));
        environment.addResource(new MobileUserSetGeoLocationResource(authorize, mobileUserLocationDAO));
        environment.addResource(new MobileUserSetAppStartResource(authorize, mobileUserAppStartDAO));
        environment.addResource(new MobileUserSetFormDataResource(authorize, mobileUserFormDataDAO));
    }
}
