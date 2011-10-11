package id.au.jwalker.mlcourse.linearregression2d.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

public class ApplicationUI
{
  private Widget _widget;

  interface ApplicationUiBinder
    extends UiBinder<Widget, ApplicationUI>
  {
  }

  private static ApplicationUiBinder binder = GWT.create( ApplicationUiBinder.class );

  public ApplicationUI()
  {
    _widget = binder.createAndBindUi( this );
  }

  public Widget asWidget()
  {
    return _widget;
  }
}