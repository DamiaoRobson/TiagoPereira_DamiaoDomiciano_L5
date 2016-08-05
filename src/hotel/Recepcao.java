package hotel;

import java.util.ArrayList;

public class Recepcao {
	private ArrayList<Estadia> estadias;
	
	public Recepcao(){
		estadias = new ArrayList<Estadia>();
	}
	
	public void checkIn(String nome, String tipo, int idade, int dias, double valor)throws Exception{
		Estadia novaEstadia = new Estadia(nome, tipo, idade, dias, valor);
		this.estadias.add(novaEstadia);
	}
	
	public void checkOut(String nome){
		for(Estadia estadia : this.estadias){
			if(estadia.getNome().equalsIgnoreCase(nome)){
				this.estadias.remove(estadia);
			}
		}
	}
	
	public int getNumDeHospedes(){
		return this.estadias.size();
	}
	
	public double getLucroTotal(){
		double total = 0.0;
		for(int i = 0; i < this.estadias.size(); i++){
			total += this.estadias.get(i).getValor();
		}
		return total;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estadias == null) ? 0 : estadias.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object objeto) {
		if(objeto instanceof Recepcao){
			Recepcao outraRecepcao = (Recepcao) objeto;
			if(outraRecepcao.getNumDeHospedes() == this.getNumDeHospedes() 
					&& outraRecepcao.getLucroTotal() == this.getLucroTotal()){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	public String toString(){
		final String FIM_LINHA = System.getProperty("line.separator");
		String saida = "Estadias:" + FIM_LINHA;
		for(int i = 0; i < this.estadias.size(); i++){
			Estadia estadia = estadias.get(i);
			saida += estadia.getNome() + " (" + estadia.getTipo() + "): "
					+ estadia.getDias() + " dias com o preco de R$ " + estadia.getValor()
					+ FIM_LINHA;
		}
		return saida;
	}
}
