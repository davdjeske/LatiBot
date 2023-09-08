package latibot.audio;

public class DecTalkWrapper {
	/* For some reason, when i compile the header and c code for these native functions
	 * with gcc, there is always a UnspecifiedLinkError thats thrown when i call native
	 * functions. I am switching to microsft visual c to compile.
	 * Here is the compile command bc i dont know how to automate this with gradle at the moment: 
	 * cl /LD /FeDecTalkWrapper.dll src/main/c/DecTalkWrapper.c /Isrc/main/c /I"C:\Program Files\Eclipse Adoptium\jdk-20.0.1.9-hotspot\include" /I"C:\Program Files\Eclipse Adoptium\jdk-20.0.1.9-hotspot\include\win32" /Ibuild/generated/sources/headers/java/main /link /LIBPATH:lib DECtalk.lib
	 * use x64 Native Tools CMD for visual studio to run this compile
	 */
	static {
		try {
			System.loadLibrary("DecTalkWrapper");
		} catch (UnsatisfiedLinkError e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private native int TextToSpeechStartup();
	private native int TextToSpeechShutdown();
	private native int TextToSpeechSync();
	private native int TextToSeechSpeak(String text);
	
	public int ttsStartup() {
		return TextToSpeechStartup();
	}
	
	public int ttsShutdown() {
		return TextToSpeechShutdown();
	}
	
	public int ttsSync() {
		return TextToSpeechSync();
	}
	
	public int ttsSpeak(String text) {
		return TextToSeechSpeak(text);
	}
	
}
