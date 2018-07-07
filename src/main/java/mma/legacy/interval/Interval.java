package mma.legacy.interval;

import org.apache.log4j.Logger;

/**
 * Clase para el ejemplo de trabajo con Legacy
 * 
 * @author Agustin 
 * 
 * Controla operaciones sobre intervalos que pudeen ser abiertos o cerrados
 */
public class Interval 
{	
	private Logger logger;

	private double minimum; // indica el limite superior del intervalo
	private double maximum; // indica el limite superior del intervalo
	private Opening opening; // indica si el tipo de intervalo (abierto o cerrado)

	/**
	 * getter publico para la propiedad minimum
	 * @return
	 */
	public double getMinimum() {
		return minimum;
	}

	/**
	 * setter publico para la propiedad minimum
	 * @param minimum
	 */
	public void setMinimum(double minimum) {
		this.minimum = minimum;
	}
	
	/**
	 * getter publico para la propiedad maximum
	 * @return
	 */
	public double getMaximum() {
		return maximum;
	}

	/**
	 * setter publico para la propiedad maximum
	 * @param maximum
	 */
	public void setMaximum(double maximum) {
		this.maximum = maximum;
	}
	
	/**
	 * getter publico para la propiedad opening
	 * @return
	 */
	public Opening getOpening() {
		return opening;
	}

	/**
	 * setter publico para la propiedad opening
	 * @param opening
	 */
	public void setOpening(Opening opening) {
		this.opening = opening;
	}

	/**
	 * Constructor privado que inicializa el logger
	 */
	private Interval()
	{
		logger = Logger.getLogger(this.getClass().getName());
	}
	
	/**
	 * Constructor de la clase
	 * 
	 * @param minimum : indica el limite superior del intervalo
	 * @param maximum : indica el limite superior del intervalo
	 * @param opening
	 */
	public Interval(double minimum, double maximum, Opening opening) 
	{
		this();
		
		this.setMinimum(minimum);
		this.setMaximum(maximum);
		this.setOpening(opening);
		
		logger.trace("Objeto 'Interval' creado");
	}

	/**
	 * Este método calcula el punto medio de los límites del intervalo
	 * 
	 * @return
	 */
	public double midPoint() 
	{
		return (getMaximum() + getMinimum()) / 2;
	}

	/**
	 * Este método mira si un número está dentro del intervalo
	 * @param value
	 * 
	 */
	public boolean includes(double value) 
	{
		logger.trace("Entro en el método 'includes'");
		
		boolean result;
		
		switch (getOpening()) 
		{
			case BOTH_OPENED:
				result = getMinimum() < value && value < getMaximum();
				break;
			
			case LEFT_OPENED:
				result = getMinimum() < value && value <= getMaximum();
				break;
			
			case RIGHT_OPENED:
				result = getMinimum() <= value && value < getMaximum();
				break;
			
			case BOTH_CLOSED:
				result = getMinimum() <= value && value <= getMaximum();
				break;
			
			default:
				result = false;
				break;
		}
		
		return result;
	}

	/**
	 * Este método calcula si un intervalo está dentro de otro intervalo
	 * 
	 * @param interval
	 * @return True si el intervalo recibido por parametro esta inlcuido, en caso contrario False
	 */
	public boolean includes(Interval interval) 
	{		
		boolean result;
		
		switch (getOpening()) 
		{
			case BOTH_OPENED:
				switch (interval.getOpening()) 
				{
					case BOTH_OPENED:
						result = areBothLimitsIncludedOrEqual(this,interval);
						break;
					
					case LEFT_OPENED:
						result = isUpperLimitIncludedAndLowerEqualOrIncluded(this,interval);
						break;
					
					case RIGHT_OPENED:
						result = isLowerLimitIncludedAndUpperEqualOrIncluded(this,interval);
						break;
					
					case BOTH_CLOSED:
						result = areBothLimitsIncluded(this,interval);
						break;
					
					default:
						result = false;
						break;
				}
				break;
		
		case LEFT_OPENED:
			switch (interval.getOpening()) 
			{
				case BOTH_OPENED:
				case LEFT_OPENED:
					result = areBothLimitsIncludedOrEqual(this,interval);
					break;
				
				case RIGHT_OPENED:
				case BOTH_CLOSED:
					result = isLowerLimitIncludedAndUpperEqualOrIncluded(this,interval);
					break;
				
				default:
					result = false;
					break;
			}
			break;
		
		case RIGHT_OPENED:
			switch (interval.getOpening()) 
			{
				case BOTH_OPENED:
				case RIGHT_OPENED:
					result = areBothLimitsIncludedOrEqual(this,interval);
					break;
					
				case LEFT_OPENED:
				case BOTH_CLOSED:
					result = isUpperLimitIncludedAndLowerEqualOrIncluded(this,interval);
					break;
				
				default:
					result = false;
					break;
			}
			break;
			
		case BOTH_CLOSED:
			switch (interval.getOpening()) 
			{
				case BOTH_OPENED:
				case LEFT_OPENED:
				case RIGHT_OPENED:
				case BOTH_CLOSED:
					result = areBothLimitsIncludedOrEqual(this,interval);
					break;
				
				default:
					result = false;
					break;
			}
			break;
			
		default:
			result = false;
			break;
		}
		
		return result;
	}

