package id.au.jwalker.mlcourse.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.layout.client.Layout.AnimationCallback;
import com.google.gwt.layout.client.Layout.Layer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import id.au.jwalker.mlcourse.client.lr2d.lr2dUI;

public class ApplicationUI
{
  private final Widget _widget;
  private Widget _current = null;

  interface ApplicationUiBinder
    extends UiBinder<Widget, ApplicationUI>
  {
  }

  private static ApplicationUiBinder binder = GWT.create( ApplicationUiBinder.class );

  @UiField
  Hyperlink linearRegression2D;
  @UiField
  Hyperlink linearRegression2D2;
  @UiField
  Label contentLabel2;
  @UiField
  LayoutPanel contentPanel;
  @UiField
  lr2dUI lr2d;

  public ApplicationUI()
  {
    _widget = binder.createAndBindUi( this );
    contentPanel.setWidgetLeftWidth( lr2d, 0, Unit.PX, 100, Unit.PCT );
    contentPanel.setWidgetLeftWidth( contentLabel2, 0, Unit.PX, 0, Unit.PX );
    contentPanel.forceLayout();
  }

  public Widget asWidget()
  {
    return _widget;
  }

  @UiHandler( "linearRegression2D" )
  void showLinearRegression2D( final ClickEvent e )
  {
    show( lr2d );
  }

  @UiHandler( "linearRegression2D2" )
  void showLinearRegressionMD( final ClickEvent e )
  {
    show( contentLabel2 );
  }

  private void show( final Widget widget )
  {
    if ( _current == widget )
    {
      return;
    }

    if ( null != _current )
    {
      hideThenShow( _current, widget );
    }
    else
    {
      _current = widget;
      contentPanel.setWidgetLeftWidth( _current, 0, Unit.PX, 100, Unit.PCT );
      contentPanel.animate( 250 );
    }
  }

  private void hideThenShow( final Widget toHide, final Widget toShow )
  {
    contentPanel.setWidgetLeftWidth( toHide, 0, Unit.PX, 0, Unit.PX );
    contentPanel.forceLayout( );
    _current = null;
    show( toShow );
  }
}