package hotel;

public class Animal {

	private String nome;
	private String tipo;
	private int idade;

	public Animal(String nome, String tipo, int idade) throws Exception {
		chacarInfoAnimal(nome, tipo, idade);
		this.nome = nome;
		this.tipo = tipo;
		this.idade = idade;
	}

	private void chacarInfoAnimal(String nome, String tipo, int idade) throws Exception {
		if (nome == null || nome.trim().equalsIgnoreCase("")) {
			throw new Exception("Nome de um animal nao pode ser nulo ou vazio");
		} else if (tipo == null || tipo.trim().equalsIgnoreCase("")) {
			throw new Exception("Tipo de um animal nao pode ser nulo ou vazio");
		} else if (idade < 0) {
			throw new Exception("Idade de um animal nao pode ser abaixo de 0");
		}
		return;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idade;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object cliente) {
		if (cliente instanceof Animal) {
			Animal animal = (Animal) cliente;
			if (this.getNome().equalsIgnoreCase(animal.getNome())
				&& this.getTipo().equalsIgnoreCase(animal.getTipo())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("Nome = %s, Tipo = %s, Idade = %d", getNome(), getTipo(), getIdade());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

}