	/**
	 * Este metodo evalua si en dos intervalos, sus limites inferiores y superiores son
	 * iguales o uno incluye al otro
	 * 
	 * @param interval : primer intervalo a comparar
	 * @param interval2 : segundo intervalo a comparar
	 * 
	 * @return true si el primer interbalo incluye al segundo o si sus limites son iguales, en caso contrario, retorna false
	 */
	private boolean areBothLimitsIncludedOrEqual(Interval interval, Interval interval2) 
	{
		boolean isMinimumIncluded = interval.includes(interval2.getMinimum());
		boolean isMaximumIncluded = interval.includes(interval2.getMaximum());
		
		return (isMinimumIncluded || getMinimum() == interval.getMinimum()) && (isMaximumIncluded || getMaximum() == interval.getMaximum());
	}
	
	/**
	 * Este metodo evalua si en dos intervalos, el primero incluye a los limites superior e inferior del segundo
	 * 
	 * @param interval : primer intervalo a comparar
	 * @param interval2 : segundo intervalo a comparar
	 * 
	 * @return true si el primer interbalo incluye a los limites superior e inferior del segundo, en caso contrario, retorna false
	 */
	private boolean areBothLimitsIncluded(Interval interval, Interval interval2) 
	{
		boolean isMinimumIncluded = interval.includes(interval2.getMinimum());
		boolean isMaximumIncluded = interval.includes(interval2.getMaximum());
		
		return (isMinimumIncluded) && (isMaximumIncluded);
	}
	
	/**
	 * Este metodo evalua si en dos intervalos, el primero incluye al limite inferior del segundo
	 * y si incluye o su limite superior es igual al del segundo
	 * 
	 * @param interval : primer intervalo a comparar
	 * @param interval2 : segundo intervalo a comparar
	 * 
	 * @return true primero incluye al limite inferior del segundo y si incluye o su limite superior es igual al del segundo, en caso contrario, retorna false
	 */
	private boolean isLowerLimitIncludedAndUpperEqualOrIncluded(Interval interval, Interval interval2) 
	{
		boolean isMinimumIncluded = interval.includes(interval2.getMinimum());
		boolean isMaximumIncluded = interval.includes(interval2.getMaximum());
		
	    return (isMinimumIncluded) && (isMaximumIncluded || getMaximum() == interval.getMaximum());
	}
	
	/**
	 * Este metodo evalua si en dos intervalos, el primero incluye al limite superior del segundo
	 * y si incluye o su limite inferior es igual al del segundo
	 * 
	 * @param interval : primer intervalo a comparar
	 * @param interval2 : segundo intervalo a comparar
	 * 
	 * @return true primero incluye al limite superior del segundo y si incluye o su limite inferior es igual al del segundo, en caso contrario, retorna false
	 */
	private boolean isUpperLimitIncludedAndLowerEqualOrIncluded(Interval interval, Interval interval2) 
	{
		boolean isMinimumIncluded = interval.includes(interval2.getMinimum());
		boolean isMaximumIncluded = interval.includes(interval2.getMaximum());
		
	    return (isMaximumIncluded) && (isMinimumIncluded || getMinimum() == interval.getMinimum());
	}

	/**
	 * Este método determina si un intervalo se intersecta con otro
	 * 
	 * @param interval
	 * @return
	 */
	public boolean intersectsWith(Interval interval) 
	{
		if (getMinimum() == interval.getMaximum()) 
		{
			switch (getOpening()) 
			{
				case BOTH_OPENED:
				case LEFT_OPENED:
					return false;
					
				case RIGHT_OPENED:
				case BOTH_CLOSED:
					return interval.getOpening() == Opening.LEFT_OPENED || interval.getOpening() == Opening.BOTH_CLOSED;
				
				default:
					return false;
			}
		}
		
		if (getMaximum() == interval.getMinimum()) 
		{
			switch (getOpening()) 
			{
				case BOTH_OPENED:
				case RIGHT_OPENED:
					return false;
					
				case LEFT_OPENED:
				case BOTH_CLOSED:
					return interval.getOpening() == Opening.RIGHT_OPENED || interval.getOpening() == Opening.BOTH_CLOSED;
				
				default:
					return false;
			}
		}
		
		return this.includes(interval.getMinimum()) || this.includes(interval.getMaximum());
	}
}
