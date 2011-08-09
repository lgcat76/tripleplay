//
// Triple Play - utilities for use in PlayN-based games
// Copyright (c) 2011, Three Rings Design, Inc. - All rights reserved.
// http://github.com/threerings/tripleplay/blob/master/LICENSE

package tripleplay.ui;

import playn.core.CanvasLayer;
import playn.core.Image;
import playn.core.PlayN;
import playn.core.TextFormat;
import playn.core.TextLayout;

import pythagoras.f.Dimension;
import pythagoras.f.IRectangle;

/**
 * A widget that displays one or more lines of text and/or an icon image.
 */
public class Label extends TextWidget
{
    /**
     * Creates a label with no custom styles.
     */
    public Label () {
    }

    /**
     * Creates a label with the specified custom styles.
     */
    public Label (Styles styles) {
        setStyles(styles);
    }

    @Override public Label setText (String text) {
        super.setText(text);
        return this;
    }

    @Override public Label setIcon (Image icon) {
        super.setIcon(icon);
        return this;
    }

    @Override public Label setIcon (Image icon, IRectangle region) {
        super.setIcon(icon, region);
        return this;
    }

    @Override public String toString () {
        return "Label(" + _text + ")";
    }

    @Override protected Dimension computeSize (float hintX, float hintY) {
        LayoutData ldata = computeLayout(hintX, hintY);
        return computeTextSize(ldata, new Dimension());
    }

    @Override protected void layout () {
        float width = _size.width, height = _size.height;
        LayoutData ldata = computeLayout(width, height);
        renderLayout(ldata, 0, 0, width, height);
        _ldata = null; // no need to keep this around
    }

    protected LayoutData computeLayout (float hintX, float hintY) {
        if (_ldata != null) return _ldata;
        _ldata = new LayoutData();
        layoutText(_ldata, _text, hintX, hintY);
        return _ldata;
    }

    protected LayoutData _ldata;
}
