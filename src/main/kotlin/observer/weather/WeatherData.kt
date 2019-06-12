package observer.weather

/**
 * Interface to fetch weather data
 */
class WeatherData : Subject {
    private val observers: ArrayList<Observer> = ArrayList()

    companion object {
        var temperature: Float = 0.0f
        var humidity: Float = 0.0f
        var pressure: Float = 0.0f
    }

    override fun registerObserver(o: Observer) {
        observers.add(o)
    }

    override fun removeObserver(o: Observer) {
        val i = observers.indexOf(o)
        if (i >= 0) {
            observers.removeAt(i)
        }
    }

    override fun notifyObservers() {
        // Notifies observers so they can fetch the new data
        observers.forEach {
            it.update()
        }
    }

    fun measurementsChanged() {
        notifyObservers()
    }

    fun setMeasurements(temperature: Float, humidity: Float, pressure: Float) {
        WeatherData.temperature = temperature
        WeatherData.humidity = humidity
        WeatherData.pressure = pressure
        measurementsChanged()
    }
}
