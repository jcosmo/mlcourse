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

  private Context2d backBufferContext;
  private Context2d context;
  private CssColor white;
  private CssColor black;

  static final int WIDTH = 400;
  static final int HEIGHT = 400;

  int posn = 1;

  public lr2dUI()
  {
    initWidget( ourUiBinder.createAndBindUi( this ) );
    final Canvas backBuffer = Canvas.createIfSupported();

    canvas.setWidth( (WIDTH) + "px" );
    canvas.setHeight( (HEIGHT) + "px" );
    canvas.setCoordinateSpaceWidth( WIDTH );
    canvas.setCoordinateSpaceHeight( HEIGHT );
    backBuffer.setCoordinateSpaceWidth( WIDTH );
    backBuffer.setCoordinateSpaceHeight( HEIGHT );

    context = canvas.getContext2d();
    backBufferContext = backBuffer.getContext2d();

    white = CssColor.make("rgba(255,255,255,1)");
    black = CssColor.make("rgba(255,0,0,1)");
  }

  @UiHandler( "startButton" )
  void startCanvas( final ClickEvent e )
  {
    drawAxis();
    context.drawImage( backBufferContext.getCanvas(), 0, 0 );
  }

  void drawAxis( )
  {
    backBufferContext.setFillStyle( white );
    backBufferContext.fillRect( 0, 0, WIDTH, HEIGHT );
    backBufferContext.setLineWidth( 1 );
    backBufferContext.setStrokeStyle( black );
    backBufferContext.beginPath();
    backBufferContext.moveTo( WIDTH / 2, 0 );
    backBufferContext.lineTo( WIDTH / 2, HEIGHT );
    backBufferContext.closePath();
    backBufferContext.stroke();
    backBufferContext.beginPath();
    backBufferContext.moveTo( 0, HEIGHT / 2 );
    backBufferContext.lineTo( WIDTH, HEIGHT / 2 );
    backBufferContext.closePath();
    backBufferContext.stroke();
  }

  @UiFactory
  Canvas constructCanvas()
  {
    return Canvas.createIfSupported();
  }
}