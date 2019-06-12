package observer.weather

/**
 * Interface for WeatherStation (observable)
 */
interface Subject {
    /**
     * Registers new observer
     * @param o Observer to register
     */
    fun registerObserver(o: Observer)

    /**
     * Removes registered observers
     * @param o Observer to remove
     */
    fun removeObserver(o: Observer)

    /**
     * Notifies the registered observers
     */
    fun notifyObservers()
}
