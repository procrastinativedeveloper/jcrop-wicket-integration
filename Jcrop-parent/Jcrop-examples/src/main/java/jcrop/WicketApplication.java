package jcrop;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.time.Duration;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 *
 */
public class WicketApplication extends WebApplication
{    	
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<HomePage> getHomePage()
	{
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{

		super.init();
        if (usesDevelopmentConfig()){
            //disable cache
            getResourceSettings().setResourcePollFrequency(Duration.ONE_SECOND);
        }
	}
}
