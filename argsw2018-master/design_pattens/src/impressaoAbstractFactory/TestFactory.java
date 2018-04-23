package impressaoAbstractFactory;
public class TestFactory {

	public static void main(String[] args) {
		AbstractImpressaoFactory factory = ImpressaoFactoryProducer.getFactory("ImpressaoFactory");
		Impressao i = factory.getimpressaoInstance("Arquivo");
		i.imprimir();
		
		factory = ImpressaoFactoryProducer.getFactory("ImpressaoFactory");
		i = factory.getimpressaoInstance("Tela");
		i.imprimir();
	}

}
