package id.au.jwalker.mlcourse.linearregression2d.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class LinearRegression2D
  implements EntryPoint
{

  /**
   * This is the entry point method.
   */
  public void onModuleLoad()
  {
    final DataSetCanvas ui = new DataSetCanvas();

    RootPanel.get().add( ui.asWidget() );
  }
}
