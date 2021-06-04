using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LibraryProject
{
    public class Weather
    {
        // method to convert from farenheit to celsius
        public static double farenheitToCelsius (double f)
        {
            double celsius;

            celsius = (f - 32) * 5 / 9;

            return celsius;
        } // end farenheit to celsius method

        // method to convert from celsius to farenheit
        public static double celsiusToFarenheit(double c)
        {
            double farenheit;

            farenheit = (c * 9 / 5) + 32;

            return farenheit;
        } // end celsius to farenheit method

        // method to convert from farenheit to kelvin
        public static double farenheitToKelvin (double f)
        {
            double kelvin;

            kelvin = (f - 32) * 5 / 9 + 273.15;

            return kelvin;
        } // end farenheit to kelvin method

        // method to convert from celsius to kelvin
        public static double celsiusToKelvin(double c)
        {
            double kelvin;

            kelvin = c + 273.15;

            return kelvin;
        } // end celsius to kelvin method

        // method to calculate heat index
        public static double calculateHeatIndex(double f, double rh)
        {
            double heatIndex;

            // uses for farenheit and relative humidity
            heatIndex = -42.379 + (2.04901523 * f) + (10.14333127 * rh) - (.22475541 * f * rh) - (.00683783 * f * f) - (.05481717 * rh * rh) + (.00122874 * f * f * rh) + (.00085282 * f * rh * rh) - (.00000199 * f * f * rh * rh);

            return heatIndex;
        } // end heat index method

        // method to calculate wind speed
        public static double calculateWindChill(double f, double s)
        {
            double windChill;

            windChill = 35.74 + 0.6215 * f - 35.75 * Math.Pow(s, 0.16) + 0.4275 * f * Math.Pow(s, 0.16);

            return windChill;
        } // end wind chill method

        // method to calculate relative humidity
        public static double calculateRelativeHumidity(double s, double a)
        {
            double relativeHumidity;

            relativeHumidity = s / a * 100;

            return relativeHumidity;
        } // end relative humidity method

        // calculate wind speed (miles per hour to knots)
        public static double calculateMPHToKnots (double mph)
        {
            double knots;

            knots = mph * 0.868976;

            return knots;
        } // end miles per hour to knots method

        // calculate wind speed (knots to miles per hour)
        public static double calculateKnotsToMPH(double knots)
        {
            double mph;

            mph = knots * 1.150779;

            return mph;
        } // end knots to mph method
    } // end Weather class
} // end namespace
