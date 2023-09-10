package org.brokenarrow.storage.api.metadata;

import javax.annotation.Nonnull;
import java.util.LinkedHashMap;
import java.util.Map;

public class ContainerMeta {

 public String typeOfContainer;

	public String fileName;

	public ContainerMeta(final String typeOfContainer, final String fileName) {
		this.typeOfContainer = typeOfContainer;
		this.fileName = fileName;
	}

	public String getTypeOfContainer() {
		return typeOfContainer;
	}

	public String getFileName() {
		return fileName;
	}

	@Nonnull
	public Map<String,Object> serialise() {
		Map<String,Object> map = new LinkedHashMap<>();
		map.put("Type",typeOfContainer);
		map.put("File_name",fileName);
		return map;
	}


	@Override
	public String toString() {
		return "ContainerMeta{" +
				"typeOfContainer='" + typeOfContainer + '\'' +
				", fileName='" + fileName + '\'' +
				'}';
	}
}
