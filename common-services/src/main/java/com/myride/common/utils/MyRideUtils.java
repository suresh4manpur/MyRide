package com.myride.common.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.util.ResourceUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyRideUtils {
	public static List<String> getListFromCommaSeparatedString(String commaSeparatedString) {
		return Arrays.asList(commaSeparatedString.split("\\s*,\\s*"));
	}
	public static String readFullFile(String fileRelativePath) {
		StringBuilder contentBuilder = new StringBuilder();
		try(Stream<String> streams = Files.lines(Paths.get(getPath(fileRelativePath)), StandardCharsets.UTF_8)){
			streams.forEach(line -> contentBuilder.append(line).append("\n"));
			
		}catch(IOException e) {
		log.error("Exception in reading the mail template, {}", e);
		}
		return contentBuilder.toString();
	}
	private static String getPath(String fileRelativePath) {
		File file = getFile(fileRelativePath);
		if(file != null) {
			return file.getAbsolutePath();
		}
		return fileRelativePath;
	}
	private static File getFile(String fileRelativePath) {
		File file =null;
		try {
			file = ResourceUtils.getFile("classpath:"+fileRelativePath);
		}catch (FileNotFoundException e) {
			log.error("File not found at {}", fileRelativePath);
		}
		return file;
	}
}
