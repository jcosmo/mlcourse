package id.au.jwalker.mlcourse.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import id.au.jwalker.mlcourse.gin.GinBootstrapModule;

public class MLCourse
  implements EntryPoint
{
  public void onModuleLoad()
  {
    final ApplicationUI ui = new ApplicationUI();

    RootLayoutPanel.get().add( ui.asWidget() );
  }
}
