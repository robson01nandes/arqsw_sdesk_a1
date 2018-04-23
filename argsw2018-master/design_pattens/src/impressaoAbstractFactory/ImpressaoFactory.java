package impressaoAbstractFactory;
public class ImpressaoFactory implements AbstractImpressaoFactory{
	@Override
	public Impressao getimpressaoInstance(String tipoImpressao) {
		switch(tipoImpressao){
		case "Arquivo": return new ArquivoImpressao();
		case "Tela": return new TelaImpressao();
	}
	
	return null;
	}

}
