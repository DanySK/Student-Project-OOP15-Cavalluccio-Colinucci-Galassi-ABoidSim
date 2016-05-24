package utils;

public class Vector {

	private float x;
	private float y;

	public Vector(final float x, final float y) {
		this.x = x;
		this.y = y;
	}

	public void add(final Vector v) {
		this.x += v.x;
		this.y += v.y;
	}

	public void diff(final Vector v) {
		this.x -= v.x;
		this.y -= v.y;
	}

	public void mul(final float z) {
		this.x *= z;
		this.y *= z;
	}

	public void mul(final float z1, final float z2) {
		this.x *= z1;
		this.y *= z2;
	}

	public void div(final float z) {
		this.mul(1 / z);
	}

	public void div(final float z1, final float z2) {
		this.mul(1 / z1, 1 / z2);
	}

	public double mag() {
		return Math.sqrt(this.x * this.x + this.y * this.y);
	}

	public void norm() {
		final float magnitude = (float) this.mag();
		this.div(magnitude);
	}

}
