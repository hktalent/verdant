package com.verdant.dm.regression;

import com.verdant.dm.common.DataPoint;

import java.util.ArrayList;

public class LinearRegression extends AbstractRegression {

    private ArrayList<DataPoint> dataPair;

    /**
     * coefficients
     */
    private double[] coefficient;

    /**
     * Constructor
     *
     * @param oriData
     */
    public LinearRegression(ArrayList<DataPoint> oriData) {
        dataPair = oriData;
    }

    /**
     * Calculate the coefficients
     * 最小二乘法
     */
    @Override
    public void generateCoefficients(int maxPow) {

        float sumX = 0;
        float sumY = 0;
        float sumXX = 0;
        float sumXY = 0;

        for (DataPoint dataPoint : dataPair) {
            sumX += dataPoint.x;
            sumY += dataPoint.y;
            sumXX += dataPoint.x * dataPoint.x;
            sumXY += dataPoint.x * dataPoint.y;
        }

        if (dataPair.size() >= 2) {
            int pn = dataPair.size();
            coefficient = new double[2];
            coefficient[1] = (pn * sumXY - sumX * sumY) / (pn * sumXX - sumX * sumX);
            coefficient[0] = sumY / pn - coefficient[1] * sumX / pn;
        } else {
            coefficient[0] = coefficient[1] = Float.NaN;
        }
    }

    /**
     * Return the coefficient
     * @return
     */
    @Override
    public double[] getCoefficients() {
        generateCoefficients(1);
        return coefficient;
    }

    /**
     * Get the predict value
     *
     * @param x
     * @return
     */
    @Override
    public double getPredict(double x) {
        if (dataPair.size() < 2)
            return Float.NaN;
        generateCoefficients(1);
        return coefficient[0] + coefficient[1] * x;
    }
}