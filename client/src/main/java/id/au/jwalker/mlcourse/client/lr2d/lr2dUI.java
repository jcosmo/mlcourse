package id.au.jwalker.mlcourse.client.lr2d;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.CssColor;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class lr2dUI
  extends Composite
{
  interface lr2dUIUiBinder
    extends UiBinder<Widget, lr2dUI>
  {
  }

  private static lr2dUIUiBinder ourUiBinder = GWT.create( lr2dUIUiBinder.class );
  @UiField
  Button startButton;
  @UiField
  Canvas canvas;
  Context2d context;
  CssColor redrawColor;

  public lr2dUI()
  {
    initWidget( ourUiBinder.createAndBindUi( this ) );
    canvas.setWidth( "100%" );
    canvas.setHeight( "100%" );
    context = canvas.getContext2d();
    redrawColor = CssColor.make("rgba(200,0,100,0.6)");
  }

  @UiHandler( "startButton" )
  void startCanvas( final ClickEvent e )
  {
    context.setFillStyle( redrawColor );
    context.fillRect( 0, 0, 100, 100);
  }

  @UiFactory
  Canvas constructCanvas()
  {
    return Canvas.createIfSupported();
  }
}