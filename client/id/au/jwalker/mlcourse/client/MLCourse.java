package id.au.jwalker.mlcourse.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class MLCourse
  implements EntryPoint
{
  public void onModuleLoad()
  {
    final ApplicationUI ui = new ApplicationUI();

    RootLayoutPanel.get().add( ui.asWidget() );
  }
}
