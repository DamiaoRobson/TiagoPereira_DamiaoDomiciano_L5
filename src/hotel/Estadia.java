package hotel;

public class Estadia {

	private Animal animal;
	private double valor;
	private int dias;

	public Estadia(String nome, String tipo, int idade, int dias, double valor) throws Exception {
		this.animal = new Animal(nome, tipo, idade);
		varificarValorDias(valor, dias);
		this.valor = valor;
		this.dias = dias;
	}

	private void varificarValorDias(double valor, int dias) throws Exception {
		if (valor <= 0.) {
			throw new Exception("Valor menor ou igual a 0");
		} else if (dias <= 0) {
			throw new Exception("Dias menor ou igual a 0");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((animal == null) ? 0 : animal.hashCode());
		result = prime * result + dias;
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return String.format("%s, %s, %d dias com o preço de R$ %.2f", this.getAnimal().getNome(),
				this.getAnimal().getTipo(), this.getDias(), this.getValor());
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

}
