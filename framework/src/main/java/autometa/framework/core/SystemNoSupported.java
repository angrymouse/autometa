package autometa.framework.core;

public class SystemNoSupported extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3262341220815945046L;
	
	public SystemNoSupported() {
		super("The operational system is not supported by drivers available in the application");
	}

}
