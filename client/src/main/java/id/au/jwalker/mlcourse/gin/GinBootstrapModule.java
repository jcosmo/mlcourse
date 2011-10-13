package id.au.jwalker.mlcourse.gin;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import javax.inject.Singleton;

public class GinBootstrapModule
  extends AbstractGinModule
{
  protected void configure()
  {
    bind( EventBus.class ).to( SimpleEventBus.class ).in( Singleton.class );
  }
}
