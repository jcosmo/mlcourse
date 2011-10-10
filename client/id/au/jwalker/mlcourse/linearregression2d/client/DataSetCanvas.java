package id.au.jwalker.mlcourse.linearregression2d.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class DataSetCanvas
  extends Composite
{
  interface DataSetCanvasUiBinder
    extends UiBinder<Widget, DataSetCanvas>
  {
  }

  private static DataSetCanvasUiBinder ourUiBinder = GWT.create( DataSetCanvasUiBinder.class );

  @UiField
  SpanElement status;

  @UiField
  Button button;

  public DataSetCanvas()
  {
    initWidget( ourUiBinder.createAndBindUi( this ) );
  }

  public void updateStatus( final String s )
  {
    status.setInnerText( s );
  }

  public String getStatus()
  {
    return status.getInnerText();
  }

  public Button getButton()
  {
    return button;
  }
}