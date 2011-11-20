package id.au.jwalker.mlcourse.client.lr2d;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.CssColor;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.touch.client.Point;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import java.util.ArrayList;

public class lr2dUI
  extends Composite
{
  interface lr2dUIUiBinder
    extends UiBinder<Widget, lr2dUI>
  {
  }

  private final CssColor WHITE;
  private final CssColor BLACK;
  private final CssColor RED;
  private final int WIDTH = 400;
  private final int HEIGHT = 400;

  private static lr2dUIUiBinder _ourUiBinder = GWT.create( lr2dUIUiBinder.class );
  @UiField
  Button _startButton;
  @UiField
  Canvas _canvas;
  @UiFactory
  Canvas constructCanvas()
  {
    return Canvas.createIfSupported();
  }

  private final Context2d _backBufferContext;
  private final Context2d _context;
  private final ArrayList<Point> _dataPoints;

  public lr2dUI()
  {
    _dataPoints = new ArrayList<Point>();
    initWidget( _ourUiBinder.createAndBindUi( this ) );
    final Canvas backBuffer = Canvas.createIfSupported();

    _canvas.setWidth( (WIDTH) + "px" );
    _canvas.setHeight( (HEIGHT) + "px" );
    _canvas.setCoordinateSpaceWidth( WIDTH );
    _canvas.setCoordinateSpaceHeight( HEIGHT );
    backBuffer.setCoordinateSpaceWidth( WIDTH );
    backBuffer.setCoordinateSpaceHeight( HEIGHT );

    _context = _canvas.getContext2d();
    _backBufferContext = backBuffer.getContext2d();

    WHITE = CssColor.make("rgba(255,255,255,1)");
    BLACK = CssColor.make("rgba(0,0,0,1)");
    RED = CssColor.make("rgb(255,0,0)");
  }

  @UiHandler( "_startButton" )
  void startCanvas( final ClickEvent e )
  {
    _dataPoints.clear();
    redraw();
  }

  private void redraw()
  {
    drawAxis();
    drawPoints();
    _context.drawImage( _backBufferContext.getCanvas(), 0, 0 );
  }

  void drawAxis( )
  {
    _backBufferContext.setFillStyle( WHITE );
    _backBufferContext.fillRect( 0, 0, WIDTH, HEIGHT );
    _backBufferContext.setLineWidth( 1 );
    _backBufferContext.setStrokeStyle( BLACK );
    _backBufferContext.beginPath();
    _backBufferContext.moveTo( WIDTH / 2, 0 );
    _backBufferContext.lineTo( WIDTH / 2, HEIGHT );
    _backBufferContext.closePath();
    _backBufferContext.stroke();
    _backBufferContext.beginPath();
    _backBufferContext.moveTo( 0, HEIGHT / 2 );
    _backBufferContext.lineTo( WIDTH, HEIGHT / 2 );
    _backBufferContext.closePath();
    _backBufferContext.stroke();
  }

  private void drawPoints()
  {
    _backBufferContext.setStrokeStyle( RED );
    for ( Point dataPoint : _dataPoints )
    {
      drawPoint( dataPoint );
    }
  }

  private void drawPoint( final Point dataPoint )
  {
    _backBufferContext.strokeRect( dataPoint.getX(), dataPoint.getY(), 1, 1 );
  }

  @UiHandler( "_canvas" )
  public void clicked( final ClickEvent clickEvent )
  {
    final Point point = new Point( clickEvent.getX(), clickEvent.getY() );
    _dataPoints.add( point );
    drawPoint( point );
    _context.drawImage( _backBufferContext.getCanvas(), 0, 0 );
  }
}