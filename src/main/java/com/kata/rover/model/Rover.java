package com.kata.rover.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * The Rover vehicle exploring Mars.
 * 
 * @author Caroline Aupert
 *
 */
public class Rover {

	/**
	 * The x coordinate.
	 */
	private int x;

	/**
	 * The y coordinate.
	 */
	private int y;

	/**
	 * The facing direction.
	 */
	private Direction direction;

	/**
	 * Rover basic constructor.
	 */
	public Rover() {
	}

	/**
	 * Rover constructor with coordinates.
	 * 
	 * @param x         The x coordinate
	 * @param y         The y coordinate
	 * @param direction The facing direction
	 */
	public Rover(int x, int y, Direction direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	/**
	 * Rover copy constructor.
	 * 
	 * @param rover The rover tyo copy
	 */
	public Rover(Rover rover) {
		this.x = rover.getX();
		this.y = rover.getY();
		this.direction = rover.getDirection();
	}

	/**
	 * direction getter.
	 *
	 * @return the direction.
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 * direction setter.
	 *
	 * @param direction : the direction to set.
	 */
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	/**
	 * x getter.
	 *
	 * @return the x.
	 */
	public int getX() {
		return x;
	}

	/**
	 * y getter.
	 *
	 * @return the y.
	 */
	public int getY() {
		return y;
	}

	/**
	 * y setter.
	 *
	 * @param y : the y to set.
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * x setter.
	 *
	 * @param x : the x to set.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Equals method
	 */
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	/**
	 * HahsCode method
	 */
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	/**
	 * ToString method
	 */
	@Override
	public String toString() {
		return String.format("Rover location is x: %d, y: %d facing: %s", this.getX(), this.getY(),
				this.getDirection().label);
	}

}
