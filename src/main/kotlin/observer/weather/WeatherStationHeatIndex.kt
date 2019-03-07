package observer.weather

object WeatherStationHeatIndex {

    @JvmStatic
    fun main(args: Array<String>) {
        val weatherData = WeatherData()
        val currentDisplay = CurrentConditionsDisplay(weatherData)
        val statisticsDisplay = StatisticsDisplay(weatherData)
        val forecastDisplay = ForecastDisplay(weatherData)
        val heatIndexDisplay = HeatIndexDisplay(weatherData)

        weatherData.setMeasurements(80f, 65f, 30.4f)
        weatherData.setMeasurements(82f, 70f, 29.2f)
        weatherData.setMeasurements(78f, 90f, 29.2f)
    }
}
