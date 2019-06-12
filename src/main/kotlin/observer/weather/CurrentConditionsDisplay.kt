package observer.weather

/**
 * Constructor
 * @param weatherData That is the Subject(Observable)
 */
class CurrentConditionsDisplayw(weatherData: Subject) : Observer, DisplayElement {
    private var temperature: Float = 0.toFloat()
    private var humidity: Float = 0.toFloat()


    init {
        // registers an observer
        weatherData.registerObserver(this)
    }

    override fun update() {
        // Fetches new data from weatherData
        this.temperature = WeatherData.temperature
        this.humidity = WeatherData.humidity
        // Display changes
        display()
    }

    /**
     * Display the current conditions
     */
    override fun display() {
        println("Current conditions: $temperature F degrees and $humidity% humidity")
    }
}
