package id.au.jwalker.mlcourse.client.lr2d;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class lr2dUI
  extends Composite
{
  interface lr2dUIUiBinder
    extends UiBinder<Widget, lr2dUI>
  {
  }

  private static lr2dUIUiBinder ourUiBinder = GWT.create( lr2dUIUiBinder.class );

  public lr2dUI()
  {
    initWidget( ourUiBinder.createAndBindUi( this ) );
  }
}