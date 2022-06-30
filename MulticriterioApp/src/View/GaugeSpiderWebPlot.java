package View;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.Paint;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.text.NumberFormat;
import java.util.ArrayList;

import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.TableOrder;

public class GaugeSpiderWebPlot extends SpiderWebPlot {

	private Color startColor, endColor;
	private float alpha;
	private int ticks = DEFAULT_TICKS;
	private static final int DEFAULT_TICKS = 8;
	private NumberFormat format = NumberFormat.getInstance();
	private static final double PERPENDICULAR = 90;
	private static final double TICK_SCALE = 0.010;
	private int valueLabelGap = DEFAULT_GAP;
	private static final int DEFAULT_GAP = 10;
	private static final double THRESHOLD = 15;

	public GaugeSpiderWebPlot(CategoryDataset data, Color startColor, Color endColor, float alpha) {
		super(data);
		this.startColor = startColor;
		this.endColor = endColor;
		this.alpha = alpha;
	}

	private int axisGaugeCount = 3;

	private BasicStroke gaugeStroke = new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1f,
			new float[] { 3f }, 0);

	public void setAxisDivideCount(int axisDivideCount) {
		this.axisGaugeCount = axisDivideCount;
	}

	public void setGaugeStroke(BasicStroke gaugeStroke) {
		this.gaugeStroke = gaugeStroke;
	}

	@Override
	protected void drawRadarPoly(Graphics2D g2, Rectangle2D plotArea, Point2D centre, PlotRenderingInfo info,
			int series, int catCount, double headH, double headW) {
		Polygon polygon = new Polygon();

		EntityCollection entities = null;
		if (info != null) {
			entities = info.getOwner().getEntityCollection();
		}

		for (int cat = 0; cat < catCount; cat++) {

			Number dataValue = getPlotValue(series, cat);

			if (dataValue != null) {
				double value = dataValue.doubleValue();

				if (value >= 0) { // draw the polygon series...
					double angle = getStartAngle() + (getDirection().getFactor() * cat * 360 / catCount);
					Point2D point = getWebPoint(plotArea, angle, value / this.getMaxValue());
					polygon.addPoint((int) point.getX(), (int) point.getY());
					Paint paint = getSeriesPaint(series);
					Paint outlinePaint = getSeriesOutlinePaint(series);
					Stroke outlineStroke = getSeriesOutlineStroke(series);
					Ellipse2D head = new Ellipse2D.Double(point.getX() - headW / 2, point.getY() - headH / 2, headW,
							headH);
					g2.setPaint(paint);
					g2.fill(head);
					g2.setStroke(outlineStroke);
					g2.setPaint(outlinePaint);
					g2.draw(head);

					if (entities != null) {
						int row = 0;
						int col = 0;
						if (this.getDataExtractOrder() == TableOrder.BY_ROW) {
							row = series;
							col = cat;
						} else {
							row = cat;
							col = series;
						}
						String tip = null;
						if (this.getToolTipGenerator() != null) {
							tip = this.getToolTipGenerator().generateToolTip(this.getDataset(), row, col);
						}

						String url = null;
						if (this.getURLGenerator() != null) {
							url = this.getURLGenerator().generateURL(this.getDataset(), row, col);
						}
						Shape area = new Rectangle((int) (point.getX() - headW), (int) (point.getY() - headH),
								(int) (headW * 2), (int) (headH * 2));
						CategoryItemEntity entity = new CategoryItemEntity(area, tip, url, this.getDataset(),
								this.getDataset().getRowKey(row), this.getDataset().getColumnKey(col));
						entities.add(entity);
					}
				}
			}
		}
		Rectangle2D rec = polygon.getBounds2D();
		Paint paint = new GradientPaint(new Point2D.Double(rec.getCenterX(), rec.getMinY()), startColor,
				new Point2D.Double(rec.getCenterX(), rec.getMaxY()), endColor);
		g2.setPaint(paint);
		g2.setStroke(getSeriesOutlineStroke(series));
		g2.draw(polygon);

		if (this.isWebFilled()) {
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
			g2.fill(polygon);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, getForegroundAlpha()));
		}
	}


	private void addGaugePoint(ArrayList<Polygon> axisGauges, Point2D center, Point2D end) {

		double centerX = center.getX();
		double centerY = center.getY();
		double endX = end.getX();
		double endY = end.getY();

		for (int j = 0; j < axisGaugeCount; j++) {
			Polygon polygon = axisGauges.get(j);
			int gaugeX = (int) (centerX + (j + 1) * (endX - centerX) / (axisGaugeCount + 1));
			int gaugeY = (int) (centerY + (j + 1) * (endY - centerY) / (axisGaugeCount + 1));
			polygon.addPoint(gaugeX, gaugeY);
		}
	}

	private void calculateMaxValue(int seriesCount, int catCount) {
		double v = 0;
		Number nV = null;

		for (int seriesIndex = 0; seriesIndex < seriesCount; seriesIndex++) {
			for (int catIndex = 0; catIndex < catCount; catIndex++) {
				nV = getPlotValue(seriesIndex, catIndex);
				if (nV != null) {
					v = nV.doubleValue();
					if (v > getMaxValue()) {
						setMaxValue(v);
					}
				}
			}
		}
	}

	@SuppressWarnings("unused")
	@Override
	protected void drawLabel(final Graphics2D g2, final Rectangle2D plotArea, final double value, final int cat,
			final double startAngle, final double extent) {
		super.drawLabel(g2, plotArea, value, cat, startAngle, extent);
		final FontRenderContext frc = g2.getFontRenderContext();
		final double[] transformed = new double[2];
		final double[] transformer = new double[2];
		final Arc2D arc1 = new Arc2D.Double(plotArea, startAngle, 0, Arc2D.OPEN);
		for (int i = 1; i <= ticks; i++) {
			final Point2D point1 = arc1.getEndPoint();
			final double deltaX = plotArea.getCenterX();
			final double deltaY = plotArea.getCenterY();
			double labelX = point1.getX() - deltaX;
			double labelY = point1.getY() - deltaY;
			final double scale = ((double) i / (double) ticks);
			final AffineTransform tx = AffineTransform.getScaleInstance(scale, scale);
			final AffineTransform pointTrans = AffineTransform.getScaleInstance(scale + TICK_SCALE, scale + TICK_SCALE);
			transformer[0] = labelX;
			transformer[1] = labelY;
			pointTrans.transform(transformer, 0, transformed, 0, 1);
			final double pointX = transformed[0] + deltaX;
			final double pointY = transformed[1] + deltaY;
			tx.transform(transformer, 0, transformed, 0, 1);
			labelX = transformed[0] + deltaX;
			labelY = transformed[1] + deltaY;
			double rotated = (PERPENDICULAR);
			AffineTransform rotateTrans = AffineTransform.getRotateInstance(Math.toRadians(rotated), labelX, labelY);
			transformer[0] = pointX;
			transformer[1] = pointY;
			rotateTrans.transform(transformer, 0, transformed, 0, 1);
			final double x1 = transformed[0];
			final double y1 = transformed[1];
			rotated = (-PERPENDICULAR);
			rotateTrans = AffineTransform.getRotateInstance(Math.toRadians(rotated), labelX, labelY);
			rotateTrans.transform(transformer, 0, transformed, 0, 1);
			final Composite saveComposite = g2.getComposite();
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
			g2.draw(new Line2D.Double(transformed[0], transformed[1], x1, y1));
			if (startAngle == this.getStartAngle()) {
				final String label = format.format(((double) i / (double) ticks) * this.getMaxValue());
				final Rectangle2D labelBounds = getLabelFont().getStringBounds(label, frc);
				final LineMetrics lm = getLabelFont().getLineMetrics(label, frc);
				final double ascent = lm.getAscent();
				if (Math.abs(labelX - plotArea.getCenterX()) < THRESHOLD) {
					labelX += valueLabelGap;
					labelY += ascent / (float) 2;
				} else if (Math.abs(labelY - plotArea.getCenterY()) < THRESHOLD) {
					labelY += valueLabelGap;
				} else if (labelX >= plotArea.getCenterX()) {
					if (labelY < plotArea.getCenterY()) {
						labelX += valueLabelGap;
						labelY += valueLabelGap;
					} else {
						labelX -= valueLabelGap;
						labelY += valueLabelGap;
					}
				} else {
					if (labelY > plotArea.getCenterY()) {
						labelX -= valueLabelGap;
						labelY -= valueLabelGap;
					} else {
						labelX += valueLabelGap;
						labelY -= valueLabelGap;
					}
				}
				g2.setPaint(getLabelPaint());
				g2.setFont(getLabelFont());
				g2.drawString(label, (float) labelX, (float) labelY);
			}
			g2.setComposite(saveComposite);
		}
	}

	public void setTicks(final int t) {
		ticks = t;
	}

	protected void drawRadarGrid(Graphics2D g2, Rectangle2D plotArea, int catCount) {
		double maxVal = getMaxValue();
		double distance = maxVal / ticks;
		double dataValue = 0;
		for (double i = 0; i < maxVal; i += distance) { // for each web grid polygon
			Polygon polygon = new Polygon();
			dataValue += distance;
			for (int cat = 0; cat < catCount; cat++) { // for each axis on current web grid
				if (0.0 < dataValue) {
					double value = dataValue;
					if (value >= 0) { // draw the polygon series...
						double angle = getStartAngle() + (getDirection().getFactor() * cat * 360 / catCount);
						Point2D point = getWebPoint(plotArea, angle, value / getMaxValue());
						polygon.addPoint((int) point.getX(), (int) point.getY());
					}
				}
			}
			g2.draw(polygon);
		} // next web grid
	}// drawRadarGrid()


	@Override
	public void draw(Graphics2D g2, Rectangle2D area, Point2D anchor, PlotState parentState, PlotRenderingInfo info) {
		RectangleInsets insets = getInsets();
		insets.trim(area);

		if (info != null) {
			info.setPlotArea(area);
			info.setDataArea(area);
		}

		drawBackground(g2, area);
		drawOutline(g2, area);
		Shape savedClip = g2.getClip();
		g2.clip(area);
		Composite originalComposite = g2.getComposite();
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, getForegroundAlpha()));

		if (!DatasetUtilities.isEmptyOrNull(getDataset())) {
			int seriesCount = 0, catCount = 0;
			if (getDataExtractOrder() == TableOrder.BY_ROW) {
				seriesCount = getDataset().getRowCount();
				catCount = getDataset().getColumnCount();
			} else {
				seriesCount = getDataset().getColumnCount();
				catCount = getDataset().getRowCount();
			}

			if (getMaxValue() == DEFAULT_MAX_VALUE)
				calculateMaxValue(seriesCount, catCount);

			double gapHorizontal = area.getWidth() * getInteriorGap();
			double gapVertical = area.getHeight() * getInteriorGap();

			double X = area.getX() + gapHorizontal / 2;
			double Y = area.getY() + gapVertical / 2;
			double W = area.getWidth() - gapHorizontal;
			double H = area.getHeight() - gapVertical;

			double headW = area.getWidth() * this.headPercent;
			double headH = area.getHeight() * this.headPercent;

			double min = Math.min(W, H) / 2;
			X = (X + X + W) / 2 - min;
			Y = (Y + Y + H) / 2 - min;
			W = 2 * min;
			H = 2 * min;

			Point2D centre = new Point2D.Double(X + W / 2, Y + H / 2);
			Rectangle2D radarArea = new Rectangle2D.Double(X, Y, W, H);

			for (int cat = 0; cat < catCount; cat++) { // for each category
				double angle = getStartAngle() + (getDirection().getFactor() * cat * 360 / catCount);
				Point2D endPoint = getWebPoint(radarArea, angle, 1); // 1 = end of axis
				Line2D line = new Line2D.Double(centre, endPoint);
				g2.setPaint(getAxisLinePaint());
				g2.setStroke(getAxisLineStroke());
				g2.draw(line);
				drawLabel(g2, radarArea, 0.0, cat, angle, 360.0 / catCount);

			} // next category

			drawRadarGrid(g2, radarArea, catCount); // <<<!!! call new method to draw web grid polygons

			for (int series = 0; series < seriesCount; series++) {
				drawRadarPoly(g2, radarArea, centre, info, series, catCount, headH, headW);
			}
		} else {
			drawNoDataMessage(g2, area);
		}
		g2.setClip(savedClip);
		g2.setComposite(originalComposite);
		drawOutline(g2, area);
	}// draw()
}
