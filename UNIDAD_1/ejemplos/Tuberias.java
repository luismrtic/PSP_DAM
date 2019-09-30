package ejemplos;

import java.io.File;
import java.util.List;

public class Tuberias{
	public static void main(String[] args) throws Exception{
		List<ProcessBuilder> pipeline = List.of(
			new ProcessBuilder("cat", "/home/lubuntu/Desktop/iris.data.txt"),
			new ProcessBuilder("cut", "-d", ",", "-f", "5"),
			new ProcessBuilder("uniq", "-c").redirectOutput(ProcessBuilder.Redirect.INHERIT).redirectOutput(new File("/home/lubuntu/Desktop/ficherosSalida/contar.txt"))
		);
		
		List<Process> processes = ProcessBuilder.startPipeline(pipeline);

		int exitValue = processes.get(processes.size() - 1).waitFor();
		
	}
}
