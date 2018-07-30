/*******************************************************************************
 * Copyright (c) Gerd Wütherich 2012-2016.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *    Gerd Wütherich (gerd@gerd-wuetherich.de) - initial API and implementation
 ******************************************************************************/
package org.slizaa.ui.widget.dsm.internal;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Display;
import org.slizaa.ui.widget.dsm.IDsmColorScheme;
import org.slizaa.ui.widget.dsm.IDsmContentProvider;
import org.slizaa.ui.widget.dsm.IMatrixListener;
import org.slizaa.ui.widget.dsm.MatrixEvent;

/**
 * <p>
 * The {@link Figure} that implements the matrix.
 * </p>
 * 
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class Matrix extends Figure {

	/** the model */
	protected IDsmContentProvider _dsmContentProvider;

	/** - */
	private IDsmColorScheme _matrixColorScheme;

	/** - */
	private ILabelProvider _matrixLabelProvider;

	/** - */
	protected CopyOnWriteArrayList<IMatrixListener> _matrixListeners;

	/** - */
	protected int _x = -1;

	/** - */
	protected int _y = -1;

	private LayoutInfo _layoutInfo;

	/**
	 * <p>
	 * Creates a new instance of type {@link Matrix}.
	 * </p>
	 * 
	 * @param model
	 * @param matrixConfiguration
	 * @param labelProvider
	 * @param matrixCycleDetector
	 */
	public Matrix(IDsmContentProvider model, ILabelProvider labelProvider, IDsmColorScheme colorScheme) {

		//
		Assert.isNotNull(model);
		Assert.isNotNull(labelProvider);
		Assert.isNotNull(colorScheme);

		// set the model
		_dsmContentProvider = model;
		_matrixColorScheme = colorScheme;
		_matrixLabelProvider = labelProvider;

		//
		_matrixListeners = new CopyOnWriteArrayList<IMatrixListener>();

		//
		addMouseListener(new MatrixMouseListener());
		addMouseMotionListener(new MatrixMouseMotionListener());
	}

	public LayoutInfo getLayoutInfo() {
		return _layoutInfo;
	}

	public void setLayoutInfo(LayoutInfo layoutInfo) {
		_layoutInfo = checkNotNull(layoutInfo);
	}

	/**
	 * <p>
	 * </p>
	 * 
	 * @param colorScheme
	 */
	protected final void setMatrixColorScheme(IDsmColorScheme colorScheme) {
		_matrixColorScheme = colorScheme;
	}

	/**
	 * <p>
	 * </p>
	 * 
	 * @return
	 */
	public IDsmContentProvider getModel() {
		return _dsmContentProvider;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param model
	 */
	public void setModel(IDsmContentProvider model) {
		_dsmContentProvider = model;
	}

	/**
	 * <p>
	 * </p>
	 * 
	 * @return
	 */
	protected final IDsmColorScheme getMatrixConfiguration() {
		return _matrixColorScheme;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void paintClientArea(Graphics graphics) {
		super.paintClientArea(graphics);

		// push the current state
		graphics.pushState();

		// draw the background for the complete matrix
		graphics.setBackgroundColor(_matrixColorScheme.getMatrixBackgroundColor());
		graphics.fillRectangle(0, 0, getHorizontalSliceSize(_dsmContentProvider.getItemCount()),
				getVerticalSliceSize(_dsmContentProvider.getItemCount()));

		// draw the diagonal
		graphics.setBackgroundColor(_matrixColorScheme.getMatrixDiagonalColor());
		for (int i = 0; i < _dsmContentProvider.getItemCount(); i++) {
			graphics.fillRectangle(getHorizontalSliceSize(i), getVerticalSliceSize(i),
					getHorizontalSliceSize(i + 1) - getHorizontalSliceSize(i) + 1,
					getVerticalSliceSize(i + 1) - getVerticalSliceSize(i) + 1);
		}

		// draw the cycles
		for (int[] cycle : _dsmContentProvider.getCycles()) {
			graphics.setBackgroundColor(_matrixColorScheme.getCycleSideMarkerColor());
			int lenght = cycle[cycle.length - 1] - cycle[0] + 1;
			graphics.fillRectangle(getHorizontalSliceSize(cycle[0]), getVerticalSliceSize(cycle[0]),
					getHorizontalSliceSize(lenght) + 1, getVerticalSliceSize(lenght) + 1);

			for (int i = 0; i < cycle.length; i++) {
				graphics.setBackgroundColor(_matrixColorScheme.getCycleMatrixDiagonalColor());
				graphics.fillRectangle(getHorizontalSliceSize(cycle[i]), getVerticalSliceSize(cycle[i]),
						getHorizontalSliceSize(cycle[i] + 1) - getHorizontalSliceSize(cycle[i]) + 1,
						getVerticalSliceSize(cycle[i] + 1) - getVerticalSliceSize(cycle[i]) + 1);
			}
		}

		//
		// draw marked rows and columns
		if (_x != -1 && _y != -1) {

			// draw column
			if (_dsmContentProvider.isInCycle(_x, _y)) {
				graphics.setBackgroundColor(getMatrixConfiguration().getCycleMatrixMarkedColumnRowColor());
			} else {
				graphics.setBackgroundColor(getMatrixConfiguration().getMatrixMarkedColumnRowColor());
			}
			graphics.fillRectangle(0, getVerticalSliceSize(_y), getHorizontalSliceSize(_x + 1),
					getVerticalSliceSize(_y + 1) - getVerticalSliceSize(_y));

			// draw row
			graphics.fillRectangle(getHorizontalSliceSize(_x), 0,
					getHorizontalSliceSize(_x + 1) - getHorizontalSliceSize(_x) + 1, getVerticalSliceSize(_y + 1));

			// draw marked cell
			if (_dsmContentProvider.isInCycle(_x, _y)) {
				graphics.setBackgroundColor(getMatrixConfiguration().getCycleMatrixMarkedCellColor());
			} else {
				graphics.setBackgroundColor(getMatrixConfiguration().getMatrixMarkedCellColor());
			}
			graphics.fillRectangle(getHorizontalSliceSize(_x), getVerticalSliceSize(_y),
					getHorizontalSliceSize(_x + 1) - getHorizontalSliceSize(_x),
					getVerticalSliceSize(_y + 1) - getVerticalSliceSize(_y));
			graphics.fillRectangle(getHorizontalSliceSize(_y), getVerticalSliceSize(_x),
					getHorizontalSliceSize(_y + 1) - getHorizontalSliceSize(_y),
					getVerticalSliceSize(_x + 1) - getVerticalSliceSize(_x));
		}

		// draw the text
		graphics.setForegroundColor(_matrixColorScheme.getMatrixTextColor());
		int[] visibleSlices = getVisibleSlices();
		for (int i = visibleSlices[0]; (i <= visibleSlices[1]); i++) {
			for (int j = visibleSlices[2]; j < _dsmContentProvider.getItemCount(); j++) {
				if (i != j) {
					String value = _matrixLabelProvider.getText(_dsmContentProvider.getDependency(i, j));
					if (value != null) {
						graphics.drawString(value,
								getHorizontalSliceSize(i) + getBoxSize().getPaddingHorizontal(value, getFont()),
								getVerticalSliceSize(j) + getBoxSize().getPaddingVertical(getFont()));
					}
				}
			}
		}

		// draw the separator lines
		graphics.setForegroundColor(_matrixColorScheme.getMatrixSeparatorColor());
		for (int i = 0; i <= _dsmContentProvider.getItemCount(); i++) {
			graphics.drawLine(new Point(0, getVerticalSliceSize(i)), new Point(
					getBoxSize().getHorizontalBoxSize() * _dsmContentProvider.getItemCount(), getVerticalSliceSize(i)));
			graphics.drawLine(new Point(getHorizontalSliceSize(i), 0), new Point(getHorizontalSliceSize(i),
					getBoxSize().getVerticalBoxSize() * _dsmContentProvider.getItemCount()));
		}

		// draw the cycle separator lines
		graphics.setForegroundColor(_matrixColorScheme.getCycleSideMarkerSeparatorColor());
		for (int[] cycle : _dsmContentProvider.getCycles()) {
			int current = 0;
			for (int i : cycle) {
				current = i;
				graphics.drawLine(getHorizontalSliceSize(i), getVerticalSliceSize(cycle[0]), getHorizontalSliceSize(i),
						getVerticalSliceSize(cycle[cycle.length - 1] + 1));
				graphics.drawLine(getHorizontalSliceSize(cycle[0]), getVerticalSliceSize(i),
						getHorizontalSliceSize(cycle[cycle.length - 1] + 1), getVerticalSliceSize(i));
			}
			current++;
			graphics.drawLine(getHorizontalSliceSize(current), getVerticalSliceSize(cycle[0]),
					getHorizontalSliceSize(current), getVerticalSliceSize(cycle[cycle.length - 1] + 1));
			graphics.drawLine(getHorizontalSliceSize(cycle[0]), getVerticalSliceSize(current),
					getHorizontalSliceSize(cycle[cycle.length - 1] + 1), getVerticalSliceSize(current));
		}

		// restore state
		graphics.popState();
	}

	private BoxSize getBoxSize() {
		return _layoutInfo.getBoxSize();
	}

	private int[] getVisibleSlices() {

		if (!(this.getParent() instanceof ZoomContainer)) {
			return new int[] { 0, _dsmContentProvider.getItemCount() - 1, 0, _dsmContentProvider.getItemCount() - 1 };
		}

		ZoomContainer zoomContainer = (ZoomContainer) this.getParent();
		Viewport viewport = ((Viewport) this.getParent().getParent());

		int horMin = (int) (viewport.getViewLocation().x / (getBoxSize().getHorizontalBoxSize() * zoomContainer.zoom));
		int horVisibleSlicesCount = (int) (viewport.getSize().width
				/ (getBoxSize().getHorizontalBoxSize() * zoomContainer.zoom));

		//
		int verMin = (int) (viewport.getViewLocation().y / (getBoxSize().getVerticalBoxSize() * zoomContainer.zoom));
		int verVisibleSlicesCount = (int) (viewport.getSize().height
				/ (getBoxSize().getVerticalBoxSize() * zoomContainer.zoom));

		return new int[] { horMin,
				horMin + horVisibleSlicesCount > _dsmContentProvider.getItemCount() - 1
						? _dsmContentProvider.getItemCount() - 1 : horMin + horVisibleSlicesCount,
				verMin, verMin + verVisibleSlicesCount > _dsmContentProvider.getItemCount() - 1
						? _dsmContentProvider.getItemCount() - 1 : verMin + verVisibleSlicesCount };
	}

	/**
	 * <p>
	 * </p>
	 */
	public void resetSize() {

		//
		Dimension dimension = new Dimension(getBoxSize().getHorizontalBoxSize() * _dsmContentProvider.getItemCount(),
				getBoxSize().getVerticalBoxSize() * _dsmContentProvider.getItemCount());

		//
		if (!getSize().equals(dimension)) {
			setSize(dimension);
		}
	}

	protected final int getHorizontalSliceSize(int count) {
		return getBoxSize().getHorizontalBoxSize() * count;
	}

	/**
	 * <p>
	 * </p>
	 * 
	 * @param count
	 * @return
	 */
	protected final int getVerticalSliceSize(int count) {
		return getBoxSize().getVerticalBoxSize() * count;
	}

	/**
	 * <p>
	 * </p>
	 * 
	 * @param listener
	 */
	public void addMatrixListener(IMatrixListener listener) {
		_matrixListeners.addIfAbsent(listener);
	}

	/**
	 * <p>
	 * </p>
	 * 
	 * @param listener
	 */
	public void removeMatrixLIstener(IMatrixListener listener) {
		_matrixListeners.remove(listener);
	}

	/**
	 * <p>
	 * </p>
	 * 
	 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
	 */
	private final class MatrixMouseMotionListener extends MouseMotionListener.Stub {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void mouseMoved(MouseEvent me) {

			//
			final Point location = me.getLocation();

			//
			final int x = (location.x / getBoxSize().getHorizontalBoxSize());
			final int y = (location.y / getBoxSize().getVerticalBoxSize());

			//
			if (x != _x || y != _y) {

				//
				if (x >= _dsmContentProvider.getItemCount() || y >= _dsmContentProvider.getItemCount()) {

					_x = -1;
					_y = -1;
				}

				//
				else {

					_x = x;
					_y = y;
				}

				// start the tool tip listener
				Display.getCurrent().timerExec(1000, new Runnable() {
					@Override
					public void run() {
						// set the new cell
						if (_x == x && _y == y) {

							// notify listener
							MatrixEvent event = new MatrixEvent(_x, _y);
							for (IMatrixListener listener : _matrixListeners.toArray(new IMatrixListener[0])) {
								listener.toolTip(event);
							}
						}
					}
				});

				// repaint
				repaint();

				// notify listener
				MatrixEvent event = new MatrixEvent(_x, _y);
				for (IMatrixListener listener : _matrixListeners.toArray(new IMatrixListener[0])) {
					listener.marked(event);
				}
			}
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void mouseExited(MouseEvent me) {

			//
			_x = -1;
			_y = -1;

			// repaint
			repaint();

			// notify listener
			MatrixEvent event = new MatrixEvent(_x, _y);
			for (IMatrixListener listener : _matrixListeners.toArray(new IMatrixListener[0])) {
				listener.marked(event);
			}
		}
	}

	/**
	 * <p>
	 * </p>
	 * 
	 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
	 */
	private final class MatrixMouseListener extends MouseListener.Stub {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void mouseDoubleClicked(MouseEvent me) {
			// notify listener
			MatrixEvent event = new MatrixEvent(_x, _y);
			for (IMatrixListener listener : _matrixListeners) {
				listener.doubleClick(event);
			}
		}

		@Override
		public synchronized void mouseReleased(MouseEvent me) {

			// notify listener
			MatrixEvent event = new MatrixEvent(_x, _y);
			for (IMatrixListener listener : _matrixListeners) {
				listener.singleClick(event);
			}
		}
	}
}
