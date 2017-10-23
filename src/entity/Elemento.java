package entity;

public class Elemento extends TipoElemento {

			private int idElemento;
			private String nombreElemento;
			
			public int getIdElemento() {
				return idElemento;
			}
			public void setIdElemento(int idElemento) {
				this.idElemento = idElemento;
			}
			public String getNombreElemento() {
				return nombreElemento;
			}
			public void setNombreElemento(String nombreElemento) {
				this.nombreElemento = nombreElemento;
			}
			
			
			public Elemento(int idtipo, String nombretipo, int cantmaxreservaspendientes, int idElemento,
					String nombreElemento) {
				super(idtipo, nombretipo, cantmaxreservaspendientes);
				this.idElemento = idElemento;
				this.nombreElemento = nombreElemento;
			}
			
			public Elemento(int idtipo, String nombretipo, int cantmaxreservaspendientes) {
				super(idtipo, nombretipo, cantmaxreservaspendientes);
				// TODO Auto-generated constructor stub
			}
			
			public Elemento() {
				super();
				// TODO Auto-generated constructor stub
			}
			
			
	
}
