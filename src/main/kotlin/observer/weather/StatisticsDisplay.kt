package observer.weather

class StatisticsDisplay(weatherData: WeatherData) : Observer, DisplayElement {
    private var maxTemp = 0.0f
    private var minTemp = 200f
    private var tempSum = 0.0f
    private var numReadings = 0

    init {
        weatherData.registerObserver(this)
    }

    override fun update() {
        // Fetches new data from weatherData
        val temp = WeatherData.temperature
        tempSum += temp
        numReadings++

        if (temp > maxTemp) {
            maxTemp = temp
        }

        if (temp < minTemp) {
            minTemp = temp
        }
        // Display changes
        display()
    }

    /**
     * Display the Avg/Max/Min temperature
     */
    override fun display() {
        println("Avg/Max/Min temperature = " + tempSum / numReadings + "/$maxTemp/$minTemp")
    }
}
