package miniProject.commons;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileResponse {
	private String name;
	private String uri;
	private String type;
	private long size;

	public FileResponse(String name, String uri, String type, long size) {
		this.name = name;
		this.uri = uri;
		this.type = type;
		this.size = size;
	}

	@Override
	public String toString() {
		return "FileResponse{" + "name='" + name + '\'' + ", uri='" + uri + '\'' + ", type='" + type + '\'' + ", size="
				+ size + '}';
	}
}
