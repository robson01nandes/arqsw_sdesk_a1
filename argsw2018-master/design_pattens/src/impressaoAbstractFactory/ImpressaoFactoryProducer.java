package impressaoAbstractFactory;
public final class ImpressaoFactoryProducer {
	private ImpressaoFactoryProducer(){
		throw new AssertionError();
	}

	public static AbstractImpressaoFactory getFactory(String t){
		
		switch(t)
		{
			case "ImpressaoFactory": return new ImpressaoFactory();
		}

		return null;
	}
}
