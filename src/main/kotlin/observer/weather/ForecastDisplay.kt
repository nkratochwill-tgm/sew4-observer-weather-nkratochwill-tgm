package observer.weather

class ForecastDisplay(weatherData: WeatherData) : Observer, DisplayElement {
    private var currentPressure = 29.92f
    private var lastPressure: Float = 0.toFloat()

    init {
        weatherData.registerObserver(this)
    }

    override fun update() {
        lastPressure = currentPressure
        // Fetches new data from weatherData
        currentPressure = WeatherData.pressure
        // Display changes
        display()
    }

    /**
     * Displays forecast
     */
    override fun display() {
        print("Forecast: ")
        when {
            currentPressure > lastPressure -> println("Improving weather on the way!")
            currentPressure == lastPressure -> println("More of the same")
            currentPressure < lastPressure -> println("Watch out for cooler, rainy weather")
        }
    }
}
