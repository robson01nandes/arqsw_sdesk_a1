package impressaoAbstractFactory;
public interface AbstractImpressaoFactory {
	Impressao getimpressaoInstance(String tipoImpressao);
}
